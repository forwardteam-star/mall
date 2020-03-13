$(function () {
    var li='';
    $.ajax({
        type: "get",
        url: "http://localhost:8080/item/getAllItem",
        withCredentials: true,
        crossDomain: true,
        traditional:true,
        xhrFields: {
            withCredentials: true
        },	//前端适配：允许session跨域
        async: true,
        dataType: "json",
        success: function (result) {
            console.log(result);
            if (result==null) {
                alert("请先登录")
                window.location.href = "index.html"
            } else {
                for (var i = 0; i < result.data.length; i++) {
                    if (result.data[i].itemType == "确认收货") {
                        li += " <tr>\n" +
                            "                <td class=\"cart-cell cell-check\">\n" +
                            // "                    <input type=\"checkbox\" class=\"cart-select\" name=\"check\" checked=\"checked\">\n" +
                            "\n" +
                            "                </td>\n" +
                            "                <td class=\"cart-cell cell-img\">\n" +
                            "                    <a href=\"detail.html?id=" +
                            result.data[i].issuesId +
                            "\">\n" +
                            "                        <img class=\"p-img\" src=\"" +
                            result.data[i].issuesUrl +
                            "\"\n" +
                            "                             alt=\"" +
                            result.data[i].issuesName +
                            "\">\n" +
                            "                    </a>\n" +
                            "                </td>\n" +
                            "                <td class=\"cart-cell cell-info\">\n" +
                            "                    <a class=\"link p-name\" href=\"\">" +
                            result.data[i].issuesName +
                            "</a>\n" +
                            "                </td>\n" +
                            "                <td class=\"cart-cell cell-price \">订单号：\n" +
                            "                    <span class=\"price\">" +
                            result.data[i].orderNum +
                            "</span>\n" +
                            "                </td>\n" +
                            "                <td class=\"cart-cell cell-count\">\n" +
                            "                    <!--<span class=\"count-btn min\"   data-opera-type=\"minus\">-</span>-->\n" +
                            "                    数量：<input   class=\"count-input text_box\"   type=\"text\" value=\"" +
                            result.data[i].itemNum +
                            "\">\n" +
                            "                    <!--<span class=\"count-btn add\"     data-opera-type=\"plus\">+</span>-->\n" +
                            "                </td>\n" +
                            "                <td class=\"cart-cell cell-total\">￥\n" +
                            "                    <span class=\"total\">" +
                            result.data[i].itemPrice +
                            "</span>\n" +
                            "                </td>\n" +
                            "                <td class=\"cart-cell cell-opera\">\n" +
                            // "                    <a role=\"button\" class=\"btn btn-default\">待发货</a>\n" +
                            "                    <a role=\"button\"  onclick=\"enter(" +
                            result.data[i].itemId +
                            ")\" class=\"btn btn-default\" style=\"background-color: red\">确认收货</a>\n" +
                            "                </td>\n" +
                            "            </tr>"
                    } else {
                        li += " <tr>\n" +
                            "                <td class=\"cart-cell cell-check\">\n" +
                            // "                    <input type=\"checkbox\" class=\"cart-select\" name=\"check\" checked=\"checked\">\n" +
                            "\n" +
                            "                </td>\n" +
                            "                <td class=\"cart-cell cell-img\">\n" +
                            "                    <a href=\"detail.html?id=" +
                            result.data[i].issuesId +
                            "\">\n" +
                            "                        <img class=\"p-img\" src=\"" +
                            result.data[i].issuesUrl +
                            "\"\n" +
                            "                             alt=\"" +
                            result.data[i].issuesName +
                            "\">\n" +
                            "                    </a>\n" +
                            "                </td>\n" +
                            "                <td class=\"cart-cell cell-info\">\n" +
                            "                    <a class=\"link p-name\" href=\"\">" +
                            result.data[i].issuesName +
                            "</a>\n" +
                            "                </td>\n" +
                            "                <td class=\"cart-cell cell-price \">订单号：\n" +
                            "                    <span class=\"price\">" +
                            result.data[i].orderNum +
                            "</span>\n" +
                            "                </td>\n" +
                            "                <td class=\"cart-cell cell-count\">\n" +
                            "                    <!--<span class=\"count-btn min\"   data-opera-type=\"minus\">-</span>-->\n" +
                            "                    数量：<input   class=\"count-input text_box\"   type=\"text\" value=\"" +
                            result.data[i].itemNum +
                            "\">\n" +
                            "                    <!--<span class=\"count-btn add\"     data-opera-type=\"plus\">+</span>-->\n" +
                            "                </td>\n" +
                            "                <td class=\"cart-cell cell-total\">￥\n" +
                            "                    <span class=\"total\">" +
                            result.data[i].itemPrice +
                            "</span>\n" +
                            "                </td>\n" +
                            "                <td class=\"cart-cell cell-opera\">\n" +
                            "                    <a role=\"button\" class=\"btn btn-default\">已收货</a>\n" +
                            // "                    <a role=\"button\" class='enter' onclick=\"enter(" +
                            // result.data[i].id +
                            // ")\" class=\"btn btn-default\" style=\"background-color: red\">确认收货</a>\n" +
                            "                </td>\n" +
                            "            </tr>"
                    }


                }
                $('#tabul').html(li);
            }
        }
    })
})

function enter(id) {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/item/Receipt",
        withCredentials: true,
        crossDomain: true,
        traditional:true,
        data: {
            id:id
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

    location.reload()
}
