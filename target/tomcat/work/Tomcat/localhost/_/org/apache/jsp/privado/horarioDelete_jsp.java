/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-01-17 00:10:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.privado;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class horarioDelete_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/privado/horarioUpdate.jsp", Long.valueOf(1610836931529L));
    _jspx_dependants.put("/privado/../footer.jsp", Long.valueOf(1610836931524L));
    _jspx_dependants.put("/privado/../header.jsp", Long.valueOf(1610840883296L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_sql_005fquery_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Reserva online</title>\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <!-- \r\n");
      out.write("        <script src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("        <link href=\"/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("        <script src=\"/js/bootstrap.min.js\" ></script>\r\n");
      out.write("        <script src=\"/js/bootstrap3-floating-labels.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <link href=\"/css/bootstrap3-floating-labels.css\" rel=\"stylesheet\" type=\"text/css\"/> \r\n");
      out.write("    -->\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" \r\n");
      out.write("    href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\" \r\n");
      out.write("    integrity=\"sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z\" \r\n");
      out.write("    crossorigin=\"anonymous\">\r\n");
      out.write("    <link href=\"../css/estilos.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!--<link href=\"css/estilos.css\" rel=\"stylesheet\">-->\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("       \r\n");
      out.write("        <!-- Static navbar -->            \r\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n");
      out.write("            <div class=\" navbar-brand\">\r\n");
      out.write("                <img class=\" navbar-brand\" src=\"../img/profile.png\" width=\"30px\">\r\n");
      out.write("                ");
 
                    Cookie loginCookie = null;
                    String userName = "";
                    Cookie[] cookies = request.getCookies();
                    if (cookies != null) {
                        for (Cookie cookie : cookies) {
                            if (cookie.getName().equals("ges_res.user")) {
                                loginCookie = cookie;
                                userName = loginCookie.getValue();
                                break;
                            }
                        }
                        if (loginCookie!=null) {
                            
                        }else{
                            userName = "Login";
                        }
                    }
                
      out.write("\r\n");
      out.write("                <a class=\" navbar-brand\" href=\"\">");
      out.print( userName);
      out.write("</a>\r\n");
      out.write("            </div>\r\n");
      out.write("            <a class=\"navbar-brand\" href=\"/\">Reservas OnLine</a>\r\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("              </button>\r\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("                <ul class=\"nav navbar-nav\">\r\n");
      out.write("                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"/logout\">Logout</a></li>\r\n");
      out.write("                    <li class=\"nav-item dropdown\">\r\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\"> Usuarios <span class=\"caret\"></span></a>\r\n");
      out.write("                        <ul class=\"dropdown-menu\">\r\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/userRead.jsp\">Listado</a></li>\r\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/userCreate.jsp\">Alta</a></li>\r\n");
      out.write("                            <li class=\"dropdown-item\" ><a href=\"/privado/userUpdate.jsp\">Modificaci??n</a></li>\r\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/userDelete.jsp\">Borrado</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item dropdown\">\r\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\"> Instalaciones <span class=\"caret\"></span></a>\r\n");
      out.write("                        <ul class=\"dropdown-menu\">\r\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/instalacionRead.jsp\">Listar</a></li>\r\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/instalacionCreate.jsp\">Alta</a></li>\r\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/instalacionUpdate.jsp\">Modificaci??n</a></li>\r\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/instalacionDelete.jsp\">Borrado</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item dropdown\">\r\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\"> Horarios <span class=\"caret\"></span></a>\r\n");
      out.write("                        <ul class=\"dropdown-menu\">\r\n");
      out.write("                            <li class=\"dropdown-item\" ><a href=\"/privado/horarioRead.jsp\">Listar</a></li>\r\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/horarioCreate.jsp\">Alta</a></li>\r\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/horarioUpdate.jsp\">Modificaci??n</a></li>\r\n");
      out.write("                            <li class=\"dropdown-item\"><a href=\"/privado/horarioDelete.jsp\">Borrado</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item dropdown\">\r\n");
      out.write("                        <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\"> Reservas <span class=\"caret\"></span></a>\r\n");
      out.write("                        <ul class=\"dropdown-menu\">\r\n");
      out.write("                            <li class=\"dropdown-item\" ><a href=\"/privado/reservas.jsp\">Listar</a></li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"card\">");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div id=\"paso1\" align=\"center\">\r\n");
      out.write("        <div class=\"form\" id=\"user-form\">\r\n");
      out.write("            <caption><h2>Seleccione la instalaci??n del horario que desea actualizar o borrar</h2></caption>\r\n");
      out.write("            <select id=\"installationIdSelect\" onchange=\"mostrarHorarios()\">\r\n");
      out.write("                ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("            </select>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"paso2\" align=\"center\">\r\n");
      out.write("        Selecci??n de horario\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div id=\"paso3\" align=\"center\">\r\n");
      out.write("        <form>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"instalacion\">Horario:</label>\r\n");
      out.write("                <input disabled class=\"form-control\" name=\"horario\" id=\"horarioID\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"instalacion\">Instalaci??n:</label>\r\n");
      out.write("                <input disabled class=\"form-control\" name=\"instalacionID\" id=\"instalacionID\" />\r\n");
      out.write("                <input disabled class=\"form-control\" name=\"instalacion\" id=\"instalacion\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"horaInicio\">Hora de Inicio</label>\r\n");
      out.write("                <input name=\"inicio\" type=\"time\" id=\"horaInicio\" val=\"12:00\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"horaFin\">Hora de Fin</label>\r\n");
      out.write("                <input name=\"fin\" type=\"time\" id=\"horaFin\" val=\"12:00\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <div id=\"btnModificar\" class=\"btn btn-primary\" type=\"submit\" onclick=\"modificar()\">Modificar</div>\r\n");
      out.write("                <div id=\"btnBorrar\" class=\"btn btn-danger\" type=\"submit\" onclick=\"eliminar()\">Eliminar</div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write(" \r\n");
      out.write("$(\"#paso2\").hide();\r\n");
      out.write("$(\"#paso3\").hide();\r\n");
      out.write("\r\n");
      out.write("$(\"#user-form > option\").first().attr(\"selected\", true);\r\n");
      out.write("// $(\"#user-form > option\").first().prop(\"selected\", true);\r\n");
      out.write("\r\n");
      out.write("function mostrarHorarios(){\r\n");
      out.write("    // $(\"#paso1\").hide();\r\n");
      out.write("    // pedimos al backend los horarios de una instalaci??n dada\r\n");
      out.write("    let instalacionID = $(\"#installationIdSelect\").val();\r\n");
      out.write("    let url = 'http://localhost:9090/rest/api/horario/instalacion/'+instalacionID;\r\n");
      out.write("    // \r\n");
      out.write("    $.ajax({\r\n");
      out.write("            type : 'GET',\r\n");
      out.write("            url : url,\r\n");
      out.write("            contentType: 'application/json',\r\n");
      out.write("            // data : JSON.stringify({name: userName, email: userEmail}),\r\n");
      out.write("            success : function(data, status, xhr){\r\n");
      out.write("                console.log(data);\r\n");
      out.write("                let horarios = data;\r\n");
      out.write("                var html = '<table class=\"table\">';\r\n");
      out.write("                html += '<thead><tr><th>instalacion</th><th>inicio</th><th>fin</th><th>acci??n</th></tr></thead>';\r\n");
      out.write("                html += '<tbody>';   \r\n");
      out.write("                horarios.forEach( (horario) =>{\r\n");
      out.write("                    /*\r\n");
      out.write("                    let inicio = new Date();\r\n");
      out.write("                    inicio.setHours(horario.inicio.hour);\r\n");
      out.write("                    inicio.setMinutes(horario.inicio.minute);\r\n");
      out.write("                    inicio.setSeconds(0);\r\n");
      out.write("\r\n");
      out.write("                    let fin = new Date();\r\n");
      out.write("                    fin.setHours(horario.fin.hour);\r\n");
      out.write("                    fin.setMinutes(horario.fin.minute);\r\n");
      out.write("                    fin.setSeconds(0);\r\n");
      out.write("                    */\r\n");
      out.write("                    html += '<tr>';\r\n");
      out.write("                    html += '<td>'+horario.instalacion.name+'</td>';\r\n");
      out.write("                    html += '<td>'+horario.inicio+'</td>';\r\n");
      out.write("                    html += '<td>'+horario.fin+'</td>';\r\n");
      out.write("                    html += '<td>'+ \r\n");
      out.write("                        '<button class=\"btn btn-info\" onclick=\"formularioM('+horario.id+', 1)\"> modificar </button>' + \r\n");
      out.write("                        '<button class=\"btn btn-danger\" onclick=\"formularioM('+horario.id+', 2)\"> eliminar </button>' + \r\n");
      out.write("                        '<button class=\"btn btn-success\" onclick=\"formularioR('+horario.id+')\"> reservar </button>' + \r\n");
      out.write("                        '</td>';\r\n");
      out.write("                    html += '</tr>';\r\n");
      out.write("                });\r\n");
      out.write("                html += '</tbody>';\r\n");
      out.write("                html += '</table>';\r\n");
      out.write("                $('#paso2').html(html);\r\n");
      out.write("                $('#paso2').show();\r\n");
      out.write("            },\r\n");
      out.write("            error: function(xhr, status, error){\r\n");
      out.write("            $('#msg').html('<span style=\\'color:red;\\'>'+error+'</span>')\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("function setTimeOnInput(id, time) {\r\n");
      out.write("  $(id).attr({'value': time});\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function formularioM(id, opcion) {\r\n");
      out.write("    $(\"#paso2\").hide();\r\n");
      out.write("    $(\"#paso3\").show();\r\n");
      out.write("    if (opcion==2) { // borrar\r\n");
      out.write("        $(\"#btnModificar\").hide();\r\n");
      out.write("        $(\"#btnBorrar\").show();\r\n");
      out.write("    } else { // modificar\r\n");
      out.write("        $(\"#btnModificar\").show();\r\n");
      out.write("        $(\"#btnBorrar\").hide();\r\n");
      out.write("    }\r\n");
      out.write("    let url = 'http://localhost:9090/rest/api/horario/'+id;\r\n");
      out.write("    // \r\n");
      out.write("    $.ajax({\r\n");
      out.write("            type : 'GET',\r\n");
      out.write("            url : url,\r\n");
      out.write("            contentType: 'application/json',\r\n");
      out.write("            // data : JSON.stringify({name: userName, email: userEmail}),\r\n");
      out.write("            success : function(data, status, xhr){\r\n");
      out.write("                let horario = data;\r\n");
      out.write("                $(\"#horarioID\").val(horario.id);\r\n");
      out.write("                $(\"#instalacionID\").val(horario.instalacion.id);\r\n");
      out.write("                $(\"#instalacion\").val(horario.instalacion.name);\r\n");
      out.write("                setTimeOnInput(\"#horaInicio\",horario.inicio);\r\n");
      out.write("                setTimeOnInput(\"#horaFin\",horario.fin);\r\n");
      out.write("            },\r\n");
      out.write("            error: function(xhr, status, error){\r\n");
      out.write("                $('#msg').html('<span style=\\'color:red;\\'>'+error+'</span>');\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function modificar(id){\r\n");
      out.write("    var url = 'http://localhost:9090/rest/api/horario/'+$(\"#horarioID\").val();\r\n");
      out.write("    var datos = {};\r\n");
      out.write("    datos.id = $(\"#horarioID\").val();\r\n");
      out.write("    datos.instalacion = {};\r\n");
      out.write("    datos.instalacion.id = $(\"#instalacionID\").val();\r\n");
      out.write("    datos.instalacion.name = $(\"#instalacion\").val();\r\n");
      out.write("    /* $(\"#horaInicio\").val().split(\":\");\r\n");
      out.write("    datos.inicio = {\r\n");
      out.write("        hour: hour,\r\n");
      out.write("        minute: minute\r\n");
      out.write("    };*/\r\n");
      out.write("    datos.inicio = $(\"#horaInicio\").val();\r\n");
      out.write("    /*[hour, minute] = $(\"#horaFin\").val().split(\":\");\r\n");
      out.write("    datos.fin = {\r\n");
      out.write("        hour: hour,\r\n");
      out.write("        minute: minute\r\n");
      out.write("    }*/\r\n");
      out.write("    datos.fin = $(\"#horaFin\").val();\r\n");
      out.write("    console.log(datos);\r\n");
      out.write("    $.ajax({\r\n");
      out.write("        type : 'PUT',\r\n");
      out.write("        url : url,\r\n");
      out.write("        contentType: 'application/json',\r\n");
      out.write("        dataType: 'json',\r\n");
      out.write("        data : JSON.stringify(datos),\r\n");
      out.write("        success : function(data, status, xhr){\r\n");
      out.write("            window.location.replace(\"horarioRead.jsp\");\r\n");
      out.write("        },\r\n");
      out.write("        error: function(xhr, status, error){\r\n");
      out.write("            $('#msg').html('<span style=\\'color:red;\\'>'+error+'</span>');\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function eliminar(){\r\n");
      out.write("    \r\n");
      out.write("    var horarioId = $(\"#horarioID\").val();\r\n");
      out.write("    var url = 'http://localhost:9090/horario/'+horarioId;\r\n");
      out.write("\r\n");
      out.write("    $.ajax({\r\n");
      out.write("        type : 'DELETE',\r\n");
      out.write("        url : url,\r\n");
      out.write("        contentType: 'application/json',\r\n");
      out.write("        // data : JSON.stringify({name: userName, email: userEmail}),\r\n");
      out.write("        success : function(data, status, xhr){\r\n");
      out.write("            window.location.replace(\"horarioRead.jsp\");\r\n");
      out.write("        },\r\n");
      out.write("        error: function(xhr, status, error){\r\n");
      out.write("            $('#msg').html('<span style=\\'color:red;\\'>'+error+'</span>')\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("function formularioR(id){\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            \r\n");
      out.write("        </div> <!-- del DIV.container principal -->\r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\" integrity=\"sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js\" integrity=\"sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <br>\r\n");
      out.write("        <div class=\"pie\">\r\n");
      out.write("            <p>IES Virgen del Carmen</p>\r\n");
      out.write("            <p>Acceso a Datos</p>\r\n");
      out.write("            <p>2?? CFGS DAM</p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
      out.write(' ');
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_sql_005fquery_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  sql:query
    org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_005fquery_005f0 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
    _jspx_th_sql_005fquery_005f0.setPageContext(_jspx_page_context);
    _jspx_th_sql_005fquery_005f0.setParent(null);
    // /privado/horarioUpdate.jsp(5,0) name = var type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sql_005fquery_005f0.setVar("installationList");
    // /privado/horarioUpdate.jsp(5,0) name = dataSource type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_sql_005fquery_005f0.setDataSource("jdbc/gestionReservas");
    int[] _jspx_push_body_count_sql_005fquery_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_sql_005fquery_005f0 = _jspx_th_sql_005fquery_005f0.doStartTag();
      if (_jspx_eval_sql_005fquery_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_005fquery_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_005fquery_005f0[0]++;
          _jspx_th_sql_005fquery_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_005fquery_005f0.doInitBody();
        }
        do {
          out.write("\r\n");
          out.write("    select id, nombre from instalacion;\r\n");
          int evalDoAfterBody = _jspx_th_sql_005fquery_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_005fquery_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_005fquery_005f0[0]--;
        }
      }
      if (_jspx_th_sql_005fquery_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_005fquery_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_005fquery_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_005fquery_005f0.doFinally();
      _005fjspx_005ftagPool_005fsql_005fquery_0026_005fvar_005fdataSource.reuse(_jspx_th_sql_005fquery_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /privado/horarioUpdate.jsp(16,16) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("installation");
    // /privado/horarioUpdate.jsp(16,16) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/privado/horarioUpdate.jsp(16,16) '${installationList.rows}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${installationList.rows}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                    <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${installation.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"/> \r\n");
          out.write("                        ");
          if (_jspx_meth_c_005fout_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\r\n");
          out.write("                    </option>\r\n");
          out.write("                ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fout_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_005fout_005f0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_005fout_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fout_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /privado/horarioUpdate.jsp(18,24) name = value type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fout_005f0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${installation.nombre}", java.lang.Object.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
    int _jspx_eval_c_005fout_005f0 = _jspx_th_c_005fout_005f0.doStartTag();
    if (_jspx_th_c_005fout_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fout_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005fout_005f0);
    return false;
  }
}
