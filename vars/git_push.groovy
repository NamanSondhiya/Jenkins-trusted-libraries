def call(String GitUrl, String GitBranch) {
    withCredentials([usernamePassword(credentialsId: 'github-creds', usernameVariable: 'GIT_USER', passwordVariable: 'GIT_TOKEN')]) {
        sh """
        git config --global user.email "ssnaman4@gmail.com"
        git config --global user.name "jenkins"
        git remote set-url origin https://${GIT_USER}:${GIT_TOKEN}@${GitUrl.replaceFirst(/^https?:\\/\\//, '')}
        git add .
        git commit -m "Updated image tags via Jenkins-CD build ${BUILD_NUMBER}" || echo "No changes to commit"
        git push https://${GIT_USER}:${GIT_TOKEN}@${GitUrl.replaceFirst(/^https?:\\/\\//, '')} ${GitBranch}
        """
    }
}
