/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import org.apache.commons.lang.StringEscapeUtils;

/**
 *
 * @author Admin
 */
public class SectionContent {
    
    private int id;
    
    private int sectionId;
    
    private String content;
    
    private String code;
    
    private String language;
    
    private String contentType;
    
    private String description;
    
    private String warning;

    public SectionContent(int id, int sectionId, String content, String code, String language, String contentType, String description, String warning) {
        this.id = id;
        this.sectionId = sectionId;
        this.content = content;
        this.code = code;
        this.language = language;
        this.contentType = contentType;
        this.description = description;
        this.warning = warning;
    }

    public SectionContent() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCode() {
        return StringEscapeUtils.escapeJavaScript(code);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }
    
    
}
