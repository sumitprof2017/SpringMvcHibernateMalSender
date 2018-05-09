/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumit.service;

import com.sumit.model.Content;
import java.util.List;

/**
 *
 * @author MR.Cutevil
 */
public interface ContentService {
      public int addContent(Content content);
       public List<Content> getAllContent();
//       public void deleteEmployee(Integer employeeId); long ma thyo data so
         public void deleteEmployee(Long employeeId);
        public Content getContentById(Long contentid);
         public Content updateContent(Content content);
}
