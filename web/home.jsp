<%-- 
    Document   : cadastro
    Created on : 24/09/2011, 16:19:05
    Author     : Marcel
--%>

<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem vindo</title>
    </head>
    <body>
        <h1>Logado!</h1>
        <h2>Olá, ${usuarionome}</h2>
<<<<<<< HEAD
        <h3>${aviso}</h3>
=======
>>>>>>> f0bc1aced80f6d1ffb291569aa0233f0b1ffeab8
        <ul>
            <li><a href="/logado">Recarregar essa pagina</a></li>
            <li><a href="/send">Enviar imagem</a></li>
            <li><a href="/editar">Editar meus dados</a></li>
            <li><a href="/alterarsenha">Editar minha senha</a></li>
            <li><a href="/remover">Remover minha conta</a></li>
            <li><a href="/sair">Sair</a></li>
        </ul>
        <table>
            <tbody>
                <%
                    //TODO: Arrumar essa gambiarra
                    int i;
                    Vector imagens = (Vector) request.getAttribute("imagens");
                    for (i = 0; i < imagens.size(); i++) {
                        request.setAttribute("imagem", (String) imagens.get(i));
                %>
                <tr>
                    <td><img src="/imagem?arquivo=${imagem}" style="max-height: 100px"> </td>
<<<<<<< HEAD
                    <td><a href="/editar_arquivo?arquivo=${imagem}">Editar essa imagem</a></td>
                    <td><a href="/copiar_editar?arquivo=${imagem}">Editar uma copia dessa imagem</a></td>
=======
                    <td><a href="/editar?arquivo=${imagem}">Editar essa imagem</a></td>
                    <td><a href="/editar_copia?arquivo=${imagem}">Editar uma copia dessa imagem</a></td>
>>>>>>> f0bc1aced80f6d1ffb291569aa0233f0b1ffeab8
                    <td><a href="/excluir?arquivo=${imagem}" onclick="return confirm('Mesmo?')">Apagar Essa imagem</a></td>

                </tr>
                <% }%>
            </tbody>
        </table>
    </body>
</html>
