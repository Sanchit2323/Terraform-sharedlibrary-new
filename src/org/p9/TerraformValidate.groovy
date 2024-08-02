package org.p9

def call() {
    sh '''
    terraform validate > terraform_validate_report.txt
    '''
}

