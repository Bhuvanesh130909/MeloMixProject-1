package com.example.demo.Controller;


	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Services.SongService;
import com.example.demo.entity.Song;

	@Controller
	public class SongsController {
		@Autowired
		SongService songserv;
		
		@PostMapping("AddSongs")
		public String addSongs(@ModelAttribute Song song) {
			boolean result=songserv.nameExist(song.getName());
			if(result == false) {
				songserv.addSongs(song);
				return "addsongsuccess";
			}
			else {
				return "addsongfail";
			}
		}
		
		@GetMapping("mapViewSongs")//for admin
		public String viewSongs(Model model) {
			List<Song> lis=songserv.viewSongs();
			model.addAttribute("songs", lis);
			return "viewsongs";
		}
		
		@GetMapping("mapViewCustomerSongs")// for customer
		public String viewCustomerSongs(Model model) {
			boolean primeStatus = true;
			if(primeStatus == true) {
				List<Song> lis=songserv.viewSongs();
				model.addAttribute("songs", lis);
				return "viewsongcustomer";
			}
			else {
				return "makepayment";
			}

		}

		@GetMapping("exploreSongs")// for customer
		public String viewsongCustomerSongs(Model model) {
			
				List<Song> lis=songserv.viewSongs();
				model.addAttribute("songs", lis);
				return "viewsongcustomer";
			}
		
		
	}


