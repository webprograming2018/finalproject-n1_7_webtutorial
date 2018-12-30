/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect_db.ConnectDB;
import dto.Lesson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LessonDaoImpl implements LessonDAO{

    final String TABLE = "lesson";
    final String COLUM_ID = "id";
    final String COLUM_SUBJECT_ID = "subject_id";
    final String COLUM_STATE = "state";
    final String COLUM_NAME = "name";
    
    @Override
    public List<Lesson> getListLessonBySubjectID(int subjectID) {
        List<Lesson> sectionList = new ArrayList<>();
        try {
            Connection conn = new ConnectDB().openConnect();
            String sql = "SELECT * FROM " + TABLE + " WHERE " 
                    + COLUM_SUBJECT_ID + " = '" + subjectID + "'" ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Lesson s = new Lesson(
                        rs.getInt(COLUM_ID),
                        rs.getInt(COLUM_SUBJECT_ID),
                        rs.getString(COLUM_NAME),
                        rs.getString(COLUM_STATE));
                sectionList.add(s);
                System.out.println(s.toString());
            }
            conn.close();
        } catch (Exception ex) {
            Logger.getLogger(SectionDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sectionList;
    }
    
    public static void main(String[] args) {
        LessonDaoImpl ldi = new LessonDaoImpl();
        ldi.getListLessonBySubjectID(1000);
    }
}
