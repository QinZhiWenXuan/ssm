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
	},
	uploadMod : function(domObject) {
		if (domObject) {
			var xmlHttp;
			var url = '/file/upload.jspx';
			var formData = new FormData();
			var fileArr = domObject.files;
			var path = "/file/async/abs/";
			var fileObject = fileArr[0];
			formData.append("file", fileObject);
			formData.append("path", path);
			if (window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest();
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.open("post", url, true);
			xmlhttp.send(formData);
			xmlhttp.onload = function(data) {
				if (xmlhttp.status == 200 && xmlhttp.responseText) {
					console.log(xmlhttp.responseText);
				} else {
					alert("上传失败！");
					return false;
				}
			};
		} else {
			return false;
		}
	}
};
