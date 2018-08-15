def webThemesModule = project(":${modulePrefix}-web-themes")

configure(webThemesModule) {
  apply(plugin: 'java')
  apply(plugin: 'maven')
  apply(plugin: 'cuba')

  appModuleType = 'web-themes'

  buildDir = file('../build/scss-themes')

  sourceSets {
    main {
      java {
        srcDir '.'
      }
      resources {
        srcDir '.'
      }
    }
  }
}