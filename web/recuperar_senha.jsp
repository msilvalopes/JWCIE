<%-- 
    Document   : cadastro
    Created on : 24/09/2011, 16:19:05
    Author     : Marcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Recuperar senha!</h1>
        <h2>Digite seu login</h2>
        <h2>${erros}</h2>
        <form method="post">
            <table>
                <tbody>
                    <tr>
                        <td>login</td>
                        <td><input name="login" value="${usuario.login}"></td>
                    </tr>
                </tbody>
            </table>
                <button>Receber por email</button>
        </form>
    </body>
</html>
