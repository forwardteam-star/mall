function register() {
    var phone = $('input[name="phone"]').val();
    var password = $('input[name="pass"]').val();
    var sex = $('input[name="sex"]').val();
    var name = $('input[name="name"]').val();
    var age = $('input[name="age"]').val();
    var address = $('input[name="address"]').val();
    $.ajax({
        type: "get",
        url: "http://localhost:8080/user/register",
        withCredentials: true,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
        },	//前端适配：允许session跨域
        data: {
            phone: phone,
            password: password,
            sex: sex,
            name: name,
            age: age,
            address: address
        },
        async: true,
        // dataType: "json",
        success: function (result) {
            // console.log(result+"****");
            // alert(result);
            if (result == "") {
                alert("注册失败，手机号已被注册或填写错误");
            } else {
                a()
            }
        }
    })
}
function login() {
    var phone = $('input[name="username"]').val();
    var password = $('input[name="password"]').val();
    $.ajax({
        type: "get",
        url: "http://localhost:8080/user/login",
        withCredentials: true,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
        },	//前端适配：允许session跨域
        data: {
            phone: phone,
            password: password
        },
        async: true,
        // dataType: "json",
        success: function (result) {
            console.log(result);
            if (result === "") {
                alert("密码错误");
            } else {
                window.location.href='index.html';
            }
        }
    })
}
function a() {
    $('#left').addClass('active');
    $('#rightc').addClass('hide');
    $('#right').removeClass('active');
    $('#leftc').removeClass('hide');

}

function b() {
    $('#right').addClass('active');
    $('#leftc').addClass('hide');
    $('#left').removeClass('active');
    $('#rightc').removeClass('hide');
}
