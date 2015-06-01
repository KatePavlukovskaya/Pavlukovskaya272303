<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:template>
    <div class="main">
    <div class="header">
        <div class="header_resize">
            <div class="clr"></div>
            <ul class="menu1">
                <li><a href="index">Главная</a></li>
                <li class="z_ind"><a href="#">Управление бюджетом</a>

                    <ul>
                        <li><a href="cost" class="documents">Расходы</a></li>
                        <li><a href="income" class="messages">Доходы</a></li>

                    </ul>
                </li>
                <li><a href="goal">Цели</a></li>
                <li><a href="statistics">Статистика</a></li>
            </ul>

        </div>

    </div>


    <div class="content">
        <div class="content_resize">
            <h3>Регистрация</h3>
            <div>
                <form action="registration2" method="get" enctype="multipart/form-data" >

                    <div>
                        <label>Логин:</label> <input  required="required" class="form-control" type='text' name='login'>

                    </div>
                    <div>
                        <label>Пароль:</label> <input  required="required" class="form-control" type='password' name='password'>
                    </div>
                    <div>
                        <label>Имя:</label> <input required="required" class="form-control" type='text' name='name'>
                    </div>
                    <div>
                        <label>Фамилия:</label> <input  required="required" class="form-control" type='text' name='surname'>
                    </div>
                    <div>
                        <label>Отчество:</label> <input required="required" class="form-control" type='text' name='patrynomic'>
                    </div>
                    <div>
                        <label>Возраст:</label> <input pattern="[0-9]{1,3}" required="required" class="form-control" type='text' name='age'>
                    </div>

                    <button id="but4" name="submit" type="submit">Зарегистрироваться</button>
                </form>
            </div>
        </div>
    </div>


</t:template>
