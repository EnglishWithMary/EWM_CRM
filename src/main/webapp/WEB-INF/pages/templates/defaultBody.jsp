<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Enjoy your English with Mary! :)</h1>
 <p>English with Mary is your new way to improve your skills!!!


 <div class="12u">
     <h3>List persons</h3>
     <div class="table-wrapper">
         <table class="alt">
             <thead>
             <tr>
                 <th>First name</th>
                 <th>Last name</th>
                 <th>Middle name</th>
                 <th>Role</th>
             </tr>
             </thead>
             <tbod>
                 <c:forEach var="person" items="${persons}">
                     <tr>
                         <td>${person.firstName}</td>
                         <td>${person.lastName}</td>
                         <td>${person.middleName}</td>
                         <td>${person.role}</td>

                     </tr>
                 </c:forEach>
             </tbod>
         </table>
     </div>

 </div >
