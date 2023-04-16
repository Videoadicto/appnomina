/* 
 Document   : editarEmpleado.jsp
 Created on : 7 abr. 2022, 13:55:08
 Author     : Videoadicto
 */

function separar(X) {

    //window.alert("" + X);
    var adc = X.split(",");

    document.getElementById("idProducto").value = adc[0];
    document.getElementById("nombre").value = adc[1];
    document.getElementById("precio").value = adc[2];
    document.getElementById("cantidadX").value = adc[3];

    //window.alert("" +  adc[3]);

}



function separarCompra(X) {

    //window.alert("" + X);
    var adc = X.split(";");

    document.getElementById("idProducto").value = adc[0];
    document.getElementById("nombre").value = adc[1];
    document.getElementById("precio").value = adc[2];

    //window.alert("" +  adc[3]);

}

function Procesar(X, Y) {
    window.alert("" + X);
    window.alert("" + Y);
}



function limpiarProducto() {
    document.getElementById("idProducto").value = "";
    document.getElementById("nombre").value = "";
    document.getElementById("precio").value = "";
    document.getElementById("cantidad").value = "";
    document.getElementById("sinDatos").style = "display:none;";
    document.getElementById("sinStock").style = "display:none;";
}

function aparecerDiv(divElegido) {
    document.getElementById("" + divElegido).style = 'display:"";';
}

function corregirNombre(nombre) {
//window.alert("nombre= " + nombre );
    var dato = nombre.replace(/_/g, " ");
    return dato;
}

function modificarMenu() {
    var valor1 = document.getElementById("valor").value;

    if (valor1 === "0") {
        document.getElementById("prov").style = "display:none;";
        document.getElementById("emp").style = "display:none;";
    }

    //window.alert("" + valor1);
}


function preValidar() {
    var usuario1 = document.getElementById("usuario").value;
    var password1 = document.getElementById("password").value;

    //frmRegistrar.getElementById("usuario").value = "";
    //frmRegistrar.getElementById("password").value = "";

    //window.alert("prevalidar");

    //limpiar();

    datos = "usuario2=" + usuario1 + "&password2=" + password1;



    return datos;
}

function validarPagina() {

    var X = document.getElementById("valor2").value;

    if (X !== "1") {
        window.alert("primero: " + X);
        return false;
    } else
    {
        window.alert("segundo: " + X);
        return true;
    }

}

function limpiar() {
    frmRegistrar.getElementById("usuario").value = "";
    frmRegistrar.getElementById("password").value = "";

    //document.getElementById("usuario").value = "";
    //document.getElementById("password").value = "";
}

//sobrante
//function validarX() {

//    frmRegistrar.cedula.value = null;
//    frmRegistrar.password.value = null;
//    window.alert("test");

//}

function validar() {
    var mens = document.getElementById("mensaje").value;

    if (mens !== "Ok") {
        return false;
    } else
    {
        //limpiar();
        return true;
    }

}



function eluid() {
    var mens = document.getElementById("emple").value;
    return mens;
}


function verificarPaginaP(texto)
{
    //window.alert("validarpagina");
    var datos = "";

    if (texto.includes("eliminar")) {
        datos = texto + "&sn=" + (window.confirm("Esta seguro que desea borrar el registro?"));
    } else
    {
        var fechai1 = "" + document.getElementById("fechaix").value;
        var fechaf1 = "" + document.getElementById("fechafx").value;

        //window.alert("" + fechai1 + " " + fechaf1);
        //window.alert(texto);


        if (fechai1 !== "" && fechaf1 !== "") {

            datos = texto + "&fechal2=" + fechai1 + "&fechah2=" + fechaf1;
        } else
        {
            window.alert("FECHA INVALIDA");
            throw new Exception("Exception message");
        }
    }
    return datos;
}

