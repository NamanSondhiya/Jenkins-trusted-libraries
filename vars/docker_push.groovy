def call(String Project, String ImageTag, String DOCKERHUB_USER){
  withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', passwordVariable: 'DOCKERHUB_PASS', usernameVariable: 'DOCKERHUB_USER')]) {
      sh "docker login -u ${DOCKERHUB_USER} -p ${DOCKERHUB_PASS}"
  }
  sh "docker push ${DOCKERHUB_USER}/${Project}:${ImageTag}"
}
