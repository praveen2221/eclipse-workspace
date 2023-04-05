package com.brigelabz.apitest;

import com.brigelabz.helper.PersonServiceHelper;
import com.brigelabz.model.Person;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestGETPerson {
private PersonServiceHelper personServiceHelper;
    
    @BeforeClass
    public void init() {
    	personServiceHelper = new PersonServiceHelper();
    }
    
    @Test
    public void getAllPerson() {
    	List<Person> personlList = personServiceHelper.getAllPerson();
    	assertNotNull(personlList,"Person list is not empty");
    	assertFalse(personlList.isEmpty(),"Person list is not true");
    }
}
