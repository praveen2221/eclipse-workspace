package com.brigelabz.helper;

import java.lang.reflect.Type;
import java.util.List;

import javax.xml.ws.Response;

import com.brigelabz.Utils.ConfigManager;
import com.brigelabz.model.Person;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;

public class PersonServiceHelper {
	public static final String BASE_URL = ConfigManager.getInstance().getString("base_url");
    public static final String PORT = ConfigManager.getInstance().getString("port");
    
    public PersonServiceHelper() {
		// TODO Auto-generated constructor stub
    	RestAssured.baseURL = BASE_URL;
        RestAssured.port = Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation();
    }
    
    public List<Person> getAllPerson(){
    	
    	Response response = RestAssured
    			.given().log().all()
    			.contentType(ContentType.JSON)
    			.get(Endpoint,GET_ALL_PERSON)
    			.andReturn();
    	
    	Type type = new TypeReference<List<Person>>[]{}.getType();
    	List<Person> personList = response.as(type);
    	return personList;
    }
}
