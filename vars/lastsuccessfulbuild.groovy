def call(jobname){
sh "curl -s http://18.217.178.163:8080/job/'${jobname}'/lastSuccessfulBuild/api/json --user admin:119767fb81f22e2f10d8594e4201717e53"
}