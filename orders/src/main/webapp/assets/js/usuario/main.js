$(document).ready(function(){
    var myCode = {
        init : function () {
            myCode.modal();
            myCode.dataGrilla();
            myCode.sendFRMNewUser();
        },

        modal : function () {

                $('.modal-delete').click(function (e) {
                        e.preventDefault();
                            $('#myModal').modal('show'); // modal
                            id = $(this).data("id"); // id
                            $('#btn-accept').click(function () {
                                            $.ajax({
                                                    method: "POST",
                                                    url: "/startup-sys-asistencia/dashboard/usuario/eliminar/"+id
                                            }).done(function( msg ) {
                                                $('#myModal').modal('hide');
                                                $("#"+id).hide('slow');
                                            });
                            });
                });

        },

        dataGrilla : function () {
            $('#gridUser').DataTable({
              'paging'      : true,
              'lengthChange': false,
              'searching'   : false,
              'ordering'    : true,
              'info'        : true,
              'autoWidth'   : false
            });
        },

        sendFRMNewUser : function () {
            $('#frmNewUser').validate(
            {
                rules: {
                    name: {
                        minlength: 2,
                        required: true
                    },
                    lastname: {
                        minlength: 2,
                        required: true
                    },
                    email: {
                        required: true,
                        email: true
                    },
                    message: {
                        minlength: 2,
                        required: true
                    }
                },
                messages: {
                    name: 'Campo requerido',
                    lastname: 'Campo requerido',
                    email: {
                        required: 'Campo requerido',
                        email: 'Por favor, introduce una dirección de correo electrónico válida.'
                    }
                },
                errorElement: 'span',
                errorClass: 'help-block',
                highlight: function(element) {
                    //$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    $(element).closest('.form-group').addClass('has-error');
                },
                unhighlight: function(element) {
                    $(element).closest('.form-group').removeClass('has-error');
                },
                /*success: function(element) {
                    element
                        .addClass('valid')
                        .closest('.form-group').removeClass('has-error').addClass('has-success');
                },*/
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