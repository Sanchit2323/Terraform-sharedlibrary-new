package org.p9

def call(script) {
    script.sh 'terraform validate > terraform_validate_report.txt'
}

