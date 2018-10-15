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
public class RequestForm {
    
   private String email = null;
   private boolean reqBCer = false;
   private boolean reqPassport = false;
   private boolean verBCer = false;
   private boolean verPassport = false;
   private boolean errBCer = false;
   private boolean errPassport = false;

    public RequestForm(String email,boolean reqBCer,boolean reqPassport,boolean verBCer,boolean verPassport,boolean errBCer,boolean errPassport) {
        this.email = email;
        this.reqBCer = reqBCer;
        this.reqPassport = reqPassport;
        this.verBCer = verBCer;
        this.verPassport = verPassport;
        this.errBCer = errBCer;
        this.errPassport = errPassport;
    }   
}