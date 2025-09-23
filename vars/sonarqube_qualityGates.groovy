def call(String abortPipeline){
  timeout(time: 1, unit: "MINUTES"){
      waitForQualityGate abortPipeline: "$(abortPipeline)"
  }
}
