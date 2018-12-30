<%@page import="utils.MyUtils"%>
<%@page import="dao.SubjectDaoImpl"%>
<%@page import="dao.LessonDaoImpl"%>
<%@page import="dto.Lesson"%>
<%@page import="dao.SectionContentDaoImpl"%>
<%@page import="dto.SectionContent"%>
<%@page import="dto.Section"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.SectionDaoImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="css/content.css" rel='stylesheet' type='text/css' />
        <link href="css/menu_vertical.css" rel='stylesheet' type='text/css'/>
        <link rel="stylesheet" href="libs/bootstrap/dist/css/bootstrap.css">
        <link rel="stylesheet" href="libs/font/Open-Sans/style.css">
        <link rel="stylesheet" href="libs/font/Righteous-Regular/style.css">
        <link rel='stylesheet' href='css/index.css'>
        <link rel="stylesheet" href="libs/font-awesome/web-fonts-with-css/css/fontawesome-all.css">
        <link rel="stylesheet" href="libs/prismjs/prism.css">

        <script src="libs/jquery/dist/jquery.js"></script>
        <script src="libs/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="libs/prismjs/prism.min.js" data-manual></script> 
        <script src="js/learn.controller.js"></script>

        <title>Content</title>
    </head>

    <body>
        <%
            String msv = null;
            if (session.getAttribute("msv") == null) {
                response.sendRedirect("/JavaWebTutorial/login.jsp");
                return;
            }

            String name = null;
            String sessionId = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("msv")) {
                        name = cookie.getValue();
                    }
                }
            }

            String lessonId = request.getParameter("lesson_id");
            String subjectId = request.getParameter("subject_id");

            int idLesson = 1000;
            if (lessonId != null) {
                idLesson = Integer.parseInt(lessonId);
            }

            int idSubject = 1000;
            if (subjectId != null) {
                idSubject = Integer.parseInt(subjectId);
            }

            LessonDaoImpl ldi = new LessonDaoImpl();
            SubjectDaoImpl sdi = new SubjectDaoImpl();
            List<Lesson> listLesson = ldi.getListLessonBySubjectID(idSubject);

            SectionDaoImpl secdi = new SectionDaoImpl();
            SectionContentDaoImpl scdi = new SectionContentDaoImpl();
            List<SectionContent> lsc = new ArrayList();
            List<Section> sections = secdi.getListSectionById(idLesson);
            for (Section s : sections) {
                lsc.add(scdi.getSectionContentBySecID(s.getIdSection()));
                System.out.println(s.getName());
            }
            String lessonName = "";
            int positionLesson = MyUtils.getPostionLesson(idLesson, listLesson);
        %>
        <div>
            <nav class='navbar navbar-default static-navbar'>
                <div class='navbar-header'>
                    <button type='button' class='navbar-toggle'>
                        <span class='sr-only'>Toggle navigation</span>
                        <span class='icon-bar'></span>
                        <span class='icon-bar'></span>
                        <span class='icon-bar'></span>
                    </button>
                    <a class='navbar-brand logo' href='/JavaWebTutorial/index.jsp'>
                        <img class='logo-img' src='images/logo-small.png' alt='logo'/>
                        <span class='hidden-sm hidden-md hidden-xs' style='font-family: Righteous'>FTutorial</span>
                    </a>
                </div>
                <div class='navbar-collapse'>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown pointer">
                            <a class="dropdown-toggle nav-font" href="/JavaWebTutorial/content.jsp?subject_id=1000&lesson_id=1000">
                                <i class="fab fa-html5"></i>
                                <span class="hidden-sm hidden-md">
                                    HTML
                                </span>
                            </a>
                        </li>
                        <li class="dropdown pointer">
                            <a class="dropdown-toggle nav-font" href="/JavaWebTutorial/content.jsp?subject_id=1001&lesson_id=1028">
                                <i class="fab fa-css3"></i>
                                <span class="hidden-sm hidden-md">
                                    CSS
                                </span>
                            </a>
                        </li>
                        <li class="dropdown pointer">
                            <a class="dropdown-toggle nav-font" href="/JavaWebTutorial/content.jsp?subject_id=1002&lesson_id=1000">
                                <i class="fab fa-js"></i>
                                <span class="hidden-sm hidden-md">
                                    JAVASCRIPT
                                </span>
                            </a>
                        </li>
                        <li class="dropdown pointer">
                            <a class="dropdown-toggle nav-font" href="/JavaWebTutorial/editor.jsp">
                                <i class="fas fa-terminal"></i>
                                <span class="hidden-sm hidden-md">
                                    EDITOR
                                </span>
                            </a>
                        </li>
                        <li class="dropdown pointer">
                            <a class="dropdown-toggle nav-font" href="" id="account-menu" data-toggle='dropdown'>
                                <span>
                                    <i class="fas fa-user"></i>
                                    <span class="hidden-sm hidden-md">
                                        ACCOUNT
                                    </span>
                                    <b class="caret"></b>
                                </span>
                            </a>
                            <ul class="dropdown-menu" role="menu">
                                <li>
                                    <a>
                                        <i class="fas fa-info-circle"></i>
                                        <span>Details</span>
                                    </a>
                                </li>
                                <li>
                                    <a>
                                        <i class="fas fa-wrench"></i>
                                        <span>Settings</span>
                                    </a>
                                </li>
                                <li>
                                    <a id="logout" action="LogoutServlet" method="post">
                                        <i class="fas fa-sign-out-alt"></i>
                                        <span>Sign out</span>
                                    </a>
                                </li>
                                <!-- <li>
                                    <a id="login">
                                        <i class="fas fa-sign-in-alt"></i>
                                        <span>Sign in</span>
                                    </a>
                                </li> -->
                            </ul>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>

        <div class="progress-bar-left">
            <div class="list-group list-group-flush sidenav hidden-xs hidden-sm">
                <%
                    for (Lesson l : listLesson) {
                        if (l.getId() == idLesson) {
                            lessonName = l.getName();
                %>
                <a class="list-group-item list-group-item-action active" href="content.jsp?subject_id=<%=idSubject%>&lesson_id=<%=l.getId()%>"><%=l.getName()%></a>
                <%
                } else {
                %>
                <a class="list-group-item list-group-item-action" href="content.jsp?subject_id=<%=idSubject%>&lesson_id=<%=l.getId()%>"><%=l.getName()%></a>
                <%
                    }
                %>
                <%
                    }
                %>
            </div>
        </div>

        <div class="progress-bar-right">
            <div class="hidden-xs hidden-sm sidenav" style="padding-left: 10px; padding-right: 10px;">
                <h5>Follow us</h5>
                <iframe src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2Fftutorialnth%2F&tabs=timeline&width=250&height=500&small_header=false&adapt_container_width=true&hide_cover=false&show_facepile=true&appId=557851737992275" width="225" height="350" style="border: none; overflow: hidden;" scrolling="no" frameborder="0" allowTransparency="true" allow="encrypted-media"></iframe>
                <div style="margin-top: 20px;">
                    <h5>Color Picker</h5>
                </div>
            </div>
        </div>

        <div class="container well" style="margin-top: 65px;">
            <div class="lesson-nav">
                <div style="display: flex; align-items: center;">
                    <button type="button" class="btn btn-default" 
                            onclick="openPage('<%=MyUtils.setUrlBack(positionLesson, idSubject, listLesson)%>')">
                        <i class="fas fa-chevron-left"></i>
                    </button>
                </div>
                <span style="font-weight: bold; font-size:40px; flex-grow: 1; text-align: center;"><%= lessonName%></span>
                <div style="display: flex; align-items: center;">
                    <button type="button" class="btn btn-default" 
                            onclick="openPage('<%=MyUtils.setUrlNext(positionLesson, idSubject, listLesson)%>')">
                        <i class="fas fa-chevron-right"></i>
                    </button>
                </div>
            </div>
            <ol>
                <div class="content-frame">
                    <%
                        for (int i = 0; i < lsc.size(); i++) {
                            SectionContent sc = lsc.get(i);
                            String nameSection = sections.get(i).getName();
                    %>
                    <li style="font-weight: bold; font-size: 24px;"><%= nameSection%></li>
                    <p><%= sc.getContent()%></p>
                    <%
                        if (sc.getCode() != null) {
                    %>
                    <div class='demo-frame code-frame'>
                        <pre class="language-markup" style='font-size: 14px;'><code class="language-markup" id="<%=sc.getId()%>"><script>highlight("<%=sc.getId()%>", '<%=sc.getCode()%>', "<%=sc.getLanguage()%>");</script></code></pre>
                        <button type='button' class='btn btn-success'>
                            <span>Practise</span>&nbsp;
                            <i class='fas fa-arrow-circle-right'></i>
                        </button>
                    </div>
                    <%
                        }
                        if (sc.getDescription() != null) {
                    %>
                    <p class="description"><%= sc.getDescription()%></p>
                    <%
                        }
                        if (sc.getWarning() != null) {
                    %>
                    <p class='warning-frame'><%= sc.getWarning()%></p>
                    <%
                        }
                    %>
                    <hr>
                    <%
                        }
                    %>
                </div>
            </ol>

            <div style="margin-bottom: 70px; display: flex; justify-content: center;">
                <button type="button" class="btn btn-default" style="float: left;" 
                        onclick="openPage('<%=MyUtils.setUrlBack(positionLesson, idSubject, listLesson)%>')">
                    <i class="fas fa-chevron-left"></i>
                </button>
                <div style="flex-grow: 1; justify-content: center; display: flex;">
                    <button type="button" class="btn btn-success" 
                            onclick="openPage('take_a_test.jsp?lesson_id=<%=lessonId%>')">
                        <i class="fas fa-check-circle"></i>&nbsp;<span>Take a Test</span>
                    </button>
                </div>
                <button type="button" class="btn btn-default" style="float: right;"
                        onclick="openPage('<%=MyUtils.setUrlNext(positionLesson, idSubject, listLesson)%>')">
                    <i class="fas fa-chevron-right"></i>
                </button>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        function openPage(pageURL)
        {
            window.location.href = pageURL;
        }
    </script>
</html>