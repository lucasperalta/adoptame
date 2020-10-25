$(document).ready(function () { //Cuando la pagina termina de cargar y esta lista, llama a los que esta aca dentro
    cargarTablaServicio();


    $('#altaServicioForm').formValidation({
        framework : 'bootstrap',
        icon : {
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        excluded : ':disabled',
        fields : {

            nombre: {
                validators: {
                    notEmpty: {
                        message: 'No puede ser vacio'
                    },
                    stringLength : {
                        max : 45,
                        message : 'Máximo 45 caracteres'
                    }
                }
            },
            apellido: {
                validators: {
                    notEmpty: {
                        message: 'No puede ser vacio'
                    },
                    stringLength : {
                        max : 50,
                        message : 'Máximo 45 caracteres'
                    }
                }
            },

            email: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {
                        max : 45,
                        message : 'Máximo 45 caracteres'
                    },
                    emailAddress: {
                        message: 'Debe ser una dirección de mail válida'
                    }
                }
            },
            direccion: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {

                        max : 100,
                        message : 'Máximo 100 caracteres'
                    }
                }
            },
            telefono: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {

                        max : 20,
                        message : 'Máximo 20 caracteres'
                    }
                }
            },
            titulo: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {

                        max : 255,
                        message : 'Máximo 255 caracteres'
                    }
                }
            } ,
            costo: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    greaterThan: {
                        message: 'Debe ser mayor que 0',
                        value: 0
                    }
                }
            },
            vigencia: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    greaterThan: {
                        message: 'Debe ser mayor que 0',
                        value: 0
                    }
                }
            },
            tipoServicio: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    }
                }
            },
            urlPago: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {

                        max : 100,
                        message : 'Máximo 100 caracteres'
                    }
                }
            },
            descripcion: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {

                        max : 255,
                        message : 'Máximo 255 caracteres'
                    }
                }
            }

        }
    });

    $('#formEditarServicio').formValidation({
        framework : 'bootstrap',
        icon : {
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        excluded : ':disabled',
        fields : {

            tituloServicioEditar: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {

                        max : 255,
                        message : 'Máximo 255 caracteres'
                    }
                }
            } ,
            tipoServicioEditar: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    }
                }
            },

            costoServicioEditar: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    greaterThan: {
                        message: 'Debe ser mayor que 0',
                        value: 0
                    }
                }
            },
            fechaFinServicioEditar: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    }
                }
            },

            urlPagoServicioEditar: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {

                        max : 255,
                        message : 'Máximo 255 caracteres'
                    }
                }
            },
            descripcionServicioEditar: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {

                        max : 255,
                        message : 'Máximo 255 caracteres'
                    }
                }
            }

        }
    });

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

