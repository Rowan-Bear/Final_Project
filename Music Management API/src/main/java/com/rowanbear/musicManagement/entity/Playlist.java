//many to many relationship with songs
//many to one relationship with website

package com.rowanbear.musicManagement.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Playlist {
	
	
	private LocalDate dateCreated;
	private Long id;
	private Set<Song> songs;
	
	@JsonIgnore
	private Website website;
	
	@ManyToOne
	@JoinColumn(name = "websiteId")
	public Website getWebsite () {
		return website;
	}

	public void setWebsite (Website  website) {
		this.website  = website ;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToMany(mappedBy = "playlist")
	public Set<Song> getSongs() {
		return songs;
	}
	
	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}

	
	
}
