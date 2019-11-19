$(function (){
    $("#btnRecuperarClaveModal").click(function (){
        recuperarClave();
    });
});
    function recuperarClave(){
       var parametros={
           accion:"ActualizarPassword",
           identificacion:$("#txtIdentificacion").val(),
           correo: $("#txtCorreo").val()
       };
       $.ajax({
          url: "../../ControllerUsuario",
          data: parametros,
          type: 'POST',
          dataType: 'json',
          cache: false,
          success: function (resultado) {
            console.log(resultado);
            if(resultado){
                $("#mensaje").html("Se Actualizo su contraseña correctamente");
                limpiarCajas();
            }else{
                $("#mensaje").html("Problemas al actualizar la Contraseña");
            }
            $("#modalRecuperarPassword").hide();
        }
       });
    }
    
     function limpiarCajas(){
       $("#txtIdentificacion").val("");
       $("#txtCorreo").val("");      
       
    }



