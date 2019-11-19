$(function(){
   $("#btnRegistrar").click(function (event){
          event.preventDefault();         
          agregarExpositor();
    });
   
    
});

    function agregarExpositor(){
        $("#mensaje").html("");
        $.ajax({
            url:'../../ControllerExpositor',
            data:$("#frmRegistrarExpositor").serialize(),
            dataType:'json',
            type: 'POST',
            processData: false,
            cache:false,
            success: function (resultado) {
                console.log(resultado);
                if (resultado){
                    $("#mensaje").html("Expositor agregado correctamente");
                    limpiar();
                }else{
                    $("#mensaje").html("problemas al agregar el Expositor");
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
       $("#txtcbsexo").val("");
       $("#txtTemeExponer").val("");
       $("#txtHoraExponer").val("");
       $("#cbEvento").val("");
       $("#DescripcionHV").val(""); 
      
       
    }


