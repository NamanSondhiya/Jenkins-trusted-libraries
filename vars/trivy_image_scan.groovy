def call(String Project, String Imagetag, String DOCKERHUB_USER) {
    sh  """
        TRIVY_CACHE_DIR=/tmp/trivy-cache

        trivy image --skip-version-check --cache-dir \$TRIVY_CACHE_DIR --timeout 10m -f table -o ${Project}-trivy-image-report.txt ${DOCKERHUB_USER}/${Project}:${Imagetag}
        trivy image --skip-version-check --cache-dir \$TRIVY_CACHE_DIR --timeout 10m -f json -o ${Project}-trivy-image-report.json ${DOCKERHUB_USER}/${Project}:${Imagetag}
        trivy image --skip-version-check --cache-dir \$TRIVY_CACHE_DIR --timeout 10m --exit-code 0 --severity CRITICAL,HIGH ${DOCKERHUB_USER}/${Project}:${Imagetag}
    """
}