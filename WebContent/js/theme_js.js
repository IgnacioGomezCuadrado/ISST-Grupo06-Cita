/*$( '#topheader .navbar-nav a' ).on( 'click', function () {
	$( '#topheader .navbar-nav' ).find( 'li.active' ).removeClass( 'active' );
	$( this ).parent( 'li' ).addClass( 'active' );
}); */


/*!
 * Check if an element is out of the viewport
 * (c) 2018 Chris Ferdinandi, MIT License, https://gomakethings.com
 * @param  {Node}  elem The element to check
 * @return {Object}     A set of booleans for each side of the element
 */
var isOutOfViewport = function (elem) {

	// Get element's bounding
	var bounding = elem.getBoundingClientRect();
	
	// Check if it's out of the viewport on each side
	var out = {};
	out.top = bounding.top < 0;
	out.left = bounding.left < 0;
	out.bottom = bounding.bottom > (window.innerHeight || document.documentElement.clientHeight);
	out.right = bounding.right > (window.innerWidth || document.documentElement.clientWidth);
	out.any = out.top || out.left || out.bottom || out.right;
	out.all = out.top && out.left && out.bottom && out.right;
	
	return out;

};

footer = document.querySelector('#footer');

var logViewport = function () {
  var isOut = isOutOfViewport(footer);
  if (isOut.any) {
	  //console.log('Not in the viewport! =( )');	
	  document.documentElement.className="";
	  document.documentElement.style.height="inherit";
  
	  document.getElementsByTagName("BODY")[0].className = "";
	  document.getElementsByTagName("BODY")[0].style.height = "inherit";
  

   } else {
	  //console.log('In the viewport! =)');
   }
		
	    
};

logViewport();

			
			
