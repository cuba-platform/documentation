task buildImage(type: DockerBuildImage, dependsOn: createDockerfile) {
    inputDir = createDockerfile.destFile.parentFile
    tags = ['sample-sales', '{docker-hub-username}/{default-repo-folder-name}:sample-sales']
    registryCredentials = dockerRegistryCredentials
}

task pushImage(type: DockerPushImage, dependsOn: buildImage) {
    tag = 'sample-sales'
    imageName = '{docker-hub-username}/{default-repo-folder-name}'
    registryCredentials = dockerRegistryCredentials
}