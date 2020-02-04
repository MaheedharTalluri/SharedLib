def call(jsondata){
def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.ci.jobs.job.job_name)
String a=jsonObj.ci.jobs.job.job_name

String jobname=a.replaceAll("\\[", "").replaceAll("\\]","");
String b=jsonObj.ci.jobs.job.dsl_fileName
String dslfilename=b.replaceAll("\\[", "").replaceAll("\\]","");
env.DSL_NAME = dslfilename
env.JENKINS_NAME = jobname


sh "rm -rf Text.xml"




sh 'curl -O https://repo.jenkins-ci.org/public/org/jenkins-ci/plugins/job-dsl-core/1.76/job-dsl-core-1.76-standalone.jar'

sh "java -jar job-dsl-core-1.76-standalone.jar '${dsl}'"

url='http://18.221.47.136:8080/createItem?name='+jobname
sh "echo ${url}"
sh "curl -s -XPOST  '$url' -u admin:119767fb81f22e2f10d8594e4201717e53 --data-binary @Test.xml -H Content-Type:text/xml"







}





