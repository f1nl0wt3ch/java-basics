$(document).ready(function(){
    $("#button").click(function(){
        var toAdd = $("input[name=checkListItem]").val();
        $(".list").append('<div>' + toAdd + '</div>');
        });
    });