/**
 * If you have a multi-project build, make sure to apply the plugin and the plugin configuration
        to every project which artifacts you want to publish to Bintray.
 */
subprojects {
    apply plugin: 'com.jfrog.bintray'

    bintray {
        user = project.hasProperty('bintrayUser') ? project.property('bintrayUser') : System.getenv('BINTRAY_USER')
        key = project.hasProperty('bintrayApiKey') ? project.property('bintrayApiKey') : System.getenv('BINTRAY_API_KEY')

        configurations = ['archives']

        // make files public ?
        publish = true
        // override existing artifacts?
        override = false

        // metadata
        pkg {
            repo = 'main'           // your repository name
            name = 'amazingsearch'  // package name - it will be created upon upload
            desc = 'AmasingSearch'  // optional package description

            // organization name, if your repository is created inside an organization.
            // remove this parameter if you don't have an organization
            userOrg = 'jupiter-org'

            websiteUrl = 'https://github.com/jupiter/amazing-search'
            issueTrackerUrl = 'https://github.com/jupiter/amazing-search/issues'
            vcsUrl = 'https://github.com/jupiter/amazing-search.git' // mandatory for Open Source projects

            licenses = ["Apache-2.0"]
            labels = ['cuba-platform', 'opensource']

            //githubRepo = 'amazingsearch/cuba-platform' // optional Github repository
            //githubReleaseNotesFile = 'README.md' // optional Github readme file
        }
    }
}