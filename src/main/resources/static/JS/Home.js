$("#enviar").click(validaEnvio);
function validaCampoVazio(campo) {
    if (campo.trim() == '') {
        return true;
    } else {
        return false;
    }
}
function createToastArea() {
    if ($(".toaster").length == 0) {
        $("body").prepend('' +
            '<div aria-live="polite" aria-atomic="true"' +
            'class="position-absolute top-0 end-0 erros">' +
            '<div class="toaster position-absolute top-0 end-0">' +
            '</div>' +
            '</div>');
    }
}
function showToast(alerta) {
    createToastArea();

    let tipo
    if (alerta.sucesso) {
        tipo = ' bg-success ';
    } else {
        tipo = ' bg-danger ';
    }
    const toastElement = $('<div class="mt-1 toast align-items-center' + tipo + 'text-white border-0" role="alert" aria-live="assertive" aria-atomic="true">' +
        '<div class="d-flex">' +
        '<div class="toast-body">' +
        alerta.mensagem +
        '</div>' +
        '<button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>' +
        '</div>' +
        '</div>');

    toastElement.on('hidden.bs.toast', function () {
        $(this).remove();
    });

    $(".toaster").append(toastElement);
    const newToast = new bootstrap.Toast(toastElement);
    newToast.show();
}


function validaEnvio() {
    let podeEnviar = true;
    let qtdNum = $("#qtdNum").val();
    let numMin = $("#numMin").val();
    let numMax = $("#numMax").val();
    let repetir = $("#repetir")[0].checked;
    let ordena = $("#ordena")[0].checked;

    $("#errorMessage").text("");
    $(".error-field").removeClass("error-field");
    if (validaCampoVazio(qtdNum)) {
        podeEnviar = false;
        $('#gQtdNum').addClass('error-field');
    }
    if (validaCampoVazio(numMin)) {
        podeEnviar = false;
        $('#gNumMin').addClass('error-field');
    }
    if (validaCampoVazio(numMax)) {
        podeEnviar = false;
        $('#gNumMax').addClass('error-field');
    }
    if (!repetir) {
        if (qtdNum > numMax) {
            podeEnviar = false;
        }
    }
    if (numMax < numMin) {
        podeEnviar = false;
    }

    if (podeEnviar) {
        $.ajax({
            type: "POST",
            url: "/",
            data: {
                qtdNum: qtdNum,
                numMin: numMin,
                numMax: numMax,
                repetir: repetir,
                ordena: ordena,
            },
            success: function (data) {
                $('html').html(data);
                $("#enviar").click(validaEnvio);


            },
            error: function () {
                $("#errorMessage").append("Ops! Ocorreu um erro inesperado.");
            }
        });
    }
}
