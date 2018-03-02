$(document).ready(function(){
    var myCode = {
        init : function () {
            myCode.dataGrilla();

        },
        dataGrilla : function () {

            $('#gridMessage').DataTable({
              'paging'      : true,
              'lengthChange': false,
              'searching'   : false,
              'ordering'    : true,
              'info'        : true,
              'autoWidth'   : false
            });

        }

    };

    myCode.init();
});