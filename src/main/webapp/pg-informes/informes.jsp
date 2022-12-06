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
                    $("#boxInsertar").load("pg-informes/insertarGrafica.jsp", function () {
                    });
                });
            });
        </script>
    </head>

    <body>

        <%
            String fechai3 = request.getParameter("fechal2");
            String fechaf3 = request.getParameter("fechah2");

        %>

        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">AGREGAR PRODUCCION</h1>
        </div>

        <div class="card-body">
            <form id="frmRegistrar" name="frmRegistrar">

                <table class="table table-borderless">
                    <thead>
                    </thead>
                    <tbody>

                        <%--
                        
                        <tr>
                            <th>                        
                                <div class="form-group">
                                    <label for="idProduccion" class="form-label">Id:</label>
                                    <input type="text" name="idProduccion" id="idProduccion" 
                                           placeholder="Ingrese el Id de la produccion" required
                                           class="form-control" required>
                                </div>
                            </th>


                        </tr> 

                        --%> 

                        <tr> 

                    <input name="idProduccion" id="idProduccion" style="display: none;" value = 0 >

                    <th>
                        <div class="form-group">
                            <label for="idEmpleado">Empleado:</label>
                            <select id="idEmpleado" name="idEmpleado" required class="form-control">
                                <option value="" selected >  </option>
                                <%                                            for (Empleado empleado : fachada1.buscarEmpleados()) {
                                %>
                                <option value="<%= empleado.getId_empleado()%>"> <%= empleado.getCedula() + " - " + (empleado.getNombre()).replace("_", " ") + " " + (empleado.getApellido()).replace("_", " ")%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                    </th>





                    </tr>

                    <tr>

                        <th>
                            <div class="form-group">
                                <label for="fechaix" class="form-label">Fecha inicial:</label>
                                <br>
                                <input type="date" name="fechaix" id="fechaix" value = '<%= fechai3%>' style="width: 200px; vertical-align:10px">
                            </div>
                        </th>


                        <th>
                            <div class="form-group">
                                <label for="fechafx" class="form-label">Fecha Final:</label>
                                <br>
                                <input value = '<%= fechaf3%>' type="date" name="fechafx" id="fechafx" style="width: 200px; vertical-align:10px">
                            </div>
                        </th>

                    </tr>


                    </tbody>
                </table>


                

                <div id="boxInsertar">
                </div>

                <br>

                <div class="form-group">
                    <input type="button" id="btnGuardar" value="Graficar" class="btn" style="background:rgb(0, 195, 255)" >
                </div>


            </form>
        </div>                    
    </body>
</html>