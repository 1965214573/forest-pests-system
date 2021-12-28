layui.define(['service'], function (exports) {
    let service = layui.service
    let obj = {
        addDeviceDrug: function (data,func) {
            service({
                url: '/store/addDeviceDrug',
                type: 'post',
                data: data,
                success: func
            })
        }
    }

    exports('store', obj)
})