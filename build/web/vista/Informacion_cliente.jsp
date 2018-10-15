<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Creando el objeto infoCliente de tipo ClienteBean -->
        <jsp:useBean id="infoCliente" type="modelo.ClienteBean" scope="request"/>
        <center><h1>Informacion del cliente</h1></center>
        
        <ul>
            <li>ID: <jsp:getProperty name="infoCliente" property="id"/> </li>
            <li>Nombres: <jsp:getProperty name="infoCliente" property="nombres"/></li>
            <li>Saldo: <jsp:getProperty name="infoCliente" property="saldo"/></li>
        </ul>
        
    </body>
</html>
