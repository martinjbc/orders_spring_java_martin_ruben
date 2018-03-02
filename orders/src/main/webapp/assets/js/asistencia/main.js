$(document).ready(function(){
    var myCode = {
        init : function () {
            myCode.dataGrilla();
            myCode.calendario();
            myCode.filtros();
        },

        filtros : function () {
            $('#cbo_iduser').change( function(){
                  $('#btn_search').click();
            });
            $('#cbo_idheadquarter').change( function(){
                  $('#btn_search').click();
            });
            $("#cbo_state").change( function(){
                  $('#btn_search').click();
            });
            $("#cbo_category").change( function(){
                  $('#btn_search').click();
            });
        },

        dataGrilla : function () {
            $('#gridAttendance').DataTable({
              'paging'      : true,
              'lengthChange': false,
              'searching'   : false,
              'ordering'    : true,
              'info'        : true,
              'autoWidth'   : false
            });
        },

        calendario : function () {
            $('#fecha1').datepicker({
                format: 'yyyy-mm-dd',
                autoclose: true
            }).on("change", function (e) {
                $('#btn_search').click();
            });

            $('#fecha2').datepicker({
              format: 'yyyy-mm-dd',
              autoclose: true
            }).on("change", function (e) {
                $('#btn_search').click();
            });

            //form
            $('#fecha').datepicker({
                format: 'dd/mm/yyyy',
                autoclose: true
            })

        }


    };

    myCode.init();
});