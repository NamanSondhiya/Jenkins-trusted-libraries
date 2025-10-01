def call(String Project, String Imagetag) {
    sh  """
        trivy image -f --skip-check-update table -o trivy-image.txt ${Project}:${Imagetag}
        trivy image --skip-check-update --exit-code 1 --severity CRITICAL,HIGH ${Project}:${Imagetag}
        """
}