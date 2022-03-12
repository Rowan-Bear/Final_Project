package com.rowanbear.musicManagement.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rowanbear.musicManagement.entity.Website;
import com.rowanbear.musicManagement.repository.PlaylistRepository;
import com.rowanbear.musicManagement.repository.WebsiteRepository;

@Service
public class WebsiteService {
	
	@Autowired
	private WebsiteRepository repo;
	
	@Autowired PlaylistRepository projectRepo;
	
	//CREATE
	public Website createWebsite(Website website) {
		return repo.save(website);
	}
	
	//READ - for a single website
	public Website getWebsiteById(Long Id) throws Exception {
		try {
			Optional <Website> site = repo.findById(Id);
			Website website = site.get();
			return website;
		}catch(Exception e) {
			throw new Exception("Unable to retrieve website by id");
		}
	}
	
	//READ - for all websites
	public Iterable<Website> getWebsites(){
		return repo.findAll();
	}
	
	//UPDATE
	public Website updateWebsite(Website website, Long id) throws Exception{
		try {
			Optional<Website> optOldWebsite = repo.findById(id);
			Website oldWebsite = optOldWebsite.get();
			oldWebsite.setName(website.getName());
			oldWebsite.setUrl(website.getUrl());
			oldWebsite.setId(website.getId());
			oldWebsite.setPlaylist(website.getPlaylist());
			return repo.save(oldWebsite);
			
		}catch(Exception e) {
			throw new Exception("Unable to update website.");
		}
	}
	
	//DELETE
	public void deleteWebsite(Long id) throws Exception {
		try {
			repo.deleteById(id);
		}catch(Exception e) {
			throw new Exception("Unable to delete customer.");
		}
	}
	
}
