import org.p9.ArchiveReports
import org.p9.CheckovScan
import org.p9.TerraformFormat
import org.p9.TerraformLint
import org.p9.TerraformInit
import org.p9.TerraformValidate

def call(Map params) {
    def REPO_URL = "https://github.com/Sanchit2323/Terra-module-CI.git"

    def CHECKOV_PATH = '/var/lib/jenkins/.local/bin'
    def TFLINT_PATH = '/usr/local/bin/tflint' // Adjust the path if tflint is installed elsewhere
    def WORKSPACE = params.WORKSPACE

    checkoutRepo(REPO_URL)
    terraformInitCall(this)
    terraformFormatCall(this)
    terraformValidateCall(this)
    terraformLintCall(this, TFLINT_PATH)
    checkovScanCall(this, CHECKOV_PATH, WORKSPACE)
    archiveReportsCall(this)
}

def checkoutRepo(String repoUrl) {
    script {
        echo "Checking out repository: ${repoUrl}"
        git url: "${repoUrl}", branch: 'main'
    }
}

def terraformInitCall(script) {
    new TerraformInit().call(script)
}

def terraformFormatCall(script) {
    new TerraformFormat().call(script)
}

def terraformValidateCall(script) {
    new TerraformValidate().call(script)
}

def terraformLintCall(script, String tflintPath) {
    new TerraformLint().call(script, tflintPath)
}

def checkovScanCall(script, String checkovPath, String workspace) {
    new CheckovScan().call(script, checkovPath, workspace)
}

def archiveReportsCall(script) {
    new ArchiveReports().call(script)
}
