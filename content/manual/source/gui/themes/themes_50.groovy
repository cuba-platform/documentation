include(":${modulePrefix}-global", ":${modulePrefix}-core", ":${modulePrefix}-web", ":${modulePrefix}-web-themes")
//...
project(":${modulePrefix}-web-themes").projectDir = new File(settingsDir, 'modules/web/themes')