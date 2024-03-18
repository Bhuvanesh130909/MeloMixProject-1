package com.example.demo.Controller;


	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;

	@Controller
	public class NavController {
		
		@GetMapping("register")
		public String mapRegister() {
			return "index";
		}
		
		@GetMapping("login")
		public String mapLogin() {
			return "login";
		}
		
		@GetMapping("mapSong")
		public String mapSongs() {
			return "addsongs";
		}
		
		@GetMapping("samplepayment")
		public String samplepayment() {
			return "samplepayment";
		}
		@GetMapping("againcustomer")
		public String againhome() {
			return "customerhome";
		}
		@GetMapping("againadmin")
		public String againadminhome() {
			return "adminhome";
		}
		@GetMapping("adminloginpage")
		public String adminlogin() {
			return "adminlogin";
		}
		@GetMapping("adminregister")
		public String mapAdminRegister() {
			return "adminregister";
		}
		@GetMapping("customerregisterpage")
		public String mapCustomerRegister() {
			return "index";
		}
	}


