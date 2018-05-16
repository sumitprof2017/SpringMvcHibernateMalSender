/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ishara.dao;

import com.ishara.model.Person;
import java.util.List;

/**
 *
 * @author MR.Cutevil
 */
public interface PersonDAO {
    public int addPerson(Person person);
     public List<Person> getAllPerson();
}
