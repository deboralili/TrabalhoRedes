<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trabalho de Redes</title>
</head>

<body>
<section>

    <form name="frmEnviarEmail" method="post" action="EnviarEmail?acao=MandarEmail">
        <div>
            <label for="emailFrom">From (Gmail do remetente):
                <div>
                    <input type="text" name="txtEmailFrom" id="emailFrom" value="" required/>
                </div>
            </label>

            <label for="senha">Senha:
                <div>
                    <input type="password" name="txtSenha" id="senha" value="" required/>
                </div>
            </label>

            <label for="emailTo">To (Gmail do destinatario):
                <div>
                    <input type="text" name="txtEmailTo" id="emailTo" value="" required/>
                </div>
            </label>

            <label for="assunto">Assunto:
                <div>
                    <input type="text" name="txtAssunto" id="assunto" value="" required/>
                </div>
            </label>

            <label for="mensagem">Mensagem:
                <div>
                    <input type="textarea" name="txtMensagem" id="mensagem" value="" required/>
                </div>
            </label>
        </div>
        <div>
            <button type="submit" name="btnEnviar" value="Enviar">Enviar</button>
        </div>
    </form>

</section>
</body>

</html>