function verificarPaginaS(texto)
{
    //window.alert("validarpagina");
    var datos = "";

    if (texto.includes("eliminar")) {
        datos = texto + "&sn=" + (window.confirm("Esta seguro que desea borrar el registro?"));
    } else
    {
        var fechai1 = "" + document.getElementById("fechaix").value;
        var fechaf1 = "" + document.getElementById("fechafx").value;
        var tipo1 = "" + document.getElementById("tipo").value;

        //window.alert("" + fechai1 + " " + fechaf1);
        //window.alert(texto);


        if (fechai1 !== "" && fechaf1 !== "") {

            datos = texto + "&tipo2=" + tipo1 + "&fechal2=" + fechai1 + "&fechah2=" + fechaf1;
        } else
        {
            window.alert("FECHA INVALIDA");
            throw new Exception("Exception message");
        }
    }
    //window.alert("" + datos);
    return datos;
}


function verificarPaginaM(texto)
{
    //window.alert("validarpagina");
    var datos = "";

    if (texto.includes("eliminar")) {
        datos = texto + "&sn=" + (window.confirm("Esta seguro que desea borrar el registro?"));
    } else
    {
        var fechai1 = "" + document.getElementById("fechaix").value;
        var fechaf1 = "" + document.getElementById("fechafx").value;
        var tipo1 = "" + document.getElementById("tipo").value;

        //window.alert("" + fechai1 + " " + fechaf1);
        //window.alert(texto);


        if (fechai1 !== "" && fechaf1 !== "") {

            datos = texto + "&tipo2=" + tipo1 + "&fechai2=" + fechai1 + "&fechaf2=" + fechaf1;
        } else
        {
            window.alert("FECHA INVALIDA");
            throw new Exception("Exception message");
        }
    }
    //window.alert("" + datos);
    return datos;
}




function verificarPaginaF(texto)
{
    //window.alert("validarpagina");
    var datos = "";

    var fechai1 = "" + document.getElementById("fechaix").value;
    var fechaf1 = "" + document.getElementById("fechafx").value;
    var tipo1 = "" + document.getElementById("tipo").value;

    //window.alert("" + fechai1 + " " + fechaf1);
    //window.alert(texto);


    if (fechai1 !== "" && fechaf1 !== "") {

        datos = texto + "&tipo2=" + tipo1 + "&fechal2=" + fechai1 + "&fechah2=" + fechaf1;
    }
    //window.alert("" + datos);
    return datos;
}

function verificarGrafica()
{
    document.getElementById("divInsertar").innerHTML = "";
    document.getElementById("divInsertar").style = 'display:"";';
    
    document.getElementById("boxInsertar").innerHTML = "";

    var datos = "";
    var fechai1 = "" + document.getElementById("fechaix").value;
    var fechaf1 = "" + document.getElementById("fechafx").value;
    var idEmpleado1 = "" + document.getElementById("idEmpleado").value;

    //window.alert("" + fechai1 + " " + fechaf1);
    if (fechai1 !== "" && fechaf1 !== "" && idEmpleado1 !=="") {

        document.getElementById("divInsertar").style = "display: none;";
        datos = "idEmpleado2=" + idEmpleado1 + "&fechai2=" + fechai1 + "&fechaf2=" + fechaf1 + "&validar=1";
    }
    else
    {
        document.getElementById("divInsertar").style = 'display:"";';
        document.getElementById("divInsertar").innerHTML = "Error: Hay campos vacios";
        datos = "validar=0";
    }
//    window.alert("pep");
    return datos;
}


function verificarGraficaCargo()
{
    document.getElementById("divInsertar").innerHTML = "";
    document.getElementById("divInsertar").style = 'display:"";';
    
    document.getElementById("boxInsertar").innerHTML = "";

    var datos = "";
    var fechai1 = "" + document.getElementById("fechaix").value;
    var fechaf1 = "" + document.getElementById("fechafx").value;

    //window.alert("" + fechai1 + " " + fechaf1);
    if (fechai1 !== "" && fechaf1 !== "" ) {

        document.getElementById("divInsertar").style = "display: none;";
        datos = "fechai2=" + fechai1 + "&fechaf2=" + fechaf1 + "&validar=1";
    }
    else
    {
        document.getElementById("divInsertar").style = 'display:"";';
        document.getElementById("divInsertar").innerHTML = "Error: Hay campos vacios";
        datos = "validar=0";
    }
//    window.alert("pep");
    return datos;
}





function verificarPagina(texto)
{
    //window.alert("validarEdicion :" + texto);
    var datos = "";

    if (texto.includes("eliminar")) {
        datos = texto + "&sn=" + (window.confirm("Esta seguro que desea borrar el registro?"));
    } else
    {
        datos = texto;
        //window.alert("" + datos);
    }
    return datos;
}





