/**
 * 扩展一个自定义的请求模块
 */

layui.define('jquery',function (exports) {
    let $ = layui.jquery
    let obj = {
        login:function (data) {
            return $.ajax({
                url: 'test/login',
                data: data,
                dataType: 'json',
                success: function (res) {
                    console.log(res);
                }
            })
        }
    }
    exports('request', obj)
})