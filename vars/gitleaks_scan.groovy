def call(boolean enforce) {
	sh 'gitleaks detect --source . -r gitleaks-report.json -f json || enforce' 
}
