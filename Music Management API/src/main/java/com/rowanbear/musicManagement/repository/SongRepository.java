package com.rowanbear.musicManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.rowanbear.musicManagement.entity.Song;

public interface SongRepository extends CrudRepository<Song, Long> {

}
