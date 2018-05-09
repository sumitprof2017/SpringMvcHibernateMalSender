/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumit.controller;

import com.sumit.model.Content;
import com.sumit.service.ContentService;
import java.util.Iterator;
import java.util.List;
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
public class ContentController {
     
//      @Autowired
//     private ContentDAO contentdao;
      
       @Autowired
     private ContentService contentservice;
      
      
     @RequestMapping(value="/content")
   public ModelAndView DisplayPage() {
    ModelAndView mv=new ModelAndView();
    
  List<Content> psEmployee = contentservice.getAllContent();
     //Result SEt jasto ho.....
     Iterator<Content> eI = psEmployee.iterator();
     while(eI.hasNext()){
         System.out.println("///////////////////"+eI.next().getDescription());
     }
         mv.addObject("listemployee", psEmployee);
         //ya space nadiera uta data gaeerako thiena before psEmployee....
        System.out.println("ya samma vaeraxa");
          String products="k xa re bhaiya";//Retrieve products from db

    mv.addObject("products",products);
        mv.setViewName("content");
//        mv.setViewName("dashboard");
        return mv;
   }
   
   @RequestMapping(value="/addcontent",method=RequestMethod.POST)
    public String addContent(@RequestParam("icon") String icon,@RequestParam("heading") String heading,@RequestParam("description") String description) {
        Content c = new Content();
        c.setIcon(icon);
        c.setHeading(heading);
        c.setDescription(description);
        
        int id= contentservice.addContent(c);
        
        if(id!=0){
          
            return "success";
        }
        else  {      
        return "fail";
    }
}
    @RequestMapping(value="/addallcontent")
    public String addallcontent(){
        return "addallcontent";
    }
 }
