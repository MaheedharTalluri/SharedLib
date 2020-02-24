def call(){
sh "curl -X PUT http://18.222.66.194:8181/v1/data/jenkins/acl --data-binary @open-policy-agent/JENKINS/BuildPolicy/jenkins-acl.json"
sh "curl -X PUT http://18.222.66.194:8181/v1/policies/myapi --data-binary @open-policy-agent/JENKINS/BuildPolicy/jenkins-policy.rego"
def response = sh(script:'curl -X POST http://18.222.66.194:8181/v1/data/myapi/policy/allow --data-binary "{ "input": { "user": "maheedhar", "access": "build" } }" | jq', returnStdout: true)
println(response)
}