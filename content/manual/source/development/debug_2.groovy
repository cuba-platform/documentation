dependencies {
    provided(servletApi)
    compile(guiModule)
    debug("com.haulmont.cuba:cuba-web-toolkit:$cubaVersion:debug@zip")
}