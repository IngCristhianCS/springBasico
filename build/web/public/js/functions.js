$(document).ready(function () {
    var nomProyecto = "/HolaMundo";
    
    $(".eliminar").click(function () {
        var id = $(this).attr("data-id");
        var nombre = $(this).attr("data-nombre");
        alertify.confirm('', '<div class="col-md-2 col-sm-2 col-xs-2">' +
                    '<img src="' + nomProyecto + '/public/img/eliminar.png" width="100%"/>'+
                '</div>'+
                '<div class="col-md-8 col-sm-10 col-xs-10"><h3>Desea eliminar a</h3><br/>' + nombre+'</div>', function () {
                    window.location.href = nomProyecto + "/home.htm?id=" + id;
                }
        , function () {
            alertify.error('Cancel');
        });
    });
    
    $(".actualizar").click(function () {
        window.location.href = nomProyecto + "/formPerson.htm?id=" + $(this).attr("data-id");
    });
    
    $("#usuarios").DataTable({
        responsive: true,
        columnDefs: [
            { responsivePriority: 1, targets: [0,-1] }
        ],
        "language": {
            "sProcessing":     "Procesando...",
            "sLengthMenu":     "Mostrar _MENU_ registros",
            "sZeroRecords":    "No se encontraron resultados",
            "sEmptyTable":     "Ningún dato disponible en esta tabla",
            "sInfo":           "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "sInfoEmpty":      "Mostrando registros del 0 al 0 de un total de 0 registros",
            "sInfoFiltered":   "(filtrado de un total de _MAX_ registros)",
            "sInfoPostFix":    "",
            "sSearch":         "Buscar:",
            "sUrl":            "",
            "sInfoThousands":  ",",
            "sLoadingRecords": "Cargando...",
            "oPaginate": {
                "sFirst":    "Primero",
                "sLast":     "Último",
                "sNext":     "Siguiente",
                "sPrevious": "Anterior"
            },
            "oAria": {
                "sSortAscending":  ": Activar para ordenar la columna de manera ascendente",
                "sSortDescending": ": Activar para ordenar la columna de manera descendente"
            }
        }
    });
});