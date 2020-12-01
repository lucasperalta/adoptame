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
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Nombre no puede contener comillas '
                    },
                    notEmpty: {
                        message: 'Nombre no puede ser vacío '
                    },
                    stringLength : {
                        max : 45,
                        message : ' Nombre debe tener un máximo de 45 caracteres'
                    }
                }
            },
            apellido: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Apellido no puede contener comillas '
                    },
                    notEmpty: {
                        message: 'Apellido no puede ser vacío '
                    },
                    stringLength : {
                        max : 50,
                        message : 'Apellido debe tener un máximo 45 caracteres'
                    }
                }
            },

            email: {
                validators: {
                    notEmpty : {
                        message : 'Correo electrónico no puede ser vacío '
                    },
                    stringLength : {
                        max : 45,
                        message : ' Correo electrónico debe tener un máximo 45 caracteres '
                    },
                    emailAddress: {
                        message: ' Correo electrónico debe ser una dirección válida'
                    }
                }
            },
            direccion: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Dirección no puede contener comillas '
                    },
                    notEmpty : {
                        message : ' Dirección no  puede ser vacío '
                    },
                    stringLength : {

                        max : 100,
                        message : ' Dirección debe tener un máximo 100 caracteres'
                    }
                }
            },
            telefono: {
                validators: {
                    numeric:{message:' Teléfono debe contener solo números '},
                    notEmpty : {
                        message : 'Teléfono no puede ser vacío '
                    },
                    stringLength : {

                        max : 20,
                        message : ' Teléfono debe tener un máximo 20 caracteres '
                    }
                }
            },
            titulo: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Título no puede contener comillas '
                    },
                    notEmpty : {
                        message : 'Título no puede ser vacío '
                    },
                    stringLength : {

                        max : 25,
                        message : 'Título debe tener un máximo de 25 caracteres '
                    }
                }
            } ,
            costo: {
                validators: {
                    notEmpty : {
                        message : 'Costo no puede ser vacío '
                    },
                    greaterThan: {
                        message: 'Costo debe ser mayor que 0 ',
                        value: 0
                    }
                }
            },
            vigencia: {
                validators: {
                    notEmpty : {
                        message : 'Vigencia no puede ser vacía '
                    },
                    greaterThan: {
                        message: 'Vigencia debe ser mayor que 0 ' ,
                        value: 0
                    }
                }
            },
            tipoServicio: {
                validators: {
                    notEmpty : {
                        message : 'Tipo de servicio no puede ser vacío '
                    }
                }
            },
            urlPago: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Link de pago no puede contener comillas '
                    },

                    uri :{
                        message:'Link de pago debe ser una url válida '
                    },
                    notEmpty : {
                        message : 'Link de pago no puede ser vacío '
                    },
                    stringLength : {

                        max : 100,
                        message : 'Link de pago debe tener un máximo 100 caracteres'
                    }
                }
            },
            descripcion: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Descripcion no puede contener comillas '
                    },

                    notEmpty : {
                        message : 'Descripcion no puede ser vacío '
                    },
                    stringLength : {

                        max : 190,
                        message : 'Descripcion debe tener un máximo de 190 caracteres'
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
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: ' Título no puede contener comillas '
                    },
                    notEmpty : {
                        message : ' Título no puede ser vacío '
                    },
                    stringLength : {

                        max : 25,
                        message : ' Título debe tener un máximo de 25 caracteres '
                    }
                }
            } ,
            tipoServicioEditar: {
                validators: {
                    notEmpty : {
                        message : 'Tipo de servicio no puede ser vacío'
                    }
                }
            },

            costoServicioEditar: {
                validators: {
                    notEmpty : {
                        message : 'Costo no puede ser vacío '
                    },
                    greaterThan: {
                        message: 'Costo debe ser mayor que 0',
                        value: 0
                    }
                }
            },
            fechaFinServicioEditar: {
                validators: {
                    notEmpty : {
                        message : 'Fecha fin no puede ser vacío'
                    }
                }
            },

            urlPagoServicioEditar: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Link de pago no puede contener comillas '
                    },
                    notEmpty : {
                        message : 'Link de pago no puede ser vacío '
                    },
                    stringLength : {

                        max : 100,
                        message : 'Link de pago debe tener un máximo de 100 caracteres'
                    }
                }
            },
            descripcionServicioEditar: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Descripcion no puede contener comillas '
                    },
                    notEmpty : {
                        message : 'Descripcion no puede ser vacío'
                    },
                    stringLength : {

                        max : 190,
                        message : 'Descripcion debe tener un máximo 190 caracteres'
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
    $('#formEditarServicio').data('formValidation').resetForm();

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
    $('#textoBorrarServicio').text("¿Seguro que desea borrar este servicio?"); //ponemos el texto
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