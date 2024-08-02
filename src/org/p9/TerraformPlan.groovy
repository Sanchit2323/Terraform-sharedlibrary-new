package org.p9

    def call() {
        sh '''
        terraform plan -out=tfplan
        '''
    }
