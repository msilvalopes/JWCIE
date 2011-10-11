<%-- 
    Document   : index
    Created on : 01/10/2011, 14:35:39
    Author     : Márcio Dias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" 
    "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/xhtml; charset=UTF-8">
        <title>Crie, Edite e Compartilhe suas fotos no JWICE!</title>
        <link rel="stylesheet" href="css/basic.css" type="text/css" />
        <script type="text/javascript" language="javascript" src="javascript/basic.js"></script>
    </head>
    <body>
        <div id="topo">
            <div id="logo">
                <img src="imagens/logo.png" alt="Logo" />
                <span>jwice</span>
            </div>
            <div id="login2">
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
            </div>
            
        </div>
        <div id="conteudo">
            <div id="welcome">
                <img src="imagens/welcome1.png" alt="Bem-vindo!" />                
            </div>
            <div id="comofunciona">
                <div id="crie" class="box">
                    <div class="titulo">Crie</div>
                    <img src="imagens/create_logo.png" alt="criar" />
                    <p>Faça o upload das suas fotos e crie albuns. Desta maneira 
                        poderá acessá-las de qualquer lugar do mundo</p>
                    <div id="comeceagora">
                        <input type="button" onclick="javascript:startupNow();" value="&raquo; Comece agora!" />
                    </div>
                </div>
                <div id="edite" class="box" >
                    <div class="titulo">Edite</div>
                    <img src="imagens/edit_logo.png" alt="editar" />
                    <p>Edite e aplique efeitos em suas fotos. Mostre que além de 
                        fotogênico você é um verdadeiro artista.</p>
                    <div id="comeceagora">
                        <input type="button" onclick="javascript:startupNow();" value="&raquo; Comece agora!" />
                    </div>
                </div>
                <div id="compartilhe" class="box">
                    <div class="titulo">Compartilhe</div>
                    <img src="imagens/share_logo.png" alt="Compartilhe" />
                    <p>Compartilhe suas imagens com seus amigos. Compartilhe seus 
                        momentos.</p>
                    <div id="comeceagora">
                        <input type="button" onclick="javascript:startupNow();" value="&raquo; Comece agora!" />
                    </div>
                </div>
            </div>    
        </div>
        <div id="rodape">
            <p>Sistema elaborado pelos alunos Marcel Lopes, 
                Márcio Dias Pereira, Michelle Veloso e Robson Torraca para fins 
                avaliativo nas disciplinas de Qualidade de Software e, 
                juntamente com Fábio da Silva, Programação Web, do curso de 
                bacharelado em Análise de Sistemas (UFMS - Universidade Federal 
                de Mato Grosso do Sul)</p>
        </div>
    </body>
</html>
