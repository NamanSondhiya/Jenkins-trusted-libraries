def call(boolean "break") {
	sh 'gitleaks detect --source . -r gitleaks-report.json -f json || "${break}"'
}
