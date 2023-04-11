/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Person;

/**
 *
 * @author emi
 */
public class Person {
    String personId;
    String name;
    
    public Person(){
        
    }
    
    public Person(String id, String name){
        this.personId = id;
        this.name = name;

    }

    public String getPersonid() {
        return personId;
    }

    public void setPersonid(String personid) {
        this.personId = personid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.personId;
    }
}
