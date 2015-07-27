package com.rcs.webform.common.enums;


public enum ValidationType {

	//list all validation type supported by aui validator
	ALPHA,
	NUMBER, 
	ALPHANUM, 
	URL, 
	EMAIL, 
	
	//should not be used
	//already handled by others
//	REQUIRED,
//	MIN, 
//	MAX, 
//	DATE,
	
	//nothing handle these
//	MAX_LENGTH, 
//	MIN_LENGTH, 
//	EQUAL_TO, 
	
	//list custom validation type
	REGEX,
	;
}
