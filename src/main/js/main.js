/*exported broadcast */
var deepdishcms = deepdishcms || {},
    broadcast = deepdishcms.broadcast = deepdishcms.broadcast || _.extend( {}, Backbone.Events );

$( function() {

    /* place polyfills that can't be checked for compatibility using modernizr here */
    if(!String.prototype.trim) {
      String.prototype.trim = function () {
        return this.replace(/^\s+|\s+$/g,'');
      };
    }

    /* Definition of underscore mixins */
    _.mixin({

        /** function parseStringToRegex - takes a string and regex flags and converts to regex and cleans string
         *
         * @param str - input string
         * @param flags - flags for creation of regex i.e. i - case insensitive, g - global
         * 
         * @return RegExp - regular expression with applied flags and string
        **/
        parseStringToRegex : function( str, flags ) {
            return new RegExp(
                        "(?![^&;]+;)(?!<[^<>]*)(" +   // clear out possibility of script injection
                        str.replace(/[\-\[\]\/\{\}\(\)\*\+\?\.\\\^\$\|]/g, "\\$&") +  // escape special characters
                        ")(?![^<>]*>)(?![^&;]+;)", flags); // clear out possibility of script injection
        },

        /** function loadLib - this mixin is used to asynchronously load in a javascript library
         *
         * @param str - url (relative or absolute) of a library to be included
         * @param function - function to be called when library has been loaded
        **/
        loadLib : function( libUrl, callback ) {

            var script = document.createElement('script');
            script.type = 'text/javascript'; script.async = true;
            script.src = libUrl;

            document.getElementsByTagName('head')[0].appendChild(script);

            script.onload = script.onreadystatechange = function() {
                var readyState = script.readyState;
                if( !script.readyState || /loaded|complete/.test( readyState ) ) {
                    script.onload = script.onreadystatechange = null;
                    script = undefined;
                    callback !== undefined && callback();
                }
            };
        }
    });

    deepdishcms.appView = new deepdishcms.AppView();

    // Presentational polyfills.
    Modernizr.load([
        {
            test: Modernizr.csscolumns && Modernizr.csstransforms && Modernizr.csstransforms3d,
            nope: '/static/common/js/plugins.js',
            complete: function() {
                if( ! Modernizr.csscolumns ) {
                    $( '.multicolumn.four-col' ).columnize( {
                        width: 220,
                        columnGap: 20,
                        doneFunc: function() {
                            $( '.multicolumn.eight-col' ).columnize( { width: 460, columnGap: 20 } );
                        }
                    } );
                }
            }
        },
        {
            test: Modernizr.input.placeholder,
            nope: '/static/common/js/polyfills.js',
            complete: function() {}
        }
    ]);

});