def call(String enVir, String projectName, String projectKey, String lang = null) {
    withSonarQubeEnv('Sonar') {
        withCredentials([string(credentialsId: "SonarToken", variable: 'SONAR_TOKEN')]) {
            def sonarHost = SONAR_HOST_URL?.trim()
            sh(script: """
                #!/bin/bash
                "${enVir}/bin/sonar-scanner" \
                  -Dsonar.projectName="${projectName}" \
                  -Dsonar.projectKey="${projectKey}" \
                  -Dsonar.sources=. \
                  ${lang ? "-Dsonar.language=${lang}" : ""} \
                  -Dsonar.host.url="${sonarHost}" \
                  -Dsonar.login="$SONAR_TOKEN"
            """, shell: 'bash')
        }
    }
}
