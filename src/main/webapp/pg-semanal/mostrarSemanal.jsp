<%-- 
    Document   : editarSemanal.jsp
    Created on : 7 abr. 2022, 13:55:08
    Author     : Videoadicto
--%>
<%@page import="appnomina.capadatos.entidades.Semanal"%>
<%@page import="appnomina.capadatos.entidades.Produccion"%>
<jsp:useBean id="fachada" class="appnomina.negocio.facade.SemanalFacade" scope="page"></jsp:useBean>
<jsp:useBean id="fachada2" class="appnomina.negocio.facade.ProduccionFacade"></jsp:useBean>

    <!DOCTYPE html>
    <html>
        <head>
            <script>

                $(document).ready(function () {

                    $("#btnCancelar").click(function () {
                        $("#box").load("pg-semanal/listarSemanal.jsp?mens=0" + uneFechas(), function () {
                        });
                    });
                });
            </script>
        </head>

    <%
        int idSemanal = Integer.parseInt(request.getParameter("idSemanal"));

        Semanal semanal = fachada.buscarSemanal(idSemanal);

        if (semanal != null) {
    %>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">INFORMACION DE LA SEMANAL</h1>
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
                        <tr>
                            <th>                        
                                <div class="form-group">
                                    <label for="idSemanal" class="form-label">Id:</label>
                                    <input type="text" name="idSemanal" id="idSemanal" 
                                           class="form-control" readonly
                                           value = "<%= semanal.getId_semanal()%>">
                                </div>
                            </th>


                        </tr>                            

                        <tr>     

                            <th>
                                <div class="form-group">
                                    <label for="idProduccion" class="form-label">Produccion:</label>

                                    <% Produccion produccion = new Produccion();
                                        produccion = fachada2.buscarProduccion(semanal.getIdProduccion().getId_produccion());
                                        {
                                    %>
                                    <input type="text"  id="idProduccion" name="idProduccion" 
                                           class="form-control" readonly
                                           value="<%= produccion.getCedula() + " - " + (produccion.getNombre()).replace("_", " ") + " " + (produccion.getApellido()).replace("_", " ")%>">
                                    <%
                                        }
                                    %>

                                </div>
                            </th>
                        </tr>

                        <tr>   
                            <th>
                                <div class="form-group">
                                    <label for="semanal" class="form-label">Semanal:</label>
                                    <input type="text" name="semanal" id="semanal" 
                                           class="form-control" readonly
                                           value = "<%= semanal.getSemanal()%>">
                                </div>
                            </th>

                        </tr>
                        <tr>
                            <th>
                                <div class="form-group">
                                    <label for="fecha" class="form-label">Fecha:</label>
                                    <input type="text" name="fecha" id="fecha" 
                                           class="form-control" readonly
                                           value = "<%= semanal.getFecha()%>">
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
                Error: Semanal no encontrada.
            </div>
            <%
                }%>
        </div>
        <%
            }
        %>
    </body>
</html>