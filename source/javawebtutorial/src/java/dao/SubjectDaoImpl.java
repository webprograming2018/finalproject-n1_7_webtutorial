/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect_db.ConnectDB;
import dto.Lesson;
import dto.Subject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class SubjectDaoImpl implements SubjectDAO{

    final String TABLE = "subject";
    final String COLUM_ID = "id";
    final String COLUM_STATE = "state";
    final String COLUM_NAME = "name";
    
    @Override
    public Subject getSubjectBySubjectID(int subId) {
        Subject s = new Subject();
         Connection conn;
        try {
            conn = new ConnectDB().openConnect();
             String sql = "SELECT * FROM " + TABLE + " WHERE " 
                    + COLUM_ID + " = '" + subId + "'" ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                s.setId(subId);
                s.setName(rs.getString(COLUM_NAME));
                s.setState(rs.getString(COLUM_STATE));
              
            }
            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(SubjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
    
    public static void main(String[] args) {
        SubjectDaoImpl s  = new SubjectDaoImpl();
        System.out.println(s.getSubjectBySubjectID(1000).getState());
    }
    
}
