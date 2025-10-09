def call(String Project, String Imagetag, String DOCKERHUB_USER) {
    sh  """
        trivy image --skip-version-check -f table -o ${Project}-trivy-image-report.txt ${DOCKERHUB_USER}/${Project}:${Imagetag}
        trivy image --skip-version-check -f json -o ${Project}-tirvy-image-report.json ${DOCKERHUB_USER}/${Project}:${Imagetag}
        trivy image --skip-version-check --exit-code 0 --severity CRITICAL,HIGH ${DOCKERHUB_USER}/${Project}:${Imagetag}
        """
}