/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sumit.dao;

import com.sumit.model.Content;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MR.Cutevil
 */@Repository
 @Transactional
public class ContentDAOImpl implements ContentDAO{
@Autowired(required = true)
    private SessionFactory sessionFactory;
    
    @Override
    public List<Content> getAllContent() {
      return sessionFactory.getCurrentSession().createQuery("from Content")
                .list();
      //small content huda error auxa "From content" vanya yo...file ho Capital Content chainxa
      
    }

    @Override
    public int addContent(Content content) {
           Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(content);
          
        return Integer.valueOf(id.toString());
        //yesari ni milxa hola return Interger.valueOf(sessionFactory.getCurrentSession().save(content).toString);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Content content = (Content) sessionFactory.getCurrentSession().load(
                Content.class, employeeId);
        if (null != content) {
            this.sessionFactory.getCurrentSession().delete(content);
        }
    }

    

    @Override
    public Content updateContent(Content content) {
           sessionFactory.getCurrentSession().update(content);
        return content;
    }

    @Override
    public Content getContentById(Long contentid) {
          return (Content) sessionFactory.getCurrentSession().get(
                Content.class, contentid);
    }

    

    

    
    

  
 
    
    
}
