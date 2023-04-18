/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Customer;

import Order.Order;
import Order.OrderCatalog;
import Person.Person;
import UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author emi
 */
public class Customer {

    private OrderCatalog customerOrderCatalog;
    private Person person;
    private UserAccount userAccount;

    public Customer(Person person, UserAccount userAccount) {
        this.customerOrderCatalog = new OrderCatalog();
        this.person = person;
        this.userAccount = userAccount;
    }

    public
    OrderCatalog getCustomerOrderCatalog() {
        return customerOrderCatalog;
    }

    public
    void setCustomerOrderCatalog(OrderCatalog customerOrderCatalog) {
        this.customerOrderCatalog = customerOrderCatalog;
    }

    public
    Person getPerson() {
        return person;
    }

    public
    void setPerson(Person person) {
        this.person = person;
    }

    public
    UserAccount getUserAccount() {
        return userAccount;
    }

    public
    void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }


}