var concat = require('gulp-concat');
var gulp = require('gulp');
var dirSync = require( 'gulp-directory-sync' );


var jsBaseDir = './src/main/resources/static/js';
var jsTargetDir = './target/classes/static/js';

gulp.task('scripts', function() {
  return gulp.src([jsBaseDir + '/angular-bootstrap.js',
                   jsBaseDir + '/jquery.sticky.js',
                   jsBaseDir + '/app.js',
                   jsBaseDir + '/controller/*.js',
                   jsBaseDir + '/directive/*.js',
                   jsBaseDir + '/service/*.js'])
    .pipe(concat('all.js'))
    .pipe(gulp.dest(jsBaseDir));
});

gulp.task('sync', function() {
  return gulp.src( '' )
  		.pipe(dirSync( './src/main/resources/static', './target/classes/static', { printSummary: true } ))
  		.on('error', console.log);
});

gulp.task('default', function(){
  gulp.watch('./src/main/resources/static/**/*.js', ['scripts', 'sync']);
  gulp.watch('./src/main/resources/static/**/*.html', ['sync']);
  gulp.watch('./src/main/resources/static/**/*.css', ['sync']);
});