<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="12u">
<h3>Students list</h3>

    <div class="table-wrapper">
        <form method="post" action="/studentSortByDate">
            <div class="form-group">
                <input type="submit" value="Sort by Registration Date">
            </div>
        </form>
        <

    <form action="/students" method="get">
        <select name="teacher_id">
            <option value="">All teachers</option>
            <option value="-1">Students without teachers</option>
            <c:forEach var="teacher" items="${teachers}">
                <option value="${teacher.id}">
                ${teacher.person.firstName}</option>
            </c:forEach>
        </select>
        <input type="submit" class="button" value="Find"/>
    </form>


        <form action="/studentsSortedByGroup" method="get">
            <select name="group_id">
                <option value="">All groups</option>
                <option value="-1">Students without group</option>
                <c:forEach var="group" items="${groups}">
                    <option value="${group.id}">
                    ${group.name}</option>
                </c:forEach>
            </select>
            <input type="submit" class="button" value="Find"/>
        </form>



        <table class="alt">
            <thead>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Middle name</th>
                    <th>Student group</th>
                    <th>Registration Date</th>
                    <th>Comments</th>
                </tr>
            </thead>
            <tbod>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.person.firstName}</td>
                        <td>${student.person.lastName}</td>
                        <td>${student.person.middleName}</td>
                        <td>${student.group.name}</td>
                        <td>${student.person.registrationDate}</td>
                        <td><textarea>${student.person.comments}</textarea></td>
                    </tr>
                </c:forEach>
            </tbod>
        </table>
    </div>
    <p><a href="/studentAdd" class="button alt">Add Student</a></p>



</div >

<a href="" class="" aria-label="" data-ga-click="">
    <img alt="" class="avatar" height="48" src="http://icons.veryicon.com/ico/System/Leopard%20iPhone/Users%20Folder.ico" width="48" />
</a>
<a href="" class="" aria-label="" data-ga-click="">
    <img alt="" class="avatar" height="48" src="http://icons.veryicon.com/ico/System/Leopard%20iPhone/Users%20Folder.ico" width="48" />
</a>