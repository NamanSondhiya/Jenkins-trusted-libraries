def call(String Env, String projectName, String projectKey) {
    sh "${Env}/bin/sonar-scanner -Dsonar.projectName=${projectName} -Dsonar.projectKey=${projectKey}"
}