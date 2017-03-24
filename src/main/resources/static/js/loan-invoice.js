function selectAll(source) {
	checkboxes = document.getElementsByName('status');
	for (var i = 0, n = checkboxes.length; i < n; i++) {
		checkboxes[i].checked = source.checked;
	}
}