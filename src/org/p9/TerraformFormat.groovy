package org.p9

def terraformFormat(script) {
    script.catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
            script.sh 'terraform fmt -check -diff > terraform_fmt_report.txt'
    }
}
