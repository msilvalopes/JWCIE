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
        <title>Alterar dados</title>
    </head>
    <body>
        <h1>Alterar dados!</h1>
        <h2>${erros}</h2>
        <form method="post">
            <table>
                <tbody>
                    <tr>
                        <td>login(Não pode alterar)</td>
                        <td>${usuario.login}</td>
                    </tr>
                    <tr>
                        <td>email</td>
                        <td><input name="email" value="${usuario.email}"></td>
                    </tr>
                    <tr>
                        <td>nome</td>
                        <td><input name="nome"value="${usuario.nome}"></td>
                    </tr>
                </tbody>
            </table>
                <button>Alterar</button>
        </form>
    </body>
</html>
