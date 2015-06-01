// <![CDATA[
$(function() {

  // Slider
  $('#coin-slider').coinslider({width:960,height:360,opacity:1});

  // Radius Box
  //$('.content p.pages span, .content p.pages a').css({"border-radius":"6px", "-moz-border-radius":"6px", "-webkit-border-radius":"6px"});
  //$('.content .sidebar .gadget, .fbg_resize').css({"border-radius":"12px", "-moz-border-radius":"12px", "-webkit-border-radius":"12px"});
  //$('.content p.pages span, .content p.pages a').css({"border-radius":"16px", "-moz-border-radius":"16px", "-webkit-border-radius":"16px"});
  //$('.menu_nav').css({"border-bottom-left-radius":"16px", "border-bottom-right-radius":"16px", "-moz-border-radius-bottomleft":"16px", "-moz-border-radius-bottomright":"16px", "-webkit-border-bottom-left-radius":"16px", "-webkit-border-bottom-right-radius":"16px"});

});	

// Cufon
Cufon.replace('h1, h2, h3, h4, h5, h6', { hover: true });
//Cufon.replace('h1', { color: '-linear-gradient(#fff, #ffaf02)'});
//Cufon.replace('h1 small', { color: '#8a98a5'});

// ]]>

function getRadio() {
    for (i = 0; i < document.getElementsByName("radio").length; i++) {
        if (document.getElementsByName("radio")[i].checked)
          return document.getElementsByName("radio")[i].value;
    }


}

function window2(){
    var v = window.open("http://localhost:8080/editCost", "", "top = 270, left = 490, width = 320, height = 180");
}
