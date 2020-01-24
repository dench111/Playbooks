pipeline {
  agent {
    node {
      label " "
    }
  }
  stages {
    stage("STAGE_#1") {
      steps {
        script {
          def workspace = "/var/lib/jenkins/workspace/InstallDocker"
          sh "chmod ugo+rwx $workspace/*"
          sh "ansible -m setup servers > $workspace/Ansible_env_variables.txt"
          sh "ansible-playbook -i " + "inventory" + " " + "$workspace/install-docker.yaml.yml"
      }
     }
    }
    stage("STAGE_#2") {
      steps {
        script {
          sh "echo "THIS IS STAGE_#2""
       }        
     }
    }
   }
}
