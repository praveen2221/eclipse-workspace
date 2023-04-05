package com.brigelabz.SpotifyAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AppTest 
{
	public String token = "Bearer BQDSGZXmXJG3t4dMYFZvTU5en03fR-dQcJdcfHQ9CYl77F18W72Ef6MIT-8Zw1kVkzKAzQAzM1-8fDSlR2JQ4XXNmNde4g7j0yGAHM_LCy8FEndxEdK45k4OSU_QfRbMiSqN5UEaG00Xhm3qd85i7u1Azm6sGQqZoKn0idj4ENZH5BwD3y26KddP4jSjZ3N4ylhSu155arJjjgpltjlaspDl6w";
   @Test(priority = 0)
   public void getUserProfile() {
	   RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);
		
		Response response = requestSpecification.request(Method.GET,"https://api.spotify.com/v1/me");
		
	    Object userID = response.path("id");
		System.out.println("user ID:"+userID);
		
		response.prettyPrint();
		
		String statusLineString = response.statusLine();
		System.out.println("StatusLine:" +statusLineString);
		
		int statusCode =response.statusCode();
       Assert.assertEquals(statusLineString, "HTTP/1.1 200 OK"); 
   }
   
   @Test(priority = 1)
   public void getUserProfileWithID() {
	   RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);
		
		Response response = requestSpecification.request(Method.GET,"https://api.spotify.com/v1/users/sp98i6gclyhjihvmkz578yx2f");
		response.prettyPrint();
		
		int statusCode =response.statusCode();
       Assert.assertEquals(statusCode, 200); 
   }
   
   @Test(priority = 2)
   public void GetCurrentUserPlaylists() {
	   RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);
		
		Response response = requestSpecification.request(Method.GET,"https://api.spotify.com/v1/me/playlists?limit=10&offset=5");
		response.prettyPrint();
		
		int statusCode =response.statusCode();
       Assert.assertEquals(statusCode, 200); 
   }
}
