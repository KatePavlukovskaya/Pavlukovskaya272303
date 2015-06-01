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
                <h3>Редактировать расходы</h3>
                <div>
                    <form action="../editCost2" method="get" enctype="multipart/form-data" >

                        <div hidden="true">
                            <label>Идентификатор:</label> <input required="required" class="form-control" type='text' name='id' value="${cost.getId()}">
                        </div>
                        <div >
                            <label>Категория: </label>
                            <select class="form-control" name = "group">
                                <c:forEach items="${groupCost}" var="groupCost">
                                    <option value="${groupCost.getId()}">${groupCost.getNameGroup()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label>Примечание:</label> <input  required="required" class="form-control" type='text' name='name' value="${cost.getNameCost()}">
                        </div>
                        <div>
                            <label>Дата покупки:</label> <input required="required" class="form-control" type='date' name='data' value="${propertiesCost.getData()}">
                        </div>
                        <div>
                            <label>Cумма:</label><input type="text" pattern="[0-9]{1,8}" required="required" class="form-control" name='sum' value="${propertiesCost.getSum()}">
                        </div>
                        <input type="hidden" name="group" value="${group.getId()}" />
                        <button name="submit" type="submit">Сохранить</button>
                    </form>
                </div>
            </div>
        </div>


</t:template>