function verificarPagina2(texto)
{
    //window.alert("validarEdicion :" + texto);
    var datos = "";

    if (texto.includes("eliminar")) {
        datos = texto + "&sn=" + (window.confirm("Esta seguro que desea borrar el registro?"));
    } else
    {

        if (texto.includes("?")) {
            datos = texto;
        } else {
            datos = texto + "?uid=" + document.getElementById("emplea").value;
            //window.alert("" + datos);
        }
    }
    return datos;
}



function validarDatos(nuevo) {
    var datos = "";
    document.getElementById("divInsertar").innerHTML = "";
    document.getElementById("divInsertar").style = 'display:"";';

    try {
        document.getElementById("divGuardar").innerHTML = "";
        document.getElementById("divGuardar").style = "display:none;";

    } catch (error) {
        console.error(error);
    }

    var cedula1 = (((frmRegistrar.cedula.value).trim()).replace(/ /g, ""));
    var nombre1 = ((frmRegistrar.nombre.value).trim()).replace(/ /g, "_");
    var email1 = ((frmRegistrar.email.value).trim()).replace(/ /g, "");
    var password11 = ((frmRegistrar.password.value).trim()).replace(/ /g, "");
    var password22 = ((frmRegistrar.repetir_password.value).trim()).replace(/ /g, "");

    //window.alert("cedula2=" + cedula1 + "&nombre2=" + nombre1 + "&email2=" + email1 + "&password2=" + password11 + "&nuevo2=" + nuevo + "&validar2=1");

    if (cedula1 === "" || nombre1 === "" || email1 === "" || password11 === "" || password22 === "")
    {
        document.getElementById("divInsertar").innerHTML = "Error: Hay campos vacios";
        datos = "validar2=0";
    } else {
        if (password11 != password22) {
            document.getElementById("divInsertar").innerHTML = "Error: La contraseña no coincide";
            //frmRegistrar.repetir_password.focus();
            datos = "validar2=0";
        } else {
            datos = "cedula2=" + cedula1 + "&nombre2=" + nombre1 + "&email2=" + email1 + "&password2=" + password11 + "&nuevo2=" + nuevo + "&validar2=1";
            document.getElementById("divInsertar").style = "display: none;";
        }
    }
    return datos;
}

function validarDatosEdicion(nuevo) {

    var datos = "";
    document.getElementById("divEditar").innerHTML = "";
    document.getElementById("divEditar").style = 'display:"";';

    try {
        document.getElementById("divGuardar").innerHTML = "";
        document.getElementById("divGuardar").style = "display:none;";

    } catch (error) {
        console.error(error);
    }

    var cedula1 = (frmRegistrar.cedula.value).trim();
    var nombre1 = ((frmRegistrar.nombre.value).trim()).replace(/ /g, "_");
    var email1 = ((frmRegistrar.email.value).trim()).replace(/ /g, "");
    var password1 = (frmRegistrar.password.value).trim();

    if (nombre1 === "" || email1 === "")
    {
        document.getElementById("divEditar").innerHTML = "Error: Hay campos vacios";
        datos = "validar2=0";
    } else {
        datos = "cedula2=" + cedula1 + "&nombre2=" + nombre1 + "&email2=" + email1 + "&password2=" + password1 + "&nuevo2=" + nuevo + "&validar2=1";
        document.getElementById("divEditar").style = "display: none;";
    }
    return datos;
}

