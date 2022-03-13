package com.rowanbear.musicManagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rowanbear.musicManagement.entity.Playlist;
import com.rowanbear.musicManagement.entity.Song;
import com.rowanbear.musicManagement.entity.Website;
import com.rowanbear.musicManagement.repository.PlaylistRepository;
import com.rowanbear.musicManagement.repository.SongRepository;
import com.rowanbear.musicManagement.repository.WebsiteRepository;

@Service
public class PlaylistService {
	
	@Autowired
	private PlaylistRepository repo;
	
	@Autowired
	private WebsiteRepository websiteRepo;
	
	@Autowired
	private SongRepository songRepo;
	
	//CREATE
	
//	public Playlist submitNewPlaylist(Set<Long> songIds) throws Exception {
//		try {
//			Playlist playlist = initializeNewPlaylist(songIds);
//			return repo.save(playlist);
//			
//		}catch(Exception e) {
//			throw new Exception("Unable to submit new playlist.");
//		}
//	}
//
//	public Playlist initializeNewPlaylist(Set<Long> songIds) {
//		Playlist playlist = new Playlist();
//		playlist.setSongs(convertToSongSet(songRepo.findAllById(songIds)));
//		playlist.setDateCreated(LocalDate.now());
//		playlist.setId(playlist.getId());
//		return playlist;
//	}
//
//	public Set<Song> convertToSongSet(Iterable<Song> iterable) {
//		Set<Song> set = new HashSet<Song>();
//		for(Song song : iterable) {
//			set.add(song);
//		}
//		return set;
//	}
//	
//	//READ - GET
//	//for specific song
//	public Playlist getPlaylistById(Long Id) throws Exception {
//		try {
//			Optional <Playlist> site = repo.findById(Id);
//			Playlist playlist = site.get();
//			return playlist;
//		}catch(Exception e) {
//			throw new Exception("Unable to retrieve website by id");
//		}
//	}
//	
	//READ
	//for all playlists
	public Iterable<Playlist> getPlaylists(){
		return repo.findAll();
	}
//	
//	//UPDATE - add a song to playlist
//	public Playlist addSong(Long id, Song song) {
//		Optional<Playlist> oldPlaylist = repo.findById(id);
//		Playlist newPlaylist = oldPlaylist.get();
//		newPlaylist.getSongs().add(song);
//		return repo.save(newPlaylist);
//		
//	}
//	
//	//DELETE 
//	public void deletePlaylist(Long id) throws Exception {
//		try{
//			repo.deleteById(id);
//		}catch(Exception e) {
//			throw new Exception("Unable to delete customer.");
//		}
//	}
		
	
	
	

}
