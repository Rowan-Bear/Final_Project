//many to many relationship with playlists

package com.rowanbear.musicManagement.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Song {

	private Long id;
	private String artist;
	private String title;
	private Long bpm;
	private String key;
	private Set<Playlist> playlists;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Long getBpm() {
		return bpm;
	}
	
	public void setBpm(Long bpm) {
		this.bpm = bpm;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	@ManyToMany
	@JoinColumn(name = "playlistId")
	public Set<Playlist> getPlaylist() {
		return playlists;
	}
	
	public void setPlaylist(Set<Playlist> playlists) {
		this.playlists = playlists;
	}
	
	

	
}
