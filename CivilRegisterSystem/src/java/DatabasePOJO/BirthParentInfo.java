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

public class BirthParentInfo {

private String email;
private String mothername;
private String motheroccupation;
private String motherphno;
private String fathername;
private String fatheroccupation;
private String fatherphno;

    public BirthParentInfo(String email, String mothername, String motheroccupation, String motherphno, String fathername, String fatheroccupation, String fatherphno) {
        this.email = email;
        this.mothername = mothername;
        this.motheroccupation = motheroccupation;
        this.motherphno = motherphno;
        this.fathername = fathername;
        this.fatheroccupation = fatheroccupation;
        this.fatherphno = fatherphno;
    }

    
}
