var main = function() {
  $('.day').click(function(){
     $(this).next().toggle();
     $('.weekday').find('span').toggleClass('glyphicon-minus');
    
  });
};

$(document).ready(main);