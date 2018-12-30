/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import utils.MyUtils;

/**
 *
 * @author Admin
 */
public class EditorCode {
    private String html;
    
    private String css;
    
    private String js;
    

    public EditorCode(String html, String css, String js) {
        this.html = html;
        this.css = css;
        this.js = js;
    }

    public EditorCode() {
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }
    
    public String resultCode(){
        return MyUtils.compileCode(html, css, js);
    }
          
}
