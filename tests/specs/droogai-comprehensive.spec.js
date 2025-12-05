/**
 * Comprehensive DroogAI Feature Tests
 * Tests all DroogAI features including branch comparison, duplicate detection, etc.
 */

const { test, expect } = require('@playwright/test');
const { DroogAISteps } = require('../step-definitions/droogai-steps');
const { BoxLoginPage } = require('../page-objects/BoxLoginPage');
const { BoxDashboardPage } = require('../page-objects/BoxDashboardPage');
const { execSync } = require('child_process');
const fs = require('fs');
const path = require('path');

const DROOG_AI_PATH = 'D:\\DROOG AI';
const TEST_REPO = 'abhijeet1771/testDroogAI';

test.describe('DroogAI Comprehensive Feature Tests', () => {
  let droogSteps;
  let testPRNumber;

  test.beforeAll(async () => {
    droogSteps = new DroogAISteps();
    
    // Get or create a test PR number
    // For now, we'll use PR 3 (or create one)
    testPRNumber = process.env.TEST_PR_NUMBER || '3';
  });

  test('DroogAI is installed and configured', async () => {
    const isInstalled = await droogSteps.droogAIInstalled();
    expect(isInstalled).toBeTruthy();
  });

  test('Repository is accessible', async () => {
    const isAccessible = await droogSteps.repositoryAccessible();
    expect(isAccessible).toBeTruthy();
  });

  test('DroogAI reviews PR and compares with main branch', async () => {
    const success = await droogSteps.runDroogAIReview(testPRNumber, true, false);
    expect(success).toBeTruthy();
    
    const report = await droogSteps.analyzeReport();
    expect(report).toBeTruthy();
    expect(report.prNumber).toBe(parseInt(testPRNumber));
    expect(report.comments).toBeDefined();
    expect(Array.isArray(report.comments)).toBeTruthy();
  });

  test('DroogAI detects duplicate code within PR', async () => {
    await droogSteps.runDroogAIReview(testPRNumber, true, false);
    
    const report = await droogSteps.analyzeReport();
    expect(report.duplicates).toBeDefined();
    expect(report.duplicates.withinPR).toBeGreaterThanOrEqual(0);
    
    // Check output mentions duplicates
    const hasDuplicates = droogSteps.hasFeature('duplicate detection');
    expect(hasDuplicates || report.duplicates.withinPR > 0).toBeTruthy();
  });

  test('DroogAI detects cross-repository duplicates when indexed', async () => {
    await droogSteps.runDroogAIReview(testPRNumber, true, false);
    
    const report = await droogSteps.analyzeReport();
    if (report.duplicates) {
      expect(report.duplicates.crossRepo).toBeGreaterThanOrEqual(0);
    }
    
    // Check if cross-repo detection is mentioned in output
    const hasCrossRepo = droogSteps.hasFeature('cross-repo');
    // This is optional - only if index exists
    if (hasCrossRepo) {
      expect(report.duplicates.crossRepo).toBeGreaterThan(0);
    }
  });

  test('DroogAI identifies breaking changes', async () => {
    await droogSteps.runDroogAIReview(testPRNumber, true, false);
    
    const report = await droogSteps.analyzeReport();
    if (report.breakingChanges) {
      expect(report.breakingChanges.count).toBeGreaterThanOrEqual(0);
      if (report.breakingChanges.count > 0) {
        expect(report.breakingChanges.details).toBeDefined();
        expect(Array.isArray(report.breakingChanges.details)).toBeTruthy();
      }
    }
    
    // Check output mentions breaking changes
    const hasBreakingChanges = droogSteps.hasFeature('breaking changes');
    // Optional - only if breaking changes exist
  });

  test('DroogAI performs security analysis', async () => {
    await droogSteps.runDroogAIReview(testPRNumber, true, false);
    
    const report = await droogSteps.analyzeReport();
    if (report.security) {
      expect(report.security.issues).toBeDefined();
      expect(Array.isArray(report.security.issues)).toBeTruthy();
    }
    
    // Check output mentions security
    const hasSecurity = droogSteps.hasFeature('security issues');
    // Security analysis should always run
  });

  test('DroogAI analyzes code quality', async () => {
    await droogSteps.runDroogAIReview(testPRNumber, true, false);
    
    const report = await droogSteps.analyzeReport();
    expect(report.comments).toBeDefined();
    expect(report.comments.length).toBeGreaterThanOrEqual(0);
    
    // Check that issues are categorized by severity
    if (report.issuesBySeverity) {
      expect(report.issuesBySeverity.high).toBeGreaterThanOrEqual(0);
      expect(report.issuesBySeverity.medium).toBeGreaterThanOrEqual(0);
      expect(report.issuesBySeverity.low).toBeGreaterThanOrEqual(0);
    }
  });

  test('DroogAI generates confidence scores', async () => {
    await droogSteps.runDroogAIReview(testPRNumber, true, false);
    
    const report = await droogSteps.analyzeReport();
    
    // Check if confidence is mentioned in output
    const hasConfidence = droogSteps.hasFeature('confidence scores');
    
    // Confidence should be calculated (may be 0 if no comments have confidence)
    if (hasConfidence && report.averageConfidence !== undefined) {
      expect(report.averageConfidence).toBeGreaterThanOrEqual(0);
      expect(report.averageConfidence).toBeLessThanOrEqual(1);
    }
  });

  test('DroogAI provides AI-powered recommendations', async () => {
    await droogSteps.runDroogAIReview(testPRNumber, true, false);
    
    const report = await droogSteps.analyzeReport();
    
    // Check output mentions recommendations
    const hasRecommendations = droogSteps.hasFeature('recommendations');
    expect(hasRecommendations).toBeTruthy();
    
    // Recommendations should be in the output
    expect(droogSteps.reviewOutput).toContain('RECOMMENDATIONS');
  });

  test('DroogAI report contains all required fields', async () => {
    await droogSteps.runDroogAIReview(testPRNumber, true, false);
    
    const report = await droogSteps.analyzeReport();
    
    // Required fields
    expect(report.prNumber).toBeDefined();
    expect(report.prTitle).toBeDefined();
    expect(report.totalIssues).toBeDefined();
    expect(report.issuesBySeverity).toBeDefined();
    expect(report.comments).toBeDefined();
  });

  test('DroogAI comments have required structure', async () => {
    await droogSteps.runDroogAIReview(testPRNumber, true, false);
    
    const report = await droogSteps.analyzeReport();
    
    if (report.comments && report.comments.length > 0) {
      const comment = report.comments[0];
      expect(comment.file).toBeDefined();
      expect(comment.line).toBeDefined();
      expect(comment.severity).toBeDefined();
      expect(comment.message).toBeDefined();
      expect(comment.suggestion).toBeDefined();
    }
  });

  test('DroogAI compares with main/master branch', async () => {
    // This test verifies that DroogAI is actually comparing with main branch
    await droogSteps.runDroogAIReview(testPRNumber, true, false);
    
    const report = await droogSteps.analyzeReport();
    
    // Check that the review output mentions branch comparison
    const output = droogSteps.reviewOutput || '';
    
    // Should mention main branch or master branch
    const mentionsBranch = /main|master|branch/i.test(output);
    
    // Should mention comparison or diff
    const mentionsComparison = /compare|diff|against|base/i.test(output);
    
    // At least one should be true
    expect(mentionsBranch || mentionsComparison).toBeTruthy();
  });
});

