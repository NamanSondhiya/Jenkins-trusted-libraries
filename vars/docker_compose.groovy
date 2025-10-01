def call(){
  sh "docker-compose down && docker-compose up -d > logs.txt"
}
