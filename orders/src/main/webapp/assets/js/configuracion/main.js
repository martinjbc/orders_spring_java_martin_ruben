$(document).ready(function(){
    var myCode = {
        init : function () {
            myCode.dataGrilla();
            myCode.sendFRMMessage();
            myCode.sendFRMConfiguration();
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
        },

        sendFRMMessage : function () {
            $('#frmMessage').validate(
            {
                rules: {
                    message: {
                        minlength: 2,
                        required: true
                    }
                },
                messages: {
                    message: 'Campo requerido',
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
        },

        sendFRMConfiguration : function () {
            $('#frmConfiguration').validate(
            {
                rules: {
                    versionandroid: {
                        minlength: 1,
                        required: true
                    },
                    intentos: {
                        minlength: 1,
                        required: true
                    },

                },
                messages: {
                    versionandroid: 'Campo requerido',
                    intentos: 'Campo requerido'
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