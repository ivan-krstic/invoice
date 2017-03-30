/*<![CDATA[*/
$(function() {
	var clients = /* [[${clients}]] */null;

	// setup autocomplete function pulling from currencies[] array
	$('#autocomplete').autocomplete(
			{
				lookup : clients,
				onSelect : function(suggestion) {
					var thehtml = '<strong>Currency Name:</strong> '
							+ suggestion.value
							+ ' <br> <strong>Symbol:</strong> '
							+ suggestion.data;
					$('#outputcontent').html(thehtml);
				}
			});

});
/*]]>*/