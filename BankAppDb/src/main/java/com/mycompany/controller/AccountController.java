/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.Accounts;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sagar
 */
public class AccountController {
    ArrayList<Accounts> accounts=new ArrayList<>();
    DbConnection db= new DbConnection();
    //create a new account
    public boolean addAccount(int accountNumber, String accountName,int accountBalance){
        //Accounts acc=new Accounts(accountNumber,accountName,accountBalance);
        if(findAccount (accountNumber)==null){
        String sql="INSERT INTO `bankdb`.`account` (`accountNumber`, `accountName`, `accountBalance`) VALUES ('"+accountNumber+"', '"+accountName+"', '"+accountBalance+"')";
        return db.iud(sql);
        }
        return false;
    }
    //find an account
    public Accounts findAccount(int accountNumber){
       String sql="select *from bankdb.account where accountNumber="+accountNumber+";"; 
       ResultSet rs=db.select(sql); 
       try{
          while(rs.next()){
              Accounts acc=new Accounts(rs.getInt(1),rs.getString(2),rs.getInt(3));
              return acc;
          }
       }
       catch(SQLException e){
           return null;
       }
        return null;
    }
    //check balance of an account
    public void checkBalance(int accountNumber ){
        if(findAccount(accountNumber)!=null){
            Accounts acc=findAccount(accountNumber);
            System.out.println("Balance is :"+acc.getAccountBalance());
        }
        else{
            System.out.println("Account doesn't exist");
        }
    }
    //deposit certain amount in an account
    public boolean depositAmount(int accountNumber,int accountBalance){
      if(findAccount(accountNumber)!=null){
        Accounts acc=findAccount(accountNumber);
          acc.setAccountBalance(acc.getAccountBalance()+accountBalance);
          return true;
    }  
      return false;
    }
    //withdraw certain amount from an account
    public int withdrawAmount(int accountNumber, int accountBalance){
        if(findAccount(accountNumber)!=null){
            Accounts acc=findAccount(accountNumber);
            if(acc.getAccountBalance()>accountBalance){
                acc.setAccountBalance(acc.getAccountBalance()-accountBalance);
                return 1;
            }
            else{
                return -1;
            }
        }
        return 0;
    }
    //transfer certain amount from 1 account to other
    public int transferAmount(int senderAccountNumber,int receiverAccountNumber,int accountBalance){
        if((findAccount(senderAccountNumber)!=null)&&(findAccount(receiverAccountNumber)!=null)){
        Accounts acc1=findAccount (senderAccountNumber);
        Accounts acc2=findAccount (receiverAccountNumber);
        if(acc1.getAccountBalance()>accountBalance){
            acc1.setAccountBalance(acc1.getAccountBalance()-accountBalance);
            acc2.setAccountBalance(acc2.getAccountBalance()+accountBalance);
            return 1;
        }
        else{
            return -1;
        }
    }
        return 0;
    }
    //delete an account
    public boolean deleteAccount(int accountNumber){
        if(findAccount(accountNumber)!=null){
        Accounts acc=findAccount(accountNumber);
        accounts.remove(acc);
        return true;
        }
        return false;
    }
}
