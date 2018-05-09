/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.service;

import com.login.dao.LoginDAO;
import com.login.model.Login;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author MR.Cutevil
 */@Service
 @Transactional
public class LoginServiceImpl implements LoginService{
     
     @Autowired
	 private LoginDAO logindao;

    @Override
    public boolean checkLogin(String userName, String userPassword) {
 return logindao.checkLogin(userName, userPassword);    
    
    }

 

  
    
    
}
