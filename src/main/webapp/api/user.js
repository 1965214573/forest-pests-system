layui.extend({
    setting: 'config/global',
    request: 'util/request'
}).define(['setting', 'request'], function (exports) {
    let request = layui.request
    request.setting = layui.setting
    let obj = {
        getMenu: function (data, fun) {
            request.ajax({
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