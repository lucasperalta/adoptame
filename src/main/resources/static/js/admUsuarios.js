$(document).ready(function () { //Cuando la pagina termina de cargar y esta lista, llama a los que esta aca dentro
    cargarTablaUsuarios();


    $('#formAltaUsuario').formValidation({
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
                        message: 'No puede contener comillas '
                    },
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
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'No puede contener comillas '
                    },
                    notEmpty: {
                        message: 'No puede ser vacio'
                    },
                    stringLength : {
                        max : 45,
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
            password: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    },

                    regexp: {
                        regexp: /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/,
                        message: 'Debe contener 8 caracteres ,1 numero,una mayuscula ,una minuscula'
                    }
                }
            },
            rol: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    }
                }
            }
        }
    });

    $('#formEditarUsuario').formValidation({
        framework : 'bootstrap',
        icon : {
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        excluded : ':disabled',
        fields : {

            nombreUsuarioEditar: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'No puede contener comillas '
                    },
                    notEmpty: {
                        message: 'No puede ser vacio'
                    },
                    stringLength : {
                        max : 45,
                        message : 'Máximo 45 caracteres'
                    }
                }
            },
            apellidoUsuarioEditar: {
                validators: {
                    regexp: {
                        regexp: /^[^'"]*$/,
                        message: 'No puede contener comillas '
                    },
                    notEmpty: {
                        message: 'No puede ser vacio'
                    },
                    stringLength : {
                        max : 45,
                        message : 'Máximo 45 caracteres'
                    }
                }
            },

            emailUsuarioEditar: {
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
            rolUsuarioEditar: {
                validators: {
                    notEmpty : {
                        message : 'No puede ser vacio'
                    }
                }
            }

        }
    });


});

function cargarTablaUsuarios() {
    $.ajax({
        type: 'GET',
        url: '../usuarios/todos',
        contentType: 'application/json; charset=utf-8',

        success: function(response) {
            console.log(response)
            $('#tablaUsuarios').bootstrapTable('load', response);
        },
        error: function(error) {
            console.log(error);
        }
    });
}

$('#crearUsuario').click(function() {
    var data = {

        nombre : document.getElementById('nombre').value,
        apellido	: document.getElementById('apellido').value,
        email	: document.getElementById('email').value,
        password	: document.getElementById('password').value,
        rol: document.getElementById('rol').value

    };

    $('#formAltaUsuario').formValidation();
    $('#formAltaUsuario').data('formValidation').validate();
    var validForm = $('#formAltaUsuario').data('formValidation').isValid()



    if (validForm == true) {

        $.ajax({
            type: 'POST',
            url: '../usuarios/guardarUsuario',
            data: JSON.stringify(data),

            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                console.log(response)
                $('#textoAltaUsuario').text(response.result);
                $('#modalAltaUsuario').show();
                cargarTablaUsuarios();
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

function cerrarModalBorrarUsuario(){
    $('#modalBorrarUsuario').hide();
}

function cerrarModalEditarUsuario(){
    $('#modalEditarUsuario').hide();
}


function editarUsuario(id,nombre,apellido,email,rol) {
    $('#idUsuarioEditar').val(id);
    $('#nombreUsuarioEditar').val(nombre);
    $('#apellidoUsuarioEditar').val(apellido);
    $('#emailUsuarioEditar').val(email);




    $('#modalEditarUsuario').show();

}

function borrarUsuario(email) {
    $('#emailUsuarioBorrar').val(email); //cargamos el mail del usuario a borrar en un campo oculto
    //lo vamos a necesitar despues cuando confirme la accion
    $('#confirmarBorrarUsuarioBtn').show(); //si el boton de aceptar lo habiamos escondido ahora lo tenemos que mostrar
    $('#textoBorrarUsuario').text("Seguro que desea borrar este usuario?"); //ponemos el texto
    $('#modalBorrarUsuario').show();//mostramos el popup de confirmacion
}

function confirmaBorrarUsuario(){
    $('#modalBorrarUsuario').hide();
    var data = {
        email	: $('#emailUsuarioBorrar').val()
    };

    $.ajax({
        type: 'POST',
        url: '../usuarios/borrar',
        data:JSON.stringify(data),

        contentType: 'application/json; charset=utf-8',
        success: function(response) {
            console.log(response)
            $('#textoBorrarUsuario').text(response);//cargamos el texto de respuesta del servidor
            $('#confirmarBorrarUsuarioBtn').hide(); //escondemos el boton borrar para que no borre de nuevo el mimdo usuario
            cargarTablaUsuarios();//recargamos la tabla de usuarios actualizada
            $('#modalBorrarUsuario').show();//mostramos popup con respuesta



        },
        error: function(error) {
            console.log(error);
        }
    });
}

function confirmaEditarUsuario(){


    var data = {
        id:$('#idUsuarioEditar').val(),
        nombre:$('#nombreUsuarioEditar').val(),
        apellido:$('#apellidoUsuarioEditar').val(),
        email	: $('#emailUsuarioEditar').val(),
        rol:$('#rolUsuarioEditar').val()


    };
    $('#formEditarUsuario').formValidation();
    $('#formEditarUsuario').data('formValidation').validate();
    var validForm = $('#formEditarUsuario').data('formValidation').isValid()



    if (validForm == true) {
        $('#modalEditarUsuario').hide();


        $.ajax({
            type: 'POST',
            url: '../usuarios/editarUsuario',
            data: JSON.stringify(data),

            contentType: 'application/json; charset=utf-8',
            success: function (response) {
                console.log(response)
                $('#textoEditarUsuario').text(response.result);//cargamos el texto de respuesta del servidor
                $('#modalRespuestaEditarUsuario').show();//mostramos popup con respuesta

                cargarTablaUsuarios();//recargamos la tabla de usuarios actualizada


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
    $('#nombre').val("");
    $('#apellido').val("");
    $('#email').val("");
    $('#password').val("");
    $('#rol').val("");
    $("#formAltaUsuario").data('formValidation').updateStatus("nombre", 'NOT_VALIDATED');
    $("#formAltaUsuario").data('formValidation').updateStatus("apellido", 'NOT_VALIDATED');
    $("#formAltaUsuario").data('formValidation').updateStatus("email", 'NOT_VALIDATED');
    $("#formAltaUsuario").data('formValidation').updateStatus("password", 'NOT_VALIDATED');
    $("#formAltaUsuario").data('formValidation').updateStatus("rol", 'NOT_VALIDATED');

}