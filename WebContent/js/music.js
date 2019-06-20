function soundplayAndSubmit(form){

	var	soundEle = document.getElementById( 'sound-file' );
    	soundEle.play() ;

    	/* サウンドが流れ終わったらsubmitする */
    	soundEle.addEventListener("ended", function() {
    		form.submit();
    		});
}
