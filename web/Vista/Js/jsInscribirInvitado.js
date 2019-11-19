$(function(){
   $("#btnRegistrarInvitado").click(function (event){
          event.preventDefault();         
          agregarInvitado();
    });    
});


 function agregarInvitado(){
     
        $("#mensaje").html("");
   
             $.ajax({
            url:'../../ControllerInvitado',
            data:$("#frmRegistrarInvitado").serialize(),
            dataType:'json',
            type: 'POST',
            processData: false,
            cache:false,
            success: function (resultado) {
                console.log(resultado);
                if (resultado){
                    $("#mensaje").html("invitado agregado correctamente");
                     $("#mensajes").html("");
                    limpiar();
                }else{
                    $("#mensaje").html("problemas al agregar el invitado");
                }
                $("#mensaje").show();
                
            },
            error:function (ex){
                console.log(ex.responseText);
            }
        });
    
    }
    function limpiar(){
       $("#txtIdentificacion").val("");
       $("#txtNombre").val("");
       $("#txtApellido").val("");
       $("#txtCorreo").val("");
       $("#txtCelular").val("");
      $("#txtEmpresa").val("");
      $("#cbsexo").val("");
       
    }
    function limpiar2(){
      
       $("#txtNombre").val("");
       $("#txtApellido").val("");
       $("#txtCorreo").val("");
       $("#txtCelular").val("");
      $("#txtEmpresa").val("");
      $("#cbsexo").val("");
       
    }
    
  function consultarpersona1(){
    $("#mensaje").html("");
    $("#mensajes").html("");
  var parametros={
      accion:"Consultar", 
      identificacion:$("#txtIdentificacion").val()
  };  
  $.ajax({
  //llamar el controlador
  url:'../../ControllerInvitado',data: parametros,
  type: 'POST',
  dataType: 'json',
  cache: false, 
  success: function (resultado) {
           console.log(resultado);           
       
          if (resultado!==null){              
             $("#txtNombre").val(resultado.Nombre);
             $("#txtApellido").val(resultado.Apellido);
             $("#txtCorreo").val(resultado.Correo);
             $("#txtCelular").val(resultado.Celular);
             $("#txtEmpresa").val(resultado.Empresa);
             $("#cbsexo").val(resultado.sexo);
             $("#txtEmpresa").val(resultado.empresa);
             $("#mensaje").html("");
             $("#mensajes").html("");
           }else {
                $("#mensajes").html("Aun no esta Registrado!!");
                limpiar2();
           } 
        },
        error:function (ex){
            console.log(ex.responseText);
        }
  });
  }
