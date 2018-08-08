configure(webModule) {
  // . . .
  task buildScssThemes(type: CubaWebScssThemeCreation)
  task deployThemes(type: CubaDeployThemeTask, dependsOn: buildScssThemes)
  assemble.dependsOn buildScssThemes
}