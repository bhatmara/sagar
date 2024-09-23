/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.User;
import java.util.ArrayList;

/**
 *
 * @author ktbff
 */
public class UserController {

    ArrayList<User> users = new ArrayList<>();

    public boolean login(String userName, String passWord) {
        for (User us : users) {
            if ((us.getUserName().equals(userName)) && (us.getPassWord().equals(passWord))) {
                return true;
            }
        }
        if ((userName.equals("admin")) && (passWord.equals("admin"))) {
            return true;
        }
        return false;
    }
    
    public boolean addUser(String userName,String passWord){
    if(findUser(userName)==null){
        User us=new User(userName,passWord);
        users.add(us);
        return true;
        }
    return false;
}

public User findUser(String userName){
    for(User us:users){
        if(us.getUserName().equalsIgnoreCase(userName))
            return us;
    }
    return null;
}

public boolean deleteUser(String userName){
    if(findUser(userName)!=null){
        User us=findUser(userName);
        users.remove(us);
        return true;
    }
    return false;
}

}
