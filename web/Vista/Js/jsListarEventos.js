$(function(){
    
    
    ListarEventoCard();

    
    
});

 function ListarEventoCard(){
    var resultado;
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
           var count = Object.keys(resultado).length;
            console.log(count);         
            
            const container= document.getElementById('containerr');
            const fragment= document.createDocumentFragment();
         
          $.each(resultado, function (i,Evento){                    
         
               const div= document.createElement('div');
                div.setAttribute('class','card');
                div.setAttribute('id','card');              
                const img=document.createElement('img');
                img.setAttribute('src','../imagenes/Carrusel/22367f_dde37ab30e50420d80877494a38afeff~mv2.jpg');
                const titulo=document.createElement('h4');
                titulo.setAttribute('id','titulo');
                titulo.innerHTML=Evento.nombre;
                var valor=Evento.idEvento;
                const button= document.createElement('a');
                button.setAttribute('href','../PaginaPrincipal/frmAgregarInvitado.jsp?valor=' + valor);
                button.setAttribute('value',Evento.idEvento);
                button.innerHTML="Mas Informacion";
               // div.textContent=day;
                fragment.appendChild(div);
                div.appendChild(img);
                div.appendChild(titulo);
              //  div.appendChild(descripcion);
                div.appendChild(button);
          });
          container.appendChild(fragment);
      },
      error:function (ex){
          console.log(ex.responseText);
      }
     });
 }