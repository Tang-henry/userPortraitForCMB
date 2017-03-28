/**
 * RequireJS main configuration file load before RequireJS
 */
require.config({
	baseUrl : '../../static',
	deps : [],
	paths : {
		/*'require-css': [requirejsResHost + '/plugins/require-css/0.1.8/css.min',
		                '//cdn.bootcss.com/require-css/0.1.8/css.min'],*/
		'jquery': ['plugins/jquery/jquery-2.2.2.min',
		           '//cdn.bootcss.com/jquery/2.2.2/jquery.min'],
		'bootstrap': ['plugins/bootstrap/3.3.6/js/bootstrap.min',
		              '//cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min'],
		'moment': ['plugins/moment.js/2.11.1/moment-with-locales.min',
		           '//cdn.bootcss.com/moment.js/2.11.1/moment-with-locales.min'],
		'Vue': ['plugins/vue/2.0.3/vue',
	               '//cdn.bootcss.com/vue/2.0.3/vue.min']
	},
	shim : {
		'bootstrap' : {
			deps : [ 'jquery' ],
			exports : 'bootstrap'
		}
	},
	config: {
        'moment' : {
            noGlobal: true
        }
    }
});
