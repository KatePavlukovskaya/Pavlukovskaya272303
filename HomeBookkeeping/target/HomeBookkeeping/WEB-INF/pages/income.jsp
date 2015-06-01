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

                        <ul>
                            <li><a href="cost" class="documents">Расходы</a></li>
                            <li><a href="income" class="messages">Доходы</a></li>

                        </ul>
                    </li>
                    <li><a href="goal">Цели</a></li>
                    <li><a href="statistics">Статистика</a></li>
                </ul>
                <div class="clr"></div>

                <div class="content">
                    <div class="content_resize">

                        <div class="clr"></div>
                        <div class="md-modal md-effect-13" id="modal-13">
                            <div class="md-content">
                                <h3>Добавить доход</h3>
                                <div>
                                    <form class="window" action="addIncome" method="get" enctype="multipart/form-data" >
                                        <div >
                                            <label>Категория: </label>
                                            <select class="form-control" name = "group">
                                                <c:forEach items="${groupIncome}" var="groupIncome">
                                                    <option value="${groupIncome.getId()}">${groupIncome.getNameGroup()}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <input type="hidden" name="group" value="${group.id}" />
                                        <div >
                                            <label>Примечание:</label> <input required="required" type='text' name='name'>
                                        </div>
                                        <div>
                                            <label>Дата поступления:</label> <input required="required" class="form-control" type='date'
                                                                                name='data'>
                                        </div>
                                        <div>
                                            <label>Cумма:</label><input pattern="[0-9]{1,8}" type="text" required="required" class="form-control" name="sum">
                                        </div>
                                        <input type="hidden" name="group" value="${group.getId()}" />
                                        <button  name="submit" type="submit" id="add6">Добавить</button>
                                    </form>
                                </div>

                                <button class="md-close" id="add5">Закрыть</button>
                            </div>
                        </div>
                    </div>

                    <button class="md-trigger" data-modal="modal-13" id="but1">Добавить доход</button>

                    <div class="clr"></div>
                    <div class="md-modal md-effect-13" id="modal-14">
                        <div class="md-content">
                            <h3>Добавить категорию доходов</h3>
                            <div>
                                <form class="window" action="addGroupIncome" method="get" enctype="multipart/form-data" >
                                    <div >
                                        <label>Список категорий: </label>
                                        <table class="cat" name = "group">
                                            <c:forEach items="${groupIncome}" var="groupIncome">
                                                <tr>
                                                    <td>${groupIncome.getNameGroup()}</td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                    </div>
                                    <div class="name">
                                    <label>Название:</label> <input required="required" type='text' name='nameGroup'>
                            </div>

                            <button name="submit" type="submit" id="add9">Добавить</button>
                            </form>
                        </div>

                        <button class="md-close" id="add8">Закрыть</button>
                    </div>
                </div>


            <button class="md-trigger" data-modal="modal-14" id="but2">Добавить категорию доходов</button>
                </div>

        </div>
            </div><!-- /container -->
            <div class="md-overlay"></div><!-- the overlay element -->
            </div>
        </div>

        <div class="content">
            <div class="content_resize">

                <c:if test = "${!empty incomes}">
                    <table class="table table-striped table-hover ">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Группа доходов</th>
                            <th>Примечание</th>
                            <th>Дата</th>
                            <th>Сумма</th>
                            <th>&nbsp;</th>

                        </tr>
                        </thead>
                        <c:forEach items = "${incomes}" var = "income" >
                            <c:forEach items = "${income.getPropertiesIncomeCollection()}" var = "incomes" >
                                <tbody>
                                <tr class="success">
                                    <td>*</td>
                                    <td>${income.getIdgroupIncome().getNameGroup()}</td>
                                    <td>${income.nameIncome}</td>

                                    <td>${incomes.getData()}</td>
                                    <td>${incomes.getSum()}</td>

                                    <td><a href="editIncome/${income.getId()}">Edit</a></td>
                                    <td><a href="deleteIncome/${income.getId()}">Del</a></td>
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
