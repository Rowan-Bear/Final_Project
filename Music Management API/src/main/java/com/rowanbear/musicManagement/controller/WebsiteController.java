package com.rowanbear.musicManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.rowanbear.musicManagement.entity.Website;
import com.rowanbear.musicManagement.service.WebsiteService;

@RestController
@RequestMapping("/websites")
public class WebsiteController {
	
	@Autowired
	private WebsiteService service;
	
	//CREATE - POST
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createWebsite(@RequestBody Website website) { 
		try {
			return new ResponseEntity<Object>(service.createWebsite(website), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
	}
	
	//READ - GET
	// for a single website
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getWebsite(@PathVariable Long id) throws Exception{
		try{
			return new ResponseEntity<Object>(service.getWebsiteById(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	//READ - GET
	// for all websites
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getWebsites(){
		try{
			return new ResponseEntity<Object>(service.getWebsites(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	//UPDATE - PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateWebsite(@RequestBody Website website, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.updateWebsite(website, id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	//DELETE - DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteWebsite(@PathVariable Long id){
		try {
			service.deleteWebsite(id);
			return new ResponseEntity<Object>("Successfully deleted website with id: " + id, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
