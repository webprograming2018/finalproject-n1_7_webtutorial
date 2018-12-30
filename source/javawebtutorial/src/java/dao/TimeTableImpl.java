/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect_db.ConnectDB;
import dto.TimeTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daova
 */
public class TimeTableImpl implements TimeTableDAO{


    final String TABLE = "time_table";
    final String COLUM_ID = "id";
    final String USER_ID = "user_id";
    final String LESSON_ID = "lesson_id";
    final String START = "start";
    final String END = "end";

    @Override
    public void setTimeTableByAll(int UserID, int lessonID, String start, String end) {
         Connection conn;
        try {
            conn = new ConnectDB().openConnect();
            String sql = " insert into time_table (user_id, lesson_id, start, end)"
        + " values (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,UserID);
            ps.setInt(2, lessonID);
            ps.setString(3, start);
            ps.setString(4, end);
            
            ps.executeUpdate();

            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(SubjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void setTimeTableBySubjectIdAndLessonIdAndStart(int UserID, int lessonID, String start) {
         Connection conn;
        try {
            conn = new ConnectDB().openConnect();
            String sql = " insert into time_table (user_id, lesson_id, start)"
        + " values (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,UserID);
            ps.setInt(2, lessonID);
            ps.setString(3, start);

            
            ps.executeUpdate();

            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(SubjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setTimeTableBySubjectIdAndLessonIdAndEnd(int UserID, int lessonID, String end) {
         Connection conn;
        try {
            conn = new ConnectDB().openConnect();
            String sql = " insert into time_table (user_id, lesson_id, end)"
        + " values (?, ?, ?)" ;
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,UserID);
            ps.setInt(2, lessonID);
            ps.setString(3, end);
            
            ps.executeUpdate();

            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(SubjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void updateTimeTableEndBySubjectIdAndLessonIdAnd(int UserID, int lessonID, String end) {
         Connection conn;
        try {
            conn = new ConnectDB().openConnect();
            String sql = " update time_table set end = ? where user_id = ? and lesson_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,end);
            ps.setInt(2, UserID);
            ps.setInt(3, lessonID);
            
            ps.executeUpdate();

            conn.close();

        } catch (Exception ex) {
            Logger.getLogger(SubjectDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        TimeTableImpl tt = new TimeTableImpl();
//        tt.setTimeTableByAll(2,1001,"2018-12-13 20:10:10","2018-12-13 20:10:10");
//        tt.setTimeTableBySubjectIdAndLessonIdAndStart(2,1001,"2018-12-13 20:10:11");
//        tt.setTimeTableBySubjectIdAndLessonIdAndEnd(2,1001,"2018-12-13 20:10:10");
            tt.updateTimeTableEndBySubjectIdAndLessonIdAnd(2,1001,"2018-12-13 20:11:12");
    }

    

    
}
