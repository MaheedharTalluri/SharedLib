
def call(){
sh "curl -X PUT http://18.222.66.194:8181/v1/data/myapi/acl --data-binary @open-policy-agent/JENKINS/BuildPolicy/jenkins-acl.json"
sh "curl -X PUT http://18.222.66.194:8181/v1/policies/myapi --data-binary @open-policy-agent/JENKINS/BuildPolicy/jenkins-policy.rego"
sh """curl --location --request POST 'http://18.222.66.194:8181/v1/data/myapi/policy/allow' --header 'Content-Type: application/json' --data-raw '{ "input": { "user": "maheedhar", "access": "build" } }'"""
String response = sh(script:"""curl --location --request POST 'http://18.222.66.194:8181/v1/data/myapi/policy/allow' --header 'Content-Type: application/json' --data-raw '{ "input": { "user": "maheedhar", "access": "build" } }'""", returnStdout: true)
println(response)
if ( response == "{/"result/":true}" )
println("You can build a job")

}
else{
println("You do not have access to trigger a build")
if (!continueBuild) {
    currentBuild.result = 'ABORTED'
}
}