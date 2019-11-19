/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(function(){
   $("#btnRegistrar").click(function (event){
          event.preventDefault();
          agregarEmpleado();
    });
    
   
    ListarRol();
    
   
});

    function agregarEmpleado(){
        $("#mensaje").html("");
        $.ajax({
            url:'../../ControllerPersona',
            data:$("#frmRegistrarPersonal").serialize(),
            dataType:'json',
            type: 'POST',
            processData: false,
            cache:false,
            success: function (resultado) {
                console.log(resultado);
                if (resultado){
                    $("#mensaje").html("Persona agregado correctamente");
                    limpiar();
                }else{
                    $("#mensaje").html("problemas al agregar el Persona");
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
       $("#txtContraseña").val("");
       
    }
 

 function ListarRol(){
    
    var parametros={
      accion:"ListarRoles" 
     };
     $.ajax({
         url:'../../ControllerPersona',    
        data: parametros,
        dataType:"json",
        type:"post",
       
        cache: false,
        success: function(resultado) {
            console.log(resultado);
          var roles =resultado;         
          
          $.each(roles, function (i,Rol){
              $("#cbRol").append(
               $('<option>',{
                   value:Rol.IdRol,
                   text: Rol.Nombre
               })
             );
          });
      },
      error:function (ex){
          console.log(ex.responseText);
      }
     });
 }
 
 function ValidarSoloNumeros(e){
     key = e.keyCode || e.which;
     teclado = String.fromCharCode(key);
     numeros= "0123456789";
     especiales="311-321-322-313-314-315-316-312-318-317-320";//array
     tecladoEspecial=false;
     
     for(var i in especiales){
            if(key===especiales[i]){
                tecladoEspecial=true;
            }
       }
       if(numeros.indexOf(teclado)===-1 && !tecladoEspecial){
           return false;
       }
}


