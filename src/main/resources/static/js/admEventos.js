
$('#dias').datepicker({
    format:"dd-mm-yyyy",
    weekStart:0,
    startDate:"0d",
    todayBtn:"linked",
    locale:"es",
    language:"es",
    autoclose:true,
    todayHighlight:true
});

$('#diaEventoEditar').datepicker({
    format:"dd-mm-yyyy",
    weekStart:0,
    startDate:"0d",
    todayBtn:"linked",
    locale:"es",
    language:"es",
    autoclose:true,
    todayHighlight:true
});
$(document).ready(function () { //Cuando la pagina termina de cargar y esta lista, llama a los que esta aca dentro


    cargarTablaEventos();


    $('#formEditarEvento').formValidation({
        framework : 'bootstrap',
        icon : {
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        excluded : ':disabled',
        fields : {

            diaEventoEditar: {
                validators: {

                    notEmpty: {
                        message: 'Día no puede ser vacío'
                    }
                }
            },
            horarioEventoEditar: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Horario no puede contener comillas '
                    },
                    notEmpty: {
                        message: 'Horario puede ser vacío '
                    },
                    stringLength : {
                        max : 15,
                        message : 'Horario debe contener un máximo de 15 caracteres '
                    }
                }
            },

            direccionEventoEditar: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Direccion no puede contener comillas '
                    },
                    notEmpty : {
                        message : 'Direccion no puede ser vacío '
                    },
                    stringLength : {
                        max : 50,
                        message : 'Direccion debe contener un máximo de 50 caracteres'
                    }
                }
            },
            lugarEventoEditar: {

                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Lugar no puede contener comillas '
                    },
                    notEmpty : {
                        message : 'Lugar no puede ser vacío'
                    },
                    stringLength : {
                        max : 50,
                        message : 'Lugar debe contener un máximo de 50 caracteres'
                    }
                }
            },
            barrioEventoEditar: {

                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Barrio no puede contener comillas '
                    },
                    notEmpty : {
                        message : 'Barrio no puede ser vacío'
                    },
                    stringLength : {
                        max : 50,
                        message : 'Barrio debe contener un máximo de 50 caracteres'
                    }
                }
            },
            consultasEventoEditar: {

                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Consultas no puede contener comillas '
                    },
                    notEmpty : {
                        message : 'Consultas no puede ser vacío'
                    },
                    stringLength : {
                        max : 140,
                        message : 'Consultas debe contener un máximo de 140 caracteres'
                    }
                }
            }

        }
    });









    $('#altaEventoForm').formValidation({
        framework : 'bootstrap',
        icon : {
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        excluded : ':disabled',
        fields : {

            dias: {
                validators: {
                    notEmpty : {
                        message : 'Día no puede ser vacio'
                    }
                }
            },
            horarios: {

                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Horario no puede contener comillas '
                    },
                    notEmpty : {
                        message : 'Horario no puede ser vacío'
                    },
                    stringLength : {
                        max : 15,
                        message : ' Horario debe tener un máximo de 15 caracteres'
                    }
                }
            },

            direccion: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Direccion no puede contener comillas '
                    },
                    notEmpty : {
                        message : 'Direccion no puede ser vacío'
                    },
                    stringLength : {
                        max : 50,
                        message : 'Direccion debe tener un máximo de 50 caracteres'
                    }
                }
            },
            lugar: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Lugar no puede contener comillas '
                    },
                    notEmpty : {
                        message : 'Lugar no puede ser vacío'
                    },
                    stringLength : {
                        max : 50,
                        message : 'Lugar debe tener un máximo de 50 caracteres'
                    }
                }
            },
            barrio: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Barrio no puede contener comillas '
                    },
                    notEmpty : {
                        message : 'Barrio no puede ser vacío'
                    },
                    stringLength : {
                        max : 50,
                        message : 'Barrio debe tener un máximo de 50 caracteres'
                    }
                }
            },
            consultas: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'Consultas no puede contener comillas '
                    },
                    notEmpty : {
                        message : 'Consultas no puede ser vacío'
                    },
                    stringLength : {
                        max : 140,
                        message : 'Consultas debe tener un máximo de 140 caracteres'
                    }
                }
            }

        }
    });



});

function revalidarDias() {
    $("#altaEventoForm").formValidation('revalidateField',
        'dias');
}

function revalidarDiasEditar() {
    $("#formEditarEvento").formValidation('revalidateField',
        'diaEventoEditar');
}
function cargarTablaEventos() {
    $.ajax({
        type: 'GET',
        url: '../eventos/todos',
        contentType: 'application/json; charset=utf-8',

        success: function(response) {
            console.log(response)
            $('#tablaEventos').bootstrapTable('load', response);
        },
        error: function(error) {
            console.log(error);
        }
    });
}

