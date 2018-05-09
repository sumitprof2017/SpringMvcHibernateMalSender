/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ishara.service;

import com.ishara.model.Person;
import java.util.List;

/**
 *
 * @author MR.Cutevil
 */
public interface PersonService {
    public int addPerson(Person person);
       public List<Person> getAllPerson();
}
