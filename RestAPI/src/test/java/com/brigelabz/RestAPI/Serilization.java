package com.brigelabz.RestAPI;


import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Serilization {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    @Test
    public void seriliza() throws JsonProcessingException {
		BlogPosts blogPosts = new BlogPosts();
		blogPosts.setId(6);
    	blogPosts.setTitle("CQA-107");
    	blogPosts.setAuthor("Praveen");
    	
    	String urlString = "http://localhost:3000/posts";
    	String jsonString = MAPPER.writeValueAsString(blogPosts);
    	
    	Response response = RestAssured.given().
    	              contentType(ContentType.JSON)
    	              .body(jsonString)
    	              .log()
    	              .all()
    	              .post(urlString);
    	response.prettyPrint();
        response.statusCode();	
    }
}
