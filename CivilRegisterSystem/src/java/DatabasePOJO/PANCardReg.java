/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabasePOJO;

/**
 *
 * @author Ravibalg
 */
public class PANCardReg {
    
private String email;
private String sourceOfIncome;
private String addr;

    public PANCardReg(String email, String sourceOfIncome, String addr) {
        this.email = email;
        this.sourceOfIncome = sourceOfIncome;
        this.addr = addr;
    }   

}
