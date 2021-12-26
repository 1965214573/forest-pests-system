layui.define(['service'], function (exports) {
    let service = layui.service
    let obj = {
        addEvent: function (data, func) {
            service({
                url: '/event/addEvent',
                type: 'post',
                data: data,
                success: func
            })
        }
    }

    exports('events', obj)
})