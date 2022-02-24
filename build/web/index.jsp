<%-- 
    Document   : index
    Created on : Feb 25, 2022, 1:38:15 AM
    Author     : tuan anh
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="login" method="post">
            <table>
                <tbody>
                    <tr>
                        <td>UserName:</td>
                        <td><input type="text" name="username" value="${username}" /></td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td><input type="password" name="password" value="${password}" /></td>
                    </tr>
                    <tr>
                        <td><input type="checkbox" name="check" />Remenber Me</td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                    </tr>
                </tbody>
            </table>
        </form>

    </body>
</html>
