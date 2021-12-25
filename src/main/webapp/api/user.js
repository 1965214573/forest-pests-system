layui.define(['service'], function (exports) {
    let service = layui.service
    let obj = {
        getMenu: function (data, fun) {
            service({
                url: '/menu.do',
                type: 'get',
                data: data,
                dataType: 'json',
                success: fun
            })
        },

        test: function (fun) {
            service({
                url: '/menu.do',
                type: 'get',
                data: data,
                dataType: 'json',
                success: fun
            })
        }
    }

    exports('user', obj)
})