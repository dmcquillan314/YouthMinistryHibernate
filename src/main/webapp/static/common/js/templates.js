this["deepdishcms"] = this["deepdishcms"] || {};

this["deepdishcms"]["colTemplate"] = function(obj) {
obj || (obj = {});
var __t, __p = '', __e = _.escape;
with (obj) {
__p += '<div class="layout-column ' +
((__t = ( colClass )) == null ? '' : __t) +
'" data-col-width="' +
((__t = ( colWidth )) == null ? '' : __t) +
'">\n    <input type="text" class="column-width" value="' +
((__t = ( colWidth )) == null ? '' : __t) +
'" />\n    <a href="#" class="update-column">Update</a>\n    <a href="#" class="delete-column">Delete</a>\n</div>';

}
return __p
};

this["deepdishcms"]["errorTemplate"] = function(obj) {
obj || (obj = {});
var __t, __p = '', __e = _.escape;
with (obj) {
__p += '<p class="errorMessage" for="' +
((__t = ( key )) == null ? '' : __t) +
'">' +
((__t = ( message )) == null ? '' : __t) +
'</p>';

}
return __p
};

this["deepdishcms"]["rowTemplate"] = function(obj) {
obj || (obj = {});
var __t, __p = '', __e = _.escape;
with (obj) {
__p += '<div class="layout-row">\n    <a href="#" class="add-column">Add column</a>\n    <input type="text" class="column-width" name="column-width" class="column-width" />\n    <div class="layout-row-columns">\n\n    </div>\n</div>';

}
return __p
};