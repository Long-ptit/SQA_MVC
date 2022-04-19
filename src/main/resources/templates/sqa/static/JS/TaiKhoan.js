$(".select").click(function(e) {
    $(".default").css("color", "black");
});
$(".default").click(function(e) {
    $(".default").css("color", "blue");
    $(".xem").css("display", "block");
    $(".sua").css("display", "none");
    $(".doimatkhau").css("display", "none");
});
$(".suaa").click(function(e) {
    $(".xem").css("display", "none");
    $(".sua").css("display", "block");
    $(".doimatkhau").css("display", "none");
});
$(".doimatkhauu").click(function(e) {
    $(".xem").css("display", "none");
    $(".sua").css("display", "none");
    $(".doimatkhau").css("display", "block");
});