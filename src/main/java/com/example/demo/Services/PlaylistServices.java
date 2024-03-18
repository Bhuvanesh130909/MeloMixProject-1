package com.example.demo.Services;



	import java.util.List;

import com.example.demo.entity.Playlist;

	
	public interface PlaylistServices {
		
		public void addPlaylist(Playlist play);

		public List<Playlist> viewPlaylist();
	
	}


