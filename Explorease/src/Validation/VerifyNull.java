/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import javax.swing.JOptionPane;

/**
 *
 * @author emi
 */
public class VerifyNull {
    public boolean checkNullObject(Object... args){
        
        boolean verifiedNoNull = true;
        
        for(Object arg: args){
            if(arg instanceof String){
                if (((String) arg).isEmpty()){   
                    verifiedNoNull = false;
                    JOptionPane.showMessageDialog(null,"Please fill all fields");
                    break;
                }
            }else {
                if (arg == null || arg.equals(null)){   
                    verifiedNoNull = false;
                    JOptionPane.showMessageDialog(null,"Please fill all fields");
                    break;
                }
            }
        }
        return verifiedNoNull;
    }
}
