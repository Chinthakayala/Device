function tableDeleteRow(input)
{
	
	if (confirm('Do you really wants to delete??')) {
			$.ajax({
				  method: "GET",
				  url: "Delete",
				  data: { ID:input}
			})
			  .done(function( data ) {
				  window.location.reload();
			  });
	    return true;
	} 
	else {
	   return false;
	}
	
	
	
	

}