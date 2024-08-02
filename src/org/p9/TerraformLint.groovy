package org.p9

def call(script, String tflintPath) {
    script.catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
        script.sh """
            ${tflintPath} --format json > tflint_report.json
        """
    }
}
 
