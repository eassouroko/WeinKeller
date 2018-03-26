package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
//import com.service.EmailService;
import com.service.UserService;

@Controller
public class LoginController {
	//private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserService userService;
	//private EmailService emailService;
 
    @Autowired
    public LoginController( UserService userService) {
      
     // this.bCryptPasswordEncoder = bCryptPasswordEncoder;
      this.userService = userService;
     
    }
    
 // Return login form template
 	@RequestMapping(value="/login", method = RequestMethod.GET)
 	public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user){
 		modelAndView.addObject("user", user);
 		modelAndView.setViewName("login");
 		return modelAndView;
 	}
 	
 // Process form input data
 	@RequestMapping(value = "/register", method = RequestMethod.POST)
 	public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult, HttpServletRequest request) {
 	// Lookup user in database by e-mail
 			User userExists = userService.findByEmail(user.getEmail());
 			
 			System.out.println(userExists);
 			
 			if ((userExists == null)||!(user.getPassword().contentEquals(userExists.getPassword()))) {
 				modelAndView.addObject("WrongEmailOrPasswordMessage", "Please provide a correct user Id or password.");
 				modelAndView.setViewName("login");
 				bindingResult.reject("email");
 			}
 			if (bindingResult.hasErrors()) { 
 				modelAndView.setViewName("login");	
 				
 			} else { // show the welcome page
 			
 			
 			}
 			
 		
 		return modelAndView;
 	}

}
