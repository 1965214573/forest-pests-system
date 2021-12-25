layui.define(['service'], function (exports) {
    let service = layui.service
    let obj = {
        addPest: function (data, func) {
            service({
                url: '/pest/addPest',
                type: 'post',
                data: data,
                dataType: 'json',
                success: func
            })
        },
        delPest: function (data, func) {
            service({
                url: '/pest/delPest',
                type: 'post',
                data: data,
                success: func
            })
        }
    }

    exports('pest', obj)
})