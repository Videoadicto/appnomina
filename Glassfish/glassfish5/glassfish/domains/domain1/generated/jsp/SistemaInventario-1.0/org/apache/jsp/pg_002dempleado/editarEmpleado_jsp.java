package org.apache.jsp.pg_002dempleado;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import sistemainventarios.capadatos.entidades.Empleado;

public final class editarEmpleado_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
      sistemainventarios.negocio.facade.EmpleadoFacade fachada = null;
      synchronized (_jspx_page_context) {
        fachada = (sistemainventarios.negocio.facade.EmpleadoFacade) _jspx_page_context.getAttribute("fachada", PageContext.PAGE_SCOPE);
        if (fachada == null){
          fachada = new sistemainventarios.negocio.facade.EmpleadoFacade();
          _jspx_page_context.setAttribute("fachada", fachada, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\n");
      out.write("            <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("            <title>Empleados</title>\n");
      out.write("            <script>\n");
      out.write("\n");
      out.write("                $(document).ready(function () {\n");
      out.write("\n");
      out.write("                    $(\"#btnCancelar\").click(function () {\n");
      out.write("                        $(\"#box\").load(\"pg-empleado/listarEmpleado.jsp\", function () {\n");
      out.write("                        });\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("    ");

        String cedula = request.getParameter("cedula");

        Empleado empleado = new Empleado();
        empleado.setCedula(cedula);

        empleado = fachada.buscarEmpleado(cedula);
    
      out.write("\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"card-header\">\n");
      out.write("            <h1>Editar Empleado</h1>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"card-body\">\n");
      out.write("            ");

                if (empleado != null) {
            
      out.write("\n");
      out.write("            <form id=\"frmRegistrar\" name=\"frmRegistrar\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"cedula\" class=\"form-label\">Número de documento: *</label>\n");
      out.write("                    <input type=\"text\" name=\"cedula\" id=\"cedula\" \n");
      out.write("                           placeholder=\"Digite su número de cedula\" required\n");
      out.write("                           class=\"form-control\" readonly\n");
      out.write("                           value = \"");
      out.print( empleado.getCedula());
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"nombre\" class=\"form-label\">Nombre: *</label>\n");
      out.write("                    <input type=\"text\" name=\"nombre\" id=\"nombre\" \n");
      out.write("                           placeholder=\"Digite su nombre\" required\n");
      out.write("                           class=\"form-control\"\n");
      out.write("                           value=\"");
      out.print( empleado.getNombre());
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"email\" class=\"form-label\">Email: *</label>\n");
      out.write("                    <input type=\"email\" name=\"email\" id=\"email\" \n");
      out.write("                           placeholder=\"Digite su correo\" required\n");
      out.write("                           class=\"form-control\"\n");
      out.write("                           value=\"");
      out.print( empleado.getEmail());
      out.write("\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <input type=\"hidden\" id=\"password\" name=\"password\" value=\"");
      out.print( empleado.getPassword());
      out.write("\">\n");
      out.write("                <br>\n");
      out.write("\n");
      out.write("                <div id=\"boxEditar\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div id=\"divEditar\" class=\"alert alert-success\">\n");
      out.write("                </div>   \n");
      out.write("\n");
      out.write("                <input id=\"nuevos\" style=\"display: none;\" value =\"0\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <input type=\"button\" id=\"btnEnviar\" value=\"Guardar Empleado\" class=\"btn btn-success\" onclick=\"validarDatosEdicion()\" >\n");
      out.write("                    <input type=\"button\" id=\"btnCancelar\" value=\"Cancelar\" class=\"btn btn-success\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            ");

            } else {
            
      out.write("\n");
      out.write("\n");
      out.write("            <div id=\"divMensaje\" class=\"alert alert-danger\">\n");
      out.write("                Error: Empleado no encontrado.\n");
      out.write("            </div>\n");
      out.write("            ");

                }
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
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
