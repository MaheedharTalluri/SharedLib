def call(jobname){
sh "curl -s http://18.219.210.127:8080/job/'${jobname}'/lastSuccessfulBuild/api/json --user admin:119767fb81f22e2f10d8594e4201717e53"
}