<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:template>
    <div class="main">
        <div class="header">
            <div class="header_resize">
                <div class="clr"></div>
                    <ul class="menu1">
                        <li><a href="index">Главная</a></li>
                        <li><a href="management">Управление бюджетом</a>

                            <ul>
                                <li><a href="cost" class="documents">Расходы</a></li>
                                <li><a href="income" class="messages">Доходы</a></li>

                            </ul>
                        </li>
                        <li><a href="goal">Цели</a></li>
                        <li><a href="statistics">Статистика</a></li>
                    </ul>
                <div class="clr"></div>
            </div>
        </div>



    </div>
</t:template>
