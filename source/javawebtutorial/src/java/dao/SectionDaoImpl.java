/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect_db.ConnectDB;
import dto.Section;
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
public class SectionDaoImpl implements SectionDAO {

    final String TABLE = "section";
    final String COLUM_ID_SECTION = "id_section";
    final String COLUM_LESSON_ID = "lesson_id";
    final String COLUM_NAME = "name";

    @Override
    public List<Section> getListSectionById(int lessonID) {
 
        List<Section> sectionList = new ArrayList<Section>();
        try {

            Connection conn = new ConnectDB().openConnect();
            String sql = "SELECT * FROM " + TABLE + " WHERE " 
                    + COLUM_LESSON_ID + " = '" + lessonID + "'" ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Section s = new Section(
                        rs.getInt(COLUM_ID_SECTION),
                        rs.getInt(COLUM_LESSON_ID),
                        rs.getString(COLUM_NAME));
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
        SectionDaoImpl sdi = new SectionDaoImpl();
        sdi.getListSectionById(1001);
    }
}
