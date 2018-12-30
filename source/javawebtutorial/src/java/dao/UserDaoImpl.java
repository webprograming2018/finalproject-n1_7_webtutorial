/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect_db.ConnectDB;
import dto.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class UserDaoImpl implements UserDAO{

    final String TABLE = "user";
    final String COLUM_ID = "id_user";
    final String COLUM_MSV = "msv";
    final String COLUM_PASS = "pass";
    final String COLUM_NAME = "name";
    
    @Override
    public User getUserByID(int idUser) {
        User u = new User();
        try {
            Connection conn = new ConnectDB().openConnect();
            String sql = "SELECT * FROM " + TABLE + " WHERE " + COLUM_ID
                    + " ='" + idUser + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            u.setId(idUser);
            u.setMsv(rs.getString(COLUM_MSV));
            u.setPass(rs.getString(COLUM_PASS));
            u.setName(rs.getString(COLUM_NAME));
            
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return u;
    }

    @Override
    public void deleteUser(int idUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(User u) {
        try {
            Connection conn = new ConnectDB().openConnect();
            String sql = "INSERT INTO " + TABLE + " VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, u.getMsv());
            ps.setString(2, u.getPass());
            ps.setString(3, u.getName());
            
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
