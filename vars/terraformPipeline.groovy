import org.p9.ArchiveReports
import org.p9.CheckovScan
import org.p9.TerraformFormat
import org.p9.TerraformLint
import org.p9.TerraformInit
import org.p9.TerraformValidate
import org.p9.TerraformPlan

def terraformInit() {
    new TerraformInit().call()
}

def terraformFormat() {
    new TerraformFormat().call()
}

def terraformValidate() {
    new TerraformValidate().call()
}

def terraformLint(String TFLINT_PATH) {
    new TerraformLint().call(TFLINT_PATH)
}

def checkovScan(String checkovPath, String workspace) {
    new CheckovScan().call(checkovPath, workspace)
}

def archiveReports() {
    new ArchiveReports().call()
}

def terraformPlan() {
    new TerraformPlan().call()
}

def terraformApply() {
    new TerraformApply().call()
}
