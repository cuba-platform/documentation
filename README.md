# CUBA Platform Documentation

## Overview

The documentation is written in AsciiDoc format. Source files, images and includes are located in the `content` directory in the following subdirectories:

* `manual` - Developer's Manual
* `polymer` - Polymer UI Tutorial
* `release_notes` - latest release notes
* other subdirectories contain documentation on platform addons.

Most of the documents have English and Russian versions in the corresponding subdirectories (`en` and `ru`). 

Released documentation is available at [CUBA website](https://www.cuba-platform.com/documentation).

## Building from Source

### Prerequisites

In order to produce HTML from AsciiDoc, we use [Asciidoctor](https://asciidoctor.org). It can be installed as follows:
 
1. Install [Ruby](https://www.ruby-lang.org/en/downloads) (tested on version 2.1).

2. Install Asciidoctor:

        gem install asciidoctor -v 1.5.2

3. Install coderay for code highlighting:

        gem install coderay
4. If want to generate PDF, install Asciidoctor PDF and  (Optional for PDF generate):

        gem install asciidoctor-pdf
        gem install prawn-gmagick 

`prawn-gmagick` should depend on the `graphicsmagick`, so need to install it such as use brew on Mac `rew install graphicsmagick`
This package is used to convert some PNG images, or will get some WARN message like:

> could not embed image xxx; PNG uses unsupported interlace method; install prawn-gmagick gem to add support

This is enough to build the documentation with the existing visual theme. If you want to change the theme, see the __Building Theme__ section below.

### Build Tasks

Gradle is used as a build tool. Build task names have the following structure: `{purpose}{doc}{lang}`.

__{purpose}__ can be one of the following:

* `build` - build single-HTML document.
* `chop` - build multi-page document.
* `war` - build a WAR file. The resulting WAR file will have a name corresponding to the document name and a version which is set by the `ext.docVersion` property defined in `build.gradle`, for example `manual-7.0.war`.
* `deploy` - deploy WAR to Tomcat (installed by the `setupTomcat` task, see below).
* `pdf` - if want to generate append pdf at end of task (current only support manual)

__{doc}__ is the document name (`Manual`, `Bpm`, etc.)

__{lang}__ can be either `En` or `Ru`.

For example, to build and deploy the English manual, use the following command:

    ./gradlew deployManualEn

Before running the deploy task, install the local Tomcat server by executing the following task:

    ./gradlew setupTomcat
    
By default, Tomcat is installed into `./deploy/tomcat` and configured to listen on port `6080`.

### Building Theme

The CSS file containing the theme is located in the `styles` directory. Don't change this file - it must be built by the AsciiDoc theme builder. The theme builder is located in the `tools/asciidoctor-stylesheet-factory` directory (it is a copy of the [asciidoctor-stylesheet-factory](https://github.com/asciidoctor/asciidoctor-stylesheet-factory) project).

The theme source code is contained in two files: `sass/cuba.scss` and `sass/settings/_cuba.scss`. After making changes in these files, execute the `buildCubaTheme` Gradle task. As a result, a new `cuba.css` will be written to the `styles` directory.

The `buildCubaTheme` task requires the following Ruby gems:

    gem install --no-rdoc --no-ri sass -v 3.4.22
    gem install --no-rdoc --no-ri compass
    gem install zurb-foundation
    
If you get an error like 

    C:/Program Files/Ruby21-x64/lib/ruby/gems/2.1.0/gems/compass-core-1.0.3/lib/compass/core/sass_extensions/functions/urls.rb:5:in `has?': undefined method `has?' for Sass::Util:Module (NoMethodError)
            from C:/Program Files/Ruby21-x64/lib/ruby/gems/2.1.0/gems/compass-core-1.0.3/lib/compass/core/sass_extensions/functions/urls.rb:9:in `included'
            from C:/Program Files/Ruby21-x64/lib/ruby/gems/2.1.0/gems/sass-3.5.0.pre.rc.1/lib/sass/script/functions.rb:632:in `include'

then try to uninstall gem `sass-3.5.0.pre.rc.1` and install `3.4.22`. Perhaps you should also reinstall all the other gems. 

### About PDF generate

The PDF generate is based on the [Asciidoctor PDF](https://asciidoctor.org/docs/asciidoctor-pdf/). This tool is used to generate the main entry adoc file.

In order to keep current path configuration in the main entry adco file, the image folder should be relocated to right place. so the build script copy all necessary source file to the build folder and make all source folder to right relative path.

The second thing need to introduce is the Image in the table. Because there are 2 use cases: Scaling and Visual Component, we have image in the table.

There is an issue for the image in the table without specify the width: <https://github.com/asciidoctor/asciidoctor-pdf/issues/830>. So we add `,pdfwidth=xxin` to these images. This parameter is only useful for PDF generate without affecting HTML generation based on test.

## Viewing Documentation Locally

After installing Tomcat and deploying a document as described above, start the server:

    ./deploy/tomcat/bin/startup.sh 

If you build, for example, manual for version 7.1, it will be available at
[http://localhost:6080/manual-7.1](http://localhost:6080/manual-7.1).  
    
