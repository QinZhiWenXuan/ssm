$(function() {
});
var testFn = {
	saveMod : function() {
		var url = '/test/save.jspx';
		var param = $('#saveForm').serialize();
		if (param) {
			$.post(url, param, function(data) {
			});
		} else {
			return false;
		}
	}
};
