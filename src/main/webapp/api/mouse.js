layui.extend({
    setting: 'config/global',
    request: 'util/request'
}).define(['setting', 'request'], function (exports) {
    let request = layui.request
    request.setting = layui.setting
    let obj = {
        addMouse: function (data, func) {
            request({
                url: '/mouse/addMouse',
                type: 'post',
                data: data,
                dataType: 'json',
                success: func
            })
        },
        delMouse: function (data, func) {
            request({
                url: '/mouse/delMouse',
                type: 'post',
                data: data,
                success: func
            })
        }
    }

    exports('mouse', obj)
})