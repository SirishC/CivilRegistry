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
public class PassportReg {

    private String email;
    private String addr;
    private String visibleMark;
    private String place;
    private String date;

    public PassportReg(String email, String addr, String visibleMark, String place, String date) {
        this.email = email;
        this.addr = addr;
        this.visibleMark = visibleMark;
        this.place = place;
        this.date = date;
    }
    
}
