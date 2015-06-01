<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<t:template>
    <form:form method="post" action="addMember" commandName="member">
        <table>
            <tr>
                <td><form:label path = "Login">
                    Login
                </form:label></td>
                <td><form:input path="login"/></td>
                <td><form:errors path="login"/></td>
            </tr>
            <tr>
                <td><form:label path = "Password">
                    Password
                </form:label></td>
                <td><form:input path="password"/></td>
            </tr>
            <tr>
                <td><form:label path = "Name">
                    Name
                </form:label></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td><form:label path = "Surname">
                    Surname
                </form:label></td>
                <td><form:input path="surname"/></td>
            </tr>
            <tr>
                <td><form:label path = "Patrynomic">
                    Patrynomic
                </form:label></td>
                <td><form:input path="patrynomic"/></td>
            </tr>
            <tr>
                <td><form:label path = "Age">
                    Age
                </form:label></td>
                <td><form:input path="age"/></td>
            </tr>
            <tr>
                <td><form:label path = "Status">
                    Status
                </form:label></td>
                <td><form:input path="status"/></td>
            </tr>
            <tr><td colspan="2"><input type="submit" value="Add Member"/></tr>

        </table>
    </form:form>
</t:template>
