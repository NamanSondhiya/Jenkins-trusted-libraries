def call(String Project, String Imagetag) {
    sh  """
        trivy image -f table -o trivy-image.txt ${Project}:${Imagetag}
        trivy image --exit-code 1 --severity CRITICAL,HIGH ${Project}:${Imagetag}
        """
}