function validarDatosEmpleado(nuevo) {

    //window.alert("A LA MERC");

    var datos = "";
    document.getElementById("divInsertar").innerHTML = "";
    document.getElementById("divInsertar").style = 'display:"";';

    try {
        document.getElementById("divGuardar").innerHTML = "";
        document.getElementById("divGuardar").style = "display:none;";

    } catch (error) {
        console.error(error);
    }

    var idEmpleado1 = (((frmRegistrar.idEmpleado.value).trim()).replace(/ /g, ""));
    var nombre1 = ((frmRegistrar.nombre.value).trim()).replace(/ /g, "_");
    var apellido1 = ((frmRegistrar.apellido.value).trim()).replace(/ /g, "_");
    var cedula1 = ((frmRegistrar.cedula.value).trim()).replace(/ /g, "");
    var fechanac1 = "" + frmRegistrar.fechanac.value;
    //var telefono1 = Number(((frmRegistrar.telefono.value).trim()).replace(/ /g, ""));
    var telefono1 = (frmRegistrar.telefono.value).trim().replace(/ /g, "");
    var eps1 = ((frmRegistrar.eps.value).trim()).replace(/ /g, "_");
    var idCargo1 = ((frmRegistrar.idCargo.value).trim()).replace(/ /g, "");
    var estado1 = ((frmRegistrar.estado.value).trim());

    //window.alert("idEmpleado1=" + idEmpleado1 + "&nombre1=" + nombre1 + "&apellido1=" + apellido1 + "&cedula1=" + cedula1 + "&fechanac1=" + fechanac1 + "&telefono1=" + telefono1 + "&eps1=" + eps1 + "&idCargo1=" + idCargo1 + "& nuevo2=" + nuevo + "&validar2=1");

    if (idEmpleado1 === "" || nombre1 === "" || apellido1 === "" || cedula1 === "" || fechanac1 === "" || telefono1 === "" || eps1 === "" || idCargo1 === "")
    {
        document.getElementById("divInsertar").innerHTML = "Error: Hay campos vacios";
        datos = "validar2=0";
    } else {
        datos = "idEmpleado2=" + idEmpleado1 + "&nombre2=" + nombre1 + "&apellido2=" + apellido1 + "&cedula2=" + cedula1 + "&fechanac2=" + fechanac1 + "&telefono2=" + telefono1 + "&eps2=" + eps1 + "&idCargo2=" + idCargo1 + "&estado2=" + estado1 + "&nuevo2=" + nuevo + "&validar2=1";
        document.getElementById("divInsertar").style = "display: none;";
    }
    return datos;
}


function validarDatosUsuario(nuevo) {

    //window.alert("A LA MERC");

    var datos = "";
    document.getElementById("divInsertar").innerHTML = "";
    document.getElementById("divInsertar").style = 'display:"";';

    try {
        document.getElementById("divGuardar").innerHTML = "";
        document.getElementById("divGuardar").style = "display:none;";

    } catch (error) {
        console.error(error);
    }

    var nick1 = (((frmRegistrar.nick.value).trim()).replace(/ /g, ""));
    var nombre1 = ((frmRegistrar.nombre.value).trim()).replace(/ /g, "_");
    var password1 = ((frmRegistrar.password.value).trim()).replace(/ /g, "");
    var tipo1 = frmRegistrar.tipo.value;

    //window.alert("idEmpleado1=" + idEmpleado1 + "&nombre1=" + nombre1 + "&apellido1=" + apellido1 + "&cedula1=" + cedula1 + "&fechanac1=" + fechanac1 + "&telefono1=" + telefono1 + "&eps1=" + eps1 + "&idCargo1=" + idCargo1 + "& nuevo2=" + nuevo + "&validar2=1");

    if (nick1 === "" || nombre1 === "" || nombre1 === "" || password1 === "")
    {
        document.getElementById("divInsertar").innerHTML = "Error: Hay campos vacios";
        datos = "validar2=0";
    } else {
        datos = "nick2=" + nick1 + "&nombre2=" + nombre1 + "&password2=" + password1 + "&tipo2=" + tipo1 + "&nuevo2=" + nuevo + "&validar2=1";
        document.getElementById("divInsertar").style = "display: none;";
    }
    return datos;
}



