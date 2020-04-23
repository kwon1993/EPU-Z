$(document).ready(function() {
     $('#summernote').summernote({
             height: 300,                 // set editor height
             minHeight: null,             // set minimum height of editor
             maxHeight: null,             // set maximum height of editor
             focus: true,
             lang: 'ko-KR',
             placeholder: '본문을 입력하세요.',
             callback: {
            	 onImageUpload: function(files) {
            		 uploadSummernoteImageFile(files[0], this);
            	 }
             }
     });
});

function uploadSummernoteImageFile(file, editor) {
	data = new FormData();
	data.append("file", file);
	$.ajax({
		data: data,
		type: "POST",
		url: "/uploadSummernoteImageFile",
		contentType: false,
		processData: false,
		success: function(data) {
			$(editor).summernote('insertImage', data.url);
		}
	});
}