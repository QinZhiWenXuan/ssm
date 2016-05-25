$(function() {
});
var testFn = {
	saveMod : function() {
		var url = '/test/save.jspx';
		var param = $('#saveForm').serialize();
		if (param) {
			$.post(url, param, function(data) {
				console.log('save result : ' + data.code);
				testFn.getListMod();
			});
		} else {
			return false;
		}
	},
	getListMod : function() {
		console.debug('获取列表信息……');
	}
};
