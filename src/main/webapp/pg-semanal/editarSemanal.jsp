<%-- 
    Document   : editarSemanal.jsp
    Created on : 7 abr. 2022, 13:55:08
    Author     : Videoadicto
--%>

<%@page import="appnomina.capadatos.entidades.NominaSemanal"%>
<%@page import="appnomina.capadatos.entidades.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="fachada" class="appnomina.negocio.facade.NominaSemanalFacade" scope="page"></jsp:useBean>
        <jsp:useBean id="fachada2" class="appnomina.negocio.facade.EmpleadoFacade"></jsp:useBean>
        <jsp:useBean id="fachada1" class="appnomina.capadatos.dao.EmpleadoDao" scope="page"></jsp:useBean>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Nomina Semanal</title>
            <script>
                $("button").click(function () {
                    $("#box").load($(this).val() + uneFechas(), function () {
                    });
                });


                $(document).ready(function () {
                    $("#btnGuardar").click(function () {
                        
                        var validos = document.getElementById("total").value;
                        
                        if (validos !== "") {
                            document.getElementById("validax").value = "1";
                        } else {
                            document.getElementById("validax").value = "0";
                        }
                        
                        var ids = [];
                        var totales = [];
                        
                        ids.push( document.getElementById("idEmpleado").value);
                        totales.push( document.getElementById("total").value);
                        
                        var ids1 = ids.toString();
                        var totales1 = totales.toString();
                        
                        $("#boxEditar").load("pg-semanal/guardarSemanal.jsp?" + (validarDatosSemanal(nuevo = 0, idsx = ids1, totalesx = totales1)), function () {
                        });
                    });
                });
            </script>
        </head>

    <%
        int idSemanal = Integer.parseInt(request.getParameter("idSemanal"));

        NominaSemanal semanal = new NominaSemanal();
        semanal.setId_semanal(idSemanal);

        semanal = fachada.buscarNominaSemanal(idSemanal);
    %>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">EDITAR NOMINA SEMANAL</h1>
        </div>

        <div class="card-body">
            <%
                if (semanal != null) {
            %>
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
                                           class="form-control" readonly
                                           value = "<%= semanal.getId_semanal()%>">
                                </div>
                            </th>
                        </tr>
                        --%> 

                        <tr> 
                            
                            <input name="idNomina" id="idNomina" style="display: none;" value = "<%= semanal.getId_semanal()%>" >
                            
                            <th>
                                <div class="form-group">
                                    <label for="idEmpleado" class="form-label">Empleado:</label>
                                    <select id="idEmpleado" name="idEmpleado" class="form-control">
                                        <% for (Empleado empleado : fachada2.buscarEmpleados()) {
                                        %>

                                        <option value="<%= empleado.getId_empleado()%>"  <%if ((semanal.getIdEmpleado().getId_empleado()) == (empleado.getId_empleado())) {%> selected <%}%> > <%= empleado.getCedula() + " - " + (empleado.getNombre()).replace("_", " ") + " " + (empleado.getApellido()).replace("_", " ")%></option>
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
                                    <label for="total" class="form-label">Total:</label>
                                    <input type="text" name="total" id="total" 
                                           placeholder="Ingrese el total" required
                                           class="form-control" 
                                           value = "<%= semanal.getTotal()%>">
                                </div>
                            </th>
                        </tr>

                        <tr>
                            <th>
                                <div class="form-group">
                                    <label for="fechafx" class="form-label">Fecha:</label>
                                    <br>
                                    <input type="date" name="fechafx" id="fechafx" value="<%= semanal.getFecha()%>" style="width: 200px; vertical-align:10px">
                                </div>
                            </th>
                        </tr>

                    </tbody>
                </table>

                <div id="boxEditar">
                </div>

                <div id="divInsertar" style="display: none;" class="alert alert-danger">
                </div>  

                <br>
                
                <input name="validax" id="validax" style="display: none;" value = "1" >

                <div class="form-group">
                    <input type="button" id="btnGuardar" value="Guardar" class="btn" style="background:rgb(0, 195, 255)">
                    <button type="button" value="pg-semanal/listarSemanal.jsp?mens=0" class="btn" style="background:rgb(0, 195, 255)">Regresar</button>
                </div>

            </form>

            <%
            } else {
            %>

            <div id="divMensaje" class="alert alert-danger">
                Error: Semanal no encontrado.
            </div>
            <%
                }%>
        </div>
    </body>
</html>