/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumit.service;

import com.sumit.dao.ContentDAO;
import com.sumit.model.Content;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MR.Cutevil
 */@Service
 @Transactional
public class ContentServiceImpl implements ContentService {
@Autowired
     private ContentDAO contentdao;
    
    @Override
    @Transactional
    public List<Content> getAllContent() {
        return contentdao.getAllContent(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addContent(Content content) {
            return contentdao.addContent(content);
            //int vaera matra return tala void so no return..
    }

    @Override
    public void deleteEmployee(Long employeeId) {
      contentdao.deleteEmployee(employeeId); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public Content updateContent(Content content) {
 return contentdao.updateContent(content);    
    }

    @Override
    public Content getContentById(Long contentid) {
   return contentdao.getContentById(contentid);
    }

    

 
  

   

  
    
}
