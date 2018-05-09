<%-- 
    Document   : contentform
    Created on : Apr 9, 2018, 4:38:13 PM
    Author     : MR.Cutevil
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conttentform</title>
       
        
    </head>
    <body>
       ${editbycontent}
        ${punit}
<!--       Model attribute vanne very imp yesmai object banera uta pathaune ho-->
 <form:form  action="${pageContext.request.contextPath}/updatecontent"  method="post" modelAttribute="content1">
<!--                         < yesari ni garna milxaform  action="${pageContext.request.contextPath}/add"  method="post" modelAttribute="userFormData">-->
             <table>
                
                 <tr>
                    <td align="right"><b>Icon</b></td>
                    <td>
                        <input type="hidden" name="id" value="${editbycontent.id}">   
                    </td>
                    
                </tr>
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
