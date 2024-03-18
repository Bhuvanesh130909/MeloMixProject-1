package com.example.demo.Controller;




import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;

	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Services.SongService;
import com.example.demo.Services.UserServices;

import com.example.demo.entity.Users;

import jakarta.servlet.http.HttpSession;


	@Controller
	public class UsersController {

		@Autowired
		UserServices userss;
		@Autowired
        SongService sserv;
		@PostMapping("register")
		public String addUser(@ModelAttribute Users user) {
			boolean userStatus = userss.emailExists(user.getEmail());
			if (userStatus == false) {
				userss.addUser(user);
				return "login";
			} 
			else 
			{
				return "emailalreadypresent";
			}
		}
		@PostMapping("adminuserregister")
		public String addadminUser(@ModelAttribute Users user) {
			boolean userStatus = userss.emailExists(user.getEmail());
			if (userStatus == false) {
				userss.addUser(user);
				return "adminlogin";
			} 
			else 
			{
				return "adminemailalreadypresent";
			}
		}

		@PostMapping("login")
		public String validateUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
			boolean emailExists = userss.emailExists(email);
	         if (!emailExists) {
	              // Email does not exist in the database, show registration fail message
	              return "registerfail";
	         }
	         
			boolean loginstatus = userss.validateUser(email, password);
			if (loginstatus == true) {
				session.setAttribute("email", email);
				if(userss.getRole(email).equals("Customer")) {
					return "customerhome";
				}
				else 
				{
					return "registerfail";
				}
			} 
			else 
			{
				return "loginfail";
			}
		}
		@PostMapping("adminlogin")
		public String adminvalidateUser(@RequestParam String email, @RequestParam String password, HttpSession session) {
			boolean emailExists = userss.emailExists(email);
	         if (!emailExists) {
	              // Email does not exist in the database, show registration fail message
	              return "adminemailnotfount";
	         }
			boolean loginstatus = userss.validateUser(email, password);
			if (loginstatus == true) {
				session.setAttribute("email", email);
				if(userss.getRole(email).equals("Admin")) {
					return "adminhome";
				}
				else 
				{
					return "adminemailnotfount";
				}
	
			}
			else {
				return "adminlogininvalidpassword";
			}
		}
	}