function validarDatosProduccion(nuevo) {

    //window.alert("mercy");

    var datos = "";
    document.getElementById("divInsertar").innerHTML = "";
    document.getElementById("divInsertar").style = 'display:"";';

    try {
        document.getElementById("divGuardar").innerHTML = "";
        document.getElementById("divGuardar").style = "display:none;";

    } catch (error) {
        console.error(error);
    }

    var idProduccion1 = (((frmRegistrar.idProduccion.value).trim()).replace(/ /g, ""));
    var idEmpleado1 = ((frmRegistrar.idEmpleado.value).trim()).replace(/ /g, "_");
    var fecha1 = ((frmRegistrar.fecha.value).trim()).replace(/ /g, "");
    var produccion1 = ((frmRegistrar.produccion.value).trim()).replace(/ /g, "");

    //window.alert("idEmpleado1=" + idEmpleado1 + "&nombre1=" + nombre1 + "&apellido1=" + apellido1 + "&cedula1=" + cedula1 + "&fechanac1=" + fechanac1 + "&telefono1=" + telefono1 + "&eps1=" + eps1 + "&idCargo1=" + idCargo1 + "& nuevo2=" + nuevo + "&validar2=1");
    //window.alert("fecha: " + fecha1);

    if (idProduccion1 === "" || idEmpleado1 === "" || fecha1 === "" || produccion1 === "")
    {
        document.getElementById("divInsertar").innerHTML = "Error: Hay campos vacios";
        datos = "validar2=0";
    } else {
        datos = "idProduccion2=" + idProduccion1 + "&idEmpleado2=" + idEmpleado1 + "&fecha2=" + fecha1 + "&produccion2=" + produccion1 + "&nuevo2=" + nuevo + "&validar2=1";
        document.getElementById("divInsertar").style = "display: none;";
    }
    return datos;
}


function validarDatosGraficarSemanal(nuevo) {

    //window.alert("mercy");



    var idEmpleado1 = ((frmRegistrar.idEmpleado.value).trim()).replace(/ /g, "_");
    var fechai = ((frmRegistrar.fechaix.value).trim()).replace(/ /g, "");
    var fechaf = ((frmRegistrar.fechafx.value).trim()).replace(/ /g, "");
    var produccion1 = ((frmRegistrar.produccion.value).trim()).replace(/ /g, "");

    //window.alert("idEmpleado1=" + idEmpleado1 + "&nombre1=" + nombre1 + "&apellido1=" + apellido1 + "&cedula1=" + cedula1 + "&fechanac1=" + fechanac1 + "&telefono1=" + telefono1 + "&eps1=" + eps1 + "&idCargo1=" + idCargo1 + "& nuevo2=" + nuevo + "&validar2=1");
    //window.alert("fecha: " + fecha1);

    if (idEmpleado1 === "" || fecha1 === "" || fecha2 === "" || produccion1 === "")
    {
        document.getElementById("divInsertar").innerHTML = "Error: Hay campos vacios";
        datos = "validar2=0";
    } else {
        datos = "idEmpleado2=" + idEmpleado1 + "&fechai1=" + fechai + "&fechaf1=" + fechaf + "&nuevo2=" + nuevo + "&validar2=1";
        document.getElementById("divInsertar").style = "display: none;";
    }
    return datos;
}


function validarDatosVenta(nuevo, filas) {

    //window.alert("si0");

    var datos = "";
    document.getElementById("divInsertar").innerHTML = "";
    document.getElementById("divInsertar").style = 'display:"";';

    try {
        document.getElementById("divGuardar").innerHTML = "";
        document.getElementById("divGuardar").style = "display:none;";

    } catch (error) {
        console.error(error);
    }


    //window.alert("si1");

    var idVenta1 = (((frmRegistrar.idFactura.value).trim()).replace(/ /g, ""));
    var idCliente1 = frmRegistrar.idCliente.value;
    var total1 = frmRegistrar.total.value;
    var lista1 = frmRegistrar.lista.value;
    var uid1 = document.getElementById("uid").value;

    //window.alert("idVenta: " + idVenta1 + "idcliente: " + idCliente1 + " total: " + total1 + " lista: " + lista1);

    //window.alert("idProducto2=" + idProducto1 + "&nombre2=" + nombre1 + "&precio2=" + precio1 + "&cantidad2=" + cantidad1 + "&iva2=" + iva1 + "&retencion2=" + retencion1 + "&cantidadMinima2=" + cantidadMinima1 + "&idCategoria2=" + idCategoria1 + "& nuevo2=" + nuevo + "&validar2=1");

    if (idVenta1 === "")
    {
        document.getElementById("divInsertar").innerHTML = "Error: Hay campos vacios";
        datos = "validar2=0";
    } else {
        datos = "idVenta2=" + idVenta1 + "&idCliente2=" + idCliente1 + "&total2=" + total1 + "&lista2=" + lista1 + "&uid=" + uid1 + "&filas2=" + filas + "&nuevo2=" + nuevo + "&validar2=1";
        document.getElementById("divInsertar").style = "display: none;";

        //window.alert("" + datos);

    }
    return datos;
}


