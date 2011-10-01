<%-- 
    Document   : index
    Created on : 24/09/2011, 14:35:39
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
        <h1>Welcome to JWICE!</h1>
        <a href="/cadastro">Cadastrar</a>
        <form method="post" action="/logado">
            Login: <input name="login">
            Senha: <input name="senha" type="password">
            <button type="submit">Logar</button>
        </form>
        <a href="/recuperar_senha">Recuperar Senha</a>
    </body>
</html>