package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
		
		@RequestMapping(method = RequestMethod.GET, path= "/addition")
		public double calcAdd(double one, double two) {
			double sum = one + two;
			return sum;
		}
			
		@RequestMapping(method = RequestMethod.GET, path= "/multip")
		public double calcMul(double one, double two) {
			double sum = one * two;
			return sum;
		}
			
		@RequestMapping(method = RequestMethod.GET, path= "/divis")
		public double calcDivi(double one, double two) {
			double sum = one / two;
			return sum;
		}
			
		}
		
		
