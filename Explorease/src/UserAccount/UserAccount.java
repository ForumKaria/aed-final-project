/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserAccount;

import Roles.Role;

/**
 *
 * @author 15512
 */
public class UserAccount {
    private static int counter = 1;
    private String accountId;
    private String username;
    private String password;
    private Role role;

    
    UserAccount(String username, String password, Role role) {
        this.accountId = "user" + this.counter++;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    UserAccount() {
        
    }
    
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        UserAccount.counter = counter;
    }
    
    
}
