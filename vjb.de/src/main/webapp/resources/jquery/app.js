
var main = function(){
	/* dropdown menu */
	$('.caret').click(function(){
	var menu = $('.dropdown-menu');
	menu.toggle();
	});
}
     /*auto slide*/
    $(".slider > div:gt(0)").hide();
    setInterval(function(){
    	$(".slider > div:first")
    	.fadeOut(1000)
    	.next()
    	.fadeIn(1000)
    	.end()
    	.appendTo(".slider");
    }, 3000);
	/* slide */
	$('.arrow-next').click(function(){
        var currentSlide = $('.active-slide')
        var nextSlide = currentSlide.next();
        var currentDot = $('.active-dot');
        var nextDot = currentDot.next();
        if(nextSlide.length === 0){
            nextSlide = $(".slide").first();
            nextDot = $('.dot').first();
            
        }
        currentDot.removeClass('active-dot');
        nextDot.addClass('active-dot');
         currentSlide.fadeOut(600).removeClass('active-slide');
         nextSlide.fadeIn(600).addClass('active-slide');
     })

$(document).ready(main);