def call(){
def user = env.BUILD_USER_ID
echo user
sh "sudo nano input.json"
sh "sudo echo '{' > input.json"
sh 'sudo echo '/"${user}/"' > input.json'
sh "sudo echo '}' > input.json"
}