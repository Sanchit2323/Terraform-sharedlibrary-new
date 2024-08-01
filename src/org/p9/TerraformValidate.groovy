package org.p9

def terraformValidate(script) {
    script.sh 'terraform validate > terraform_validate_report.txt'
}