$('#crearEvento').click(function() {
    var data = {

        dias : $('#dias').val(),
        horarios	: $('#horarios').val(),
        direccion	:$('#direccion').val(),
        lugar	: $('#lugar').val(),
        barrio: $('#barrio').val(),
        consultas	: $('#consultas').val()


    };



    $('#altaEventoForm').formValidation();
    $('#altaEventoForm').data('formValidation').validate();
    var validForm = $('#altaEventoForm').data('formValidation').isValid();



    if (validForm == true) {

        $.ajax({
            type: 'POST',
            url: '../eventos/guardarEvento',
            data:JSON.stringify(data),

            contentType: 'application/json; charset=utf-8',
            success: function(response) {
                console.log(response.status);
                $("#error").hide();
                if(response.status=="SUCESS"){
                    $('#textoAltaEvento').text(response.result);
                    $('#modalAltaEvento').show();
                    cargarTablaEventos();
                    limpiarCampos();
                    $("#error").hide();
                }else{
                    var errorInfo="";
                    $.each(response.result,function (index,elem) {
                        errorInfo+="<br />"+(index+1)+". "+elem.field+" : "+elem.defaultMessage ;

                    });
                    $("#error").html("Efectúe las siguientes correcciones: "+errorInfo);
                    $("#error").show();
                    console.log(errorInfo);

                }


            },
            error: function(error) {

                console.log(error);
            }
        });
    }else{
        return false;
    }
});

function cerrarModal(nombre){
    $('#'+nombre+'').hide();
    $('#formEditarEvento').data('formValidation').resetForm();
}

function cerrarModalBorrarEvento(){
    $('#modalBorrarEvento').hide();
}

function cerrarModalEditarEvento(){
    $('#modalEditarEvento').hide();
}


function editarEvento(id,dia,horario,direccion,lugar,barrio,consultas) {

    $('#idEventoEditar').val(id);
        $('#diaEventoEditar').val(dia);
        $('#horarioEventoEditar').val(horario);
        $('#direccionEventoEditar').val(direccion);
        $('#lugarEventoEditar').val(lugar);
        $('#barrioEventoEditar').val(barrio);
        $('#consultasEventoEditar').val(consultas);

    $('#modalEditarEvento').show();

}


function borrarEvento(idEvento) {
    $('#idEventoBorrar').val(idEvento); //cargamos el mail del usuario a borrar en un campo oculto
    //lo vamos a necesitar despues cuando confirme la accion
    $('#confirmarBorrarEventoBtn').show(); //si el boton de aceptar lo habiamos escondido ahora lo tenemos que mostrar
    $('#textoBorrarEvento').text("¿Seguro que desea borrar este evento?"); //ponemos el texto
    $('#modalBorrarEvento').show();//mostramos el popup de confirmacion
}

function confirmaBorrarEvento(){
    $('#modalBorrarEvento').hide();
    var data = {
        id	: $('#idEventoBorrar').val()
    };

    $.ajax({
        type: 'POST',
        url: '../eventos/borrar',
        data:JSON.stringify(data),

        contentType: 'application/json; charset=utf-8',
        success: function(response) {
            console.log(response)
            $('#textoBorrarEvento').text(response);//cargamos el texto de respuesta del servidor
            $('#confirmarBorrarEventoBtn').hide(); //escondemos el boton borrar para que no borre de nuevo el mimdo evento
            cargarTablaEventos();//recargamos la tabla de usuarios actualizada
            $('#modalBorrarEvento').show();//mostramos popup con respuesta



        },
        error: function(error) {
            $('#textoBorrarEvento').text(error);//cargamos el texto de respuesta del servidor
            $('#confirmarBorrarEventoBtn').hide(); //escondemos el boton borrar para que no borre de nuevo el mimdo evento
            cargarTablaEventos();//recargamos la tabla de usuarios actualizada
            $('#modalBorrarEvento').show();//mostramos popup con respuesta
        }
    });
}

function confirmaEditarEvento(){


    var data = {
        id:$('#idEventoEditar').val(),
        dias:$('#diaEventoEditar').val(),
        horarios:$('#horarioEventoEditar').val(),
        direccion	: $('#direccionEventoEditar').val(),
        lugar:$('#lugarEventoEditar').val(),
        barrio:$('#barrioEventoEditar').val(),
        consultas:$('#consultasEventoEditar').val()


    };

    $('#formEditarEvento').formValidation();
    $('#formEditarEvento').data('formValidation').validate();
    var validForm = $('#formEditarEvento').data('formValidation').isValid()



    if (validForm == true) {
        $('#modalEditarEvento').hide();

        $.ajax({
            type: 'POST',
            url: '../eventos/editarEvento',
            data: JSON.stringify(data),

            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                console.log(response)
                $('#textoEditarEvento').text(response);//cargamos el texto de respuesta del servidor
                $('#modalRespuestaEditarEvento').show();//mostramos popup con respuesta

                cargarTablaEventos();//recargamos la tabla de eventos actualizada


            },
            error: function (error) {
                console.log(error);
            }
        });
    }else{
        return false;
    }
}

function limpiarCampos() {
    $('#dias').val("");
    $('#horarios').val("");
    $('#direccion').val("");
    $('#lugar').val("");
    $('#barrio').val("");
    $('#consultas').val("");
    $("#altaEventoForm").data('formValidation').updateStatus("dias", 'NOT_VALIDATED');
    $("#altaEventoForm").data('formValidation').updateStatus("horarios", 'NOT_VALIDATED');
    $("#altaEventoForm").data('formValidation').updateStatus("direccion", 'NOT_VALIDATED');
    $("#altaEventoForm").data('formValidation').updateStatus("lugar", 'NOT_VALIDATED');
    $("#altaEventoForm").data('formValidation').updateStatus("barrio", 'NOT_VALIDATED');
    $("#altaEventoForm").data('formValidation').updateStatus("consultas", 'NOT_VALIDATED');

}