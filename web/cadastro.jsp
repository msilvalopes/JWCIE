<%-- 
    Document   : cadastro
    Created on : 24/09/2011, 16:19:05
    Author     : Marcel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" 
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/xhtml; charset=UTF-8">
        <title>Crie, Edite e Compartilhe suas fotos no JWICE!</title>
        <link rel="stylesheet" href="css/basic.css" type="text/css" />
        <script type="text/javascript" language="javascript" src="javascript/basic.js"></script>
    </head>
    <body>
        <div id="topo">
            <div id="logo">
                <img src="imagens/logo.png" alt="jwcie" />
                <span>jwice</span>
            </div>
            <!--<div id="login2">
               <form method="post" action="/logado">
                <label for="login">
                    Login: <input name="login" />
                </label>
                <label for="senha">
                    Senha: <input name="senha" type="password" />
                </label>
                <input id="btLogin" type="submit" value="Entrar" />
            </form> 
            </div>
            <div id="login">
                <img src="imagens/login_mini.png" alt="login" />
                <a href="javascript:void(0);" onclick="javascript:logarSe();">Entrar</a>
            </div>
             <div id="signup">
                <img src="imagens/signup_mini.png" alt="signup" />
                <a href="/cadastro">Cadastre-se</a>
            </div>-->
            
        </div>
        <div id="conteudo">
            <h1>Cadastro!</h1>
            <div id="form_cad">
                <h2>${erros}</h2>
                <form method="post">
                    <table>
                        <tbody>
                            <tr>
                                <td>Usuário:</td>
                                <td><input name="login" value="${usuario.login}"></td>
                            </tr>
                            <tr>
                                <td>E-mail:</td>
                                <td><input name="email" value="${usuario.email}"></td>
                            </tr>
                            <tr>
                                <td>Nome:</td>
                                <td><input name="nome"value="${usuario.nome}"></td>
                            </tr>
                            <tr>
                                <td>Senha:</td>
                                <td><input name="senha" type="password"></td>
                            </tr>
                            <tr>
                                <td>Confirme sua senha:</td>
                                <td><input name="confsenha" type="password"></td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <div>
                                        <input type="submit" value="Cadastrar" class="submit" />
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                        
                </form>
            </div>
        </div>
    </body>
</html>
