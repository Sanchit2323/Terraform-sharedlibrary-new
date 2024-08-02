import org.p9.ArchiveReports
import org.p9.CheckovScan
import org.p9.TerraformFormat
import org.p9.TerraformLint
import org.p9.TerraformInit
import org.p9.TerraformValidate

def call(Map params) {
    def REPO_URL = "https://github.com/Sanchit2323/Terra-module-CI.git"
    
    pipeline {
        agent any
        environment {
            CHECKOV_PATH = '/var/lib/jenkins/.local/bin'
            TFLINT_PATH = '/usr/local/bin/tflint' // Adjust the path if tflint is installed elsewhere
            REPO_URL = "${REPO_URL}"
        }
    
def checkoutRepo(String repoUrl) {
    script {
        echo "Checking out repository: ${repoUrl}"
        git url: repoUrl, branch: 'main'
    }
}

def terraformInitCall(script) {
    new TerraformInit(script).call()
}

def terraformFormatCall(script) {
    new TerraformFormat(script).call()
}

def terraformValidateCall(script) {
    new TerraformValidate(script).call()
}

def terraformLintCall(script, String tflintPath) {
    new TerraformLint(script).call(tflintPath)
}

def checkovScanCall(script, String checkovPath, String workspace) {
    new CheckovScan(script).call(checkovPath, workspace)
}

def archiveReportsCall(script) {
    new ArchiveReports(script).call()
}
