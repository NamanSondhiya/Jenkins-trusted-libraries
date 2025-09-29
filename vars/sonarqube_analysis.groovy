def call(String Env, String projectName, String projectKey, String credentialsId) {
    withCredentials([string(credentialsId:"${credentialsId}", variable: 'SONAR_TOKEN')]) {
        sh """${Env}/bin/sonar-scanner \
            -Dsonar.projectName=${projectName} \
            -Dsonar.projectKey=${projectKey} \
            -Dsonar.login=$SONAR_TOKEN """
    }
}