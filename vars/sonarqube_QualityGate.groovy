def call(int time, boolean abortPipeline) {
  timeout(time: time, unit: "MINUTES"){
      waitForQualityGate abortPipeline: "${abortPipeline}"
  }
}
