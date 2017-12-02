function setHeight() {
	var textarea = document.getElementsByTagName('textarea');

	for (i = 0; i < textarea.length; i++) {
		textarea[i].style.height = textarea[i].scrollHeight + 'px';
		textarea[i].setAttribute("style", textarea[i].getAttribute("style")
				+ " overflow: hidden;");
	}
}

function disableSelects() {
	var type = document.getElementById("loaiTimKiem").value;

	var maTinh = document.getElementsByName("maTinh");
	var maDanhMuc = document.getElementsByName("maDanhMuc");
	var sapXepGia = document.getElementsByName("sapXepGia");
	var sapXepThoiGian = document.getElementsByName("sapXepThoiGian");

	if (type === "request") {
		$(maTinh).attr("disabled", true);
		$(maTinh).attr("style", "background-color: #d6d6d6;");

		$(maDanhMuc).attr("disabled", true);
		$(maDanhMuc).attr("style", "background-color: #d6d6d6;");

		$(sapXepGia).attr("disabled", true);
		$(sapXepGia).attr("style", "background-color: #d6d6d6;");

		$(sapXepThoiGian).attr("disabled", true);
		$(sapXepThoiGian).attr("style", "background-color: #d6d6d6;");
	}
	if (type === "sell") {
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

function getValidString(s){
	if(s === null){
		s = "";
	}
	return s;
}

$(document).ready(function() {
	var pageBody = document.getElementById("page-body");
	var scrollTop = document.createElement("a");
	$(scrollTop).attr("class", "scrollToTop");
	$(scrollTop).attr("href", "#");
	$(scrollTop).attr("style", "color: white;");

	var icon = document.createElement("i");
	$(icon).attr("class", "glyphicon glyphicon-arrow-up");

	scrollTop.appendChild(icon);
	pageBody.appendChild(scrollTop);

	// Check to see if the window is top if not then display button
	$(window).scroll(function() {
		if ($(this).scrollTop() > 100) {
			$('.scrollToTop').fadeIn();
		} else {
			$('.scrollToTop').fadeOut();
		}
	});

	// Click event to scroll to top
	$('.scrollToTop').click(function() {
		$('html, body').animate({
			scrollTop : 0
		}, 500);
		return false;
	});

	// +++++++++++++++++++++++++++
	// +++++++++++++++++++++++++++
	// +++++++++++++++++++++++++++

	// Add smooth scrolling to all links
	$("a").on('click', function(event) {

		// Make sure this.hash has a value before overriding default behavior
		
		if (!getValidString(this.getAttribute("class")).includes('default-link')){
			if (this.hash !== "") {
				// Prevent default anchor click behavior
				event.preventDefault();

				// Store hash
				var hash = this.hash;

				// Using jQuery's animate() method to add smooth page scroll
				// The optional number (800) specifies the number of
				// milliseconds it
				// takes to scroll to the specified area
				$('html, body').animate({
					scrollTop : $(hash).offset().top
				}, 800, function() {

					// Add hash (#) to URL when done scrolling (default click
					// behavior)
					window.location.hash = hash;
				});
			} // End if
		}
	});
});