function validarDatosSemanal(nuevo, idsx, primasx, cesantiasx, icesantiasx, totalesx) {

    //window.alert("totales= " +  idsx.toLocaleString());

    var datos = "";
    document.getElementById("divInsertar").innerHTML = "";
    document.getElementById("divInsertar").style = 'display:"";';

    try {
        document.getElementById("divGuardar").innerHTML = "";
        document.getElementById("divGuardar").style = "display:none;";

    } catch (error) {
        console.error(error);
    }


    //window.alert("si1");

    //var lista1 = frmRegistrar.lista.value;
    var validax1 = "" + document.getElementById("validax").value;

    //window.alert("validax: " + validax1);

    if (validax1 === "0")
    {
        document.getElementById("divInsertar").innerHTML = "Error: No se han seleccionado empleados";
        datos = "validar2=0";
    } else {

        var fechaf1 = "" + document.getElementById("fechafx").value;
        var idNomina1 = "" + document.getElementById("idNomina").value;

        datos = "idNomina2=" + idNomina1 + "&ids2=" + idsx + "&primas2=" + primasx + "&cesantias2=" + cesantiasx + "&icesantias2=" + icesantiasx + "&totales2=" + totalesx + "&fechaf2=" + fechaf1 + "&nuevo2=" + nuevo + "&validar2=1";
        //document.getElementById("divInsertar").style = "display: none;";

        //window.alert("" + lista1);
        document.getElementById("divInsertar").style = "display: none;";
    }
    return datos;
}

function validarDatosCargo(nuevo) {



    var datos = "";
    document.getElementById("divInsertar").innerHTML = "";
    document.getElementById("divInsertar").style = 'display:"";';

    try {
        document.getElementById("divGuardar").innerHTML = "";
        document.getElementById("divGuardar").style = "display:none;";

    } catch (error) {
        console.error(error);
    }

    var idCargo1 = (((frmRegistrar.idCargo.value).trim()).replace(/ /g, ""));
    var nombre1 = ((frmRegistrar.nombre.value).trim()).replace(/ /g, "_");
    var pago1 = ((frmRegistrar.pago.value).trim()).replace(/ /g, "");
    var estado1 = ((frmRegistrar.estado.value).trim());

    //window.alert("idProducto2=" + idProducto1 + "&nombre2=" + nombre1 + "&precio2=" + precio1 + "&cantidad2=" + cantidad1 + "&iva2=" + iva1 + "&retencion2=" + retencion1 + "&cantidadMinima2=" + cantidadMinima1 + "&idCategoria2=" + idCategoria1 + "& nuevo2=" + nuevo + "&validar2=1");



    if (idCargo1 === "" || nombre1 === "" || pago1 === "", estado1 === "")
    {
        document.getElementById("divInsertar").innerHTML = "Error: Hay campos vacios";
        datos = "validar2=0";
    } else {
        datos = "idCargo2=" + idCargo1 + "&nombre2=" + nombre1 + "&pago2=" + pago1 + "&estado2=" + estado1 + "&nuevo2=" + nuevo + "&validar2=1";
        document.getElementById("divInsertar").style = "display: none;";
    }
    return datos;
}

function validarDatosFijos(nuevo) {



    var datos = "";
    document.getElementById("divInsertar").innerHTML = "";
    document.getElementById("divInsertar").style = 'display:"";';

    try {
        document.getElementById("divGuardar").innerHTML = "";
        document.getElementById("divGuardar").style = "display:none;";

    } catch (error) {
        console.error(error);
    }

    var idFijo1 = (((frmRegistrar.idFijo.value).trim()).replace(/ /g, ""));
    var nombre1 = ((frmRegistrar.nombre.value).trim()).replace(/ /g, "_");
    var valor1 = ((frmRegistrar.valor.value).trim());

    //window.alert("idProducto2=" + idProducto1 + "&nombre2=" + nombre1 + "&precio2=" + precio1 + "&cantidad2=" + cantidad1 + "&iva2=" + iva1 + "&retencion2=" + retencion1 + "&cantidadMinima2=" + cantidadMinima1 + "&idCategoria2=" + idCategoria1 + "& nuevo2=" + nuevo + "&validar2=1");



    if (idFijo1 === "" || nombre1 === "" || valor1 === "")
    {
        document.getElementById("divInsertar").innerHTML = "Error: Hay campos vacios";
        datos = "validar2=0";
    } else {
        datos = "idFijo2=" + idFijo1 + "&nombre2=" + nombre1 + "&valor2=" + valor1 + "&nuevo2=" + nuevo + "&validar2=1";
        document.getElementById("divInsertar").style = "display: none;";
    }
    return datos;
}


