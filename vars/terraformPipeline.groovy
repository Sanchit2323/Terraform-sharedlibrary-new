import org.p9.ArchiveReports
import org.p9.CheckovScan
import org.p9.TerraformFormat
import org.p9.TerraformLint
import org.p9.TerraformInit
import org.p9.TerraformValidate

def terraformInit() {
    new TerraformInit().call()
}

def terraformFormat() {
    new TerraformFormat().call()
}

def terraformValidate() {
    new TerraformValidate().call()
}

def terraformLint(String tflintPath) {
    new TerraformLint().call(tflintPath)
}

def checkovScanCall(script, String checkovPath, String workspace) {
    new CheckovScan(script).call(checkovPath, workspace)
}

def archiveReportsCall(script) {
    new ArchiveReports(script).call()
}
