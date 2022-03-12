//one to many relationship with Playlist

///needs joining anotation w/ playlist
package com.rowanbear.musicManagement.entity;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Website {
	
	private String name;
	private String url;
	private Long id;
	private Set<Playlist> playlists;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "website")
	public Set<Playlist> getPlaylist() {
		return playlists;
	}
	
	public void setPlaylist(Set<Playlist> playlists) {
		this.playlists = playlists;
	}

}
