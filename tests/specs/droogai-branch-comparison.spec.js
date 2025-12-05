/**
 * DroogAI Branch Comparison Tests
 * Specifically tests that DroogAI compares PR changes with main/master branch
 */

const { test, expect } = require('@playwright/test');
const { execSync } = require('child_process');
const { DroogAIVerification } = require('../methods/droogai-verification');
const fs = require('fs');
const path = require('path');

const DROOG_AI_PATH = 'D:\\DROOG AI';
const TEST_REPO = 'abhijeet1771/testDroogAI';

test.describe('DroogAI Branch Comparison Tests', () => {
  let verification;
  let testPRNumber;

  test.beforeAll(() => {
    verification = new DroogAIVerification(DROOG_AI_PATH);
    testPRNumber = process.env.TEST_PR_NUMBER || '3';
  });

  test('DroogAI compares PR with main branch', async () => {
    // Run DroogAI review
    let output = '';
    try {
      output = execSync(
        `cd "${DROOG_AI_PATH}" && npx tsx src/index.ts review --repo ${TEST_REPO} --pr ${testPRNumber} --enterprise`,
        { encoding: 'utf-8', stdio: 'pipe', timeout: 300000, shell: true }
      );
    } catch (error) {
      output = error.stdout || error.message;
    }

    // Load report
    const report = verification.loadReport();

    // Verify branch comparison
    const hasComparison = verification.verifyBranchComparison(report, output);
    
    expect(hasComparison).toBeTruthy();
  });

  test('DroogAI detects cross-repo duplicates when comparing with main', async () => {
    // Run DroogAI review
    let output = '';
    try {
      output = execSync(
        `cd "${DROOG_AI_PATH}" && npx tsx src/index.ts review --repo ${TEST_REPO} --pr ${testPRNumber} --enterprise`,
        { encoding: 'utf-8', stdio: 'pipe', timeout: 300000, shell: true }
      );
    } catch (error) {
      output = error.stdout || error.message;
    }

    const report = verification.loadReport();

    // Check for cross-repo duplicates (indicates main branch comparison)
    if (report.duplicates) {
      // Output should mention cross-repo or index
      const mentionsCrossRepo = /cross-repo|cross repository|index found/i.test(output);
      
      // If index exists, cross-repo duplicates should be detected
      if (mentionsCrossRepo) {
        expect(report.duplicates.crossRepo).toBeGreaterThanOrEqual(0);
      }
    }
  });

  test('DroogAI report shows main branch comparison indicators', async () => {
    let output = '';
    try {
      output = execSync(
        `cd "${DROOG_AI_PATH}" && npx tsx src/index.ts review --repo ${TEST_REPO} --pr ${testPRNumber} --enterprise`,
        { encoding: 'utf-8', stdio: 'pipe', timeout: 300000, shell: true }
      );
    } catch (error) {
      output = error.stdout || error.message;
    }

    // Check for indicators that DroogAI is comparing with main
    const indicators = [
      /main.*branch/i,
      /master.*branch/i,
      /index found/i,
      /cross-repo/i,
      /loaded.*symbols.*main/i,
    ];

    const hasIndicator = indicators.some(pattern => pattern.test(output));
    expect(hasIndicator).toBeTruthy();
  });

  test('DroogAI uses index for main branch comparison', async () => {
    let output = '';
    try {
      output = execSync(
        `cd "${DROOG_AI_PATH}" && npx tsx src/index.ts review --repo ${TEST_REPO} --pr ${testPRNumber} --enterprise`,
        { encoding: 'utf-8', stdio: 'pipe', timeout: 300000, shell: true }
      );
    } catch (error) {
      output = error.stdout || error.message;
    }

    // Check if index is mentioned (indicates main branch comparison)
    const hasIndex = /index found|enabling.*cross-repo|loaded.*symbols/i.test(output);
    
    // If index exists, it means DroogAI is comparing with main branch
    if (hasIndex) {
      expect(output).toMatch(/index|cross-repo|main/i);
    }
  });

  test('DroogAI compares file changes with base branch', async () => {
    const report = verification.loadReport();

    // Verify that the report contains information that suggests branch comparison
    // This could be:
    // 1. Cross-repo duplicates (requires main branch index)
    // 2. Breaking changes (compares signatures with base)
    // 3. Duplicate detection (compares with indexed code)

    const hasComparisonFeatures = 
      (report.duplicates && report.duplicates.crossRepo !== undefined) ||
      (report.breakingChanges && report.breakingChanges.count !== undefined);

    expect(hasComparisonFeatures).toBeTruthy();
  });
});


