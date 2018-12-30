<%@page contentType='text/html' pageEncoding='UTF-8'%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>

        <link rel="stylesheet" href="libs/bootstrap/dist/css/bootstrap.css">
        <link rel="stylesheet" href="libs/font/Open-Sans/style.css">
        <link rel="stylesheet" href="libs/font/Righteous-Regular/style.css">
        <link rel='stylesheet' href='css/index.css'>
        <link rel="stylesheet" href="libs/font-awesome/web-fonts-with-css/css/fontawesome-all.css">

        <script src="libs/jquery/dist/jquery.js"></script>
        <script src="libs/bootstrap/dist/js/bootstrap.min.js"></script>
        
        <title>Home</title>
    </head>
    <body>
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
                                    <a id="logout">
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
        <div class="container well">
            <div class="row">
                <div class="banner">
                    <img src="images/banner.jpg" class="banner-image">
                    <span class="banner-text">FTUTORIAL</span>
                </div>
                <section>
                    <div class="welcome demo-frame">
                        <div>Welcome!</div>
                    </div>
                </section>
                <section class="intro-html demo-frame">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <button type="button" class="btn btn-html">
                                <i class="fab fa-html5" style="font-size: 20vh;"></i>
                            </button>
                        </div>
                        <div class="col-md-8" style="color: white; font-size: 2vh;">
                            <p>With HTML you can create your own Website</p>
                            <p>This tutorial teaches you everything about HTML</p>
                            <p>HTML is easy to learn - Even you don't have brain, you can still learn HTML</p>
                        </div>
                    </div>
                </section>
                <section class="intro-css demo-frame">
                    <div class="col-md-12">
                        <div class="col-md-8" style="color: white; font-size: 2vh;">
                            <p>CSS is a language that describes the style of an HTML document</p>
                            <p>CSS describes how HTML elements should be displayed</p>
                            <p>This tutorial will teach you CSS from basic to advanced</p>
                        </div>
                        <div class="col-md-4">
                            <button type="button" class="btn btn-css">
                                <i class="fab fa-css3-alt" style="font-size: 20vh;"></i>
                            </button>
                        </div>
                    </div>
                </section>
                <section class="intro-javascript demo-frame">
                    <div class="col-md-12">
                        <div class="col-md-4">
                            <button type="button" class="btn btn-js">
                                <i class="fab fa-js-square" style="font-size: 20vh;"></i>
                            </button>
                        </div>
                        <div class="col-md-8" style="color: white; font-size: 2vh;">
                            <p>JavaScript is the programming language of HTML and the Web</p>
                            <p>JavaScript is very easy to learn too - Like HTML, brain is not required</p>
                            <p>This tutorial will teach you JavaScript from basic to advanced</p>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>