layui.extend({
    request: './util/request'
}).define(['request'], function (exports) {
    let request = layui.request
    let obj = {
        getMenu: function (data, fun) {
            request({
                url: '/menu.do',
                type: 'get',
                data: data,
                dataType: 'json',
                success: fun
            })
        },

        test: function (fun) {
            request({
                url: '/menu.do',
                type: 'get',
                data: data,
                dataType: 'json',
                success: fun
            })
        }
    }

    exports('user', obj)
})