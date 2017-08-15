$(document).ready(function(){
	$(".button-collapse").sideNav({
		  menuWidth: 150, // Default is 300
	      edge: 'left', // Choose the horizontal origin
	      closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
	      draggable: true
	});
});

$(document).ready(function(){
    $('.slider').slider();
  });

$(document).ready(function() {
    $('select').material_select();
 });