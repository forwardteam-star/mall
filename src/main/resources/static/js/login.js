function register() {
    var phone = $('input[name="phone"]').val();
    var password = $('input[name="pass"]').val();
    var sex = $('input[name="sex"]').val();
    var name = $('input[name="name"]').val();
    var age = $('input[name="age"]').val();
    var address = $('input[name="address"]').val();
    var address2 = $('input[name="address2"]').val();
    var address3 = $('input[name="address3"]').val();
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
            address: address,
            address2:address2,
            address3:address3
        },
        async: true,
        // dataType: "json",
        success: function (result) {
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

function edit() {
    var phone = $('input[name="username"]').val();
    var password = $('input[name="password"]').val();
    var address = $('input[name="address"]').val();
    var address2 = $('input[name="address2"]').val();
    var address3 = $('input[name="address3"]').val();
    if(phone ===''){
        alert("手机号不能为空");
        return;
    }
    if (password === '') {
        alert("密码不能为空");
        return;
    }

    $.ajax({
        type: "get",
        url: "http://localhost:8080/user/edit",
        withCredentials: true,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
        },	//前端适配：允许session跨域
        data: {
            phone: phone,
            password: password,
            address: address,
            address2: address2,
            address3: address3
        },
        async: true,
        // dataType: "json",
        success: function (result) {
            if (result) {
                alert("修改成功");
            }
        }
    })
}

