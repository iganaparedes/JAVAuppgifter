package com.example.demo;

import java.util.ArrayList;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.BearBeans;
import com.example.demo.beans.ikeaBeans;
import com.example.demo.database.SQLconnection;

@RestController
public class WelcomeController {

	@RequestMapping(value = "/bear", method = RequestMethod.GET)
	public ArrayList<BearBeans> Search(@RequestParam String search) {

		String searchString = search;

		ArrayList<BearBeans> searchResult = new ArrayList<BearBeans>();

		// check if connection is open?
		if (SQLconnection.connectSQL()) {
			// send the string
			searchResult = SQLconnection.stateSQL(searchString, searchResult);

			return searchResult;
		} else {
			return searchResult;
		}

	}

	@RequestMapping(value = "/ikea", method = RequestMethod.GET)
	public ArrayList<ikeaBeans> Search1(@RequestParam String search) {

		String ikeaString = search;

		ArrayList<ikeaBeans> ikeaResult = new ArrayList<ikeaBeans>();

		// check if connection is open?
		if (SQLconnection.connectSQL()) {
			// send the string

			ikeaResult = SQLconnection.ikeaSQL(ikeaString, ikeaResult);
			return ikeaResult;
		} else {
			return ikeaResult;
		}

	}

}