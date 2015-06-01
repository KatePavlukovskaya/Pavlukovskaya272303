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
                        <ul >
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
    </div>

    <div class="content">
        <div class="content_resize">

            <div class="modal fade" id="basicModal" tabindex="-1" role="dialog">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header"><button class="close" type="button" data-dismiss="modal">x</button>
                            <h4 class="modal-title" id="myModalLabel">Название модального окна</h4>
                        </div>
                        <div class="modal-body">
                            <h3>Содержимое модального окна</h3>
                        </div>
                        <div class="modal-footer"><button class="btn btn-default" type="button" data-dismiss="modal">Закрыть</button>
                            <button class="btn btn-primary" type="button">Сохранить изменения</button></div>
                    </div>
                </div>
            </div>

        </div>
    </div>

</t:template>
