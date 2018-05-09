/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.dao;

import com.login.model.Login;

/**
 *
 * @author MR.Cutevil
 */
public interface LoginDAO {
  public boolean checkLogin(String username, String userpassword);
}
