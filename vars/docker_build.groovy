def call(String Project, String ImageTag, String DOCKERHUB_USER, String buildContext = ".") {
    sh "docker build -t ${DOCKERHUB_USER}/${Project}:${ImageTag} ${buildContext}"
}
