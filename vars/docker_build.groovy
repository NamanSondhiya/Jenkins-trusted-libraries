def call(String Project, String ImageTag, String DOCKERHUB_USER) {
    sh "docker build -t ${DOCKERHUB_USER}/${Project}:${ImageTag} ."
}