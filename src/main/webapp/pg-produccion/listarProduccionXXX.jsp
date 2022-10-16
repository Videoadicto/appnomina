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

            
            $(document).ready(function () {
                $("#btnListar").click(function () {
                    $("#boxInsertar").load("pg-produccion/enumerarProduccion.jsp?" + (listarTabla()), function () {
                    });
                });
            });
        </script>
    </head>

    
    
    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">PRODUCCION</h1>
        </div>

        <div class="card-body">
            
 
            
            <input type="button" id="btnListar" value="Listar" class="btn btn-success" >
           
            
            
            <form id="frmRegistrar" name="frmRegistrar">

                


                <div id="divInsertar" style="display: none;" class="alert alert-danger">
                </div>

                <div id="boxInsertar">
                </div>

                <br>

                <div class="form-group">
                    
                </div>


            </form>
        </div>                    
    </body>
</html>