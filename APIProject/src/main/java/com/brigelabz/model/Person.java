package com.brigelabz.model;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"firstName",
"lastName",
"age",
"id",
"address",
"phoneNumber"
})
@Generated("jsonschema2pojo")
public class Person {

@JsonProperty("firstName")
private String firstName;
@JsonProperty("lastName")
private String lastName;
@JsonProperty("age")
private Integer age;
@JsonProperty("id")
private Integer id;
@JsonProperty("address")
private String address;
@JsonProperty("phoneNumber")
private String phoneNumber;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("firstName")
public String getFirstName() {
return firstName;
}

@JsonProperty("firstName")
public void setFirstName(String firstName) {
this.firstName = firstName;
}

@JsonProperty("lastName")
public String getLastName() {
return lastName;
}

@JsonProperty("lastName")
public void setLastName(String lastName) {
this.lastName = lastName;
}

@JsonProperty("age")
public Integer getAge() {
return age;
}

@JsonProperty("age")
public void setAge(Integer age) {
this.age = age;
}

@JsonProperty("id")
public Integer getId() {
return id;
}

@JsonProperty("id")
public void setId(Integer id) {
this.id = id;
}

@JsonProperty("address")
public String getAddress() {
return address;
}

@JsonProperty("address")
public void setAddress(String address) {
this.address = address;
}

@JsonProperty("phoneNumber")
public String getPhoneNumber() {
return phoneNumber;
}

@JsonProperty("phoneNumber")
public void setPhoneNumber(String phoneNumber) {
this.phoneNumber = phoneNumber;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}
}
