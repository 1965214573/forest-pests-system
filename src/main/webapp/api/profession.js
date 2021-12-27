layui.define(['service'], function (exports) {
    let service = layui.service
    let obj = {
        updateExport: function (data, func) {
            service({
                url: '/export/updateExport',
                data: data,
                type: 'post',
                success: func
            })
        },
        addExport: function (data, func) {
            service({
                url: '/export/addExport',
                data: data,
                type: 'post',
                success: func
            })
        },
        delExport: function (data, func) {
            service({
                url: '/export/deleteExport',
                type: 'post',
                data: data,
                success: func
            })
        }
    }

    exports('profession', obj)
})