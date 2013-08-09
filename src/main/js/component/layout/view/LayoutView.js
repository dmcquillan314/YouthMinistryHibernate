deepdishcms.LayoutView = Backbone.View.extend({

    el: $( '.layout-grid-view' ),
    layoutDataRef: '#layoutJSON',
    data: {},
    rowTemplate: deepdishcms.rowTemplate,
    colTemplate: deepdishcms.colTemplate,
    classArray: [ 
                    'one-col', 'two-col', 'three-col',
                    'four-col', 'five-col', 'six-col',
                    'seven-col', 'eight-col', 'nine-col',
                    'ten-col', 'eleven-col', 'twelve-col',
                    'thirteen-col', 'fourteen-col', 'fifteen-col',
                    'sixteen-col'
                ],

    initialize: function() {
        _.bindAll( this, 'addRow', 'addColumn' );
        try {
            this.model.set({
                data: JSON.parse( $( this.layoutDataRef ).val() )
            });
        } catch( e ) {
            // object empty -- create new
            this.data = { rows: [] };
        }

    },

    render: function() {
        this.createGrid();
        return this;
    },

    updateJSON: function() {

    },

    importJSON: function() {

    },

    addRowColListeners: function() {
        $( '.add-column' ).on( 'click', this.addColumn );
        $( '.add-row' ).on( 'click', this.addRow );
    },

    removeRowColListeners: function() {
        $( '.add-column' ).off( 'click', this.addColumn );
        $( '.add-row' ).off( 'click', this.addRow );
    },

    createGrid: function() {
        if( this.data.rows.length === 0 ) {
            // create new grid
            this.$el.append( _.template( this.rowTemplate( this.data ) ) );
        } else {
            // parse grid
        }

        this.addRowColListeners();
    },

    addRow: function( e ) {
        this.removeRowColListeners();

        var rowEl = this.rowTemplate( this.data );
        $( e.target ).siblings('.layout-column-rows').append( rowEl );

        this.addRowColListeners();
    },

    addColumn: function( e ) {
        this.removeRowColListeners();

        var colEl = this.colTemplate( { colClass: this.classArray[ parseInt( $( e.target ).siblings( '.column-width' ).val(), 10 ) - 1 ] } );
        $( e.target ).siblings('.layout-row-columns').append( colEl );

        this.addRowColListeners();
    }

});