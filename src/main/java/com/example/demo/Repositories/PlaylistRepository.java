package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}
