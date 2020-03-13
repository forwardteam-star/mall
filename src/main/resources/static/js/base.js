$(function () {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/user/getSession",
        withCredentials: true,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
        },	//前端适配：允许session跨域

        async: true,
        // dataType: "json",
        success: function (result) {
            console.log(result);
            if (result.code!=404) {
                $('#login-link-wrap').html(result.data.name);
            }

        }
    })
});