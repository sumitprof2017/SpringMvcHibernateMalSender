/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ishara.controller;



import com.ishara.bean.NewSessionBean;
import com.ishara.model.Person;
import com.ishara.service.PersonService;
import com.sumit.model.Content;
import com.sumit.service.ContentService;
import java.util.List;
import javax.ejb.EJB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MR.Cutevil
 */@Controller
 @EJB
 
public class HomeController {
     @Autowired
     private PersonService personservice;
     
     @Autowired
     private ContentService contentservice;
     
     
     
  @RequestMapping(value="/")
    public String showIndex(){
        return "logindashboard";
        //return "index"; modifeied
    }
    
     @RequestMapping(value="/index")
    public ModelAndView sendEmail(){
       ModelAndView mv=new ModelAndView();
    
  List<Content> psEmployee = contentservice.getAllContent();
     mv.addObject("listemployee", psEmployee);
         mv.setViewName("index");
         return mv;
        
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
    public ModelAndView addIndexData(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("subject") String subject,@RequestParam("message") String message) {
        Person p = new Person();
        p.setName(name);
        p.setEmail(email);
        p.setSubject(subject);
        p.setMessage(message);
        ModelAndView mv = new ModelAndView();
        int id= personservice.addPerson(p);
        
        if(id!=0){
           String fromemail="sumitbabucutevil@gmail.com";
           String username="sumitbabucutevil";
           String password="vivalarasa";
           
           NewSessionBean nb = new NewSessionBean();
           nb.sendEmail(email, subject, message);
           //nb.send();
             mv.addObject("msg1", "Your data is sent succesfully");
             mv.setViewName("index");
           return mv;
        }
        else  {      
        mv.addObject("msg2", "Some troubles occured while send the email");
        mv.setViewName("index");
        return mv;
    }
    }
  
}
