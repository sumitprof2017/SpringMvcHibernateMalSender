/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ishara.controller;



import com.ishara.bean.NewSessionBean;
import com.ishara.model.Person;
import com.ishara.service.PersonService;
import javax.ejb.EJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author MR.Cutevil
 */@Controller
 @EJB
 
public class HomeController {
     @Autowired
     private PersonService personservice;
     
     
     
  @RequestMapping(value="/")
    public String showIndex(){
        return "logindashboard";
        //return "index"; modifeied
    }
    
     @RequestMapping(value="/index")
    public String sendEmail(){
        return "index";
        //return "index"; modifeied
    }
    
//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//public String checkLogin(@ModelAttribute("userFormData") LoginDTO formData, BindingResult 
//result) {
//
//    System.out.println("Controller...");
//
//    System.out.println("=====>  " + formData.getUsername());
//    System.out.println("=====>  " + formData.getPassword());
//
//}
    @RequestMapping(value="/add",method=RequestMethod.POST)
    public String addPerson(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("subject") String subject,@RequestParam("message") String message) {
        Person p = new Person();
        p.setName(name);
        p.setEmail(email);
        p.setSubject(subject);
        p.setMessage(message);
        
        int id= personservice.addPerson(p);
        
        if(id!=0){
           String fromemail="sumitbabucutevil@gmail.com";
           String username="sumitbabucutevil";
           String password="vivalarasa";
           
           NewSessionBean nb = new NewSessionBean();
           nb.sendEmail(email, subject, message);
           //nb.send();
             
            return "success";
        }
        else  {      
        return "fail";
    }
    }
  
}
