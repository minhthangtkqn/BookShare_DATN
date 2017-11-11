function setHeight(){
    var textarea = document.getElementsByTagName('textarea');
    
    for(i = 0; i<textarea.length; i++){
    	textarea[i].style.height = textarea[i].scrollHeight+'px';
    	textarea[i].setAttribute("style", textarea[i].getAttribute("style") + " overflow: hidden;");
    }
}