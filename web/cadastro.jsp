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
        <title>JSP Page Cadastro</title>
    </head>
    <body>
        <h1>Cadastro!</h1>
        <h2>${erros}</h2>
        <form method="post">
            <table>
                <tbody>
                    <tr>
                        <td>login</td>
                        <td><input name="login" value="${usuario.login}"></td>
                    </tr>
                    <tr>
                        <td>email</td>
                        <td><input name="email" value="${usuario.email}"></td>
                    </tr>
                    <tr>
                        <td>nome</td>
                        <td><input name="nome"value="${usuario.nome}"></td>
                    </tr>
                    <tr>
                        <td>senha</td>
                        <td><input name="senha" type="password"></td>
                    </tr>
                    <tr>
                        <td>confirmacao senha</td>
                        <td><input name="confsenha" type="password"></td>
                    </tr>
                </tbody>
            </table>
                <button>Cadastro</button>
        </form>
    </body>
</html>
