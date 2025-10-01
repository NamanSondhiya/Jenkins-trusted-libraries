def call(String Project, String Imagetag, String DOCKERHUB_USER) {
    sh  """
        trivy image --skip-version-check -f table -o trivy-image.txt ${DOCKERHUB_USER}/${Project}:${Imagetag}
        trivy image --skip-version-check --exit-code 1 --severity CRITICAL,HIGH ${DOCKERHUB_USER}/${Project}:${Imagetag}
        """
}