package com.fiap.checkpoint.repository;

import com.fiap.checkpoint.model.Album;
import java.util.List;

import com.fiap.checkpoint.model.GenMusic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album , Long> {

    List<Album> findByArtist(String artist);

}
