package org.p9

class ArchiveReports.groovy implements Serializable {
    def script
    ArchiveReports(script) {
        this.script = script
    }

    def archiveReports() {
        archiveArtifacts artifacts: 'terraform_fmt_report.txt, terraform_validate_report.txt, checkov_report.json, tflint_report.json', allowEmptyArchive: true
    }
}
