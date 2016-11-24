<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="12u">
<h3>Teachers list</h3>
        <form method="post" action="/teacherSortByDate">
            <div class="form-group">
                <input type="submit" value="Sort by Registration Date">
            </div>
        </form>
    <div class="table-wrapper">
        <table class="alt">
            <thead>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Middle name</th>
                    <th>Registration Date</th>
                </tr>
            </thead>
            <tbod>
                <c:forEach var="teacher" items="${teachers}">
                    <tr>
                        <td>${teacher.firstName}</td>
                        <td>${teacher.lastName}</td>
                        <td>${teacher.middleName}</td>
                        <td>${teacher.registrationDate}</td>
                    </tr>
                </c:forEach>
            </tbod>
        </table>
    </div>
    <p><a href="/teacherAdd">Add Teacher</a></p>
</div >