
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
                        message: 'No puede ser vacio'
                    }
                }
            },
            horarioEventoEditar: {
                validators: {
                    notEmpty: {
                        message: 'No puede ser vacio'
                    },
                    stringLength : {
                        max : 50,
                        message : 'Máximo 50 caracteres'
                    }
                }
            },

            direccionEventoEditar: {
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
            lugarEventoEditar: {
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
            barrioEventoEditar: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {
                        max : 50,
                        message : 'Máximo 50 caracteres'
                    }
                }
            },
            consultasEventoEditar: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {
                        max : 100,
                        message : 'Máximo 100 caracteres'
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
                        message : 'No puede ser vacio'
                    }
                }
            },
            horarios: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {
                        max : 50,
                        message : 'Máximo 50 caracteres'
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
            lugar: {
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
            barrio: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {
                        max : 50,
                        message : 'Máximo 50 caracteres'
                    }
                }
            },
            consultas: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },
                    stringLength : {
                        max : 100,
                        message : 'Máximo 100 caracteres'
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
                    $("#error").html("Efectue las siguientes correciones: "+errorInfo);
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
}

function cerrarModalBorrarEvento(){
    $('#modalBorrarEvento').hide();
}

function cerrarModalEditarEvento(){
    $('#modalEditarEvento').hide();
}


function editarEvento(id,dia,horario,direccion,lugar,barrio,consultas) {

    $('#idEventoEditar').val(id),
        $('#diaEventoEditar').val(dia),
        $('#horarioEventoEditar').val(horario),
        $('#direccionEventoEditar').val(direccion),
        $('#lugarEventoEditar').val(lugar),
        $('#barrioEventoEditar').val(barrio),
        $('#consultasEventoEditar').val(consultas)

    $('#modalEditarEvento').show();

}


function borrarEvento(idEvento) {
    $('#idEventoBorrar').val(idEvento); //cargamos el mail del usuario a borrar en un campo oculto
    //lo vamos a necesitar despues cuando confirme la accion
    $('#confirmarBorrarEventoBtn').show(); //si el boton de aceptar lo habiamos escondido ahora lo tenemos que mostrar
    $('#textoBorrarEvento').text("Seguro que desea borrar este evento?"); //ponemos el texto
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