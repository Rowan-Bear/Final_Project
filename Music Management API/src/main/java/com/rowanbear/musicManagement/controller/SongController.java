package com.rowanbear.musicManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rowanbear.musicManagement.entity.Song;
import com.rowanbear.musicManagement.service.SongService;

@RestController
@RequestMapping("/songs")
public class SongController {
	
	@Autowired
	private SongService service;
	
	//CREATE - POST REQUEST
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createCustomer(@RequestBody Song song){
		try {
			return new ResponseEntity<Object>(service.createSong(song), HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	//READ - GET REQUEST
	//getting a specific song - find by id using service
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCustomer(@PathVariable long id) throws Exception{
		try {
			return new ResponseEntity<Object>(service.getSongById(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	//READ - GET REQUEST 
	//getting all songs
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getCustomers(){
		try {
			return new ResponseEntity<Object>(service.getSongs(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	//UPDATE - PUT
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateSong(@RequestBody Song song, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.updateSong(song, id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	//DELETE - DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object>
	deleteCustomer(@PathVariable Long id){
		try { service.deleteSong(id);
			return new ResponseEntity<Object>("Successfully deleted song wtih id: " + id, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
