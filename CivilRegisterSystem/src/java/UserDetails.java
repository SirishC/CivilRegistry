

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ravibalg
 */
public class UserDetails {
    
    public String email;
    public String pass;
    public String cpass;
    public String fname; 
    public String lname; 
    public String gender;
    public String city;
    public String phno;
    public String address;  

    public UserDetails(String email, String pass, String cpass, String fname, String lname,String gender, String city, String phno, String address ) {
        this.email = email;
        this.pass = pass;
        this.cpass = cpass;
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.city = city;
        this.phno = phno;
        this.address = address;
       
    }         
            
}
