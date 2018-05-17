/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ishara.controller;

import com.sumit.model.Content;
import com.sumit.service.ContentService;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MR.Cutevil
 */@Controller
public class DashboardController {
       @Autowired
     private ContentService contentservice;
      
   @RequestMapping(value="/dashboard")
    public ModelAndView getdashboard(){
        ModelAndView mv = new ModelAndView();
        List<Content> psEmployeee = contentservice.getAllContent();
    Iterator<Content> eI = psEmployeee.iterator();
     while(eI.hasNext()){
         System.out.println("///////////////////"+eI.next().getDescription());
     }
         mv.addObject("listemployeee", psEmployeee);
         //ya space nadiera uta data gaeerako thiena before psEmployee....
        System.out.println("ya samma vaeraxa");
          String products="k xa re bhaiya";//Retrieve products from db

    mv.addObject("product", products);
        mv.setViewName("dashboard");
        return mv;
    }
     @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteContent(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        Long employeeId = Long.parseLong(request.getParameter("id"));
        contentservice.deleteEmployee(employeeId);
          List<Content> psEmployeees = contentservice.getAllContent();
           mv.addObject("listemployeees", psEmployeees);
           mv.setViewName("delete");
           return mv;
        
    }
    
    
    
      @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView editContent(HttpServletRequest request) {
        Long contentid = Long.parseLong(request.getParameter("id"));
            Content content1 = contentservice.getContentById(contentid);
        ModelAndView model = new ModelAndView("contentform");
        model.addObject("editbycontent", content1);
         String products="k xa re bhaiya";
         model.addObject("punit", products);
       
        return model;
    }

    
     @RequestMapping(value = "/updatecontent", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute Content content) {
       if (content.getId() == 0) { // if employee id is 0 then creating the
           // employee other updating the employee
          
            contentservice.addContent(content);
      } else {
            contentservice.updateContent(content);
       }
        return new ModelAndView("dashboard");
    }
    
    
    
     
}
