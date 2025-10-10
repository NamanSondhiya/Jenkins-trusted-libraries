def call(String Project, String ImageTag, String DockerUserParam) {
    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKERHUB_USER', passwordVariable: 'DOCKERHUB_PASS')]) {
        sh """
        echo "\$DOCKERHUB_PASS" | docker login -u "\$DOCKERHUB_USER" --password-stdin
        docker push "\$DOCKERHUB_USER/${Project}:${ImageTag}"
        """
    }
}
