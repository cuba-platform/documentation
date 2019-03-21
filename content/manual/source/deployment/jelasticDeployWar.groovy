task deployWar(type: CubaJelasticDeploy, dependsOn: buildWar){
    email = ****
    password = ****
    hostUrl = 'app.j.layershift.co.uk'
    environment = 'my-env-1'
}