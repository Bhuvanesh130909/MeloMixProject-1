package com.example.demo.Services;


	import java.util.List;

import com.example.demo.entity.Song;

	

	public interface SongService {
		public String addSongs(Song song);
		public boolean nameExist(String name);
		public List<Song> viewSongs();
		public void updateSong(Song song);
	}

