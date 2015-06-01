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
            <h3>Редактировать профиль</h3>
            <div>
                <form action="../cabinet2" method="get" >

                    <div hidden="true">
                        <label>Идентификатор:</label> <input  class="form-control" type='text' name='id' value="${member.getId()}">
                    </div>
                    <div >
                        <label>Логин: </label><input  class="form-control" required="required" type='text' name='login' value="${member.getLogin()}">
                    </div>
                    <div>
                        <label>Пароль:</label> <input class="form-control" type='password' required="required" name='password' value="${member.getPassword()}">
                    </div>
                    <div>
                        <label>Имя:</label> <input  class="form-control" type='text' required="required" name='name' value="${member.getName()}">
                    </div>
                    <div>
                        <label>Фамилия:</label><input type="text" class="form-control" required="required" name='surname' value="${member.getSurname()}">
                    </div>
                    <div>
                        <label>Отчество:</label><input type="text" class="form-control" required="required" name='patrynomic' value="${member.getPatrynomic()}">
                    </div>
                    <div>
                        <label>Возраст:</label><input pattern="[0-9]{1,3}"  required="required" type="text" class="form-control" name='age' value="${member.getAge()}">
                    </div>
                    <button  name="submit" type="submit">Изменить данные</button>
                </form>
            </div>
        </div>
    </div>


</t:template>
