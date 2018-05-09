<%-- 
    Document   : logindashboard
    Created on : Apr 11, 2018, 4:33:31 PM
    Author     : MR.Cutevil
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<!--        chalne code highlight for form:form
       <form action="${pageContext.request.contextPath}/checkuser1" method="post" modelAttribute="login1">
            Username <br> <input name="username" ></br>
            Password<br>  <input name="password" type="password" path="text" ></br>
            <input type="submit" value="login">
        </form>-->
            
       <form:form action="${pageContext.request.contextPath}/checkuser1" method="post" modelAttribute="login1">
        <table>
          
            <tr>
              Username <br> <input name="username" ></br>
            </tr>
            <tr>
                Password<br>  <input name="password" type="password" path="text" ></br>
            </tr>
           
             <input type="submit" value="login">
           
            
        </table>
        </form:form>     
            
    </body>
</html>
