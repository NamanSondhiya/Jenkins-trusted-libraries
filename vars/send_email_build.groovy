def call(String recipient, String frontendTag = "", String backendTag = "", String attachments = "") {
    emailext(
        subject: "${currentBuild.currentResult}: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
        body: """
              Build Status: ${currentBuild.currentResult}
              Project: ${env.JOB_NAME}
              Build Number: #${env.BUILD_NUMBER}
              Frontend Tag: ${frontendTag}
              Backend Tag: ${backendTag}
              Build URL: ${env.BUILD_URL}
              """,
        to: recipient,
        attachmentsPattern: attachments
    )
}
