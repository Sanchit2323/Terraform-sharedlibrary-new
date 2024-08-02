package org.p9

def call(String tflintPath) {
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
        sh """
        ${tflintPath} --format json > tflint_report.json
        """
    }
}
 
