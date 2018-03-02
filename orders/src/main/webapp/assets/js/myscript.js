/*
$( document ).ready(function() {
   
   var sForm = {
   	
	    init : function(){
	    	//this.cbogroup();	
	    },
	    cbogroup : function(){
	    	
	    	$("#cbo_group").change(function() {
	    		alert("ya");
			});
	    	
	    }
   
   }
   
   sForm.init();
   
});
*/    
    
    
    
    
    
    
/*
$( document ).ready(function() {

	var lengthText = 2;
	
	var flagDelivery;
	var flagSendDelivery = true;
	
	var flagInvoice;
	var flagSendInvoice = true;
	
 	var sForm = {
        init : function(){
            this.inputDelivery();
            this.inputInvoice();	
        },
        inputDelivery : function(){
        	// validando Formulario en el evento change
			$("#data_address_delivery input").live("change",function(e){
				setTimeout(function(){ 
					var flag = sForm._flagDelivery();
					console.log(flag)
					if (flag){
						var id_state = $( "#id_state option:selected" ).val();
						console.log('True: '+id_state)
						if (parseInt(id_state) > 0){
							console.log('Envia')
							sForm._sendFormDelivery();
						}
					}
				}, 500);
			
				e.preventDefault();
			});
			
			$("#data_address_delivery input").live("blur", function(){
				sForm._flagDelivery();
			});
			
			$("#id_state").live("change", function(e){
				console.log("id_state change")
				sForm._sendFormDelivery();
				e.preventDefault();
			});
	
        },
        _flagDelivery : function(){
        	//var flag = true;
        	flagDelivery = true;
        	$('#data_address_delivery input.validate').each(function(){
					var checked = $('#invoice_address').is(':checked');
					var text = $(this).val();
		    		if($.trim(text)=="" || text.length <= lengthText){
		    			var  inputText =  $(this).attr('name');
		    			$("#"+inputText).parent().removeClass('form-ok').addClass('form-error');
		    			
		    			console.log($(this).attr('name')+' false =>'+ $.trim(text) + ' / (' + text.length + '-' + lengthText + ')')
		    			flagDelivery = flagDelivery && false;
		    		}else{
		    			$("#"+inputText).parent().removeClass('form-error').addClass('form-ok');
		    			flagDelivery = flagDelivery && true;
		    		}
		    		
			});
			
			return flagDelivery
        },
        _sendFormDelivery : function(){
        	console.log('_sendFormDelivery')
        	if(flagSendDelivery){
        		flagSendDelivery = false
        		setTimeout(function(){
					var flag = sForm._flagDelivery();
					console.log('flag final :' +flag)
					if (flag){
						$("#submitAccount").click();
						$("#submitAccount").hide();
					}
					flagSendDelivery = true
				}, 800);
        	}else{
        		console.log("Error flagSendDelivery")
        	}
        },
        inputInvoice : function(){
        	// validando Formulario en el evento change
			$("#opc_invoice_address input").live("change",function(e){
				setTimeout(function(){ 
					var flag = sForm._flagInvoice();
					console.log(flag)
					if (flag){
						var id_state = $( "#id_state_invoice option:selected" ).val();
						console.log('True: '+id_state)
						if (parseInt(id_state) > 0){
							console.log('Envia')
							sForm._sendFormInvoice();
						}
					}
				}, 500);
			
				e.preventDefault();
			});
			
			$("#opc_invoice_address input").live("blur", function(){
				sForm._flagInvoice();
			});
			
			$("#id_state_invoice").live("change", function(e){
				console.log("id_state_invoice change")
				sForm._sendFormInvoice();
				e.preventDefault();
			});
        },
        _flagInvoice : function(){
        	flagInvoice = true;
        	var checked = $('#invoice_address').is(':checked');
        	console.log('checked: '+checked)
        	if(checked){
	        	$('#opc_invoice_address input.validate').each(function(){
						var checked = $('#invoice_address').is(':checked');
						var text = $(this).val();
			    		if($.trim(text)=="" || text.length <= lengthText){
			    			var  inputText =  $(this).attr('name');
			    			$("#"+inputText).parent().removeClass('form-ok').addClass('form-error');
			    			
			    			console.log($(this).attr('name')+' Invoice : false')
			    			flagInvoice = flagInvoice && false;
			    		}else{
			    			$("#"+inputText).parent().removeClass('form-error').addClass('form-ok');
			    			flagInvoice = flagInvoice && true;
			    		}
			    		
				});	
        	}
        	
			
			return flagInvoice
        },
        _sendFormInvoice : function(){
        	if(flagSendInvoice){
        		flagSendInvoice = false
        		setTimeout(function(){
					var flag = sForm._flagInvoice();
					var checked = $('#invoice_address').is(':checked');
					
					console.log('flag final Invoice :' +flag+' checked:' +checked)
					if (flag && checked){
						$("#submitAccount").click();
						$("#submitAccount").hide();
					}
					flagSendInvoice = true
				}, 800);
        	}else{
        		console.log("Error flagSendInvoice")
        	}
        },
        
    }
    
    sForm.init();
    
});
*/







////////////-


/*
(function(){
    
    $("#cbo_group").change(function() {
    
        //var idgroup = $(this).val();
        
        var form = $('#form_members');
	    var params = form.serialize();
        
        alert(params);
        
        
        $.ajax({
            type: "POST",
            url: '<?php  echo base_url("dashboard/miembro/index")?>',
    		dataType : "json",
    		data: params ,
    		success: function(jsonData) {
                console.log(jsonData);
            },
            error: function() {
               
            }
        });
            
            
    });

    
})();
*/
 