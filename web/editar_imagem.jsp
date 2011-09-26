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
    <body style="width: 96%;height: 96%;margin: 1%;padding: 0;">
        <h1>Logado!</h1>
        <h2>Olá, ${usuario.nome}</h2>
        <ul>
            <li><a onclick="return confirm('Mesmo?')" href="/editar_arquivo?toBeP=128&amp;arquivo=${arquivo}">Converter para P/B com thesh = </a> <input name="contraste" value="128"></li>
            <li>Aumentar contraste em <input name="contraste" value="1.1">% <a onclick="return confirm('Mesmo?')&&false" href="/">-></a></li>
            <li>Aumentar brilho em <input name="brilho" value="1.1">% <a href="/">-></a></li>
            <li><a onclick="return confirm('Mesmo?')" href="/editar_arquivo?grayscale=1&amp;arquivo=${arquivo}">Converter para escala de cinza</a></li>
            <li><a onclick="return confirm('Mesmo?')" href="/editar_arquivo?sepia=1&amp;arquivo=${arquivo}">Converter para sepia</a></li>
        </ul>
        <img src="/imagem?arquivo=${arquivo}" style="max-width: 80%;max-height: 80%">
    </body>
</html>
