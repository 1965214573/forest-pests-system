layui.extend({
    setting: 'config/global',
    request: 'util/request'
}).define(['setting', 'request'], function (exports) {
    let request = layui.request
    request.setting = layui.setting
    let obj = {
        getLandType: function (func) {
            request({
                url: '/area/getLandList',
                success: func
            })

        },
        addArea: function (data, func) {
            request({
                url: '/area/addArea',
                data: data,
                success: func
            })

        }
    }

    exports('area', obj)
})