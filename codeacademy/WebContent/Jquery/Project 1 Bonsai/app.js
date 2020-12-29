var main = function() {
	$('#image-url').keyup(function(){
	    var imageUrl = $('input[id=image-url]').val();
	    $('img').attr("src",imageUrl);
	  });
  $("#top-text").keyup(function(){
    var topText = $('input[id=top-text]').val();
    $('.top-caption').text(topText);
  });
  $("#bottom-text").keyup(function(){
    var bottomText = $('input[id=bottom-text]').val();
    $('.bottom-caption').text(bottomText);
  });
  
};
 
$(document).ready(main);