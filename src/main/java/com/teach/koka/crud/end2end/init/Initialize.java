package com.teach.koka.crud.end2end.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Initialize implements WebApplicationInitializer {

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		
		AnnotationConfigWebApplicationContext annotaionCtx = new AnnotationConfigWebApplicationContext();
		annotaionCtx.register(AppConfig.class);
		servletContext.addListener(new ContextLoaderListener(annotaionCtx));
		
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(annotaionCtx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
	}

}
