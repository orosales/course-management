package com.orosals.soap.webservices.coursemanagement.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//Enable Spring WS
@EnableWs
//Spring Configuration
@Configuration
public class WebServiceConfig {
	//MessageDispatchServlet
		//ApplicationContext
	//URL -> /ws/*
	
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
		//MessageDispatcherServlet, "/ws/*"
		
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(applicationContext);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(messageDispatcherServlet, "/ws/*");
	}

	//  ws/courses.wsdl
		// PortType: coursePort
		// Namespace: http://orosales.com.pe/courses
	//  course-details.xsd
	
	@Bean(name="courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema) {
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		// PortType: CoursePort
		definition.setPortTypeName("CoursePort");
		
		// Namespace: http://orosales.com.pe/courses
		definition.setTargetNamespace("http://orosales.com.pe/courses");
		// /ws
		definition.setLocationUri("/ws");
		// schema
		definition.setSchema(coursesSchema);
		
		
		return definition;
	}
	
	@Bean
	public XsdSchema coursesSchema() {
		
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd") );
	}
	
}
