package org.p9

def call(String checkovPath, String workspace) {
    catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
    sh """
    cd ${workspace}
       ${checkovPath}/checkov -d . -s --output-file-path checkov_report.json
       ls -l
    """
    }
}
