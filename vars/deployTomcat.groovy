def call(ip,user,credId){
   sshagent([credId]) {
      sh "mv target/myweb-0.0.9.war target/myapp.war"
      sh "scp target/myapp.war ${user}@${ip}:/opt/tomcat9/webapps"
      sh "ssh ${user}@${ip} /opt/tomcat9/bin/shutdown.sh"
      sh "ssh ${user}@${ip} /opt/tomcat9/bin/startup.sh"
  } 
}
