layui.define(['service'], function (exports) {
    let service = layui.service
    let obj = {
        getMenu: function (data, func) {
            service({
                url: '/menu.do',
                type: 'get',
                data: data,
                dataType: 'json',
                success: func
            })
        },

        updateUser: function (data, func) {
            service({
                url: '/user.do/updateUser',
                data: data,
                type: 'post',
                success: func
            })
        },

        getRoleList: function (func) {
            service({
                url: '/user.do/roleList',
                success: func
            })
        },
        delUser: function (data, func) {
            service({
                url: '/user.do/delUser',
                type: 'post',
                data: data,
                success: func
            })
        },
        addUser: function (data, func) {
            service({
                url: '/user.do/addUser',
                type: 'post',
                data: data,
                success: func

            })
        }
    }

    exports('user', obj)
})