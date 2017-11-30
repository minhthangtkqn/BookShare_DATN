function setHeight(){
    var textarea = document.getElementsByTagName('textarea');
    
    for(i = 0; i<textarea.length; i++){
    	textarea[i].style.height = textarea[i].scrollHeight+'px';
    	textarea[i].setAttribute("style", textarea[i].getAttribute("style") + " overflow: hidden;");
    }
}

function disableSelects(){
	var type = document.getElementById("loaiTimKiem").value;
	
	var maTinh = document.getElementsByName("maTinh");
	var maDanhMuc = document.getElementsByName("maDanhMuc");
	var sapXepGia = document.getElementsByName("sapXepGia");
	var sapXepThoiGian = document.getElementsByName("sapXepThoiGian");
	
	
	if (type === "request"){
		$(maTinh).attr("disabled", true);
		$(maTinh).attr("style", "background-color: #d6d6d6;");
		
		$(maDanhMuc).attr("disabled", true);
		$(maDanhMuc).attr("style", "background-color: #d6d6d6;");
		
		$(sapXepGia).attr("disabled", true);
		$(sapXepGia).attr("style", "background-color: #d6d6d6;");
		
		$(sapXepThoiGian).attr("disabled", true);
		$(sapXepThoiGian).attr("style", "background-color: #d6d6d6;");
	}
	if( type === "sell"){
		$(maTinh).attr("disabled", true);
		$(maTinh).attr("style", "background-color: white;");
		
		$(maDanhMuc).attr("disabled", true);
		$(maDanhMuc).attr("style", "background-color: white;");
		
		$(sapXepGia).attr("disabled", true);
		$(sapXepGia).attr("style", "background-color: white;");
		
		$(sapXepThoiGian).attr("disabled", true);
		$(sapXepThoiGian).attr("style", "background-color: white;");
	}
}