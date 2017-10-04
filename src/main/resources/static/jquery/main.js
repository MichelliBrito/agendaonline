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

$(document).ready(function(){
    // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
  });

$(document).ready(function(){
    $('.collapsible').collapsible();
  });



$(document).ready(function(){
	$('.salvar').click(function(){
		
		confirm("Tem certeza que deseja salvar este prontuário? Depois de salvar não é possível fazer alterações!");
		
	});
});
