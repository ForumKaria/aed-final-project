/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserAccount;

import Roles.Role;
import java.util.ArrayList;

/**
 *
 * @author 15512
 */
public class UserAccountDirectory {
    private ArrayList<UserAccount> useraccountlist;
    
    public UserAccountDirectory() {
        this.useraccountlist = new ArrayList<UserAccount>();
    }

    public ArrayList<UserAccount> getUseraccountList() {
        return useraccountlist;
    }

    public void setUseraccountList(ArrayList<UserAccount> useraccountlist) {
        this.useraccountlist = useraccountlist;
    }
    
    public UserAccount addUserAccount(UserAccount ua) {
        this.useraccountlist.add(ua);
        return ua;
    }
    
    public UserAccount createUserAccount(String username, String password, Role role) {
//        for(UserAccount ua: this.useraccountlist) {
//            if(ua.getUsername().equals(username)) {
//                return null;
//            }
//        }
        UserAccount ua = new UserAccount( username,  password,  role);
        
        this.useraccountlist.add(ua);
        return ua;
    }
    
    
    public UserAccount findUserAccount(String username) {
        for(UserAccount ua: this.useraccountlist) {
            if(ua.getUsername().equals(username)) {
                return ua;
            }
        }
        return null;
    }
    
    public UserAccount authenticateUser(String name, String password) {
        for(UserAccount ua: this.useraccountlist) {
            if(ua.getUsername().equals(name) && ua.getPassword().equals(password)) {
                return ua;
            }
        }
        return null;
    }
    
    public Boolean checkUserNameUnique(String username){
        for (UserAccount u:this.useraccountlist){
            if(u.getUsername().equals(username)){
                return false;
            }
        }
        return true;
    }
    
    public Boolean accountExists(String username, String password){
        for (UserAccount u:this.useraccountlist){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    
        public UserAccount getUserAccount(String username, String password){
        for(UserAccount u:useraccountlist){
            if(u.getUsername().equals(username) && u.getPassword().equals(password) ){
                return u;
            }
        }
        return null;
    }
    
    public UserAccount findById(String id){
        for(UserAccount u:useraccountlist){
            if (u.getAccountId().equals(id)){
                return u;
            }
        }
        return null;
    }
    
    public UserAccount findByUserName(String un){
        for(UserAccount u:useraccountlist){
            if (u.getUsername().equals(un)){
                return u;
            }
        }
        return null;
    }
}
