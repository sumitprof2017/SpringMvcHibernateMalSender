/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author MR.Cutevil
 */@Repository
 @Transactional
public class LoginDAOImpl implements LoginDAO {

     @Autowired(required = true)
    private SessionFactory sessionFactory;
   

       public boolean checkLogin(String username, String userpassword){
			System.out.println("In Check login");
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			//Query using Hibernate Query Language
                        //Login vanne  class ko naam dont put table name login....
                        
			String SQL_QUERY = "from Login as o where o.username=? and o.password=?";
			//Mathiko login class ko naam ho entity class not login of table and username ra password 
                        //property ho tyo class ko username ra property
                        Query query = session.createQuery(SQL_QUERY);
                        //query ma sql query save hunxa jasma login bata username ra pass magya xa
			query.setParameter(0,username);
                        //ako username ma username hunxa
			query.setParameter(1,userpassword);
                        //ako password userpassword ma save hunxa
			List list = query.list();
                        //list ma query ko list save hunxa    
			if ((list != null) && (list.size() > 0)) {
				userFound= true;
                                //boolen value true hunxa userfound string jastai boolean ho
			}

			session.close();
			return userFound;              
       }
   
    
    }
