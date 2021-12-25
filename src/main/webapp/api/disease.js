layui.define(['service'], function (exports) {
    let service = layui.service
    let obj = {
        addDisease: function (data, func) {
            service({
                url: '/disease/addDisease',
                type: 'post',
                data: data,
                dataType: 'json',
                success: func
            })
        },
        delDisease: function (data, func) {
            service({
                url: '/disease/delDisease',
                type: 'post',
                data: data,
                success: func
            })
        }
    }

    exports('disease', obj)
})