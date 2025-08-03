package com.thales.curso_springboot_udemy.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thales.curso_springboot_udemy.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {

	@RequestMapping("/sum/{numberOne}/{numberTwo}") 
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("please set a numeric value");
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}
	
	@RequestMapping("/subtraction/{numberOne}/{numberTwo}") 
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("please set a numeric value");
		return convertToDouble(numberOne) - convertToDouble(numberTwo);
	}
	
	@RequestMapping("/multiplication/{numberOne}/{numberTwo}") 
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("please set a numeric value");
		return convertToDouble(numberOne) * convertToDouble(numberTwo);
	}
	
	@RequestMapping("/division/{numberOne}/{numberTwo}") 
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("please set a numeric value");
		return convertToDouble(numberOne) / convertToDouble(numberTwo);
	}
	
	@RequestMapping("/average/{numberOne}/{numberTwo}") 
	public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo ) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("please set a numeric value");
		return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
	}
	
	@RequestMapping("/squareRoot/{numberOne}") 
	public Double squareRoot(@PathVariable("numberOne") String numberOne ) throws Exception{
		if(!isNumeric(numberOne)) throw new UnsupportedMathOperationException("please set a numeric value");
		return Math.sqrt(convertToDouble(numberOne));
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
