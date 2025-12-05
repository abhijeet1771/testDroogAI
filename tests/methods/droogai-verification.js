/**
 * DroogAI Verification Methods
 * Helper methods to verify DroogAI functionality
 */

const fs = require('fs');
const path = require('path');

class DroogAIVerification {
  constructor(droogAIPath = 'D:\\DROOG AI') {
    this.droogAIPath = droogAIPath;
    this.reportPath = path.join(droogAIPath, 'report.json');
  }

  /**
   * Verify report.json exists and is valid
   */
  verifyReportExists() {
    return fs.existsSync(this.reportPath);
  }

  /**
   * Load and parse report.json
   */
  loadReport() {
    if (!this.verifyReportExists()) {
      throw new Error('report.json does not exist');
    }
    
    const content = fs.readFileSync(this.reportPath, 'utf-8');
    return JSON.parse(content);
  }

  /**
   * Verify report structure
   */
  verifyReportStructure(report) {
    const requiredFields = [
      'prNumber',
      'prTitle',
      'totalIssues',
      'issuesBySeverity',
      'comments',
    ];
    
    for (const field of requiredFields) {
      if (!(field in report)) {
        throw new Error(`Missing required field: ${field}`);
      }
    }
    
    return true;
  }

  /**
   * Verify comments structure
   */
  verifyCommentsStructure(comments) {
    if (!Array.isArray(comments)) {
      throw new Error('Comments must be an array');
    }
    
    const requiredFields = ['file', 'line', 'severity', 'message', 'suggestion'];
    
    for (const comment of comments) {
      for (const field of requiredFields) {
        if (!(field in comment)) {
          throw new Error(`Comment missing required field: ${field}`);
        }
      }
    }
    
    return true;
  }

  /**
   * Verify DroogAI compared with main branch
   */
  verifyBranchComparison(report, output) {
    // Check for branch comparison indicators
    const indicators = [
      /main.*branch/i,
      /master.*branch/i,
      /base.*branch/i,
      /compare.*main/i,
      /compare.*master/i,
      /cross-repo/i,
      /cross repository/i,
    ];
    
    const hasComparison = indicators.some(pattern => pattern.test(output));
    
    // Also check report for duplicate cross-repo data
    const hasCrossRepo = report.duplicates && report.duplicates.crossRepo > 0;
    
    return hasComparison || hasCrossRepo;
  }

  /**
   * Verify duplicate detection
   */
  verifyDuplicateDetection(report) {
    if (!report.duplicates) {
      return false;
    }
    
    return (
      typeof report.duplicates.withinPR === 'number' &&
      typeof report.duplicates.crossRepo === 'number' &&
      report.duplicates.withinPR >= 0 &&
      report.duplicates.crossRepo >= 0
    );
  }

  /**
   * Verify breaking change detection
   */
  verifyBreakingChangeDetection(report) {
    if (!report.breakingChanges) {
      return true; // Optional feature
    }
    
    return (
      typeof report.breakingChanges.count === 'number' &&
      report.breakingChanges.count >= 0
    );
  }

  /**
   * Verify security analysis
   */
  verifySecurityAnalysis(report) {
    if (!report.security) {
      return true; // Optional feature
    }
    
    return (
      Array.isArray(report.security.issues) &&
      typeof report.security.issues.length === 'number'
    );
  }

  /**
   * Verify all DroogAI features
   */
  verifyAllFeatures(report, output) {
    const results = {
      reportExists: this.verifyReportExists(),
      reportStructure: this.verifyReportStructure(report),
      commentsStructure: this.verifyCommentsStructure(report.comments),
      branchComparison: this.verifyBranchComparison(report, output),
      duplicateDetection: this.verifyDuplicateDetection(report),
      breakingChanges: this.verifyBreakingChangeDetection(report),
      securityAnalysis: this.verifySecurityAnalysis(report),
    };
    
    return results;
  }

  /**
   * Generate verification report
   */
  generateVerificationReport(report, output) {
    const verification = this.verifyAllFeatures(report, output);
    
    const reportText = `
DroogAI Verification Report
===========================

Report Exists: ${verification.reportExists ? '✅' : '❌'}
Report Structure: ${verification.reportStructure ? '✅' : '❌'}
Comments Structure: ${verification.commentsStructure ? '✅' : '❌'}
Branch Comparison: ${verification.branchComparison ? '✅' : '❌'}
Duplicate Detection: ${verification.duplicateDetection ? '✅' : '❌'}
Breaking Changes: ${verification.breakingChanges ? '✅' : '❌'}
Security Analysis: ${verification.securityAnalysis ? '✅' : '❌'}

Overall: ${Object.values(verification).every(v => v) ? '✅ PASS' : '⚠️ PARTIAL'}
`;
    
    return reportText;
  }
}

module.exports = { DroogAIVerification };


