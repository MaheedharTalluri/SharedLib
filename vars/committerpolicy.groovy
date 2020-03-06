def call(committername,branch){
sh "curl -X PUT http://18.221.205.57:8181/v1/data/metrics --data-binary @open-policy-agent/METRICS/COMMITTER-BASED/metrics-data.json"
sh "curl -X PUT http://18.221.205.57:8181/v1/policies/metrics --data-binary @open-policy-agent/METRICS/COMMITTER-BASED/metrics.rego"
String response = sh(script:"""curl --location --request POST 'http://18.221.205.57:8181/v1/data/metrics/policy/foo' --header 'Content-Type: application/json' --data-raw '{"committer":[{"name":"'${committername}'","branch_name":"'${branch}'"}]}'""", returnStdout: true)
println(response)
}