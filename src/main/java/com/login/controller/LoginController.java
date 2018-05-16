/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.controller;

import com.login.model.Login;
import com.login.service.LoginService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MR.Cutevil
 */@Controller
public class LoginController {
     @Autowired
     private LoginService loginservice;
    @RequestMapping(value="/login")
    public String name(){
        return "index";
    }
    
    
    
     
    
    
    
     @RequestMapping(value = "/checkuser1", method = RequestMethod.POST)
    public String submit(@RequestParam("username") String username,@RequestParam("password") String password) {
     Login login = new Login();
     login.setUsername(username);
     login.setPassword(password);
     boolean userExists = loginservice.checkLogin(login.getUsername(), login.getPassword());
     if(userExists){
			
			return "dashboard";
		}else{
			
			return "logindashboard";
		}
    }
    //Principal vaneko login gareko user haru.....
    private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		return "access-denied";
	}
    }
//   @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
//    public String submit(
//      @ModelAttribute("employee") Employee employee,
//      BindingResult result, ModelMap model) {
//        if (result.hasErrors()) {
//            return "error";
//        }
//        model.addAttribute("name", employee.getName());
//        model.addAttribute("id", employee.getId());
// 
//        employeeMap.put(employee.getId(), employee);
// 
//        return "employeeView";
//    }


//	
//	@Autowired
//	public LoginService loginService;
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String showForm(Map model) {
//		LoginForm loginForm = new LoginForm();
//		model.put("loginForm", loginForm);
//		return "loginform";
//	}
//
//	@RequestMapping(method = RequestMethod.POST)
//	public String processForm(@Valid LoginForm loginForm, BindingResult result,
//			Map model) {
//
//		
//		if (result.hasErrors()) {
//			return "loginform";
//		}
//		
//		/*
//		String userName = "UserName";
//		String password = "password";
//		loginForm = (LoginForm) model.get("loginForm");
//		if (!loginForm.getUserName().equals(userName)
//				|| !loginForm.getPassword().equals(password)) {
//			return "loginform";
//		}
//		*/
//		boolean userExists = loginService.checkLogin(loginForm.getUserName(),
//                loginForm.getPassword());
//		if(userExists){
//			model.put("loginForm", loginForm);
//			return "loginsuccess";
//		}else{
//			result.rejectValue("userName","invaliduser");
//			return "loginform";
//		}
//
//	}
//  

    
 

    

