<%@ tag description="Template Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype>
<html>
<head>


    <title>HomeMoney</title>

    <meta  charset=utf-8" />


    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/default.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/component.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/coin-slider.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css" />

    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/modernizr.custom.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/cufon-yui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/cufon-times-700.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.4.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/coin-slider.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
</head>
<body>
<div class="main">
    <div class="header">
        <div class="header_resize">

            <div  class="login-link-container">


                <sec:authorize access="isAnonymous()">

                        <a href="/spring_security_login">Вход</a>

                </sec:authorize>
                <sec:authorize access="isAuthenticated()">

                        <a href="/j_spring_security_logout">Выход</a>

                </sec:authorize>
                <p>
                <sec:authorize access="isAuthenticated()">

                    <a href="cabinet">Личный кабинет пользователя</a>

                </sec:authorize>
                </p>
            </div>
            <div class="login-link-container">

                    <a href="registration">Регистрация</a>

            </div>
            <div class="logo">
                <h1><img src="images/save-money-button.jpg" width="75" height="75" alt="" class="gal" /><a  href="index.html">Home<span>Money</span> <small>Научись тратить деньги на себя</small></a></h1>


            </div>



        </div>
    </div>

</div>
    <jsp:doBody/>




</div>
</body>
</html>


