layui.extend({
    request: 'request'
}).define(['request', 'jquery'], function (exports) {
    let request = layui.request
    let $ = layui.$
    let test = {
        testMethod: function (test) {
            request.hello(test)


            $.ajax({
                url: '/testurl'
            })
        }
    }

    exports('test',test)
})