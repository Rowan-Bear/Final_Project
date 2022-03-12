package com.rowanbear.musicManagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.rowanbear.musicManagement.entity.Playlist;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {

}
