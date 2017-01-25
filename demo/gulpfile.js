var gulp = require('gulp');
var watch = require('gulp-watch');
var babel = require('gulp-babel');
var browserSync = require('browser-sync').create();
var historyApiFallback = require('connect-history-api-fallback');
var compression = require('compression');
var argv = require('yargs').argv;

var example = argv.example;
var jsPath = [example + '/src/*.js', example + 'src/**/*.js'];

gulp.task('js', function() {
    if(typeof example !== 'string' || example === '') {
        throw new Error('--example parameter is needed and cant be null');
    }

    return gulp.src(jsPath)
        .pipe(babel({ babelrc: true }))
        .pipe(gulp.dest('./' + example + '/dist/'));
});

gulp.task('jsWatch', ['js'], function() {
    browserSync.reload();
});

gulp.task('serve', ['js'], function() {
    watch(jsPath, function() {
        gulp.start('jsWatch');
    });
    watch([example + '/json/*.json', example + '/css/*.css'], function() {
        browserSync.reload();
    });
    watch([example + '.html', example + '/src/*.html', example + '/src/**/*.html'], function() {
        browserSync.reload();
    });

    browserSync.init({
        server: {
            baseDir: './',
            index: example + '.html',
            middleware: [historyApiFallback({ index: '/' + example + '.html' }), compression()]
        },
        host: 'localhost',
        port: argv.port || 3000,
        ghostMode: false,
        online: false
    });
});