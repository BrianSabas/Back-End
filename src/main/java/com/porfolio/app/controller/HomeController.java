package com.porfolio.app.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = {"", "/"})
public class HomeController {	

	@ResponseBody
	@GetMapping
	public String index() {		
		//Controlador principal		
		return "Welcome to my API";
	}	

}
