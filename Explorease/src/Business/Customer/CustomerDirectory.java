/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Customer;

import Person.Person;
import UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author forumkaria
 */
public
        class CustomerDirectory {
    
    ArrayList<Customer> customerlist;
    
    public CustomerDirectory() {
        this.customerlist = new ArrayList<Customer>();
    }

    public
    ArrayList<Customer> getCustomerlist() {
        return customerlist;
    }

    public
    void addtoCustomerlist(Customer customer) {
        this.customerlist.add(customer);
    }
    
    
    public Customer findCustomerById(String id){
        for (Customer c:customerlist){
            if (c.getUserAccount().getAccountId().equals(id)){
                return c;
            }
        }
        return null;
    }
    
    public Customer createCustomer(Person p, UserAccount ua){
        Customer c = new Customer(p,ua);
        
        this.customerlist.add(c);
        return c;
    }
    
    public Customer findCustomerByUSerName(String un){
        for (Customer c:customerlist){
            if (c.getUserAccount().getUsername().equals(un)){
                return c;
            }
        }
        return null;
    }
}
