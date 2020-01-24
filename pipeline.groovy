pipeline {
  agent {
    node {
      label " "
    }
  }
  stages {
    stage("*****STAGE_1*****") {
      steps {
        script {
          def workspace = "/var/lib/jenkins/workspace/InstallDocker"
          sh "chmod ugo+rwx $workspace/*"
          sh "ansible -m setup servers > $workspace/Ansible_env_variables.txt"
          sh "cat $workspace/Ansible_env_variables.txt"
          sh "ansible-playbook -i " + "inventory" + " " + "$workspace/Docker/install-docker.yaml"
      }
     }
    }
    stage("*****STAGE_2*****") {
      steps {
        script {
          sh "echo "THIS IS STAGE_2""
       }        
     }
    }
   }
}
