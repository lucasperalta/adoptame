$(document).ready(function () { //Cuando la pagina termina de cargar y esta lista, llama a los que esta aca dentro
    cargarTablaUsuarios();
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
    $.ajax({
        type: 'POST',
        url: '../usuarios/guardarUsuario',
        data:JSON.stringify(data),

        contentType: 'application/json; charset=utf-8',
        success: function(response) {
            console.log(response)
            $('#textoAltaUsuario').text(response);
            $('#modalAltaUsuario').show();
            cargarTablaUsuarios();

        },
        error: function(error) {
            console.log(error);
        }
    });
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


function editarUsuario(id,nombre,apellido,email,estado,rol) {
    $('#idUsuarioEditar').val(id);
    $('#nombreUsuarioEditar').val(nombre);
    $('#apellidoUsuarioEditar').val(apellido);
    $('#emailUsuarioEditar').val(email);
    $("#estadoUsuarioEditar option").each(function() {
        if($(this).text() === estado) {
            $(this).attr('selected', 'selected');
        }
    });

    $("#rolUsuarioEditar option").each(function() {
        if($(this).text() === rol) {
            $(this).attr('selected', 'selected');
        }
    });

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
    $('#modalEditarUsuario').hide();


    var data = {
        id:$('#idUsuarioEditar').val(),
        nombre:$('#nombreUsuarioEditar').val(),
        apellido:$('#apellidoUsuarioEditar').val(),
        email	: $('#emailUsuarioEditar').val(),
        estado:$('#estadoUsuarioEditar').val(),
        rol:$('#rolUsuarioEditar').val()


    };

    $.ajax({
        type: 'POST',
        url: '../usuarios/editarUsuario',
        data:JSON.stringify(data),

        contentType: 'application/json; charset=utf-8',
        success: function(response) {
            console.log(response)
            $('#textoEditarUsuario').text(response);//cargamos el texto de respuesta del servidor
            $('#modalRespuestaEditarUsuario').show();//mostramos popup con respuesta

            cargarTablaUsuarios();//recargamos la tabla de usuarios actualizada


        },
        error: function(error) {
            console.log(error);
        }
    });
}
