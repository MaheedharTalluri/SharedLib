def call(jsondata){
def jsonString = jsondata
println(jsonString)
def jsonObj = readJSON text: jsonString
println(jsonObj.ci)
String a=jsonObj.ci.jobs.job.job_name

String jobname=a.replaceAll("\\[", "").replaceAll("\\]","");
String b=jsonObj.ci.jobs.job.dsl_fileName
String dslfilename=b.replaceAll("\\[", "").replaceAll("\\]","");

String c=jsonObj.ci.jobs.job.job_type
String jobtype=c.replaceAll("\\[", "").replaceAll("\\]","");




sh "rm -rf Text.xml"




sh 'curl -O https://repo.jenkins-ci.org/public/org/jenkins-ci/plugins/job-dsl-core/1.76/job-dsl-core-1.76-standalone.jar'

if ( jobtype == "freestyle" )
{
sh "java -jar job-dsl-core-1.76-standalone.jar freestyle.groovy"
}
if ( jobtype == "pipeline" )
{
sh "java -jar job-dsl-core-1.76-standalone.jar pipeline.groovy"
}


jurl='curl -XGET http://18.221.47.136:8080/checkJobName?value='+jobname+' --user admin:119767fb81f22e2f10d8594e4201717e53'


def var = sh(script: "'${jurl}'", returnStdout: true)


//def response = sh(script: 'curl -XGET http://18.221.47.136:8080/checkJobName?value=EDN250 --user admin:119767fb81f22e2f10d8594e4201717e53', returnStdout: true)

//println(response)

println(var)







url='http://18.221.47.136:8080/createItem?name='+jobname
sh "echo ${url}"
sh "curl -s -XPOST  '$url' -u admin:119767fb81f22e2f10d8594e4201717e53 --data-binary @Test.xml -H Content-Type:text/xml"
}





