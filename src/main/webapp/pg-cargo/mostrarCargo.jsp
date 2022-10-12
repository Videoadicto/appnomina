<%-- 
    Document   : editarCargo.jsp
    Created on : 7 abr. 2022, 13:55:08
    Author     : Videoadicto
--%>
<%@page import="appnomina.capadatos.entidades.Cargo"%>
<jsp:useBean id="fachada" class="appnomina.negocio.facade.CargoFacade" scope="page"></jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <script>

                $(document).ready(function () {

                    $("#btnCancelar").click(function () {
                        $("#box").load("pg-cargo/listarCargo.jsp?mens=0", function () {
                        });
                    });
                });
            </script>
        </head>

    <%
        int idCargo = Integer.parseInt(request.getParameter("idCargo"));

        Cargo cargo = fachada.buscarCargo(idCargo);

        if (cargo != null) {
    %>

    <body>
        <div class="card-header" style="background-color: rgb(75, 131, 145);height:50px;">,
            <h1 style="font-family: 'Dyuthi';font-size: 40px; color: rgb(255, 255, 255);top: -30px; position:relative;">INFORMACION DEL CARGO</h1>
        </div>

        <div class="card-body">
            <%
                if (cargo != null) {
            %>
            <form id="frmRegistrar" name="frmRegistrar">

                <table class="table table-borderless">
                    <thead>
                    </thead>
                    <tbody>

                        <tr>
                            <th>  

                                <div class="form-group">
                                    <label for="idCargo" class="form-label">Id:</label>
                                    <input type="text" name="idCargo" id="idCargo" 
                                           placeholder="" required
                                           class="form-control" readonly
                                           value = "<%= cargo.getId_cargo()%>">
                                </div>

                            </th> 
                        </tr>

                        <tr>
                            <th> 


                                <div class="form-group">
                                    <label for="nombre" class="form-label">Nombre:</label>
                                    <input type="text" name="nombre" id="nombre" 
                                           placeholder="" required
                                           class="form-control" readonly
                                           value="<%= (cargo.getNombre()).replace("_", " ")%>">
                                </div>

                            </th>
                        </tr>

                        <tr>
                            <th> 


                                <div class="form-group">
                                    <label for="pago" class="form-label">Pago:</label>
                                    <input type="text" name="pago" id="pago" 
                                           placeholder="" required
                                           class="form-control" readonly
                                           value="<%= cargo.getPago()%>">
                                </div>
                            </th> 
                        </tr>

                    </tbody>
                </table> 

                <br>


                <div class="form-group">
                    <input type="button" id="btnCancelar" value="Regresar" class="btn btn-success">
                </div>

            </form>
            <%
            } else {
            %>

            <div id="divMensaje" class="alert alert-danger">
                Error: Cargo no encontrado.
            </div>
            <%
                }%>
        </div>
        <%
            }
        %>
    </body>
</html>