<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table>
    <tr>
        <th colspan="2">Замена</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <tr>
        <td colspan="2">Продолжительность</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td rowspan="2">№</td>
        <td rowspan="2">Имя</td>
        <td rowspan="2">Учебник</td>
        <td rowspan="2">Тетрадь</td>
        <td colspan="7">Модуль 1</td>
        <td>Оплачено</td>
    </tr>
    <tr>
        <td>21.09</td>
        <td>23.09</td>
        <td>25.09</td>
        <td>27.09</td>
        <td>29.09</td>
        <td>03.09</td>
        <td>05.09</td>
        <td></td>
    </tr>
    <c:forEach var="student" items="${students}">
    <tr>
        <td>1</td>
        <td>Бессонов Егений</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>2</td>
        <td>Балабанов Денис</td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
</table>
