configure(webModule) {
    ''' '''
    dependencies {
        provided(servletApi)
        compile(guiModule)

        compile('com.haulmont.theme:halo-facebook:0.1')
        themes('com.haulmont.theme:halo-facebook:0.1')
    }
    ''' '''
}