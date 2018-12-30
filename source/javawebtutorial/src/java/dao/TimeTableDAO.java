/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.TimeTable;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface TimeTableDAO {
   
    //set gia tri cho bang time_table vs full giá trị
    public void setTimeTableByAll(int UserID,int lessonID, String start , String end);
    
    //set giá trị cho bảng time_table  khi user mở bài học vs thoi gian bắt đầu = thời gian hiện tại
    public void setTimeTableBySubjectIdAndLessonIdAndStart(int UserID,int lessonID, String start);
    
    //set gia tri cho bang time_table khi user kết thúc bài học vời thơi gian kết thúc là thời gian hiện tai
    public void setTimeTableBySubjectIdAndLessonIdAndEnd(int UserID,int lessonID, String end);
    
    //update thời gian kết thúc bài học cho những bản ghi đã được set thời gian bắt đầu vào bài ở trên
    public void updateTimeTableEndBySubjectIdAndLessonIdAnd(int UserID,int lessonID, String end);
    
    
}
