package com.example.demo.controllers;

import java.util.List;
//
//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Value;

import com.example.demo.entities.Dependent;
//
//import com.example.demo.daos.CabDriverDaoImpl;
import com.example.demo.entities.Enroller;
import com.example.demo.services.EnrollerService;

@RestController
@CrossOrigin(origins = "*")
public class WelcomeController {

	
	
	@Autowired
	private EnrollerService service;
	
	@Value("${server.port}")
	private String info;
	@GetMapping(path = "/enroller")
	public List<Enroller> findAll() {
		
		List<Enroller> EnrollerList = service.findAll();
//		driverList.get(0).setRating(Integer.parseInt(info));
		
		return EnrollerList;
	}
	
	
	@PostMapping(path = "/enroller/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Enroller Add( @RequestBody Enroller enrollee) {
		
	return this.service.add(enrollee);
		
		
	}
	
	@PostMapping(path = "/enroller/delete")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void Delete( @RequestBody Enroller enrollee) {
		
		this.service.delete(enrollee.getId());
			
	}
	
	@PostMapping(path = "/enroller/updateEnrolleeStatus")
	@ResponseStatus(code = HttpStatus.CREATED)
	public int UpdateStatus( @RequestBody Enroller enrollee,  boolean newStatus) {
		
		return this.service.updatestatus(enrollee.getId(),newStatus);
			
	}
	

	@PostMapping(path = "/enroller/updateEnrolleePhone")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void UpdatePhoneNumber( @RequestBody Enroller enrollee,  Long newphoneNumber) {
		
		this.service.updatephonenumber(enrollee.getId(),newphoneNumber);
			
	}
	
	@PostMapping(path = "/enroller/dependent/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void AddDependent( @RequestBody Dependent dependent) {
		
	 this.service.addDependent(dependent);
		
		
	}
	
	@PostMapping(path = "/enroller/dependent/delete")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void RemoveDependent( @RequestBody Enroller enrollee,int dp_id) {
		
	 this.service.removeDependent(enrollee,dp_id);
		
		
	}
	
}


