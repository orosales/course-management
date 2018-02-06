package com.orosals.soap.webservices.coursemanagement.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import pe.com.orosales.courses.CourseDetails;
import pe.com.orosales.courses.GetCourseDetailsRequest;
import pe.com.orosales.courses.GetCourseDetailsResponse;

@Endpoint
public class CourseDetailsEndPoint {

	//method
	//input - GetCourseDetailsRequest
	//output - GetCourseDetailsReponse
	
	//http://orosales.com.pe/courses
	//GetCourseDetailsRequest
	
	@PayloadRoot(namespace="http://orosales.com.pe/courses", 
			localPart="GetCourseDetailsRequest" )
	@ResponsePayload
	public GetCourseDetailsResponse processCourseDetailsRequest(
			@RequestPayload GetCourseDetailsRequest request) {
		
		GetCourseDetailsResponse response = new GetCourseDetailsResponse();
		CourseDetails courseDetails = new CourseDetails();
		courseDetails.setId(request.getId());
		courseDetails.setName("Microservices");
		courseDetails.setDescription("Amazing course");
		response.setCourseDetails(courseDetails );
		return response;
	}
}
