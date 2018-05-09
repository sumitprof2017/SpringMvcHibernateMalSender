/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ishara.controller;

import com.ishara.model.Person;
import com.ishara.service.PersonService;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author MR.Cutevil
 */@Controller
public class PersonController {
       @Autowired
    private PersonService personservice;
 
    @RequestMapping(value="/added")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<Person> pEmployee = personservice.getAllPerson();
        model.addObject("listEmployee", pEmployee);
        model.setViewName("home");
        return model;
    }
    @RequestMapping("/welcome")
	public ModelAndView helloWorld() {
 
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}
      
@RequestMapping(value="/products")
   public ModelAndView processProductPage() {
    ModelAndView mv=new ModelAndView();
    mv.setViewName("newjsp");

   String products="k xa re bhaiya";//Retrieve products from db

    mv.addObject("products",products);
    mv.addObject("hello","hai");


    return mv;
   }
   @RequestMapping(value="/display")
   public ModelAndView DisplayPage() {
    ModelAndView mv=new ModelAndView();
    
     List<Person> pEmployee = personservice.getAllPerson();
     //Result SEt jasto ho.....
     Iterator<Person> eI = pEmployee.iterator();
     //arko style ko iterator for(object next : ei) while eh.hasnext ko satta
     while(eI.hasNext()){
         System.out.println("///////////////////"+eI.next().getEmail());
     }
     mv.addObject("listemployee",pEmployee);
        System.out.println("ya samma vaeraxa");
          String products="k xa re bhaiya";//Retrieve products from db

    mv.addObject("products",products);
        mv.setViewName("home");
        return mv;
   }
}
