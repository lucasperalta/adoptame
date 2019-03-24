$(document).ready(function () { //Cuando la pagina termina de cargar y esta lista, llama a los que esta aca dentro
    cargarTablaServicio();
});

function cargarTablaServicio() {
    $.ajax({
        type: 'GET',
        url: '../prestador/todos',
        contentType: 'application/json; charset=utf-8',

        success: function(response) {
            console.log(response);
            $('#tablaServicios').bootstrapTable('load', response);
        },
        error: function(error) {
            console.log(error);
        }
    });
}


$('#crearPrestador').click(function() {
    var data = {

        nombre    : document.getElementById('nombre').value,
        apellido  : document.getElementById('apellido').value,
        direccion : document.getElementById('direccion').value,
        email     : document.getElementById('email').value,
        urlPago   : document.getElementById('urlPago').value,
        titulo    : document.getElementById('titulo').value,
        costo     : document.getElementById('costo').value,
        tipoServicio : document.getElementById('tipoServicio').value,
        descripcion : document.getElementById('descripcion').value,
        vigencia : document.getElementById('vigencia').value

    };
    $.ajax({
        type: 'POST',
        url: '../prestador/guardarPrestador',
        data:JSON.stringify(data),

        contentType: 'application/json; charset=utf-8',
        success: function(response) {
            console.log(response);
            $('#textoAltaServicio').text(response);
            $('#modalAltaServicio').show();
            document.getElementById("nombre").value = "";
            document.getElementById("email").value = "";
            document.getElementById("apellido").value = "";
            document.getElementById("direccion").value = "";
            document.getElementById("titulo").value = "";
            document.getElementById("costo").value = "";
            document.getElementById("descripcion").value = "";
            document.getElementById("vigencia").value = "";
            document.getElementById("urlPago").value = "";
            cargarTablaServicio();

        },
        error: function(error) {
            console.log(error);
        }
    });
});

function cerrarModal(nombre){
    $('#'+nombre+'').hide();
}

function cerrarModalBorrarServicio(){
    $('#modalBorrarServicio').hide();
}


function dateFormat(value, row, index) {
    return moment(value).format('DD/MM/YYYY');
}


function borrarServicio(email) {
    $('#emailServicioBorrar').val(email); //cargamos el mail del usuario a borrar en un campo oculto
    //lo vamos a necesitar despues cuando confirme la accion
    $('#confirmarBorrarServicioBtn').show(); //si el boton de aceptar lo habiamos escondido ahora lo tenemos que mostrar
    $('#textoBorrarServicio').text("Seguro que desea borrar este servicio?"); //ponemos el texto
    $('#modalBorrarServicio').show();//mostramos el popup de confirmacion
}

function confirmaBorrarServicio(){
    $('#modalBorrarServicio').hide();
    var data = {
        email	: $('#emailServicioBorrar').val()
    };

    $.ajax({
        type: 'POST',
        url: '../prestador/borrar',
        data:JSON.stringify(data),

        contentType: 'application/json; charset=utf-8',
        success: function(response) {
            console.log(response)
            $('#textoBorrarServicio').text(response);//cargamos el texto de respuesta del servidor
            $('#confirmarBorrarServicioBtn').hide(); //escondemos el boton borrar para que no borre de nuevo el mimdo usuario
            cargarTablaServicio();//recargamos la tabla de usuarios actualizada
            $('#modalBorrarServicio').show();//mostramos popup con respuesta

        },
        error: function(error) {
            console.log(error);
        }
    });
}
