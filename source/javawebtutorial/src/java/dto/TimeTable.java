/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author daova
 */
public class TimeTable {
    private int id;
    private int userId;
    private int lessonId;
    private String start;
    private String end;

    public TimeTable() {
    }

    public TimeTable(int id, int userId, int lessonId, String start, String end) {
        this.id = id;
        this.userId = userId;
        this.lessonId = lessonId;
        this.start = start;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TimeTable{" + "id=" + id + ", userId=" + userId + ", lessonId=" + lessonId + ", start=" + start + ", end=" + end + '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }


  
    
}
