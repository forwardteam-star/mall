$(function () {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/cart/getAllCart",
        withCredentials: true,
        crossDomain: true,
        xhrFields: {
            withCredentials: true
        },	//前端适配：允许session跨域
        async: true,
        dataType: "json",
        success: function (result) {
            console.log(result);
            if (result.code == 404) {
                alert("请先登录")
                window.location.href = "index.html"
            } else {
                var li = ''
                for (var i = 0; i < result.data.length; i++) {
                    li += ' <tr>\n' +
                        '                <td class="cart-cell cell-check">\n' +
                        '                    <input type="checkbox" class="cart-select" name="check" data-id="' +
                        result.data[i].id +
                        '" checked="checked">\n' +
                        '                </td>\n' +
                        '                <td class="cart-cell cell-img">\n' +
                        '                    <a href="detail.html?id=' +
                        result.data[i].issuesId +
                        '">\n' +
                        '                        <img class="p-img" src="' +
                        result.data[i].image +
                        '"\n' +
                        '                             alt="' +
                        result.data[i].title +
                        '">\n' +
                        '                    </a>\n' +
                        '                </td>\n' +
                        '                <td class="cart-cell cell-info">\n' +
                        '                    <a class="link p-name" href="">' +
                        result.data[i].title +
                        '</a>\n' +
                        '                </td>\n' +
                        '                <td class="cart-cell cell-price ">$\n' +
                        '                    <span class="price">' +
                        result.data[i].price +
                        '</span>\n' +
                        '                </td>\n' +
                        '                <td class="cart-cell cell-count">\n' +
                        '                    <span class="count-btn min"   data-opera-type="minus">-</span>\n' +
                        '                    <input   class="count-input text_box"   type="text" value="' +
                        result.data[i].num +
                        '">\n' +
                        '                    <span class="count-btn add"    data-opera-type="plus">+</span>\n' +
                        '                </td>\n' +
                        // '                <td class="cart-cell cell-total">￥\n' +
                        // '                    <span class="total">' +
                        // '请确认数量' +
                        // '</span>\n' +
                        // '                </td>\n' +
                        '                <td class="cart-cell cell-opera"><a class="link cart-delete" onclick="deleteCart(' +
                        result.data[i].id +
                        ')">删除</a></td>\n' +
                        '            </tr>'
                }
                $('#tabul').html(li)
                setTotal()
            }
        }
    })
    $(".add").click(function () {
        console.log("***");
        var t = $(this).parent().find('input[class*=text_box]');
        t.val(parseInt(t.val()) + 1);
        var price = $(this).parent().parent().find('td[class*=cell-price]').find('span[class*=price]')
        var total = $(this).parent().parent().find('td[class*=cell-total]').find('span[class*=total]')
        total.text(price.text() * t.val());
        setTotal();
    });
    $(".min").click(function () {
        var t = $(this).parent().find('input[class*=text_box]');
        t.val(parseInt(t.val()) - 1)
        if (parseInt(t.val()) < 0) {
            t.val(0);
        }
        var price = $(this).parent().parent().find('td[class*=cell-price]').find('span[class*=price]')
        var total = $(this).parent().parent().find('td[class*=cell-total]').find('span[class*=total]')
        total.text(price.text() * t.val());
        setTotal();
    });
})

function setTotal() {
    var s = 0;
    $("#tab tr").each(function () {
        s += parseInt($(this).find('td[class*=cell-count]').find('input[class*=text_box]').val())
            * parseInt($(this).find('td[class*=cell-price]').find('span[class*=price]').text())
    });
    $("#total").html(s.toFixed(2));
}

function deleteCart(id) {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/cart/delete",
        withCredentials: true,
        crossDomain: true,
        data: {
            id: id
        },
        xhrFields: {
            withCredentials: true
        },	//前端适配：允许session跨域
        async: true,
        dataType: "json",
        success: function (result) {
            console.log(result);

        }
    })
    alert("删除成功");
    location.reload()
}

function createOrder() {
    var B = new Array();
    var j = 0
    var ci = document.getElementsByName("check");
    for (var i = 0; i < ci.length; i++) {
        console.log(ci[i].checked);
        if (ci[i].checked == true) {
            var id = ci[i].dataset["id"]  //获取标签自定义属性的值
            B[j++] = id
        }
    }
    $.ajax({
        type: "get",
        url: "http://localhost:8080/order/CreateOrder",
        withCredentials: true,
        crossDomain: true,
        traditional:true,
        data: {
            cardId: B,
            total:parseFloat($('#total').val()),
            address:$('#address').val(),
            name:$('#name').val(),
            phone:$('#phone').val()
        },
        xhrFields: {
            withCredentials: true
        },	//前端适配：允许session跨域
        async: true,
        dataType: "json",
        success: function (result) {
            console.log(result);

        }
    })
    alert("结算成功");
    location.reload()
}

setTotal();
