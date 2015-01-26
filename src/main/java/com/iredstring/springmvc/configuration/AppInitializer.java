package com.iredstring.springmvc.configuration;

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
		servlet.addMapping("/api/hello");
		servlet.addMapping("/api/hello2");
		servlet.addMapping("/api/hello3/*");
		servlet.addMapping("/api/emp/list");
		servlet.addMapping("/api/emp/new");
		servlet.addMapping("/api/emp/delete");
		servlet.addMapping("/restapi/hello3");		
	}

}
