import org.p9.ArchiveReports
import org.p9.CheckovScan
import org.p9.TerraformFormat
import org.p9.TerraformLint
import org.p9.TerraformInit
import org.p9.TerraformValidate

def terraformInit() {
    new TerraformInit().call()
}

def terraformFormatCall() {
    new TerraformFormat().call()
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
