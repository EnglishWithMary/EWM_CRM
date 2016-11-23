<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="UTF-8">
    <link href="/resources/assets/css/bootstrap-3.3.5/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/assets/css/bootstrap-3.3.5/css/styles.css" rel="stylesheet">
</head>
<div class="12u wrapper">
<h3>Students list</h3>
    <div class="table-wrapper">
        <form method="post" action="/studentSortByDate">
            <div class="form-group">
                <input type="submit" value="Sort by Registration Date">
            </div>
        </form>
        <table class="alt">
            <thead>
                <tr>
                    <th>First name</th>
                    <th>Last name</th>
                    <th>Middle name</th>
                    <th>Registration Date</th>
                    <th>Comments</th>
                </tr>
            </thead>
            <tbod>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.firstName}</td>
                        <td>${student.lastName}</td>
                        <td>${student.middleName}</td>
                        <td>${student.registrationDate}</td>
                        <td><textarea>${student.comments}</textarea></td>
                    </tr>
                </c:forEach>
            </tbod>
        </table>






    </div>
    <p><a href="/studentAdd">Add Student</a></p>



</div >

<a href="" class="" aria-label="" data-ga-click="">
    <img alt="" class="avatar" height="48" src="http://icons.veryicon.com/ico/System/Leopard%20iPhone/Users%20Folder.ico" width="48" />
</a>
<a href="" class="" aria-label="" data-ga-click="">
    <img alt="" class="avatar" height="48" src="http://icons.veryicon.com/ico/System/Leopard%20iPhone/Users%20Folder.ico" width="48" />
</a>