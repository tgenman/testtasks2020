package com.example.incrementator.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE, reason="not all numbers in the request")
public class NotNumberValueException extends RuntimeException {
}
