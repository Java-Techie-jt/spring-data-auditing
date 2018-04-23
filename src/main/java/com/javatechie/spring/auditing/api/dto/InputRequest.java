package com.javatechie.spring.auditing.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class InputRequest<T> {
	@JsonProperty(value = "userId", required = true)
	private String loggedInUser;
	private String timeZone;
	private T employee;
}
