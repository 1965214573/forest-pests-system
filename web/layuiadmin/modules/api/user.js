/**
 * 扩展一个自定义的请求模块
 */

layui.define('jquery',function (exports) {
    let $ = layui.jquery
    let obj = {
        login:function (data) {
             $.ajax({
                url: '/test/login',
                method: 'post',
                data: data,
                dataType: 'json',
                success: function (res) {
                    console.log(res.data)
                }
            })
        }
    }
    exports('user', obj)
})