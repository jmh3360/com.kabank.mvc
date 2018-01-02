/**
 * 
 */
 function goBitcamPage() {
	 location.href = "http://bitcamp.co.kr/index.php?main_page=home";
}
 function clickMe() {
	 document.querySelector('#bitcampPage')
	 .onclick = goBitcamPage;
	
}