cuba {
    artifact {
        group = 'com.company.sales'
        version = '0.1'
        isSnapshot = true
    }
    tomcat {
        dir = "$project.rootDir/build/tomcat"
    }
    ide {
        copyright = '...'
        classComment = '...'
        vcs = 'Git'
    }
}
