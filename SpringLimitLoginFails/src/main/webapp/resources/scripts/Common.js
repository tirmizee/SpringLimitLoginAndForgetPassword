var AjaxManager = {
	RootUrl: '',
	PostData : function (objToPost, postUri, onPostSuccess, onPostError) {
        $.ajax({
            type: 'POST',
            url: postUri,
            contentType: 'application/json',
            headers: {
                'Accept': 'application/json'
            },
            data: JSON.stringify(objToPost)
        }).done(function (objRet) {
            onPostSuccess(objRet);
        }).fail(function (jqXHR, textStatus, errorThrown) {
            onPostError(jqXHR, textStatus, errorThrown);
        });
    },
    GetData: function (objToGet, getUri, onGetSuccess, onGetError) {
        $.ajax({
            type: 'GET',
            url: getUri,
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            headers: {
            	'Accept': 'application/json'
            },
            data: objToGet,
        }).done(function (objRet) {
            onGetSuccess(objRet);
        }).fail(function (jqXHR, textStatus, errorThrown) {
            onGetError(jqXHR, textStatus, errorThrown);
        });
    },
    DeleteData : function (deleteUri, onDeleteSuccess, onDeleteError) {
        $.ajax({
            type: 'DELETE',
            url: deleteUri,
            contentType: 'application/json;charset=utf-8',
        }).done(function (objRet) {
        	onDeleteSuccess(objRet);
        }).fail(function (jqXHR, textStatus, errorThrown) {
        	onDeleteError(jqXHR, textStatus, errorThrown);
        });
    }
};

var BlockUIManager = {
	AjaxStyleOne : function() {
		$(document).ajaxStart($.blockUI({ css: { 
            border: 'none', 
            padding: '10px', 
            backgroundColor: '#000', 
            '-webkit-border-radius': '8px', 
            '-moz-border-radius': '8px', 
            opacity: .4, 
            color: '#fff' 
         }})).ajaxStop($.unblockUI);
	}
};

var Swal = {
	Success : function(title,text) {
		swal({ type  : 'success',  
			   title : title, 
			   text  : text, 
			   showConfirmButton : false, 
			   timer: 3000  });
	},
	Error : function(title,text) {
		swal({ type  : 'warning', 
			   title : title,  
			   text  : text, 
			   showConfirmButton : false, 
			   timer: 4000 });
	}
};
