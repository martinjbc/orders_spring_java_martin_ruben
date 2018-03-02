$(document).ready(function(){
    var myCode = {
        init : function () {
            myCode.modal();
            myCode.dataGrilla();
            myCode.sendFRMNewGroup();
        },

        modal : function () {

                $('.modal-delete').click(function (e) {
                        e.preventDefault();
                            $('#myModal').modal('show'); // modal
                            id = $(this).data("id"); // id
                            $('#btn-accept').click(function () {
                                            $.ajax({
                                                    method: "POST",
                                                    url: "/startup-sys-asistencia/dashboard/grupo/eliminar/"+id
                                            }).done(function( msg ) {
                                                $('#myModal').modal('hide');
                                                $("#"+id).hide('slow');
                                            });
                            });
                });

        },

        dataGrilla : function () {
            $('#gridGroup').DataTable({
              'paging'      : true,
              'lengthChange': false,
              'searching'   : false,
              'ordering'    : true,
              'info'        : true,
              'autoWidth'   : false
            });
        },

        sendFRMNewGroup : function () {
            $('#frmNewGroup').validate(
            {
                rules: {
                    name: {
                        minlength: 2,
                        required: true
                    }
                },
                messages: {
                    name: 'Campo requerido'
                },
                errorElement: 'span',
                errorClass: 'help-block',
                highlight: function(element) {
                    $(element).closest('.form-group').addClass('has-error');
                },
                unhighlight: function(element) {
                    $(element).closest('.form-group').removeClass('has-error');
                },
                errorPlacement: function(error, element) {
                    if(element.parent('.input-group').length) {
                        error.insertAfter(element.parent());
                    } else {
                        error.insertAfter(element);
                    }
                }
            });
        }


    };

    myCode.init();
});