window.onload = function() {
    var Closead=document.getElementById('closead');
  
   Closead.onclick= function (){
    var Message=document.getElementById('mssage');
    document.getElementById("mssage").className = "showMessage";
    setTimeout(()=> document.getElementById("Ads").className="hideAd",3000);
   }
  };
