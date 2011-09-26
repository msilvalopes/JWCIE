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
        <title>Enviar Imagem</title>
    </head>
    <body>
        <h1>Enviar Imagem!</h1>
        <h2>${erro}</h2>
        <form method="post" enctype="multipart/form-data">
            <table>
                <tbody>
                    <tr>
                        <td>Imagem do tipo JPG ou JPEG</td>
                        <td><input name="imagem" type="file"></td>
                    </tr>
                </tbody>
            </table>
                <button>Enviar Imagem</button>
        </form>
    </body>
</html>
