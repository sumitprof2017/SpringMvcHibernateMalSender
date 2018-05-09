<%-- 
    Document   : home
    Created on : Apr 2, 2018, 12:06:02 PM
    Author     : MR.Cutevil
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <table border="1">
 
            <th>Name</th>
            <th>Email</th>
            <th>subject</th>
            <th>message</th>
            
                ${products}
                ${listemployee}
             
                
            ya vako sab property  haru ho....modelko
                  <c:forEach items="${listemployee}" var="employee">
                <tr>
 
                    <td>${employee.name}</td>
                    <td>${employee.email}</td>
                    <td>${employee.subject}</td>
                    <td>${employee.message}</td>
                    <td><a href="editEmployee?id=${employee.id}">Edit</a>
                             <a
                        href="deleteEmployee?id=${employee.id}">Delete</a></td>
 
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
