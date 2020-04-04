var editor;
$(document).ready(function(){
     editor = new Simditor({
        toolbar: [
            'title', 'bold', 'italic', 'underline', 'strikethrough', 'fontScale',
            'color', '|', 'ol', 'ul', 'blockquote', 'code',  '|', 'link',
            // 'image',
            'hr', '|', 'alignment'
        ],
        textarea: '#editor',
        placeholder: '写点什么...',
        // defaultImage: '/static/home/images/logo.png',
        imageButton: ['upload'],
        upload: {
            url: 'http://localhost:8080/upload',
            // params: {_token: token},
            defaultImage : '../images/AA.png', //编辑器插入图片时使用的默认图片
            fileKey: 'file',
            leaveConfirm: '正在上传文件..',
            connectionCount: 3
        }
    });
});

function addIssues() {
    var issuesName = $('#issuesName').val();
    var issuesNum = $('#issuesNum').val();
    var issuesPrice = $('#issuesPrice').val();
    var issuesUrl = $('#issuesUrl').val();
    var issuesDetails = editor.getValue();
    $.ajax({
        type: "get",
        url: "http://localhost:8080/issues/insert",
        data: {
            'issuesName':issuesName,
            'issuesNum':issuesNum,
            'issuesPrice':issuesPrice,
            'issuesUrl':issuesUrl,
            'issuesDetails':issuesDetails
        },
        withCredentials: true,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
        },	//前端适配：允许session跨域
        success: function (result) {
            alert(result.msg);
        }
    })
}