$("label.quenmk").click(function(e) {
    $("div.content").hide();
    $("div.content1").css("display", "block");
});
$(".tiep1").click(function(e) {
    $("div.content1").css("display", "none");
    $("div.content2").css("display", "block");
});
$(".tiep2").click(function(e) {
    $("div.content1").css("display", "none");
    $("div.content2").css("display", "none");
    $("div.content3").css("display", "block");
});