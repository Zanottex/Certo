    $("#enviar").click(validaEnvio);

        function validaCampoVazio(campo){
            if(campo.trim() == ''){
                return true;
            }else{
                return false;
            }
        }



        function validaEnvio(){
            let podeEnviar = true;
            let qtdNum = $("#qtdNum").val();
            let numMin = $("#numMin").val();
            let numMax = $("#numMax").val();
            let repetir = $("#repetir")[0].checked;
            let ordena = $("#ordena")[0].checked;

            $("#errorMessage").text("");
            $(".error-field").removeClass("error-field");
            if(validaCampoVazio(qtdNum)){
                podeEnviar = false;

            }
            if(validaCampoVazio(numMin)){
                podeEnviar = false;

            }
            if(validaCampoVazio(numMax)){
                podeEnviar = false;

                }

            if(podeEnviar){
                $.ajax({
                    type: "POST",
                    url: "/",
                    data:{
                        qtdNum:qtdNum,
                        numMin:numMin,
                        numMax:numMax,
                        repetir:repetir,
                        ordena:ordena,
                    },
                    success: function(data){
                        document.write(data);

                    },
                    error: function(){
                        $("#errorMessage").append("Ops! Ocorreu um erro inesperado.");
                    }
                });
            }
        }
