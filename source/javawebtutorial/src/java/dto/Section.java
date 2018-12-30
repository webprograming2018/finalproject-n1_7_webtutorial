/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Admin
 */
public class Section {
    
    private int idSection;
    
    private int lessonId;
    
    private String name;

    public Section(int idSection, int lessonId, String name) {
        this.idSection = idSection;
        this.lessonId = lessonId;
        this.name = name;
    }

    public Section() {
    }

    public int getIdSection() {
        return idSection;
    }

    public void setIdSection(int idSection) {
        this.idSection = idSection;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return idSection + "/" + lessonId + "/" + name;
    }
    
    
    
    
}