function buscoEmail() {

    var data = {

        email     : document.getElementById('email').value
    };


    $.ajax({
        type: 'POST',
        url: '../prestador/buscarEmail',
        contentType: 'application/json; charset=utf-8',
        data:JSON.stringify(data),
        success: function(response) {
            console.log(response);
            if(typeof response.nombre!='undefined'){
                document.getElementById('nombre').value=response.nombre;
            }
            if(typeof response.apellido!='undefined'){
                document.getElementById('apellido').value=response.apellido;
            }
            if(typeof response.direccion!='undefined'){
                document.getElementById('direccion').value=response.direccion;
            }
            if(typeof response.telefono!='undefined'){
                document.getElementById('telefono').value=response.telefono;
            }
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
        vigencia : document.getElementById('vigencia').value,
        telefono : document.getElementById('telefono').value



    };

    $('#altaServicioForm').formValidation();
    $('#altaServicioForm').data('formValidation').validate();
    var validForm = $('#altaServicioForm').data('formValidation').isValid();



    if (validForm == true) {
        $.ajax({
            type: 'POST',
            url: '../prestador/guardarPrestador',
            data: JSON.stringify(data),

            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                console.log(response);
                $('#textoAltaServicio').text(response);
                $('#modalAltaServicio').show();
                cargarTablaServicio();
                limpiarCampos();


            },
            error: function (error) {
                console.log(error);
            }
        });
    }else{
        return false;
    }
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


function borrarServicio(idServicio) {
    $('#idServicio').val(idServicio); //cargamos el mail del usuario a borrar en un campo oculto
    //lo vamos a necesitar despues cuando confirme la accion
    $('#confirmarBorrarServicioBtn').show(); //si el boton de aceptar lo habiamos escondido ahora lo tenemos que mostrar
    $('#textoBorrarServicio').text("Seguro que desea borrar este servicio?"); //ponemos el texto
    $('#modalBorrarServicio').show();//mostramos el popup de confirmacion
}

function confirmaBorrarServicio(){
    $('#modalBorrarServicio').hide();
    var data = {
        idServicio	: $('#idServicio').val()
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
function editarServicio(idServicio,titulo,descripcion,costo,urlPago,fechaFin,tipoServicio) {

    $('#idServicioEditar').val(idServicio);
    $('#tituloServicioEditar').val(titulo);
    $('#descripcionServicioEditar').val(descripcion);
    $('#costoServicioEditar').val(costo);
    $('#urlPagoServicioEditar').val(urlPago);
    $('#fechaFinServicioEditar').val(fechaFin);
    $('#tipoServicioEditar').val(tipoServicio);
    $('#modalEditarServicio').show();

}

$('#fechaFinServicioEditar').datepicker({
    format:"dd-mm-yyyy",
    weekStart:0,
    startDate:"0d",
    todayBtn:"linked",
    locale:"es",
    language:"es",
    autoclose:true,
    todayHighlight:true
});

function confirmaEditarServicio(){


    var data = {
        idServicio:$('#idServicioEditar').val(),
        titulo:$('#tituloServicioEditar').val(),
        descripcion:$('#descripcionServicioEditar').val(),
        costo	: $('#costoServicioEditar').val(),
        urlPago:$('#urlPagoServicioEditar').val(),
        fechaFin:$('#fechaFinServicioEditar').val(),
        tipoServicio:$('#tipoServicioEditar').val()



    };

    $('#formEditarServicio').formValidation();
    $('#formEditarServicio').data('formValidation').validate();
    var validForm = $('#formEditarServicio').data('formValidation').isValid()



    if (validForm == true) {
        $('#modalEditarServicio').hide();

        $.ajax({
            type: 'POST',
            url: '../prestador/editarServicio',
            data: JSON.stringify(data),

            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                console.log(response)
                $('#textoEditarServicio').text(response);//cargamos el texto de respuesta del servidor
                $('#modalRespuestaEditarServicio').show();//mostramos popup con respuesta

                cargarTablaServicio();//recargamos la tabla de eventos actualizada


            },
            error: function (error) {
                console.log(error);
            }
        });
   }else{
        return false;
    }
}

function revalidarDias() {
    $("#formEditarServicio").formValidation('revalidateField',
        'fechaFinServicioEditar');
}
function limpiarCampos() {
    document.getElementById("nombre").value = "";
    document.getElementById("email").value = "";
    document.getElementById("apellido").value = "";
    document.getElementById("direccion").value = "";
    document.getElementById("titulo").value = "";
    document.getElementById("costo").value = "";
    document.getElementById("descripcion").value = "";
    document.getElementById("vigencia").value = "";
    document.getElementById("urlPago").value = "";
    document.getElementById("telefono").value = "";

    $("#altaServicioForm").data('formValidation').updateStatus("email", 'NOT_VALIDATED');
    $("#altaServicioForm").data('formValidation').updateStatus("nombre", 'NOT_VALIDATED');
    $("#altaServicioForm").data('formValidation').updateStatus("apellido", 'NOT_VALIDATED');
    $("#altaServicioForm").data('formValidation').updateStatus("direccion", 'NOT_VALIDATED');
    $("#altaServicioForm").data('formValidation').updateStatus("telefono", 'NOT_VALIDATED');
    $("#altaServicioForm").data('formValidation').updateStatus("titulo", 'NOT_VALIDATED');
    $("#altaServicioForm").data('formValidation').updateStatus("costo", 'NOT_VALIDATED');
    $("#altaServicioForm").data('formValidation').updateStatus("descripcion", 'NOT_VALIDATED');
    $("#altaServicioForm").data('formValidation').updateStatus("vigencia", 'NOT_VALIDATED');
    $("#altaServicioForm").data('formValidation').updateStatus("urlPago", 'NOT_VALIDATED');
}