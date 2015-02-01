package com.iredstring.springmvc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


import org.joda.time.LocalDate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.iredstring.springmvc.model.Employee;
import com.iredstring.springmvc.service.EmployeeService;

public class TestHsqlDBEmployee {

	static EmployeeService service;

	public static void main(String[] args) {

		setupHsqlDB();

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.iredstring.springmvc");
		context.refresh();

		service = (EmployeeService) context.getBean("employeeService");
		
		createEmployeesInDB();

		for(Employee e : service.findAllEmployees()){
			System.out.println(e);
		}
		
		context.close();
		
		
	}

	public static void setupHsqlDB() {
		Connection c = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			c = DriverManager.getConnection("jdbc:hsqldb:mem:mymemdb", "sa", "");
			//c = DriverManager.getConnection("jdbc:hsqldb:file:hsqldb/hsqldb-file;shutdown=true;hsqldb.write_delay=false;", "sa", "");

			Statement s = c.createStatement();
			String sql = "CREATE TABLE EMPLOYEE(" 
					+ "id INTEGER IDENTITY, "
					+ "name VARCHAR(50) , " 
					+ "joining_date DATE , "
					+ "salary DOUBLE , " 
					+ "ssn VARCHAR(30) UNIQUE );";
			
			s.execute(sql);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (Exception e) {
			}
		}
		
		
	}

	
	
	public static void createEmployeesInDB() {

		Employee peter = new Employee();
		peter.setName("peter");
		peter.setJoiningDate(new LocalDate("2010-01-11"));
		peter.setSalary(new BigDecimal("101000"));
		peter.setSsn("ssn1");

		Employee nancy = new Employee();
		nancy.setName("nancy");
		nancy.setJoiningDate(new LocalDate("2010-02-13"));
		nancy.setSalary(new BigDecimal("102000"));
		nancy.setSsn("ssn2");

		service.saveEmployee(peter);
		service.saveEmployee(nancy);

	}

}
