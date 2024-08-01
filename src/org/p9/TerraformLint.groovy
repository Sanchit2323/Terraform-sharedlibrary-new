package org.p9

def terraformLint(script) {
    script.catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
    script.sh """
                ${tflintPath} --format json > tflint_report.json
            """
    }
}  
