package com.cognizant.Rest_Practice_Check_Truyum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="Cart is Empty")
public class CartEmptyException extends Exception {

}