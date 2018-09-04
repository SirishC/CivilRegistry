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
public class UserReg {

    private String email;
    private String pass;
    private String fname;
    private String lname;
    private String phno;
    private String addr;

    public UserReg(String email, String pass, String fname, String lname, String phno, String addr) {
        this.email = email;
        this.pass = pass;
        this.fname = fname;
        this.lname = lname;
        this.phno = phno;
        this.addr = addr;
    }
    
}


