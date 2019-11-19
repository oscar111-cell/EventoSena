$(function(){
   $("#btnRegistrar").click(function (event){
          event.preventDefault();         
          agregarEvento();
    });
    ListarEvento(); 
    
});

    function agregarEvento(){
        $("#mensaje").html("");
        $.ajax({
            url:'../../ControllerEvento',
            data:$("#frmRegistrarEvento").serialize(),
            dataType:'json',
            type: 'POST',
            processData: false,
            cache:false,
            success: function (resultado) {
                console.log(resultado);
                if (resultado){
                    $("#mensaje").html("Evento agregado correctamente");
                    limpiar();
                }else{
                    $("#mensaje").html("problemas al agregar el Evento");
                }
                $("#mensaje").show();
                
            },
            error:function (ex){
                console.log(ex.responseText);
            }
        });
    
    }
    
    function ListarEvento(){
    
    var parametros={
      accion:"ListarEvento" 
     };
     $.ajax({
         url:'../../ControllerEvento',    
        data: parametros,
        dataType:"json",
        type:"post",
       
        cache: false,
        success: function(resultado) {
            console.log(resultado);
          var evento =resultado;         
          
          $.each(evento, function (i,Evento){
              $("#cbEvento").append(
               $('<option>',{
                   value:Evento.idEvento,
                   text: Evento.nombre
               })
             );
          });
      },
      error:function (ex){
          console.log(ex.responseText);
      }
     });
 }

function limpiar(){
   $("#txtNombreEvento").val("");
   $("#txtFecha").val("");
   $("#txtLugar").val("");
   $("#txtDesCripcion").val("");


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
