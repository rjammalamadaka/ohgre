(function( ohgre, undefined ) {

var store = ohgre.store = function( key, value, options ) {
	var returnValue;
    if(value){
        var stringvalue=JSON.stringify(value);
         returnValue=value;
         document.cookie=key+"="+stringvalue+";path=/";
    }else{
         var cookieValue=getCookie(key);
        if(cookieValue && cookieValue.length>0){
        returnValue=JSON.parse(cookieValue);
        } else{
            returnValue={};
        }
    }


    return returnValue;
};


    function eraseCookieFromAllPaths(name) {
    // This function will attempt to remove a cookie from all paths.
    var pathBits = location.pathname.split('/');
    var pathCurrent = ' path=';

    // do a simple pathless delete first.
    document.cookie = name + '=; expires=Thu, 01-Jan-1970 00:00:01 GMT;';

    for (var i = 0; i < pathBits.length; i++) {
        pathCurrent += ((pathCurrent.substr(-1) != '/') ? '/' : '') + pathBits[i];
        document.cookie = name + '=; expires=Thu, 01-Jan-1970 00:00:01 GMT;' + pathCurrent + ';';
    }
}

    ohgre.removeStore=function(key){
              document.cookie = key+'=;path=/;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
        eraseCookieFromAllPaths(key);
    }


var getCookie= function (cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}


}( this.ohgre = this.ohgre || {} ) );