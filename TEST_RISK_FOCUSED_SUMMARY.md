# Test Scenarios: Risk-Focused Summary Features

This branch also tests DroogAI's risk-focused summary features:
1. **Impact Analysis** - What will break?
2. **Test Cases That Will Fail**
3. **Performance Regressions**
4. **Breaking Changes**

## Test Files for Risk-Focused Summary

### Negative Scenarios (Should Show "WILL BREAK")

#### Breaking Changes
- `BreakingChangesService.java` - Contains:
  - Method signature changes (parameter added)
  - Visibility reduction (public → private)
  - Return type changes (String → int)
  - Parameter type changes (Long → String)
  - Method removals

#### Files That Will Break (Call Sites)
- `CallingService.java` - Calls breaking methods:
  - Calls `processData()` with old signature (missing parameter)
  - Calls `getUserInfo()` which is now private
  - Calls `getStatus()` expecting String but gets int
  - Calls `updateUser()` with Long but expects String

- `OrderProcessingService.java` - Multiple call sites:
  - Line 15: Calls `processData()` with old signature
  - Line 20: Calls `getUserInfo()` (now private)
  - Line 26: Calls `getStatus()` with wrong return type

- `PaymentProcessingService.java` - More call sites:
  - Line 12: Calls `processData()` with old signature
  - Line 17: Calls `updateUser()` with wrong parameter type

#### Features That Will Break
- `FeatureService.java` - Represents features that will fail:
  - User Management Feature (depends on getUserInfo)
  - Data Processing Feature (depends on processData)
  - Status Checking Feature (depends on getStatus)

#### Tests That Will Fail
- `BreakingChangesServiceTest.java` - Tests that will fail:
  - `testProcessData()` - Calls method with old signature
  - `testGetUserInfo()` - Calls private method
  - `testGetStatus()` - Expects String, gets int
  - `testUpdateUser()` - Passes Long, expects String

- `OrderServiceTest.java` - More failing tests:
  - `testOrderProcessing()` - Calls breaking method

#### Performance Regressions
- `PerformanceRegressionService.java` - Contains:
  - N+1 query problem (getOrdersWithUsers)
  - String concatenation in loop (buildMessage)
  - Excessive object creation (processItems)
  - High complexity increase (complexProcessing)

### Positive Scenarios (Should NOT Show "WILL BREAK")

#### Safe Changes
- `SafeService.java` - Contains:
  - New methods (not breaking)
  - Unchanged methods (safe)
  - Private method changes (safe)
  - Performance improvements (StringBuilder, batch queries)

- `SafeServiceTest.java` - Tests that should pass:
  - All tests should pass - no breaking changes

## Expected Results

When running DroogAI review, you should see in the summary:

### 🚨 What Will Break?
- **Affected Features:**
  - User Management Feature (HIGH RISK)
  - Data Processing Feature (HIGH RISK)
  - Status Checking Feature (HIGH RISK)
- **Files that will fail:**
  - `CallingService.java`
  - `OrderProcessingService.java`
  - `PaymentProcessingService.java`
- **Exact locations:**
  - Multiple call sites listed with line numbers

### 🧪 Test Cases That WILL FAIL
- `BreakingChangesServiceTest::testProcessData` (HIGH probability)
- `BreakingChangesServiceTest::testGetUserInfo` (HIGH probability)
- `BreakingChangesServiceTest::testGetStatus` (HIGH probability)
- `OrderServiceTest::testOrderProcessing` (HIGH probability)

### ⚡ Performance Regressions
- `PerformanceRegressionService::getOrdersWithUsers` - N+1 query problem
- `PerformanceRegressionService::buildMessage` - String concatenation in loop
- `PerformanceRegressionService::processItems` - Excessive object creation
- `PerformanceRegressionService::complexProcessing` - High complexity

### 💥 Breaking Changes
- `BreakingChangesService::processData` - Signature changed
- `BreakingChangesService::getUserInfo` - Visibility reduced
- `BreakingChangesService::getStatus` - Return type changed
- `BreakingChangesService::updateUser` - Parameter type changed

### ✅ Safe Files (Should NOT appear in "What Will Break")
- `SafeService.java` - No breaking changes
- `SafeServiceTest.java` - All tests should pass

## How to Test

```bash
# From DroogAI directory
npx tsx src/index.ts review --repo abhijeet1771/testDroogAI --pr <PR_NUMBER> --enterprise --post
```

The summary should focus on:
1. What will break
2. Which features will fail
3. Which tests will fail
4. Performance regressions
5. Breaking changes with impact scores

