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
                <li class="z_ind"><a href="#">Управление бюджетом</a>
                    <ul >
                        <li><a href="cost" class="documents">Расходы</a></li>
                        <li><a href="income" class="messages">Доходы</a></li>
                    </ul>
                </li>
                <li><a href="goal">Цели</a></li>
                <li><a href="statistics">Статистика</a></li>
            </ul>

            <div class="content">
                <div class="content_resize">

                    <div class="clr"></div>

                    <div class="content">
                        <div class="content_resize">

                            <div class="clr"></div>


                        <div class="clr"></div>
                        <div class="md-modal md-effect-13" id="modal-14">
                            <div class="md-content">
                                <h3>Добавить цель</h3>
                                <div>
                                    <form class="window2" action="addGoal" method="get" enctype="multipart/form-data" >
                                        <div >
                                            <label>Название: </label><input required="required" type='text' name='collected'>
                                        </div>
                                        <div>
                                            <label>Стоимость:</label><input  pattern="[0-9]{1,8}" required="required" type='text' name='sum'>
                                        </div>
                                        <div>
                                            <label>Сумма для накопления:</label><input required="required" type='text' name='ante'>
                                        </div>
                                        <div>
                                            <label>Накапливать:
                                                <p>
                                                    <input name="radio" type="radio" value="1">Каждый день<Br>
                                                    <input name="radio" type="radio" value="2">Каждую неделю<Br>
                                                    <input name="radio" type="radio" value="3">Каждый месяц<Br></p></label>
                                        </div>
                                        <div>
                                            <label>Начало накопления:</label> <input pattern="[0-9]{1,8}" required="required" type='date' name='start' value="${goal.getStart()}">
                                        </div>

                                        <button name="submit" type="submit" id="add10">Добавить</button>
                                    </form>

                                </div>

                                <button class="md-close" id="add21">Закрыть</button>
                            </div>
                        </div>


                        <button class="md-trigger" data-modal="modal-14" id="but10">Добавить категорию доходов</button>
                    </div>

                </div>
            </div><!-- /container -->
            <div class="md-overlay"></div><!-- the overlay element -->
        </div>
    </div>


        <div class="content">
            <div class="content_resize">

                <c:if test = "${!empty goals}">
                    <table class="table table-striped table-hover ">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Название</th>
                            <th>Сумма</th>
                            <th>Дата</th>
                            <th>Сумма</th>
                            <th>&nbsp;</th>

                        </tr>
                        </thead>
                        <c:forEach items = "${goals}" var = "goal" >
                                <tbody>
                                <tr class="success">
                                    <td>*</td>
                                    <td>${goal.getCollected()}</td>
                                    <td>${goal.getSum()}</td>

                                    <td>${goal.getStart()}</td>
                                    <td>${goal.getFinish()}</td>

                                    <td><a href="editIncome/${goal.getId()}">Edit</a></td>
                                    <td><a href="deleteIncome/${goal.getId()}">Del</a></td>
                                </tr>
                                </tbody>
                            </c:forEach>
                    </table>
                </c:if>


            </div>
        </div>
    </div>


    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/classie.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/css-filters-polyfill.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/cssParser.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/modalEffects.js"></script>


</t:template>
