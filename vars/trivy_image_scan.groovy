def call(String Project, String Imagetag) {
    sh  """
        trivy image --skip-check-update -f table -o trivy-image.txt ${Project}:${Imagetag}
        trivy image --skip-check-update --exit-code 1 --severity CRITICAL,HIGH ${Project}:${Imagetag}
        """
}