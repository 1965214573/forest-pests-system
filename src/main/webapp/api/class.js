layui.extend({
    setting: 'config/global',
    request: 'util/request'
}).define(['setting', 'request'], function (exports) {
    let request = layui.request
    request.setting = layui.setting
    let obj = {

        addClass: function (data, func) {
            request({
                url: '/class/addClass',
                data: data,
                success: func
            })

        }
    }

    exports('class', obj)
})