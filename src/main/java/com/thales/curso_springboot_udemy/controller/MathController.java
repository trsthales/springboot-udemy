package com.thales.curso_springboot_udemy.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

	@RequestMapping("/sum/{numberOne}/{numberTwo}") 
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new Exception();
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	private boolean isNumeric(String strNumber) {
		if(strNumber == null || strNumber.isEmpty()) return false;
		String number = strNumber.replace(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
	private Double convertToDouble(String strNumber) {
		String number = strNumber.replace(",", ".");
		return Double.parseDouble(number);
	}
	
}
