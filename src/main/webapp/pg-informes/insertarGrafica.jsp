<%-- 
    Document   : insertarProduccion.jsp
    Created on : 11 may. 2021, 09:57:25
    Author     : Videoadicto
--%>

<%-- <%@page import="appnomina.capadatos.entidades.Produccion"%> --%>
<%@page import="appnomina.capadatos.entidades.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.ProduccionFacade" scope="page"></jsp:useBean>
        <jsp:useBean id="fachada1" class="appnomina.capadatos.dao.EmpleadoDao" scope="page"></jsp:useBean>
        <%--     <jsp:useBean id="fachada2" class="appnomina.negocio.facade.EmpleadoFacade"></jsp:useBean> --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PRODUCCION</title>
        <script>
            $("button").click(function () {
                $("#box").load($(this).val() + uneFechas(), function () {
                });
            });


            $(document).ready(function () {
                $("#btnGuardar").click(function () {
                    $("#boxInsertar").load("pg-produccion/guardarProduccion.jsp?" + (validarDatosProduccion(nuevo = 1)), function () {
                    });
                });
            });
        </script>
    </head>

    <body>
       

        
        <div class="profile">
                    <img src="img/paper.png" alt="profile_picture" style="width:930px">
                    <h3></h3>
                    <p> </p>
                </div>
                



                     
    </body>
</html>