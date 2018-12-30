/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.User;

/**
 *
 * @author Admin
 */
public interface UserDAO {
    
    public User getUserByID(int idUser);
    
    public void deleteUser(int idUser);
    
    public void addUser(User u);
}
