package org.p9

class CheckovScan {
    def call(script, String checkovPath, String workspace) {
        script.catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
            script.sh """
                cd ${workspace}
                ${checkovPath}/checkov -d . -s --output-file-path checkov_report.json
            """
            script.sh 'ls -l'
        }
    }
}
