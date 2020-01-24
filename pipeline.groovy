pipeline {
  agent {
    node {
      label " "
    }
  }
  stages {
    stage("Install env and elasticsearch on servers") {
      steps {
        script {
          def workspace = "/var/lib/jenkins/workspace/Ansible_Git"
          sh "chmod ugo+rwx $workspace/*"
          sh "ansible -m setup servers > $workspace/Ansible_env_variables.txt"
          sh "ansible-playbook -i " + "inventory" + " " + "$workspace/Elastic-install-pb.yml"
      }
     }
    }
    stage("Congigurating elasticsearch nodes") {
      steps {
        script {
          def workspace = "/var/lib/jenkins/workspace/Ansible_Git"
          sh "chmod ugo+rwx $workspace/*"
          sh "ansible-playbook -i " + "inventory" + " " + "$workspace/Elastic_Nodes-conf-pb.yml"
       }        
     }
    }
   }
}
