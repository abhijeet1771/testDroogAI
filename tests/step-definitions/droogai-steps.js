/**
 * Step Definitions for DroogAI Feature Tests
 * Implements Gherkin steps for testing DroogAI functionality
 */

const { execSync } = require('child_process');
const fs = require('fs');
const path = require('path');

const DROOG_AI_PATH = 'D:\\DROOG AI';
const TEST_REPO = 'abhijeet1771/testDroogAI';
const MAIN_BRANCH = 'main';

class DroogAISteps {
  constructor() {
    this.reviewOutput = null;
    this.reportData = null;
    this.prNumber = null;
  }

  async droogAIInstalled() {
    try {
      const result = execSync(
        `cd "${DROOG_AI_PATH}" && npm list --depth=0`,
        { encoding: 'utf-8', stdio: 'pipe' }
      );
      return result.includes('@google/generative-ai') || result.includes('droog');
    } catch {
      return false;
    }
  }

  async repositoryAccessible() {
    try {
      const result = execSync(
        `git ls-remote https://github.com/${TEST_REPO}.git`,
        { encoding: 'utf-8', stdio: 'pipe', timeout: 10000 }
      );
      return result.length > 0;
    } catch {
      return false;
    }
  }

  async runDroogAIReview(prNumber, enterprise = true, post = false) {
    this.prNumber = prNumber;
    const flags = enterprise ? '--enterprise' : '';
    const postFlag = post ? '--post' : '';
    
    try {
      this.reviewOutput = execSync(
        `cd "${DROOG_AI_PATH}" && npx tsx src/index.ts review --repo ${TEST_REPO} --pr ${prNumber} ${flags} ${postFlag}`,
        { encoding: 'utf-8', stdio: 'pipe', timeout: 300000, shell: true }
      );
      
      // Try to load report.json
      const reportPath = path.join(DROOG_AI_PATH, 'report.json');
      if (fs.existsSync(reportPath)) {
        this.reportData = JSON.parse(fs.readFileSync(reportPath, 'utf-8'));
      }
      
      return true;
    } catch (error) {
      this.reviewOutput = error.stdout || error.message;
      return false;
    }
  }

  async analyzeReport() {
    if (!this.reportData) {
      const reportPath = path.join(DROOG_AI_PATH, 'report.json');
      if (fs.existsSync(reportPath)) {
        this.reportData = JSON.parse(fs.readFileSync(reportPath, 'utf-8'));
      }
    }
    return this.reportData;
  }

  hasFeature(feature) {
    if (!this.reviewOutput) return false;
    
    const featureChecks = {
      'duplicate detection': /duplicate|similarity/i,
      'breaking changes': /breaking change/i,
      'security issues': /security|vulnerability/i,
      'cross-repo': /cross-repo|cross repository/i,
      'confidence scores': /confidence|average confidence/i,
      'recommendations': /recommendations|RECOMMENDATIONS/i,
    };
    
    const pattern = featureChecks[feature.toLowerCase()];
    return pattern ? pattern.test(this.reviewOutput) : false;
  }

  getReportValue(path) {
    if (!this.reportData) return null;
    
    const keys = path.split('.');
    let value = this.reportData;
    for (const key of keys) {
      if (value && typeof value === 'object' && key in value) {
        value = value[key];
      } else {
        return null;
      }
    }
    return value;
  }
}

// Export step definitions for use in tests
module.exports = { DroogAISteps };

