layui.extend({
    setting: 'config/global',
    service: 'util/service',
    user: 'user',
    area: 'area',
    class: 'class',
    disease: 'disease',
    mouse: 'mouse',
    pest: 'pest',
    events: 'event'
}).define(['setting', 'service', 'user', 'area', 'class', 'disease', 'mouse', 'pest', 'events'], function(exports){
    //输出 request 接口
    exports('request');
});