/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 window.fbAsyncInit = function() {
    FB.init({
      appId      : '679214162183752',
      xfbml      : true,
      version    : 'v2.4'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
     
function publicaMensaje(message){
    window.resultFB= FB.login(
        function(){
            FB.api('/me/feed', 'post',  {message: message});
            },
            {scope: 'publish_actions'}
    );
}