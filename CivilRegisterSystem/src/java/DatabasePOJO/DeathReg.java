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
public class DeathReg {
    
    private String email;
    private boolean dead;

    public DeathReg(String email, boolean dead) {
        this.email = email;
        this.dead = dead;
    }

    public String getEmail() {
        return email;
    }

    public boolean isDead() {
        return dead;
    }
    
    
    
    
}
