'use strict';

const gulp = require('gulp');
const del = require('del');
const polymerBuild = require('polymer-build');
const mergeStream = require('merge-stream');

const project = new polymerBuild.PolymerProject(require('./polymer.json'));

gulp.task('clean', function() {
  return del('../content/polymer/source/polymer-build', {force: true});
});

gulp.task('build', ['clean'], function() {
  return mergeStream(project.sources(), project.dependencies())
    .pipe(gulp.dest('../content/polymer/source/polymer-build'));
});