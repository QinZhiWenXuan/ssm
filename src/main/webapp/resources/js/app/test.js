$(function() {
});
var testFn = {
	saveMod : function() {
		var url = '/test/save.jspx';
		var param = $('#saveForm').serialize();
		if (param) {
			$.post(url, param, function(data) {
				var code = data.code;
				if (200 == code) {
					testFn.getListMod();
				} else {
					alert(data.message);
				}
			});
		} else {
			return false;
		}
	},
	getListMod : function() {
		var url = '/test/get/list.jspx';
		$.get(url, function(data) {
			var code = data.code;
			console.debug('code :' + code);
		});
	}
};
