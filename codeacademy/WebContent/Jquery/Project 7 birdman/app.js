var main = function() {
  $('img').click(function(){
      $('.dropdown-menu').toggle();
   });
};
 
$(document).ready(main);

//$(document).ready(function(){
//	  $('img').click(function(){
//	    $('.dropdown-menu').toggle();
//	  });
//	 });