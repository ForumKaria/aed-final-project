/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Person;

import Business.Customer.Customer;
import java.util.ArrayList;

/**
 *
 * @author forumkaria
 */
public
        class PersonDirectory {
    
    ArrayList<Person> personlist;
    
    public PersonDirectory() {
        this.personlist = new ArrayList<Person>();
    }

    public
    ArrayList<Person> getPersonlist() {
        return personlist;
    }

    public
    void addtoPersonlist(Person person) {
        this.personlist.add(person);
    }
    
    
    public Person findById(String id){
        for (Person p : personlist){
            if (p.getPersonid().equals(id)){
                return p;
            }
        }
        return null;
    }
    
    public Person createPerson(String id, String name){
        Person p = new Person();
        p.setPersonid(id);
        p.setName(name);
        
        this.personlist.add(p);
        return p;
    }
}