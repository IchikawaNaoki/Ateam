function sound(form){
	// [ID:sound-file]の音声ファイルを再生[play()]する
	document.getElementById( 'sound-file' ).play() ;

	var formSubmit = function(){
		form.submit();
	}

	setTimeout(formSubmit,500);
}