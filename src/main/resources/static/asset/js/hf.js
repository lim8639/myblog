$(function () {

    if (window.location.pathname=="/"||window.location.pathname=="/index.html"){
    $("#header_nav").load("header.html");
    $("#page_footer").load("footer.html");
}else {
    $("#header_nav").load("../header.html");
    $("#page_footer").load("../footer.html");
    $(document).on("click","nav a",function () {
    var url = "../"+$(this).attr('href');
    $(this).attr("href",url);
})
}
})
