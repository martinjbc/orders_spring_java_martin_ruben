$(document).ready(function() {
    $('#fecha1').datepicker( {
     onSelect: function(date) {
        alert(date)
     },
    selectWeek: true,
    inline: true,
    startDate: '01/01/2000',
    firstDay: 1,
  });
  
});

$(function() {         
   var report = {
		init : function(){
			
			report.btnExport();
			/**
			report._ajax();
			report.selectDate();
			report.cboSede();
			**/
		},
		cboSede : function(){
			$("#cbo_idsede").change(function(){
				report._ajax();
			})
		},
		selectDate : function(){
			console.log('aaa')
			$(".date-picker").datepicker({
		        dateFormat: "dd-mm-yy",
		        onSelect: function(dateText, inst) {
		        	console.log('holaaaaa')
			           console.log(dateText)
			           console.log(inst)
			     } 
		    });	
		},
		_ajax : function(){
			$.ajax({
				type: 'POST',
				headers: { "cache-control": "no-cache" },
				url: $("#ajax_reporte").val(),
				async: false,
				cache: false,
				dataType : "html",
				data: $('#form_search').serialize() ,
				success: function(jsonData)
				{
					$("#body_result").html(jsonData)
				},
				error: function(XMLHttpRequest, textStatus, errorThrown) {
					console.log(XMLHttpRequest)
					console.log(textStatus)
					console.log(errorThrown)
				}
				
			});
		},
		btnExport : function(){
			$("#btn_export").click(function(e){
				var params = $('#form_search').serialize();
				var url = $(this).data('action')
				window.open(url + '?' + params,'_self');
				e.preventDefault();
			});
		}
    }
    report.init();
   
});
