<!-- jQuery 3 -->
<script src="<c:url value='/assets/adminlte/bower_components/jquery/dist/jquery.min.js'/>"></script>
<!-- Bootstrap 3.3.7 -->
<script src="<c:url value='/assets/adminlte/bower_components/bootstrap/dist/js/bootstrap.min.js'/>"></script>
<!-- DataTables -->
<script src="<c:url value='/assets/adminlte/bower_components/datatables.net/js/jquery.dataTables.min.js'/>"></script>
<script src="<c:url value='/assets/adminlte/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js'/>"></script>
<!-- Select2 -->
<script src="<c:url value='/assets/adminlte/bower_components/select2/dist/js/select2.full.min.js'/>"></script>

<script>
$(document).ready(function(){
    var myCode = {
        init : function () {
            myCode.dataGrilla();
        },

        dataGrilla : function () {
            $('#dinamicGrid').DataTable({
              'paging'      : true,
              'lengthChange': false,
              'searching'   : false,
              'ordering'    : true,
              'info'        : true,
              'autoWidth'   : false
            });
        }
   }});     
</script>	