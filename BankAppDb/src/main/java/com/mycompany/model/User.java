/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Sagar
 */
public class User {
    private String UserName;
    private String passWord;

    public User(String UserName, String passWord) {
        this.UserName = UserName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

   
}
