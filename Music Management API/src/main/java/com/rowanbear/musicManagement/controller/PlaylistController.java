package com.rowanbear.musicManagement.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rowanbear.musicManagement.entity.Song;
import com.rowanbear.musicManagement.service.PlaylistService;

@RestController
@RequestMapping("/playlists") 
/**
 * 
 * @author rowan
 *
 */
//when does this become plural? Where does the S come from

public class PlaylistController {
	
	@Autowired
	private PlaylistService service;
	
	//CREATE - POST
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> 
	createPlaylist(@RequestBody Set<Long> songIds, @PathVariable Long websiteId) throws Exception{
		try {
			return new ResponseEntity<Object>(service.submitNewPlaylist(songIds, websiteId), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	//READ - GET
	//for specific playlist
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getPlaylist(@PathVariable Long id) throws Exception{
		try{
			return new ResponseEntity<Object>(service.getPlaylistById(id), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	//READ - GET
	//for all playlists
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Object> getPlaylists() throws Exception{
		try{
			return new ResponseEntity<Object>(service.getPlaylists(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	//UPDATE - PUT
	//add a song to playlist
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> addSong(@PathVariable Long id, @RequestBody Song song){
		try {
			return new ResponseEntity<Object>(service.addSong(id, song), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	//DELETE - DELETE
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deletePlaylist(@PathVariable Long id){
		try {
			service.deletePlaylist(id);
			return new ResponseEntity<Object>("Successfully deleted playlist with id: " + id, HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