function validarDatosCliente(nuevo) {

    var datos = "";
    document.getElementById("divInsertar").innerHTML = "";
    document.getElementById("divInsertar").style = 'display:"";';

    try {
        document.getElementById("divGuardar").innerHTML = "";
        document.getElementById("divGuardar").style = "display:none;";

    } catch (error) {
        console.error(error);
    }

    var cedula1 = ((frmRegistrar.cedula.value).trim()).replace(/ /g, "");
    var nombre1 = ((frmRegistrar.nombre.value).trim()).replace(/ /g, "_");
    var email1 = ((frmRegistrar.email.value).trim()).replace(/ /g, "");
    var telefono1 = ((frmRegistrar.telefono.value).trim()).replace(/ /g, "");

    if (cedula1 === "" || nombre1 === "" || email1 === "" || telefono1 === "")
    {
        document.getElementById("divInsertar").innerHTML = "Error: Hay campos vacios";
        datos = "validar2=0";
    } else {
        datos = "cedula2=" + cedula1 + "&nombre2=" + nombre1 + "&email2=" + email1 + "&telefono2=" + telefono1 + "&nuevo2=" + nuevo + "&validar2=1";
        document.getElementById("divInsertar").style = "display: none;";
    }
    return datos;
}


function validarDatosProveedor(nuevo) {

    var datos = "";
    document.getElementById("divInsertar").innerHTML = "";
    document.getElementById("divInsertar").style = 'display:"";';

    try {
        document.getElementById("divGuardar").innerHTML = "";
        document.getElementById("divGuardar").style = "display:none;";

    } catch (error) {
        console.error(error);
    }

    var idProveedor1 = ((frmRegistrar.idProveedor.value).trim()).replace(/ /g, "");
    var nombre1 = ((frmRegistrar.nombre.value).trim()).replace(/ /g, "_");
    var email1 = ((frmRegistrar.email.value).trim()).replace(/ /g, "");
    var telefono1 = ((frmRegistrar.telefono.value).trim()).replace(/ /g, "");

    if (idProveedor1 === "" || nombre1 === "" || email1 === "" || telefono1 === "")
    {
        document.getElementById("divInsertar").innerHTML = "Error: Hay campos vacios";
        datos = "validar2=0";
    } else {
        datos = "idProveedor2=" + idProveedor1 + "&nombre2=" + nombre1 + "&email2=" + email1 + "&telefono2=" + telefono1 + "&nuevo2=" + nuevo + "&validar2=1";
        document.getElementById("divInsertar").style = "display: none;";
    }
    return datos;
}

function listarTabla() {
    //var uid1 = document.getElementById("uid").value;
    window.alert("test1");

    var datos = "mens=0";

    return datos;
}


function uneFechas() {
    var fechai1 = document.getElementById("fechai").value;
    var fechaf1 = document.getElementById("fechaf").value;
    var fechal1 = document.getElementById("fechal").value;
    var fechah1 = document.getElementById("fechah").value;

    var fechas = "&fechai2=" + fechai1 + "&fechaf2=" + fechaf1 + "&fechal2=" + fechal1 + "&fechah2=" + fechah1;

    return fechas;
}


function agregarFechas() {
    //window.alert("test");
    var fechai1 = document.getElementById("fechai").value;
    var fechaf1 = document.getElementById("fechaf").value;
    var fechas = "&fechai2=" + fechai1 + "&fechaf2=" + fechaf1;
    window.alert(fechas);
    return fechas;
}