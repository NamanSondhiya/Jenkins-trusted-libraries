def call(){
  sh "trivy fs . > trivy-fs-report.txt"
}
