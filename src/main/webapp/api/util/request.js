layui.extend({
    setting: '../config/global'
}).define(['setting', 'jquery'], function(exports){
    let setting = layui.setting
    let $ = layui.$

    $.ajaxPrefilter(function (options) {
        options.url = setting.backgroundAddress + options.url
        options.dataType = (typeof(options.dataType) === 'undefined') ? setting.dataType : options.dataType
    })

    let obj = function (options) {
        options.statusCode =  {
            404: function() {
                alert("page not found")
            }
        }
        $.ajax(options)
    }

    //输出 request 接口
    exports('request', obj);
});