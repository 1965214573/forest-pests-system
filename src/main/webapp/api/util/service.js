layui.define(['setting', 'jquery'], function (exports) {
    let setting = layui.setting
    let $ = layui.$

    $.ajaxPrefilter(function (options) {
        options.url = setting.baseURL + options.url
        options.dataType = (typeof(options.dataType) === 'undefined') ? setting.dataType : options.dataType
    })

    //输出 request 接口
    exports('service', function (options) {
        options.statusCode =  {
            404: function() {
                layer.msg("page not found")
            }
        }
        $.ajax(options)
    });
})
