/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin
 */
public class User {
    
    private int id;
    
    private String msv;
    
    private String pass;
    
    private String name;

    public User() {
    }

    public User(int id, String msv, String pass, String name) {
        this.id = id;
        this.msv = msv;
        this.pass = pass;
        this.name = name;
    }

    public User(String msv, String pass) {
        this.msv = msv;
        this.pass = pass;
    }

    public User(String msv, String pass, String name) {
        this.msv = msv;
        this.pass = pass;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
