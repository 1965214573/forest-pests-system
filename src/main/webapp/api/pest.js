layui.extend({
    setting: 'config/global',
    request: 'util/request'
}).define(['setting', 'request'], function (exports) {
    let request = layui.request
    request.setting = layui.setting
    let obj = {
        addPest: function (data, func) {
            request({
                url: '/pest/addPest',
                type: 'post',
                data: data,
                dataType: 'json',
                success: func
            })
        }
    }

    exports('pest', obj)
})