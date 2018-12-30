/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import dto.Lesson;
import dto.User;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author Admin
 */
public class MyUtils {

    public static final String ATT_NAME_CONNECTION = "ATTRIBUTE_FOR_CONNECTION";

    private static final String ATT_NAME_USER_NAME = "ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE";

    // Lưu trữ Connection vào attribute của request.
    // Thông tin lưu trữ này chỉ tồn tại trong thời gian yêu cầu (request)
    // cho tới khi dữ liệu được trả về trình duyệt người dùng.
    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME_CONNECTION, conn);
    }

    // Lấy đối tượng Connection đã được lưu trữ trong attribute của request.
    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME_CONNECTION);
        return conn;
    }

    // Lưu trữ thông tin người dùng đã login vào Session.
    public static void storeLoginedUser(HttpSession session, User loginedUser) {
        // Trên JSP có thể truy cập thông qua ${loginedUser}
        session.setAttribute("loginedUser", loginedUser);
    }

    // Lấy thông tin người dùng lưu trữ trong Session.
    public static User getLoginedUser(HttpSession session) {
        User loginedUser = (User) session.getAttribute("loginedUser");
        return loginedUser;
    }

    // Lưu thông tin người dùng vào Cookie.
    public static void storeUserCookie(HttpServletResponse response, User user) {
        System.out.println("Store user cookie");
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, user.getName());
        // 1 ngày (Đã đổi ra giây)
        cookieUserName.setMaxAge(24 * 60 * 60);
        response.addCookie(cookieUserName);
    }

    public static String getUserNameInCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (ATT_NAME_USER_NAME.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    // Xóa Cookie của người dùng
    public static void deleteUserCookie(HttpServletResponse response) {
        Cookie cookieUserName = new Cookie(ATT_NAME_USER_NAME, null);
        // 0 giây. (Cookie này sẽ hết hiệu lực ngay lập tức)
        cookieUserName.setMaxAge(0);
        response.addCookie(cookieUserName);
    }

    public static int getPostionLesson(int lessonID, List<Lesson> lessonList) {
        int position = 0;
        for (int i = 0; i < lessonList.size(); i++) {
            if (lessonID == lessonList.get(i).getId()) {
                position = i;
                return position;
            }
        }
        return position;
    }

    public static String setUrlNext(int positionLesson, int subjectID, List<Lesson> listLesson) {
        if (positionLesson == listLesson.size() - 1) {
            positionLesson = 0;
        } else {
            positionLesson++;
        }
        int lessonID = listLesson.get(positionLesson).getId();
        String url = "content.jsp?subject_id=" + subjectID + "&lesson_id=" + lessonID;
        return url;
    }

    public static String setUrlBack(int positionLesson, int subjectID, List<Lesson> listLesson) {
        if (positionLesson == 0) {
            positionLesson = listLesson.size() - 1;
        } else {
            positionLesson--;
        }
        int lessonID = listLesson.get(positionLesson).getId();
        String url = "content.jsp?subject_id=" + subjectID + "&lesson_id=" + lessonID;
        return url;
    }

    public static String compileCode(String html, String css, String js) {
        if (html == null) {
            html = "";
        }
        if (css != null) {
            css = "<style>" + css + "</style>";
        } else {
            css = "";
        }
        if (js != null) {
            js = "<script type='text/javascript'>" + js + "</script>";
        } else {
            js = "";
        }

        Document result = Jsoup.parse(html);
        result = Jsoup.parse(result.html());

        result.select("head").append(css);
        result.select("head").append(js);

        return result.toString();
    }

    public static void main(String[] args) {
        List<Lesson> lessonList = new ArrayList<>();
        lessonList.add(new Lesson(1, 1, "1", "2"));
        lessonList.add(new Lesson(2, 2, "1", "2"));
        lessonList.add(new Lesson(3, 4, "1", "2"));
        lessonList.add(new Lesson(5, 6, "1", "2"));

        System.out.println("" + getPostionLesson(5, lessonList));

    }

}
