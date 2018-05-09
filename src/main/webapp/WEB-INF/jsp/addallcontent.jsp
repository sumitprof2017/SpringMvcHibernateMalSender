<%-- 
    Document   : addallcontent
    Created on : Apr 9, 2018, 5:36:41 PM
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
         <form:form  action="/SnewProjectSpringHibernateExamples/addcontent"  method="post" modelAttribute="userFormData">
<!--                         < yesari ni garna milxaform  action="${pageContext.request.contextPath}/add"  method="post" modelAttribute="userFormData">-->
             <table>
                
                <tr>
                    <td align="right"><b>Icon</b></td>
                    <td>
                        <input type="text" name="icon" size="75">   
                    </td>
                    
                </tr>
                
                 <tr>
                    <td align="right"><b>Heading:</b></td>
                    <td>
                        <input type="text" name="heading" size="75">   
                    </td>
                    
                </tr>
                
                <tr>
                    <td align="right"><b>Description:</b></td>
                    <td>
                        <textarea name="description" cols="75" rows="6">   </textarea>
                    </td>
                    
                </tr>
                
                <tr>
                    <td ></td>
                    <td>
                        <input type="submit" value="send">   
                    </td>
                    
                </tr>
                
                
            </table>
            
        </form:form>
        
    </body>
</html>
