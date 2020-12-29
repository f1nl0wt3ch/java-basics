var template = function(text) {
  return '<p><input type="checkbox"><i class="glyphicon glyphicon-star"></i><span>' + text + '</span><i class="glyphicon glyphicon-remove"></i></p>';
};

var main = function() {
  $('form').submit(function() {
    var input = $('input[id=todo]').val();
    if(input.length !== 0) {
        var html = template(input);
        $('.list').append(html);
        this.input = $('input[id=todo]').val('');
    }
    return false;  
  });
  
   $('.glyphicon-star').click(function(){
	   $(this).toggleClass('active');
	  });
   $('.glyphicon-star').on('click',function(){
     $(this).toggleActive();
   });
  $('.glyphicon-remove').click(function(){
    $('.active').parent().remove();
  });
  $('input[type=checkbox]').change(function(){
    $(".glyphicon-remove").click(function(){
      $(this).parent().remove();
    });
  });
};

$(document).ready(main);