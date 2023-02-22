$(function(){
	$('#empName').blur(function(){
		$.ajax({
			type:"get",
			url:"servlet1?"+"name1=ad",
			data:'empName='+$('#empName').val(),
			success:function(data){
				$('#nameTip').html(data)
			}
		})
	})

})
