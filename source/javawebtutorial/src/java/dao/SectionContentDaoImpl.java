/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connect_db.ConnectDB;
import dto.SectionContent;
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
public class SectionContentDaoImpl implements SectionContentDAO {

    final String TABLE = "section_content";
    final String COLUM_ID = "id";
    final String COLUM_SECTION_ID = "section_id";
    final String COLUM_CONTENT = "content";
    final String COLUM_CODE = "code";
    final String COLUM_LANGUAGE = "language";
    final String COLUM_CONTENT_TYPE = "content_type";
    final String COLUM_DESCRIPTION = "description";
    final String COLUM_WARNING = "warning";

    @Override
    public SectionContent getSectionContentBySecID(int sectionID) {
        SectionContent sc = new SectionContent();
        Connection conn;
        try {
            conn = new ConnectDB().openConnect();
            String sql = "SELECT * FROM " + TABLE + " WHERE " 
                    + COLUM_SECTION_ID + " = '" + sectionID + "'" ;
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                sc.setId(rs.getInt(COLUM_ID));
                sc.setSectionId(sectionID);
                sc.setCode(rs.getString(COLUM_CODE));
                sc.setLanguage(rs.getString(COLUM_LANGUAGE));
                sc.setContentType(rs.getString(COLUM_CONTENT_TYPE));
                sc.setDescription(rs.getString(COLUM_DESCRIPTION));
                sc.setWarning(rs.getString(COLUM_WARNING));
                sc.setContent(rs.getString(COLUM_CONTENT));
            }
            
            ps.close();
            rs.close();
            conn.close();
            
        } catch (Exception ex) {
            Logger.getLogger(SectionContentDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        return sc;
    }

    public static void main(String[] args) {
        SectionContentDaoImpl scdi = new SectionContentDaoImpl();
        System.out.println(scdi.getSectionContentBySecID(1001).getContent());
    }
}
