/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumit.dao;

import com.sumit.model.Content;
import java.util.List;

/**
 *
 * @author MR.Cutevil
 */
public interface ContentDAO {
    //insert data in table  
    public int addContent(Content content);
     //to display data of table list 
    public List<Content> getAllContent();
    //fo delete
    public void deleteEmployee(Long employeeId);
    //fo edit send to edit page
     public Content getContentById(Long contentid);
     //update datas
    public Content updateContent(Content content);
   
}
