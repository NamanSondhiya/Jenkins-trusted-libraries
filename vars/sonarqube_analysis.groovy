def call(String Envir, String projectName, String projectKey) {
    withSonarQubeEnv('Sonar') {
        withCredentials([string(credentialsId:"SonarToken", variable: 'SONAR_TOKEN')]) {
        withEnv(["SONAR_TOKEN=${SONAR_TOKEN}"]) {
            sh """${Envir}/bin/sonar-scanner \
                -Dsonar.projectName=${projectName} \
                -Dsonar.projectKey=${projectKey} \
                -Dsonar.sources=. \
                -Dsonar.exclusions=venv/**,node_modules/** \
                -Dsonar.host.url=\${SONAR_HOST_URL:-http://localhost:9000} \
                -Dsonar.login=\${SONAR_TOKEN}
                """
            }
        }
    }
}