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

            <div class="content">
                <div class="content_resize">

                    <div class="clr"></div>
                    <div class="md-modal md-effect-13" id="modal-13">
                        <div class="md-content">
                            <h3>Добавить расходы</h3>
                            <div>
                                <form class="window" action="addCost" method="get" enctype="multipart/form-data" >
                                    <div >
                                    <label>Категория: </label>
                                    <select class="form-control" name = "group">
                                        <c:forEach items="${groupCost}" var="groupCost">
                                            <option value="${groupCost.getId()}">${groupCost.getNameGroup()}</option>
                                        </c:forEach>
                                    </select>
                                    </div>
                                    <input type="hidden" name="group" value="${group.id}" />
                                    <div >
                                        <label>Примечание:</label> <input  required="required" type='text' name='name'>
                                    </div>
                                    <div>
                                        <label>Дата покупки:</label> <input required="required" class="form-control" type='date'
                                                                            name='data'>
                                    </div>
                                    <div>
                                        <label>Cумма:</label><input pattern="[0-9]{1,8}" required="required" type="text" class="form-control" name="sum">
                                    </div>
                                    <input type="hidden" name="group" value="${group.getId()}" />

                                    <button  name="submit" id="add4" type="submit" >Добавить</button>


                                </form>
                            </div>
                            <button class="md-close" id="add5" >Закрыть</button>

                        </div>
                    </div>
                </div>

                <button class="md-trigger" data-modal="modal-13" id="but1">Добавить расходы</button>

                <div class="clr"></div>
                <div class="md-modal md-effect-13" id="modal-14">
                    <div class="md-content">
                        <h3>Добавить категорию расходов</h3>
                        <div >
                            <form class="window" action="addGroupCost" method="get" enctype="multipart/form-data" >
                                <div >
                                    <label>Список категорий: </label>
                                    <table name = "group" class="cat">
                                        <c:forEach items="${groupCost}" var="groupCost">
                                        <tr>
                                            <td>${groupCost.getNameGroup()}</td>
                                        </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                <div class="name">
                                    <label>Название:</label> <input required="required"  type='text' name='nameGroup'>
                                </div>

                                <button id="add33" name="submit" type="submit">Добавить</button>
                            </form>
                        </div>
                        <button class="md-close" id="add22">Закрыть</button>

                    </div>
                </div>
            </div>
                <button class="md-trigger" data-modal="modal-14" id="but2">Добавить категорию расходов</button>

        </div>

      </div>

            </div><!-- /container -->
               <div class="md-overlay"></div><!-- the overlay element -->
              </div>
      </div>

    <div class="content">
        <div class="content_resize">

                <c:if test = "${!empty costs}">
                    <table class="table table-striped table-hover ">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Группа расходов</th>
                            <th>Примечание</th>
                            <th>Дата</th>
                            <th>Сумма</th>
                            <th>&nbsp;</th>

                        </tr>
                        </thead>
                        <c:forEach items = "${costs}" var = "cost" >
                            <c:forEach items = "${cost.getPropertiesCostCollection()}" var = "costs" >
                                <tbody>
                                <tr class="success">
                                    <td>*</td>
                                    <td>${cost.getIdgroupCost().getNameGroup()}</td>
                                    <td>${cost.nameCost}</td>

                                    <td>${costs.getData()}</td>
                                    <td>${costs.getSum()}</td>

                                    <td><a href="editCost/${cost.getId()}">Edit</a></td>
                                    <td><a href="deleteCost/${cost.getId()}">X</a></td>
                                </tr>
                                </tbody>
                            </c:forEach>

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
