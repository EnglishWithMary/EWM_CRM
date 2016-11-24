<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="UTF-8">
    <link href="/resources/assets/css/bootstrap-3.3.5/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/resources/assets/css/bootstrap-3.3.5/css/styles.css" rel="stylesheet">
</head>
<div class="12u wrapper">
<h3>Managers list</h3>
    <form method="get" action="/managers">
        <div class="form-group">
            <input type="hidden" name="flagSorted" value="${!flagSorted}">
            <input type="submit" value="${flagSorted == true ? 'Common  order' : 'Sort by Registration Date'}"/>
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
                <c:forEach var="manager" items="${managers}">
                    <tr>
                        <td>${manager.person.firstName}</td>
                        <td>${manager.person.lastName}</td>
                        <td>${manager.person.middleName}</td>
                        <td>${manager.person.registrationDate}</td>
                    </tr>
                </c:forEach>
            </tbod>
        </table>
    </div>
    <p><a href="/managerAdd" class="button">Add Manager</a></p><br>
    <p>Pages</p>

    <table>
        <c:forEach var="page" begin="1" end="${pages}">
            <tr>
                <a href="/managers?page=${page}&flagSorted=${flagSorted}" class="button atl small">${page}</a>
            </tr>
        </c:forEach>
    </table>
</div >