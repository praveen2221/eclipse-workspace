package com.brigelabz.RestAPI;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.restassured.RestAssured;

public class Deserilization {
  @Test
  public void deserilization() throws JsonProcessingException {
	  String urlString = "http://localhost:3000/posts/4";
	  BlogPosts blogPosts = RestAssured.given().get(urlString).as(BlogPosts.class);
	  System.out.println("blgf6"+blogPosts.toString());
  }
}
