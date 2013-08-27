deepdishcms.AppView = Backbone.View.extend({

    el: $( 'body' ),

    components: {
        'layout-component': 'layoutComponent',
        'page-component': 'pageComponent'
    },

    events: {},

    initialize: function() {
        this.loadComponents();
    },

    render: function() { return this; },

    loadComponents: function() {
        var components = [];

        _.each( this.$( '[data-require]' ), function( component ) {
            components.push( $( component ).data( 'require' ).split( ',' ) );
        }, this);

        _.each( _.uniq( _.flatten( components ) ), function( component ) {
            this[ this.components[ component.trim() ] ]();
        }, this);
    },

    layoutComponent: function() {
        var layoutComponent = new deepdishcms.LayoutView();
        layoutComponent.render();
    },

    pageComponent: function() {
        var pageComponent = new deepdishcms.PageView();
        pageComponent.render();
    }
});