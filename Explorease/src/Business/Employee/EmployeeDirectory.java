/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Employee;

import Business.Customer.Customer;
import Person.Person;
import UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author emi
 */
public class EmployeeDirectory {
        
    ArrayList<Employee> employeelist;
    static int counter = 1;
    public EmployeeDirectory() {
        this.employeelist = new ArrayList<Employee>();
    }

    public
    ArrayList<Employee> getEmployeelist()  {
        return employeelist;
    }

    public
    void addtoCustomerlist(Employee customer) {
        this.employeelist.add(customer);
    }
    
    
    public Employee findById(String id){
        for (Employee e:employeelist){
            if (e.getPerson().getPersonid().equals(id)){
                return e;
            }
        }
        return null;
    }
    
    public Employee createEmployee(String orgId,Person p, UserAccount ua){
        Employee e = new Employee(orgId +"_emp_" + this.counter++,p,ua);
        
        this.employeelist.add(e);
        return e;
    }
    
    public Employee findEmployeeByUserAccount(UserAccount ua){
        for (Employee e:employeelist){
            if (e.getUserAccount()==ua){
                return e;
            }
        }
        return null;
    }
}
