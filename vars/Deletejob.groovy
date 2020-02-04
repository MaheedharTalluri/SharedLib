def call(jobname){
sh "curl -X POST http://18.219.210.127:8080/job/'${jobname}'/doDelete -u admin:119767fb81f22e2f10d8594e4201717e53"
}