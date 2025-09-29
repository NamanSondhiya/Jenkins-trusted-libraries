def call(String Envir, String projectName, String projectKey, String credentialsId) {
    withCredentials([string(credentialsId:"${credentialsId}", variable: 'SONAR_TOKEN')]) {
        withEnv(["SONAR_TOKEN=${SONAR_TOKEN}"]) {
        sh """${Envir}/bin/sonar-scanner \
            -Dsonar.projectName=${projectName} \
            -Dsonar.projectKey=${projectKey} \
            """
        }
    }
}