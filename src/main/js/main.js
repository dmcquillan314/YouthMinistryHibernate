/*exported broadcast */

$( function() {
    /* Definition of underscore mixins */
    _.mixin({
        /* function parseStringToRegex - takes a string and regex flags and converts to regex and cleans string
         *
         * @param str - input string
         * @param flags - flags for creation of regex i.e. i - case insensitive, g - global
        */
        parseStringToRegex : function( str, flags ) {
            return new RegExp(
                        "(?![^&;]+;)(?!<[^<>]*)(" +   // clear out possibility of script injection
                        str.replace(/[\-\[\]\/\{\}\(\)\*\+\?\.\\\^\$\|]/g, "\\$&") +  // escape special characters
                        ")(?![^<>]*>)(?![^&;]+;)", flags); // clear out possibility of script injection
        }
    });

    ddcms.App = Ember.Application.create();

});