$(function () {
    var token = $.cookie("token");
    if (token==""||token==undefined||token==null){
        var url = window.location.href;
        $.cookie("url",url,{path:"/"})
        window.location= "../check/login.html";
    }
})