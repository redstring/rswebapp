package com.iredstring.springmvc.configuration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.setServletContext(container);

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		
		servlet.addMapping("/api");
		servlet.addMapping("/api/v1/rsuser/list");
		servlet.addMapping("/api/v1/rsuser/read");
		
		servlet.addMapping("/api/hello");
		servlet.addMapping("/api/hello2");
		servlet.addMapping("/api/hello3/*");
		servlet.addMapping("/api/emp/list");
		servlet.addMapping("/api/emp/new");
		servlet.addMapping("/api/emp/delete");
		servlet.addMapping("/restapi/hello3");		
		
		setupHsqlDBInMemory();
		
//		StringBuilder result = new StringBuilder();
//		try (Scanner scanner = new Scanner(file)) {
//			 
//			while (scanner.hasNextLine()) {
//				String line = scanner.nextLine();
//				result.append(line).append("\n");
//			}
//	 
//			scanner.close();
//	 
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(result.toString());
		
//		Connection c = null;
//		Statement s = null;
//		try {
//			Class.forName("org.hsqldb.jdbcDriver");
//			c = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "sa", "");
//			//c = DriverManager.getConnection("jdbc:hsqldb:file:hsqldb/hsqldb-file;shutdown=true;hsqldb.write_delay=false;", "sa", "");
//
//			s = c.createStatement();
//			String sql = "CREATE TABLE EMPLOYEE(" 
//					+ "id INTEGER IDENTITY, "
//					+ "name VARCHAR(50) , " 
//					+ "joining_date DATE , "
//					+ "salary DOUBLE , " 
//					+ "ssn VARCHAR(30) UNIQUE );";
//			
//			s.execute(sql);
//			sql = "INSERT INTO Employee VALUES(1,'Jason1','2010-01-01',101000,'ssn1')";
//			s.execute(sql);
//			sql = "INSERT INTO Employee VALUES(2,'Jason2','2010-02-02',102000,'ssn2')";
//			s.execute(sql);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				s.close();
//			} catch (Exception e) {
//			}
//			try {
//				c.close();
//			} catch (Exception e) {
//			}
//		}
		
		
		
	}

	private void setupHsqlDBInMemory() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("db-hsqldb.sql").getFile());
		
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try( Connection c = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "sa", "");
			 Statement s = c.createStatement();
			 BufferedReader br = new BufferedReader(new FileReader(file));) {
			
			String line;
			StringBuilder strb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				line = " "+line.trim();
				strb.append(line);
				if(line.endsWith(";")){
					//System.out.println(strb.toString());
					s.execute(strb.toString());
					strb.setLength(0); //Clear out string buffer
				}
			}
			if(strb.toString().length()!=0){
				System.out.println(strb.toString());
				s.execute(strb.toString());
				
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
