/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.service;

import com.login.model.Login;

/**
 *
 * @author MR.Cutevil
 */
public interface LoginService {
      

    public boolean checkLogin(String userName, String userPassword);
}
