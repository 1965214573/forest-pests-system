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
        },
        getDeviceDrugList: function (func) {
            service({
                url: '/store/getDeviceDrugList',
                success: func
            })
        },
        addOutInfo: function (data, func) {
            service({
                url: '/store/addOutInfo',
                type: 'post',
                contentType: "application/x-www-form-urlencoded; charset=utf-8",
                data: data,
                success: func
            })
        }

    }

    exports('store', obj)
})