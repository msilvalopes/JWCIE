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
        <title>Alterar senha</title>
    </head>
    <body>
        <h1>Alterar senha!</h1>
        <h2>${erro}</h2>
        <form method="post">
            <table>
                <tbody>
                    <tr>
                        <td>senha atual</td>
                        <td><input name="senhaatual" type="password"></td>
                    </tr>
                    <tr>
                        <td>senha nova</td>
                        <td><input name="senhanova" type="password"></td>
                    </tr>
                    <tr>
                        <td>confirmacao da senha nova</td>
                        <td><input name="confsenha" type="password"></td>
                    </tr>
                </tbody>
            </table>
                <button>Alterar senha</button>
        </form>
    </body>
</html>
