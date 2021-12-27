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
        },
        getEventById: function (data, func) {
            service({
                url: '/event/getEventById',
                data: data,
                type: 'post',
                success: func
            })
        },
        updateEvent: function (data, func) {
            service({
                url: '/event/updateEvent',
                data: data,
                type: 'post',
                success: func
            })
        },
        governingEvent: function (data, func) {
            service({
                url: '/event/governingEvent',
                data: data,
                type: 'post',
                success: func
            })
        }
    }

    exports('events', obj)
})