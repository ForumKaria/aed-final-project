/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Employee;

import Person.Person;
import UserAccount.UserAccount;

/**
 *
 * @author emi
 */
public class Employee {

    private String orgEmpId;
    private Person person;
    private UserAccount userAccount;
    private Boolean approved;

    public Employee(String empId, Person person, UserAccount userAccount) {
        this.orgEmpId = empId;
        this.person = person;
        this.userAccount = userAccount;
        this.approved = false;
    }

    public
    String getOrgEmpId() {
        return orgEmpId;
    }

    public
    void setOrgEmpId(String orgEmpId) {
        this.orgEmpId = orgEmpId;
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

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
    
    @Override
    public String toString(){
        return this.orgEmpId;
    }
    
}
