def call(String Project, String Imagetag) {
    sh  """
        trivy image --skip-version-check -f table -o trivy-image.txt ${Project}:${Imagetag}
        trivy image --skip-version-check --exit-code 1 --severity CRITICAL,HIGH ${Project}:${Imagetag}
        """
}