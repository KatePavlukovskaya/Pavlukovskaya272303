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
                <div class="clr"></div>

            </div>

        </div>

        <div class="content">
            <div class="content_resize">
                     <table class="table table-striped table-hover" >
                        <thead>
                        <tr></tr>
                        <tr></tr>
                        <tr>
                            <th>#</th>
                            <th>Группа расходы</th>
                            <th>Январь</th>
                            <th>Февраль</th>
                            <th>Март</th>
                            <th>Апрель</th>
                            <th>Май</th>
                            <th>Июнь</th>
                            <th>Июль</th>
                            <th>Август</th>
                            <th>Сентябрь</th>
                            <th>Октябрь</th>
                            <th>Ноябрь</th>
                            <th>Декабрь</th>
                            <th>Всего</th>
                        </tr>
                        </thead>
                        <c:forEach items = "${statisticsList}" var = "el" >
                            <tbody>

                            <tr class="success">
                                <td>*</td>
                                <td>${el.getNameCategory()}</td>
                                <td>${el.getJanuary()}</td>
                                <td>${el.getFebruary()}</td>
                                <td>${el.getMarch()}</td>
                                <td>${el.getApril()}</td>
                                <td>${el.getMay()}</td>
                                <td>${el.getJune()}</td>
                                <td>${el.getJuly()}</td>
                                <td>${el.getAugust()}</td>
                                <td>${el.getSeptember()}</td>
                                <td>${el.getOctober()}</td>
                                <td>${el.getNovember()}</td>
                                <td>${el.getDecember()}</td>
                                <td>${el.getYear()}</td>
                            </tr>
                            </tbody>
                        </c:forEach>

                    </table>

            </div>
        </div>
        <div class="content">
            <div class="content_resize">
                <table class="table table-striped table-hover ">
                    <thead>
                    <tr></tr>
                    <tr></tr>
                    <tr>
                        <th>#</th>
                        <th>Группа доходы</th>
                        <th>Январь</th>
                        <th>Февраль</th>
                        <th>Март</th>
                        <th>Апрель</th>
                        <th>Май</th>
                        <th>Июнь</th>
                        <th>Июль</th>
                        <th>Август</th>
                        <th>Сентябрь</th>
                        <th>Октябрь</th>
                        <th>Ноябрь</th>
                        <th>Декабрь</th>
                        <th>Всего</th>
                    </tr>
                    </thead>
                    <c:forEach items = "${statisticsListIncome}" var = "el" >
                        <tbody>
                        <tr class="success">
                            <td>*</td>
                            <td>${el.getNameCategory()}</td>
                            <td>${el.getJanuary()}</td>
                            <td>${el.getFebruary()}</td>
                            <td>${el.getMarch()}</td>
                            <td>${el.getApril()}</td>
                            <td>${el.getMay()}</td>
                            <td>${el.getJune()}</td>
                            <td>${el.getJuly()}</td>
                            <td>${el.getAugust()}</td>
                            <td>${el.getSeptember()}</td>
                            <td>${el.getOctober()}</td>
                            <td>${el.getNovember()}</td>
                            <td>${el.getDecember()}</td>
                            <td>${el.getYear()}</td>

                        </tr>
                        </tbody>
                    </c:forEach>

                </table>

            </div>
        </div>
    </div>


</t:template>
