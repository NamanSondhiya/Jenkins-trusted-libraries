def call(String enVir, String projectName, String projectKey, String lang = null) {
    withSonarQubeEnv('Sonar') {
        withCredentials([string(credentialsId: "SonarToken", variable: 'SONAR_TOKEN')]) {
            sh """
                ${enVir}/bin/sonar-scanner \
                -Dsonar.projectName=${projectName} \
                -Dsonar.projectKey=${projectKey} \
                -Dsonar.sources=. \
                ${lang ? "-Dsonar.language=${lang}" : ""} \
                -Dsonar.host.url=${SONAR_HOST_URL} \
                -Dsonar.login=${SONAR_TOKEN}
            """
        }
    }
}
