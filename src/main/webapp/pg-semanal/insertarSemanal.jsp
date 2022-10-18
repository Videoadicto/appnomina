<%-- 
    Document   : insertarSemanal.jsp
    Created on : 11 may. 2021, 09:57:25
    Author     : Videoadicto
--%>

<%-- <%@page import="appnomina.capadatos.entidades.Semanal"%> --%>
<%@page import="appnomina.capadatos.entidades.Produccion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.SemanalFacade" scope="page"></jsp:useBean>
        <jsp:useBean id="fachada1" class="appnomina.capadatos.dao.ProduccionDao" scope="page"></jsp:useBean>
        <%--     <jsp:useBean id="fachada2" class="appnomina.negocio.facade.ProduccionFacade"></jsp:useBean> --%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SEMANAL</title>
        <script>
            $("button").click(function () {
                $("#box").load($(this).val() + uneFechas(), function () {
                });
            });


            $(document).ready(function () {
                $("#btnGuardar").click(function () {
                    $("#boxInsertar").load("pg-semanal/guardarSemanal.jsp?" + (validarDatosSemanal(nuevo = 1)), function () {
                    });
                });
            });
        </script>
    </head>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">AGREGAR SEMANAL</h1>
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
                                    <label for="idSemanal" class="form-label">Id:</label>
                                    <input type="text" name="idSemanal" id="idSemanal" 
                                           placeholder="Ingrese el Id de la semanal" required
                                           class="form-control" required>
                                </div>
                            </th>


                        </tr> 

                        --%> 

                        <tr> 
                            
                            <input name="idSemanal" id="idSemanal" style="display: none;" value = 0 >

                            <th>
                                <div class="form-group">
                                    <label for="idProduccion">Produccion:</label>
                                    <select id="idProduccion" name="idProduccion" required class="form-control">
                                        <option value="" selected >  </option>
                                        <%
                                            for (Produccion produccion : fachada1.buscarProduccions()) {
                                        %>
                                        <option value="<%= produccion.getId_produccion()%>"> <%= produccion.getCedula() + " - " + (produccion.getNombre()).replace("_", " ") + " " + (produccion.getApellido()).replace("_", " ")%></option>
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
                                    <label for="semanal" class="form-label">Semanal:</label>
                                    <input type="text" name="semanal" id="semanal" 
                                           placeholder="Ingrese la semanal" required
                                           class="form-control" required>
                                </div>
                            </th>
                        </tr>

                        <tr>

                            <th>
                                <div class="form-group">
                                    <label for="fecha" class="form-label">Fecha:</label>
                                    <br>
                                    <input type="date" name="fecha" id="fecha" style="width: 200px; vertical-align:10px">
                                </div>
                            </th>
                        </tr>


                    </tbody>
                </table>


                <div id="divInsertar" style="display: none;" class="alert alert-danger">
                </div>

                <div id="boxInsertar">
                </div>

                <br>

                <div class="form-group">
                    <input type="button" id="btnGuardar" value="Guardar" class="btn btn-success" >
                    <button type="button" value="pg-semanal/listarSemanal.jsp?mens=0" class="btn btn-success">Regresar</button>
                </div>


            </form>
        </div>                    
    </body>
</html>