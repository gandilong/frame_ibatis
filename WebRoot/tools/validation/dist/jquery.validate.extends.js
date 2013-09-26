(function(){
	
	jQuery.validator.addMethod("en", function(value, element) {
		return this.optional(element) || /^[a-z\-.,()'"\s]+$/i.test(value);
	}, "请输入a-z|A-Z的字");
	
})();