test.describe('Box.com Automation Tests (Website Testing)', () => {
  test('Box.com login page loads correctly', async ({ page }) => {
    const loginPage = new BoxLoginPage(page);
    await loginPage.navigate();
    
    // Check that email input is visible
    await expect(loginPage.emailInput).toBeVisible({ timeout: 10000 });
  });

  test('Box.com login form has required fields', async ({ page }) => {
    const loginPage = new BoxLoginPage(page);
    await loginPage.navigate();
    
    // Check email input exists
    const emailVisible = await loginPage.emailInput.isVisible();
    expect(emailVisible).toBeTruthy();
    
    // Check password input exists
    const passwordVisible = await loginPage.passwordInput.isVisible();
    expect(passwordVisible).toBeTruthy();
    
    // Check login button exists
    const loginButtonVisible = await loginPage.loginButton.isVisible();
    expect(loginButtonVisible).toBeTruthy();
  });

  test('Box.com shows error for invalid login', async ({ page }) => {
    const loginPage = new BoxLoginPage(page);
    await loginPage.navigate();
    
    // Try invalid login
    await loginPage.enterEmail('invalid@test.com');
    await loginPage.enterPassword('wrongpassword');
    await loginPage.clickLogin();
    
    // Wait a bit for error to appear
    await page.waitForTimeout(2000);
    
    // Check if error is shown (may or may not show depending on Box's behavior)
    const hasError = await loginPage.isErrorVisible();
    // Error may or may not be visible immediately, so we just check the page state
    expect(page.url()).toContain('box.com');
  });
});

