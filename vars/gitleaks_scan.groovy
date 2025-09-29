def call(String enforce) {
	sh 'gitleaks detect --source . -r gitleaks-report.json -f json || "${enforce}"' 
}
