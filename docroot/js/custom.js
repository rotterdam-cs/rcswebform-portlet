/*!
 * jQuery JavaScript Library v1.11.1
 * http://jquery.com/
 *
 * Includes Sizzle.js
 * http://sizzlejs.com/
 *
 * Copyright 2005, 2014 jQuery Foundation, Inc. and other contributors
 * Released under the MIT license
 * http://jquery.org/license
 *
 * Date: 2014-05-01T17:42Z
 */


/*
 * Use code from jQuery JavaScript Library v1.11.1  
 */

var webFormCustomFunction = {
	// Support: Android<4.1, IE<9
	// Make sure we trim BOM and NBSP
	rtrim : /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g,
	rcleanScript : /^\s*<!(?:\[CDATA\[|--)|(?:\]\]|--)>\s*$/g,
	
	//Support: Android<4.1, IE<9
	trim : function( text ) {
		return text == null ?
			"" :
			( text + "" ).replace( this.rtrim, "" );
	},
	
	// Evaluates a script in a global context
	// Workarounds based on findings by Jim Driscoll
	// http://weblogs.java.net/blog/driscoll/archive/2009/09/08/eval-javascript-global-context
	globalEval : function ( data ) {
		if ( data && this.trim(data) ) {
			// We use execScript on Internet Explorer
			// We use an anonymous function so that context is window
			// rather than jQuery in Firefox
			( window.execScript || function( data ) {
				window[ "eval" ].call( window, data );
			} )( data );
		}
	},
	
	evalScript : function(scripts){
		for(var i = 0; i < scripts.length ; i++){
			var node = scripts.item(i);
			this.globalEval( ( node.text || node.textContent || node.innerHTML || "" ).replace( this.rcleanScript, "" ));
		}
	}
};
