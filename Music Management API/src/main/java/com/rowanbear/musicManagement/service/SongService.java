package com.rowanbear.musicManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rowanbear.musicManagement.entity.Song;
import com.rowanbear.musicManagement.repository.SongRepository;

@Service
public class SongService {
	
	@Autowired
	private SongRepository repo;
	
	//CREATE - POST
	
	public Song createSong(Song song) {
		return repo.save(song);
	}
	
	//READ - for a single song
	public Song getSongById(Long id) throws Exception {
		try {
			Optional <Song> s = repo.findById(id);
			Song song = s.get();
			return song;
		}
		catch(Exception e) {
			throw new Exception("Unable to retrieve customer by id");
		}
	}
	
	//READ - for all songs
	public Iterable<Song> getSongs(){
			return repo.findAll();
		}
		
		//UPDATE - PUT
			public Song updateSong(Song song, Long id) throws Exception{
				try {
					Optional<Song> optOldSong = repo.findById(id);
					Song oldSong = optOldSong.get();
					oldSong.setArtist(song.getArtist());
					oldSong.setTitle(song.getTitle());
					oldSong.setBpm(song.getBpm());
					oldSong.setKey(song.getKey());
					return repo.save(oldSong);
				}catch(Exception e) {
					throw new Exception("Unable to update song.");
				}
			}
			
		
		//DELETE - DELETE
			public void deleteSong(Long id) throws Exception {
				try {
					repo.deleteById(id);
				}catch(Exception e) {
				throw new Exception("Unable to delete customer.");
			}
			}
}
