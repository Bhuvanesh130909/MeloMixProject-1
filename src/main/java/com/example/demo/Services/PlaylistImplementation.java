package com.example.demo.Services;



	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.example.demo.Repositories.PlaylistRepository;
import com.example.demo.entity.Playlist;

	@Service
	public class PlaylistImplementation implements PlaylistServices{
		
		@Autowired
		PlaylistRepository playrepo;

		@Override
		public void addPlaylist(Playlist play) {
			playrepo.save(play);
		}

		@Override
		public List<Playlist> viewPlaylist() {
			return playrepo.findAll();
		}



	}

