package org.apache.jsp.pg_002dempleado;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sistemainventarios.capadatos.entidades.Empleado;

public final class listarEmpleado_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      response.setHeader("X-Powered-By", "JSP/2.3");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write('\n');
      sistemainventarios.negocio.facade.EmpleadoFacade fachada = null;
      synchronized (_jspx_page_context) {
        fachada = (sistemainventarios.negocio.facade.EmpleadoFacade) _jspx_page_context.getAttribute("fachada", PageContext.PAGE_SCOPE);
        if (fachada == null){
          fachada = new sistemainventarios.negocio.facade.EmpleadoFacade();
          _jspx_page_context.setAttribute("fachada", fachada, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("    <html>\n");
      out.write("        <head>\n");
      out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("            <title>Gestión Empleados</title>\n");
      out.write("            <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("            <link href=\"css/dataTable/jquery.dataTables.min.css\" rel=\"stylesheet\">\n");
      out.write("            <link href=\"css/dataTable/buttons.dataTables.min.css\" rel=\"stylesheet\">\n");
      out.write("            <script src=\"js/validaciones.js\"></script>\n");
      out.write("            <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("            <script src=\"js/jquery-3.2.1.min.js\"></script>\n");
      out.write("            <script src=\"js/dataTable/jquery.dataTables.min.js\"></script>\n");
      out.write("\n");
      out.write("            <script>\n");
      out.write("                $(\"button\").click(function () {\n");
      out.write("\n");
      out.write("                    $(\"#box\").load($(this).val(), function () {\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("        <div class=\"card-header\">\n");
      out.write("            <h1>Administracion de Empleados</h1>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        <div>\n");
      out.write("        ");
      out.write("\n");
      out.write("        <button class=\"btn\" id=\"nuevo\" value=\"pg-empleado/insertarEmpleado.jsp\" style=\"left : 1.2%; position:relative;\">\n");
      out.write("            <i class=\"fa fa-toolbox\" >\n");
      out.write("            </i> Agregar Empleado\n");
      out.write("        </button>                     \n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"card-body\">\n");
      out.write("        <div class=\"table-responsive\">\n");
      out.write("            <table id=\"tablaEmpleados\" class=\"table table-bordered\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Cedula</th>\n");
      out.write("                        <th>Nombre</th>\n");
      out.write("                        <th>Email</th>\n");
      out.write("                        <th>opciones</th>\n");
      out.write("                    </tr>                            \n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
 for (Empleado usuario : fachada.buscarEmpleados()) {
                    
      out.write("\n");
      out.write("                    <tr>                               \n");
      out.write("                        <td>");
      out.print( usuario.getCedula());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( usuario.getNombre());
      out.write("</td>\n");
      out.write("                        <td>");
      out.print( usuario.getEmail());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <button  class=\"item\" style=\"border:none\" value=\"pg-empleado/editarEmpleado.jsp?cedula=");
      out.print( usuario.getCedula());
      out.write("\">\n");
      out.write("                                <img src=\"img/editar.png\" width=\"16\" height=\"16\" >\n");
      out.write("                            </button>\n");
      out.write("\n");
      out.write("                            <button  class=\"item\" style=\"border:none\" value=\"pg-empleado/mostrarEmpleado.jsp?cedula=");
      out.print( usuario.getCedula());
      out.write("\">\n");
      out.write("                                <img src=\"img/info.png\" alt=\"alt\"/>\n");
      out.write("                            </button>\n");
      out.write("\n");
      out.write("                            <button  class=\"item\" style=\"border:none\" value=\"pg-empleado/eliminarEmpleado.jsp?cedula=");
      out.print( usuario.getCedula());
      out.write("\">\n");
      out.write("                                <img src=\"img/borrar.png\" alt=\"alt\"/>\n");
      out.write("                            </button>    \n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div id=\"divListar\" class=\"alert alert-success\">\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div id=\"boxListar\">\n");
      out.write("    </div>    \n");
      out.write("\n");
      out.write("    <div class=\"card-footer\">\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <script src=\"js/dataTable/dataTables.buttons.min.js\"></script>\n");
      out.write("    <script src=\"js/dataTable/buttons.flash.min.js\"></script>\n");
      out.write("    <script src=\"js/dataTable/jszip.min.js\"></script>\n");
      out.write("    <script src=\"js/dataTable/pdfmake.min.js\"></script>\n");
      out.write("    <script src=\"js/dataTable/vfs_fonts.js\"></script>\n");
      out.write("    <script src=\"js/dataTable/buttons.html5.min.js\"></script>\n");
      out.write("    <script src=\"js/dataTable/buttons.print.min.js\"></script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("                $(document).ready(function () {\n");
      out.write("                    $('#tablaEmpleados').DataTable({\n");
      out.write("                        dom: 'Bfrtip',\n");
      out.write("                        buttons: [\n");
      out.write("                            'copy', 'csv', 'excel', 'pdf', 'print'\n");
      out.write("                        ]\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
