var page = 1;
var limite = 8;
var maxpage=3;
$.ajax({
    type: "get",
    url: "http://localhost:8080/issues/getSize",
    async: true,
    dataType: "json",
    success: function (result) {
        maxpage=result/limite;
    }
})

function limit() {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/issues/queryAllByLimit",
        data: {
            page: page,
            limit: limite
        },
        async: true,
        dataType: "json",
        success: function (result) {
            var li = '';
            for (var a = 0; a < result.data.length; a++) {
                li += '  <li class="left">\n' +
                    '                    <a href="detail.html?id=' +
                    result.data[a].id +
                    '">\n' +
                    '                        <div class="recom-ibox">\n' +
                    '                            <img class="" style="width: 92%;" data-auto="autopic"\n' +
                    '                                 src="' +
                    result.data[a].issuesUrl +
                    '">\n' +
                    '                        </div>\n' +
                    '                        <div class="recom-txt ">\n' +
                    '                            <div>\n' +
                    '                                <div class="pirbox">\n' +
                    '                                    <div class="balepir">\n' +
                    '                                    <div   style="margin-top: 40px;margin-left: auto;margin-right: auto;width: auto;">\n' +
                    '                                        <p class="block" style="text-align: center;margin-left: auto;margin-right: auto;width: auto;">$' +
                    result.data[a].issuesPrice +
                    '</p>\n' +
                    '                                        <center style="font-size: 18px;color: black; text-align: center" class="grey">' +
                    result.data[a].issuesName +
                    '</center>\n' +
                    '                                    </div>\n' +
                    '                                        <center style="margin-right: 18px;margin-top: -80px" class="grey">\n' +
                    '                                            发布时间：' +
                    result.data[a].issuesDate +
                    '</center>\n' +
                    '                                    </div>\n' +
                    '                                </div> \n' +
                    '                            </div>\n' +
                    '                        </div>\n' +
                    '                    </a>\n' +
                    '                </li>'
            }
            $('#IssuesUL').html(li);

        }
    })
}

function news() {
    $.ajax({
        type: "get",
        url: "http://localhost:8080/issues/queryAllByLimit",
        data: {
            page: 1,
            limit: 4
        },
        async: true,
        dataType: "json",
        success: function (result) {
            var li = '';
            for (var a = result.data.length - 1; a > result.data.length - 5; a--) {
                li += '  <li>' +
                  '                    <a href="detail.html?id=' +
                  result.data[a].id +'">\n'+
                  '<img  src="' +
                  result.data[a].issuesUrl +
                  '">\n' +
                  '</a>\n' +
                  '</li>'
            }
            $('#new').html(li);

        }
    })
}

function next() {
    if (page <maxpage)
    page++;
    limit(page, limit);
}

function back() {
    if (page > 1)
        page--;
    limit(page, limit);
}

limit();
news();

function search() {
    var name = $('#search-input').val();
    window.open('search.html?name='+name)
    $.ajax({
        type: "get",
        url: "http://localhost:8080/issues/selectByName",
        data: {name: name},
        async: true,
        dataType: "json",
        success: function (result) {
            var li = '';
            for (var a = 0; a < result.data.length; a++) {
                li += '  <li class="left">\n' +
                    '                    <a href="detail.html?id=' +
                    result.data[a].id +
                    '">\n' +
                    '                        <div class="recom-ibox">\n' +
                    '                            <img class="" style="width: 92%;" data-auto="autopic"\n' +
                    '                                 src="' +
                    result.data[a].issuesUrl +
                    '">\n' +
                    '                        </div>\n' +
                    '                        <div class="recom-txt ">\n' +
                    '                            <div>\n' +
                    '                                <div class="pirbox">\n' +
                    '                                    <div class="balepir">\n' +
                    '                                    <div   style="margin-top: 40px;margin-left: auto;margin-right: auto;width: auto;">\n' +
                    '                                        <p class="block" style="text-align: center;margin-left: auto;margin-right: auto;width: auto;">$' +
                    result.data[a].issuesPrice +
                    '</p>\n' +
                    '                                        <center style="font-size: 18px;color: black; text-align: center" class="grey">' +
                    result.data[a].issuesName +
                    '</center>\n' +
                    '                                    </div>\n' +
                    '                                        <center style="margin-right: 18px;margin-top: -80px" class="grey">\n' +
                    '                                            发布时间：' +
                    result.data[a].issuesDate +
                    '</center>\n' +
                    '                                    </div>\n' +
                    '                                </div> \n' +
                    '                            </div>\n' +
                    '                        </div>\n' +
                    '                    </a>\n' +
                    '                </li>'
            }
            $('#IssuesUL').html(li);

        }
    })
}
