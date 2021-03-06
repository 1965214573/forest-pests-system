layui.define(['service'], function (exports) {
    let service = layui.service
    let obj = {

        addClass: function (data, func) {
            service({
                url: '/class/addClass',
                data: data,
                success: func
            })
        },
        getClass: function (func) {
            service({
                url: '/class/getClass',
                success: func
            })
        },
        updateClass: function (data, func) {
            service({
                url: '/class/updateClass',
                data: data,
                success: func
            })
        }
    }

    exports('class', obj)
})