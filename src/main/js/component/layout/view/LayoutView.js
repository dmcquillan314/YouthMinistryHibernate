deepdishcms.LayoutView = Backbone.View.extend({

    el: $( '.layout-grid-view' ),
    layoutDataRef: '#layoutJSON',
    data: {},
    rowTemplate: deepdishcms.rowTemplate,
    colTemplate: deepdishcms.colTemplate,
    errorTemplate: deepdishcms.errorTemplate,
    classArray: [ 
                    'one-col', 'two-col', 'three-col',
                    'four-col', 'five-col', 'six-col',
                    'seven-col', 'eight-col', 'nine-col',
                    'ten-col', 'eleven-col', 'twelve-col',
                    'thirteen-col', 'fourteen-col', 'fifteen-col',
                    'sixteen-col'
                ],
    maxCols: 16,
    jsonData: {},
    jsonInput: $( '#layoutJSON' ),

    initialize: function() {
        _.bindAll( this, 'addRow', 'addColumn', 'removeRow', 'removeColumn', 'updateColumn' );
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
        var rows = this.$el.children();
        this.jsonData.rows = [];
        _.each( rows, function( row ) {
            var $row = $( row );
            var rowData = {
                              cols: []
                          };
            _.each( $row.find( '.layout-column' ), function( col ) {
                var colData = { width: $( col ).data('col-width') };
                rowData.cols.push( colData );
            } );

            this.jsonData.rows.push( rowData );
        }, this);
        this.jsonInput.val( JSON.stringify( this.jsonData ) );
    },

    importJSON: function() {

    },

    addRowColListeners: function() {
        $( '.add-column' ).on( 'click', this.addColumn );
        $( '.add-row' ).on( 'click', this.addRow );
        $( '.delete-column' ).on( 'click', this.removeColumn );
        $( '.delete-row' ).on( 'click', this.removeRow );
        $( '.update-column' ).on( 'click', this.updateColumn );
    },

    removeRowColListeners: function() {
        $( '.add-column' ).off( 'click' );
        $( '.add-row' ).off( 'click' );
        $( '.delete-column' ).off( 'click' );
        $( '.delete-row' ).off( 'click' );
        $( '.update-column' ).off( 'click' );
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

    addRow: function() {
        this.removeRowColListeners();

        var rowEl = this.rowTemplate( this.data );

        this.$el.append( rowEl );
        this.updateJSON();
        this.addRowColListeners();
    },

    addColumn: function( e ) {
        this.removeRowColListeners();

        var colInput = $( e.target ).siblings( '.column-width' ).val();
        var colWidth = colInput !== null && colInput !== "" ? parseInt( colInput, 10 ) : this.maxCols ;
        var rowSum = this.sumRecurse( 0, $( e.target ).siblings('.layout-row-columns').children(), colWidth );

        if( rowSum <= this.maxCols ) {
            var colEl = this.colTemplate( { 
                        colWidth: colWidth, 
                        colClass: this.classArray[ colWidth - 1 ] 
                    } );
            $( e.target ).siblings('.layout-row-columns').append( colEl );
            $( e.target ).siblings('.layout-row-columns').children().removeClass('omega');
            rowSum === this.maxCols && $( e.target ).siblings('.layout-row-columns').children().last().addClass('omega');
        } else {
            this.addError( 'row-overflow', 'The number of total columns in a row must be less than ' + this.maxCols );
        }
        this.updateJSON();
        this.addRowColListeners();
    },


    removeRow: function( e ) {
        this.removeRowColListeners();
        $( e.target ).parents( '.layout-row' ).remove();
        this.updateJSON();
        this.addRowColListeners();
    },

    removeColumn: function( e ) {
        this.removeRowColListeners();
        $( e.target ).parents( '.layout-column' ).remove();
        this.updateJSON();
        this.addRowColListeners();
    },

    updateColumn: function( e ) {
        this.removeRowColListeners();
        var col = $( e.target ).parents( '.layout-column' );
        var colWidth = $( e.target ).siblings( '.column-width' ).val();

        if( colWidth !== undefined || colWidth !== null ) {
            var rowSum = this.sumRecurse( 0, $( e.target ).parents( '.layout-row' ).children('.layout-row-columns').children(), colWidth );
            if( rowSum - parseInt(col.data('col-width'), 10) <= this.maxCols ) {
            var colEl = this.colTemplate({ colWidth: colWidth, colClass: this.classArray[ colWidth - 1 ] });
                var newCol = col.after( colEl );
                console.log( newCol );
                col.remove();
                if(parseInt(col.data('col-width'), 10) <= this.maxCols ) {
                    _.each( this.$el.children('.layout-row'), function( row ) {
                        $(row).children().removeClass('omega');
                        $(row).children().last().addClass('omega');
                    });
                }
            } else {
                this.addError( 'row-overflow', 'The number of total columns in a row must be less than ' + this.maxCols );
            }
        }
        
        this.updateJSON();
        this.addRowColListeners();
    },

    addError: function( key, message ) {
        $( '.errors-container p[for=' + key + ']').remove();
        $( '.errors-container' ).append( this.errorTemplate({ key: key, message: message }));
    },

    sumRecurse: function( n, columns, nextTotal ) {

        var widthArr = [];
        _.each( columns, function( column ) {
            widthArr.push( $(column).data('col-width') === undefined ? 0 : parseInt($(column).data('col-width'), 10) );
        });
        widthArr.push(nextTotal);

        return _.reduce( widthArr, function( a, b ) {
            return parseInt(a, 10) + parseInt(b, 10);
        });
    }
});