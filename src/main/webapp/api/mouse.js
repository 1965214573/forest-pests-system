layui.define(['service'], function (exports) {
    let service = layui.service
    let obj = {
        addMouse: function (data, func) {
            service({
                url: '/mouse/addMouse',
                type: 'post',
                data: data,
                dataType: 'json',
                success: func
            })
        },
        delMouse: function (data, func) {
            service({
                url: '/mouse/delMouse',
                type: 'post',
                data: data,
                success: func
            })
        }
    }

    exports('mouse', obj)
})