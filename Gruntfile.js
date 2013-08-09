/*global module:false */
/*jslint es5:true */
/*jshint -W083 */

module.exports = function( grunt ) {

	'use strict';

	var fs = require( 'fs' ),
		gzip = require( 'zlib' ).gzip,
		minFiles = [];

	// Task configuration.
	grunt.initConfig({

		// Build metadata.
		pkg: grunt.file.readJSON( 'package.json' ),
		banner: '/*! <%= pkg.title || pkg.name %> - v<%= pkg.version %> - ' +
		'Built: <%= grunt.template.today("yyyy-mm-dd h:MM:ss TT") %> CST\n' +
		'<%= pkg.homepage ? "* " + pkg.homepage + "\\n" : "" %>' +
		'*   Copyright (c) <%= grunt.template.today("yyyy") %> <%= pkg.author %> All Rights Reserved.\n*/\n',

		// Assign directories.
		dir: {
			static: 'src/main/webapp/static',
			staticTarget: 'src/main/webapp/static',
			js: {
				common: 'src/main/js',
				commonTarget: '<%= dir.staticTarget %>/common/js',
				mobile: '',
				mobileTarget: ''
			},
			scss: {}
		},

		// Lint JavaScript.
		jshint: {
			all: [
				'Gruntfile.js',
				'<%= dir.js.common %>/*.js',
				'<%= dir.js.common %>/component/**/*.js'
			],
			options: {
				//devel: true,	// Enable for console logging
				curly: true,
				eqeqeq: true,
				immed: true,
				latedef: true,
				newcap: true,
				noarg: true,
				sub: true,
				undef: true,
				unused: true,
				boss: true,
				eqnull: true,
				browser: true,
				smarttabs:true,
				expr: true,		// Allows ternary operators
				predef: [
					'define',
					'require',
					'console',
					'Modernizr',
					'$',
					'deepdishcms',
					'YT'
				],
				globals: {
					_: true,
					jQuery: true,
					Backbone: true,
					requirejs: true,
					youtubeProxy: true
				}
			}
		},

		// Compile templates.
		jst: {
			compile: {
				options: {
					namespace: 'deepdishcms',
					processName: function(filename) {
						var name = filename.split( '/' ).pop();
						return name.substr( 0, name.lastIndexOf( '.' ) );
					}
				},
				files: {
					'<%= dir.js.commonTarget %>/templates.js': [ '<%= dir.js.common %>/component/**/*.html' ]
				}
			}
		},

		// Compile JavaScript.
		concat: {
			options: {
				separator: ';',
			},
			base: {
				options: {
					// Replace 'use strict' statements with a single one at the top.
					banner: "'use strict';\n",
					process: function(src, filepath) {
						return '// Source: ' + filepath + '\n' +
						src.replace(/(^|\n)[ \t]*('use strict'|"use strict");?\s*/g, '$1');
			        }
				},
				src: [ // Lib order is important.
					'<%= dir.js.common %>/lib/underscore.js',
					'<%= dir.js.common %>/lib/jquery-1.9.1.js',
					'<%= dir.js.common %>/lib/backbone.js',
					'<%= dir.js.common %>/main.js',
					'<%= dir.js.common %>/component/**/model/*.js',
					'<%= dir.js.common %>/component/**/collection/*.js',
					'<%= dir.js.common %>/component/**/view/*.js'
				],
				dest: '<%= dir.js.commonTarget %>/compiled.js',
				nonull: true // Warn on missing files.
			},
			polyfill: {
				src: [ '<%= dir.js.common %>/lib/polyfill/*.js' ],
				dest: '<%= dir.js.commonTarget %>/polyfills.js',
				nonull: true
			},
			plugin: {
				src: [ '<%= dir.js.common %>/lib/plugin/*.js' ],
				dest: '<%= dir.js.commonTarget %>/plugins.js',
				nonull: true
			}
		},

		// Minify JavaScript.
		gcc: {
			base: {
				options: {
					compilation_level: 'ADVANCED_OPTIMIZATIONS',
					language_in: 'ECMASCRIPT5_STRICT'
				},
				src: ['<%= dir.js.commonTarget %>/compiled.js'],
				dest: '<%= dir.js.commonTarget %>/compiled.min.js'
			},
			polyfill: {
				options: {
					compilation_level: 'SIMPLE_OPTIMIZATIONS'
				},
				src: ['<%= dir.js.commonTarget %>/polyfills.js'],
				dest: '<%= dir.js.commonTarget %>/polyfills.min.js'
			},
			plugin: {
				options: {
					compilation_level: 'SIMPLE_OPTIMIZATIONS'
				},
				src: ['<%= dir.js.commonTarget %>/plugins.js'],
				dest: '<%= dir.js.commonTarget %>/plugins.min.js'
			}
		},

		// Compile CSS.
		compass: {
			options: {
				require: 'susy',
				cssDir: 'src/main/webapp/static/',
				sassDir: 'src/main/scss/',
				imagesDir: 'src/main/webapp/',
				fontsDir: '/static/common/font/',
				relativeAssets: true,
				force: false // Don't compile if no changes detected
			},
			development: {
				options: {
					environment: 'development',
					outputStyle: 'expanded'
				}
			},
			production: {
				options: {
					environment: 'production',
					outputStyle: 'compressed'
				}
			}
		},

		// Prepend our files with build date and copyright info.
		usebanner: {
			options: {
				position: 'top',
				banner: '<%= banner %>'
			},
			files: {
				src: [
					'<%= dir.js.commonTarget %>/compiled.js',
					'<%= dir.staticTarget %>/common/**/*.css'
				]
			}
		},

		// Auto-compile javascript and stylesheets if changes are made live.
		watch: {
			js: {
				files: [
					'<%= dir.js.common %>/*.js',
					'<%= dir.js.common %>/component/**/*.js',
					'<%= dir.js.common %>/component/**/*.html'
				],
				tasks: [ 'preflight', 'jst', 'concat' ]
			},
			scss: {
				files: [ 'src/main/scss/**/*.scss' ],
				tasks: [ 'compass:development' ]
			}
		}

	});

	grunt.loadNpmTasks( 'grunt-contrib-compass' );	// https://github.com/gruntjs/grunt-contrib-compass
	grunt.loadNpmTasks( 'grunt-contrib-concat' );	// https://github.com/gruntjs/grunt-contrib-concat
	grunt.loadNpmTasks( 'grunt-contrib-jshint' );	// https://github.com/gruntjs/grunt-contrib-jshint
	grunt.loadNpmTasks( 'grunt-contrib-jst' );		// https://github.com/gruntjs/grunt-contrib-jst
	grunt.loadNpmTasks( 'grunt-contrib-watch' );	// https://github.com/gruntjs/grunt-contrib-watch
	grunt.loadNpmTasks( 'grunt-banner' );			// https://github.com/mattstyles/grunt-banner
	grunt.loadNpmTasks( 'grunt-gcc' );				// https://github.com/Darsain/grunt-gcc

	// Preflight task will lint and (eventually) test our code, ready to be checked in to source control.
	grunt.registerTask( 'preflight', [ 'jshint' ] );

	// Default task.
	grunt.registerTask( 'default', [ 'preflight', 'jst', 'concat', 'compass:development', 'usebanner', 'postflight' ] );

	// Development task is simply an alias to default.
	grunt.registerTask( 'development', [ 'default' ] );

	// Production task will run the debug tasks and minify/optimize build files.
	grunt.registerTask( 'production', [ 'preflight', 'jst', 'concat', 'gcc', 'compass:production', 'usebanner', 'postflight' ] );

	// Postflight task prepares the build directory for use.
	grunt.registerTask( 'postflight', 'Prepare build directory.', function() {
		var commonTargetDir = grunt.config.get( 'dir.js.commonTarget' ),
			minifiedFiles = fs.readdirSync( commonTargetDir ),
			includeDir = grunt.config.get( 'dir.js.common' ) + '/lib/include',
			includeFiles = fs.readdirSync( includeDir );

		for ( var minFile in minifiedFiles ) {
			if ( minifiedFiles[ minFile ].search( /min.js/i ) !== -1 ) {
				var currentFile = commonTargetDir + '/' + minifiedFiles[ minFile ].slice( 0, -7 ) + '.js';
				minFiles.push( currentFile );

				grunt.file.copy( commonTargetDir + '/' + minifiedFiles[ minFile ], currentFile );
				grunt.file.delete( commonTargetDir + '/' + minifiedFiles[ minFile ] );
			}
		}

		for ( var file in includeFiles ) {
			grunt.file.copy( includeDir + '/' + includeFiles[ file ],
				commonTargetDir + '/' + includeFiles[ file ] );
		}

		grunt.task.run( '_mininfo' );
	});

	// Mininfo task displays minified size of a file.
	grunt.registerTask( '_mininfo', 'Output minified size of a file.', function() {
		var done = this.async();

		function minInfo( min, filename, onComplete ) {
			gzip( min, function( error, buffer ) {

				if ( error ) {
					onComplete.call( this, error );
				}

				var gzipSize = buffer.toString().length;

				grunt.log.writeln('Compressed size of ' + filename + ': ' + String(( gzipSize / 1024 ).toFixed( 2 )).green +
					' kb gzipped (' + String( gzipSize ).green + ' bytes).');

				onComplete.call( this, null );
			});
		}

		if ( minFiles.length ) {
			for ( var file in minFiles ) {
				var min = fs.readFileSync( minFiles[ file ], 'utf8' );

				minInfo( min, minFiles[ file ], function( error ) {
					if ( error ) {
						grunt.warn( error );
						done( false );
					}
				});
			}
		}
	});
};
