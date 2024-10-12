package com.fiap.checkpoint.repository;

import com.fiap.checkpoint.model.Album;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album , Long> {

    List<Album> findByArtist(String artist);

    Page<Album> findAll(Pageable pageable);

}
