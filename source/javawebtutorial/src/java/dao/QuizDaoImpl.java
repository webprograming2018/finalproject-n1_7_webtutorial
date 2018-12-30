/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect_db.ConnectDB;
import dto.Quiz;
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
public class QuizDaoImpl implements QuizDAO {

    final String TABLE = "quiz";
    final String COLUM_ID = "idquiz";
    final String COLUM_LESSON_ID = "lesson_id";
    final String COLUM_QUESTION = "question";
    final String COLUM_ANSWER_A = "answer_a";
    final String COLUM_ANSWER_B = "answer_b";
    final String COLUM_ANSWER_C = "answer_c";
    final String COLUM_CORRECT_ANSWER = "correct_answer";

    @Override
    public List<Quiz> getListQuizByLesson(int idLesson) {
        List<Quiz> list = new ArrayList();
        String sql = "Select * from " + TABLE + " where " + COLUM_LESSON_ID
                + " = " + idLesson;
        try {
            Connection conn = new ConnectDB().openConnect();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Quiz quiz = new Quiz(
                        rs.getInt(COLUM_ID),
                        rs.getInt(COLUM_LESSON_ID),
                        rs.getString(COLUM_QUESTION),
                        rs.getString(COLUM_ANSWER_A),
                        rs.getString(COLUM_ANSWER_B),
                        rs.getString(COLUM_ANSWER_C),
                        rs.getString(COLUM_CORRECT_ANSWER));
                
                list.add(quiz);
            }
        } catch (Exception ex) {
            Logger.getLogger(QuizDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    
    public static void main(String[] args) {
        QuizDaoImpl q = new QuizDaoImpl();
        System.out.println(q.getListQuizByLesson(1000).size()+"");
    }

}
