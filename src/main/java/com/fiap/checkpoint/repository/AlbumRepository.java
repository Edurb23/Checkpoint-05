package com.fiap.checkpoint.repository;

import com.fiap.checkpoint.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album , Long> {
}
