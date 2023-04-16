<%-- 
    Document   : editarMensual.jsp
    Created on : 7 abr. 2022, 13:55:08
    Author     : Videoadicto
--%>
<%@page import="appnomina.capadatos.entidades.NominaMensual"%>
<%@page import="appnomina.capadatos.entidades.Empleado"%>
<jsp:useBean id="fachada" class="appnomina.negocio.facade.NominaMensualFacade" scope="page"></jsp:useBean>
<jsp:useBean id="fachada2" class="appnomina.negocio.facade.EmpleadoFacade"></jsp:useBean>

    <!DOCTYPE html>
    <html>
        <head>
            <script>

                $(document).ready(function () {

                    $("#btnCancelar").click(function () {
                        $("#box").load("pg-mensual/listarMensual.jsp?mens=0" + uneFechas(), function () {
                        });
                    });
                });
            </script>
        </head>

    <%
        int idMensual = Integer.parseInt(request.getParameter("idMensual"));
        
        NominaMensual mensual = fachada.buscarNominaMensual(idMensual);

        if (mensual != null) {
    %>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">INFORMACION DE NOMINA MENSUAL</h1>
        </div>

        <div class="card-body">
            <%
                if (mensual != null) {
            %>
            <form id="frmRegistrar" name="frmRegistrar">
                <table class="table table-borderless">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <th>                        
                                <div class="form-group">
                                    <label for="idMensual" class="form-label">Id:</label>
                                    <input type="text" name="idMensual" id="idMensual" 
                                           class="form-control" readonly
                                           value = "<%= mensual.getId_mensual()%>" >
                                </div>
                            </th>


                        </tr>                            

                        <tr>     

                            <th>
                                <div class="form-group">
                                    <label for="idEmpleado" class="form-label">Empleado:</label>

                                    <% Empleado empleado = new Empleado();
                                        empleado = fachada2.buscarEmpleado(mensual.getIdEmpleado().getId_empleado());
                                        {
                                    %>
                                    <input type="text"  id="idEmpleado" name="idEmpleado" 
                                           class="form-control" readonly
                                           value="<%= empleado.getCedula() + " - " + (empleado.getNombre()).replace("_", " ") + " " + (empleado.getApellido()).replace("_", " ")%>" >
                                    <%
                                        }
                                    %>

                                </div>
                            </th>
                        </tr>

                        <tr>   
                            <th>
                                <div class="form-group">
                                    <label for="mensual" class="form-label">Mensual:</label>
                                    <input type="text" name="mensual" id="mensual" 
                                           class="form-control" readonly
                                           value = "<%= mensual.getTotal()%>" >
                                </div>
                            </th>

                        </tr>
                        <tr>
                            <th>
                                <div class="form-group">
                                    <label for="fecha" class="form-label">Fecha:</label>
                                    <input type="text" name="fecha" id="fecha" 
                                           class="form-control" readonly
                                           value = "<%= mensual.getFecha()%>" >
                                </div>
                            </th>

                        </tr>

                    </tbody>
                </table>
                <div class="form-group">
                    <input type="button" id="btnCancelar" value="Regresar" class="btn" style="background:rgb(0, 195, 255)">
                </div>

            </form>
            <%
            } else {
            %>

            <div id="divMensaje" class="alert alert-danger">
                Error: Nomina Mensual no encontrada.
            </div>
            <%
                }%>
        </div>
        <%
            }
        %>
    </body>
</html>