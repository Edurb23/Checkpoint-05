package com.fiap.checkpoint.repository;


import com.fiap.checkpoint.model.Album;
import com.fiap.checkpoint.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {


    List<Artist> findByArtistName(String artistName);

}
