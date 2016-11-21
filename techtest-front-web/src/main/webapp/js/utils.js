window.HttpHelper = {
		ajaxCall : function (settings) {
			$.ajax(settings);
		},
};

window.Alert = {
		show : function (_level, _title, _message){
			var _htmlContent = '';
			_htmlContent += '<div class="alert alert-'+ _level +' alert-dismissible fade in" role="alert">';
			_htmlContent += '<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>';
			_htmlContent += (!!_title ? '<strong>' + _title + '</strong>&nbsp;' : '');
			_htmlContent += (!!_message ? _message : '');
			_htmlContent += '</div>';
			$('#alerts-container').append(_htmlContent);
		},
	};