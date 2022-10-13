<%-- 
    Document   : editarProduccion.jsp
    Created on : 7 abr. 2022, 13:55:08
    Author     : Videoadicto
--%>
<%@page import="appnomina.capadatos.entidades.Produccion"%>
<%@page import="appnomina.capadatos.entidades.Empleado"%>
<jsp:useBean id="fachada" class="appnomina.negocio.facade.ProduccionFacade" scope="page"></jsp:useBean>
<jsp:useBean id="fachada2" class="appnomina.negocio.facade.EmpleadoFacade"></jsp:useBean>

    <!DOCTYPE html>
    <html>
        <head>
            <script>

                $(document).ready(function () {

                    $("#btnCancelar").click(function () {
                        $("#box").load("pg-produccion/listarProduccion.jsp?mens=0", function () {
                        });
                    });
                });
            </script>
        </head>

    <%
        int idProduccion = Integer.parseInt(request.getParameter("idProduccion"));

        Produccion produccion = fachada.buscarProduccion(idProduccion);

        if (produccion != null) {
    %>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">INFORMACION DE LA PRODUCCION</h1>
        </div>

        <div class="card-body">
            <%
                if (produccion != null) {
            %>
            <form id="frmRegistrar" name="frmRegistrar">
                <table class="table table-borderless">
                    <thead>
                    </thead>
                    <tbody>
                        <tr>
                            <th>                        
                                <div class="form-group">
                                    <label for="idProduccion" class="form-label">Id:</label>
                                    <input type="text" name="idProduccion" id="idProduccion" 
                                           class="form-control" readonly
                                           value = "<%= produccion.getId_produccion()%>">
                                </div>
                            </th>


                        </tr>                            

                        <tr>     

                            <th>
                                <div class="form-group">
                                    <label for="idEmpleado" class="form-label">Empleado:</label>

                                    <% Empleado empleado = new Empleado();
                                        empleado = fachada2.buscarEmpleado(produccion.getIdEmpleado().getId_empleado());
                                        {
                                    %>
                                    <input type="text"  id="idEmpleado" name="idEmpleado" 
                                           class="form-control" readonly
                                           value="<%= empleado.getCedula() + " - " + (empleado.getNombre()).replace("_", " ") + " " + (empleado.getApellido()).replace("_", " ")%>">
                                    <%
                                        }
                                    %>

                                </div>
                            </th>
                        </tr>

                        <tr>   
                            <th>
                                <div class="form-group">
                                    <label for="produccion" class="form-label">Produccion:</label>
                                    <input type="text" name="produccion" id="produccion" 
                                           class="form-control" readonly
                                           value = "<%= produccion.getProduccion()%>">
                                </div>
                            </th>

                        </tr>
                        <tr>
                            <th>
                                <div class="form-group">
                                    <label for="fecha" class="form-label">Fecha:</label>
                                    <input type="text" name="fecha" id="fecha" 
                                           class="form-control" readonly
                                           value = "<%= produccion.getFecha()%>">
                                </div>
                            </th>

                        </tr>

                    </tbody>
                </table>
                <div class="form-group">
                    <input type="button" id="btnCancelar" value="Regresar" class="btn btn-success">
                </div>

            </form>
            <%
            } else {
            %>

            <div id="divMensaje" class="alert alert-danger">
                Error: Produccion no encontrada.
            </div>
            <%
                }%>
        </div>
        <%
            }
        %>
    </body>
</html>