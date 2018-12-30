<%-- 
    Document   : take_a_test
    Created on : Dec 26, 2018, 9:38:03 PM
    Author     : Admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dto.Quiz"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="dao.QuizDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Take a test</title>
        <meta charset="utf-8">
        <style type="text/css">
            div#test{
                border: #8BC34A 2px solid;
                padding: 10px 20px 20px 20px;
            }
            .button {
                background-color: #00BCD4;
                border: none;
                color: white;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
            }

            .button:hover{
                background-color:#4CAF50;
            }

        </style>
    </head>
    <body>
        <%
            String lessonId = request.getParameter("lesson_id");
//            lessonId = "1000";
            QuizDaoImpl quizDaoImpl = new QuizDaoImpl();
            List<Quiz> quizList = quizDaoImpl.getListQuizByLesson(Integer.parseInt(lessonId));
            System.out.println("Quiz size : " + quizList.size());
        %>

        <h2 id = "test_status"></h2>
        <div id = "test">hello</div>
    </body>

    <script type="text/javascript">


        /*
         var questionsJS = [
         ["Which of the following is a server-side Java Script object?", "A. Function", "B. File", "C. FileUpload", "B"],
         ["To insert a JavaScript into an HTML page, which tag is used?", "", "", "", ""],
         ["", "", "", "", ""],
         ["", "", "", "", ""],
         ["", "", "", "", ""],
         ["", "", "", "", ""],
         ["", "", "", "", ""],
         ["", "", "", "", ""],
         ["", "", "", "", ""],
         ["", "", "", "", ""],
         ["", "", "", "", ""],
         ];
         
         var questionsCSS = [
         ["What does the a stand for in RGBa? ", "A. alpha", "B. aqua ", "C. Apple ", "A"],
         ["How do four values work on border-radius ", "A. top, bottom, left, right", "B. up, down, front, behind ", "	C. top-left, top-right, bottom-right, bottom-left ", "C"],
         ["How can you created rounded corners using CSS3?", "A. border[round]: 30px; ", "B. corner-effect: round; ", "	C. border-radius: 30px; ", "C"],
         ["How do you add shadow to elements in CSS3? ", "A. box-shadow: 10px 10px 5px grey", "	B. shadow-right: 10px shadow-bottom: 10px; shadow-color: grey; ", "	C. shadow-color: grey; ", "A"],
         ["How to you modify a border image using CSS3? ", "A. border: url(image.png); ", "	B. border-variable: image url(image.png); ", "C. border-image: url(border.png) 30 30 round; ", "C"],
         ["How to resize a background image using CSS3? ", " A. background-size: 80px 60px; ", "B. bg-dimensions: 80px 60px; ", "C. background-proportion: 80px 60px; ", "A"],
         ["How to force a word wrap using CSS3? ", "	A. word-wrap: break-word; ", "	B. text-wrap: break-word; ", "C. text-wrap: force; ", "A"],
         ["Which of these are valid CSS3 transformation statements (select only one): ", "A. matrix() ", "B. modify() ", "	C. skip()", "A"],
         ["How to rotate objects using CSS3? ", "A. object-rotation: 30deg; ", "	B. transform: rotate(30deg); ", "	C. rotate-object: 30deg; ", "B"],
         ["The ____________ property specifies the stack order of an element ", "A. d-index ", "	B. s-index ", "	C. z-index ", "C"],
         ["The _____________ selector is used to specify a style for a single, unique element ", "A. id", "B. class ", "C. text ", "A"]
         ];
         
         
         var questions = [
         ["What is the difference between XML and HTML? ", "	A. HTML is used for exchanging data, XML is not.", "B. XML is used for exchanging data, HTML is not ", "C. HTML can have user defined tags, XML cannot ", "B"],
         ["Opening Tag of HTML Tag is called as ________.", "A. Closed Tag", "B. Starting Tag", "	C. Forward Tag", "A"],
         ["HTML stands for ________.", "A. Hyper Text Markup Language", "B. Hyper Text Makeup Language", "C. None of these ", "A"],
         ["HTML program is saved using _________ extension.", "A. .htl", " B. .html ", " C. .hml", "B"],
         [" Who was the primary author of HTML?", "	A. Brendan Eich", "B. Sabeer Bhatiya", "C. Tim Berners-Lee", "C"],
         ["Which of the following is valid colour code ?", "A. #000000;", "	B. #0000000;", "C. #00000000;", "A"],
         ["Caption Tag in HTML ?", "A. Is used to display the Title for table at the top", "B. Is used to display the Title for table at the bottom", "C. Both", "C"],
         ["Which of the following is used increase the row height?", "A. Cellspacing", "B. Cellpadding ", "C. Row span", "C"],
         ["DOM stands for ", "A. Document object model", "B. Data object model", "C. Document Oriented model", "C"],
         ["The href attribute in the link tag specifies the:", "A. Destination of a link", "	B. Link", "C. Hypertext", "A"]
         
         ];
         
         */

        var pos = 0, test, test_status, question, choice, choices, chA, chB, chC, correct = 0;
        var questions = new Array();
      
        <%for (int i = 0; i < quizList.size(); i++) {%>
            questions[<%=i%>] = ["<%=quizList.get(i).getQuestion()%>","<%=quizList.get(i).getAnswerA()%>","<%=quizList.get(i).getAnswerB()%>","<%=quizList.get(i).getAnswerC()%>","<%=quizList.get(i).getCorrectAnswer()%>"];   
        <%}%>
         
        var anserwerUser = ["D", "D", "D", "D"];

        function _(x) {
            return document.getElementById(x);
        }

        function renderQuestion() {
            test = _("test");
            _("test_status").innerHTML = "Question " + (pos + 1) + " of " + questions.length;
            question = questions[pos][0];
            chA = questions[pos][1];
            chB = questions[pos][2];
            chC = questions[pos][3];
            test.innerHTML = "<h3>" + (pos + 1) + "." + question + "<h3>";
            test.innerHTML += "<input type ='radio' name='choices' value='A'> " + chA + "<br>";
            test.innerHTML += "<input type ='radio' name='choices' value='B'> " + chB + "<br>";
            test.innerHTML += "<input type ='radio' name='choices' value='C'> " + chC + "<br><br>";
            test.innerHTML += "<button onclick='checkAnswer()' class='button'>SubmitAnswer</button>";
        }

        function checkAnswer() {
            choices = document.getElementsByName("choices");
            for (var i = 0; i < choices.length; i++) {
                if (choices[i].checked) {
                    choice = choices[i].value;
                    anserwerUser[pos] = choice
                }
            }

            if (choice == questions[pos][4]) {
                correct++;
            }
            pos++;
            if (pos < questions.length) {
                renderQuestion();
            } else {
                test.innerHTML = "<h2>correct " + correct + " / " + questions.length;
                _("test_status").innerHTML = "Ahihi";
                pos = 0;
                correct = 0;

                for (var i = 0; i < questions.length; i++) {
                    test.innerHTML += "<h3>" + (i + 1) + "." + questions[i][0] + "<h3>";
                    if (questions[i][4] == "A") {

                        test.innerHTML += "<input type ='radio' checked='checked'><font color='green'>" + questions[i][1] + "<font><br>";
                        if (anserwerUser[i] == "B") {
                            test.innerHTML += "<input type ='radio'><font color='red'>" + questions[i][2] + "<font><br>";
                        } else {
                            test.innerHTML += "<input type ='radio' >" + questions[i][2] + "<br>";
                        }

                        if (anserwerUser[i] == "C") {
                            test.innerHTML += "<input type ='radio' ><font color='red'>" + questions[i][3] + "<font><br>";
                        } else {
                            test.innerHTML += "<input type ='radio' >" + questions[i][3] + "<br>";
                        }

                    } else if (questions[i][4] == "B") {

                        if (anserwerUser[i] == "A") {
                            test.innerHTML += "<input type ='radio' ><font color='red'>" + questions[i][1] + "<font><br>";
                        } else {
                            test.innerHTML += "<input type ='radio' >" + questions[i][1] + "<br>";
                        }

                        test.innerHTML += "<input type ='radio' checked='checked'><font color='green' >" + questions[i][2] + "<font><br>";

                        if (anserwerUser[i] == "C") {
                            test.innerHTML += "<input type ='radio' ><font color='red'>" + questions[i][3] + "<font><br>";
                        } else {
                            test.innerHTML += "<input type ='radio' >" + questions[i][3] + "<br>";
                        }


                    } else {

                        if (anserwerUser[i] == "A") {
                            test.innerHTML += "<input type ='radio'><font color='red'>" + questions[i][1] + "<font><br>";
                        } else {
                            test.innerHTML += "<input type ='radio'>" + questions[i][1] + "<br>";
                        }

                        if (anserwerUser[i] == "B") {
                            test.innerHTML += "<input type ='radio' ><font color='red'>" + questions[i][2] + "<font><br>";
                        } else {
                            test.innerHTML += "<input type ='radio' >" + questions[i][2] + "<br>";
                        }

                        test.innerHTML += "<input type ='radio' checked='checked'><font color='green'>" + questions[i][3] + "<font><br>";
                    }

                }
            }
        }

        window.addEventListener("load", renderQuestion, false);
    </script>

</html>