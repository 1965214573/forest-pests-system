layui.extend({
    setting: 'config/global',
    request: 'util/request'
}).define(['setting', 'request'], function (exports) {
    let request = layui.request
    request.setting = layui.setting
    let obj = {
        addDisease: function (data, func) {
            request({
                url: '/disease/addDisease',
                type: 'post',
                data: data,
                dataType: 'json',
                success: func
            })
        },
        delDisease: function (data, func) {
            request({
                url: '/disease/delDisease',
                type: 'post',
                data: data,
                success: func
            })
        }
    }

    exports('disease', obj)
})