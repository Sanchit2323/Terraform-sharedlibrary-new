import org.p9.ArchiveReports
import org.p9.CheckovScan
import org.p9.TerraformFormat
import org.p9.TerraformLint
import org.p9.TerraformInit
import org.p9.TerraformValidate

def call(Map params) {
    def REPO_URL = "https://github.com/Sanchit2323/Terra-module-CI.git"

    // Use environment variables for paths
    def CHECKOV_PATH = '/var/lib/jenkins/.local/bin'
    def TFLINT_PATH = '/usr/local/bin/tflint' // Adjust the path if tflint is installed elsewhere

    // Using the passed workspace from the params
    def WORKSPACE = params.WORKSPACE ?: env.WORKSPACE

    // Checkout repository
    checkoutRepo(REPO_URL)

    // Call Terraform operations
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
