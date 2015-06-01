<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:template>

    <div class="main">
        <div class="header">
            <div class="header_resize">
                <div class="clr"></div>

                    <sec:authorize access="isAuthenticated()">
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
                    </sec:authorize>

            </div>
        </div>


    <div class="content">
    <div class="content_resize">

        <div class="slider">
            <div id="coin-slider"> <a href="#"><img src="images/slide1.jpg" width="960" height="360" alt="" /><span><big>Накопление денег основано на 3 столпах</big><br />
        Чтобы накопить деньги, нужно четко представлять – на что уходят заработанные средства, и понять, на чем Вы готовы экономить, а на чем - нет.. Чтобы накопить деньги, их нужно систематически откладывать. Не будете откладывать – никогда ничего не накопите.
Безболезненно можно откладывать 10-15% доходов. </span></a> <a href="#"><img src="images/slide2.jpg" width="960" height="360" alt="" /><span><big>Как контролировать свои расходы?</big><br />
          Накопление – минимум 10% от доходов.Квартплата, телефон, Интернет. Расходы на еду. Расходы на транспорт.Расходы на одежду.Расходы на отдых и развлечения.</span></a> <a href="#"><img src="images/slide3.jpg" width="960" height="360" alt="" /><span><big>Сделай свою жизнь лучше вместе с Homemoney.</big><br />
          «HomeMoney» - позволяет быстро понять, куда уходят деньги и где есть резервы для экономии.</span></a> </div>
            <div class="clr"></div>
        </div>

    </div>
    </div>



</t:template>
