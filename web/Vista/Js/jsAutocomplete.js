               $(function (){                   
                    var empresas= new Array();
                    $("#txtEmpresa").bind("keydown",function(event){
                        var data ={empresa:$("#txtEmpresa").val()};
                        var url="../../buscar";
                        $.getJSON(url,data,function (res,est,jqXHR){   
                            empresas.length=0;
                            $.each(res,function (i,item){
                                empresas[i]=item;
                            });                            
                        });
                    });
                    $("#txtEmpresa").autocomplete({
                        source:empresas,
                        minLength:1
                        
                    });
                });
                
            
