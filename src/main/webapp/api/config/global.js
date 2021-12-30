layui.define(function (exports) {
    exports('setting', {
        baseURL: getRootPath(), // 后端接口路径
        dataType: 'json'
    })

    /**
     * 获取当前项目部署环境，前后端分离时，可指定具体后端接口路径
     * @returns {string}
     */
    function getRootPath() {
        let curWwwPath=window.document.location.href;
        let pathName=window.document.location.pathname;
        let pos=curWwwPath.indexOf(pathName);
        return curWwwPath.substring(0,pos)
    }
})