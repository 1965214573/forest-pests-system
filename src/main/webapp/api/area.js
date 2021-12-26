layui.define(['service'], function (exports) {
    let service = layui.service
    let obj = {
        getLandType: function (func) {
            service({
                url: '/area/getLandList',
                success: func
            })

        },
        addArea: function (data, func) {
            service({
                url: '/area/addArea',
                data: data,
                success: func
            })

        },
        getNoClassAreaList: function (func) {
            service({
                url: '/area/getNoClassArea',
                success: func
            })
        },
        getAllArea: function (func) {
            service({
                url: '/area/getAllArea',
                success: func
            })

        }
    }

    exports('area', obj)
})