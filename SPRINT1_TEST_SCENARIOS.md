# Sprint 1 Test Scenarios

## Overview
This branch tests the Sprint 1 features:
1. **Consolidated PR Summary** - Single executive summary instead of per-file summaries
2. **Human-like Comment Formatting** - Conversational, respectful tone
3. **Conversational LLM Prompts** - "I noticed", "I'd recommend" style

## Test Files

### Negative Scenarios (Should Trigger Issues)

#### `TestSprint1Negative.java`
**Purpose**: Contains intentional issues to test detection and summary generation

**Issues Included**:
1. **Breaking Change**: `processOrder()` signature changed (added `quantity` parameter)
   - Will break: `CallingService.processOrderFlow()` (2 call sites)
   - Expected: "I noticed this change will break 2 call sites..."

2. **Breaking Change**: `getUserData()` visibility reduced from public to private
   - Will break: `CallingService.processOrderFlow()`
   - Expected: "I noticed this method is now private and will break external callers..."

3. **Breaking Change**: `getStatus()` return type changed from `int` to `String`
   - Will break: `CallingService.processOrderFlow()`
   - Expected: "I noticed the return type changed, this will cause compilation errors..."

4. **Breaking Change**: `calculateDiscount()` signature changed (added `discountPercent` parameter)
   - Will break: `CallingService.processOrderFlow()` and tests
   - Expected: "I noticed this change will break call sites and tests..."

5. **Performance Regression**: N+1 query problem in `processOrders()`
   - Expected: "I noticed this will cause a performance regression - N+1 query problem..."

6. **Performance Regression**: O(n²) complexity in `calculateTotal()`
   - Expected: "I noticed this will slow down with large lists - O(n²) complexity..."

#### `CallingService.java`
**Purpose**: Contains call sites that WILL BREAK

**Call Sites**:
- `processOrder("ORD-123")` - Missing quantity parameter
- `getUserData("USER-456")` - Method is now private
- `getStatus()` - Return type mismatch
- `calculateDiscount(100)` - Missing discountPercent parameter

**Expected in Summary**:
- "4 call sites will break"
- "CallingService.java will fail to compile"

#### `TestSprint1NegativeTest.java`
**Purpose**: Tests that WILL FAIL

**Failing Tests**:
1. `testProcessOrder()` - Signature mismatch
2. `testGetUserData()` - Cannot access private method
3. `testGetStatus()` - Return type mismatch
4. `testCalculateDiscount()` - Signature mismatch

**Expected in Summary**:
- "4 test(s) will fail (CI blocked)"
- "TestSprint1NegativeTest.java::testProcessOrder will fail"
- "TestSprint1NegativeTest.java::testGetUserData will fail"
- etc.

### Positive Scenarios (Should Find ZERO Issues)

#### `TestSprint1Positive.java`
**Purpose**: Clean, well-written code with no issues

**Features**:
- Proper method signatures
- No breaking changes
- Efficient implementations (Streams API, batch processing)
- No performance regressions
- Follows best practices

**Expected**: 
- **ZERO issues** should be found
- No comments should be posted
- Summary should show "✅ No major breakage detected"

#### `TestSprint1PositiveTest.java`
**Purpose**: Clean tests that should pass

**Expected**:
- **ZERO issues** should be found
- No test failures predicted

## Expected Summary Format

When reviewing this PR, the summary should be:

```
# ⚠️ PR Impact Assessment

**Merge Risk**: 🔴 HIGH ⚠️

**If merged, main branch will experience:**
- **1 feature(s)** will break
- **4 test(s)** will fail (CI blocked)
- **2 performance regression(s)** detected
- **4 breaking change(s)** affecting 3 file(s)

## Must Fix Before Merge (Priority Order):

1. 🔴 HIGH **Breaking change in TestSprint1Negative.java::processOrder**
   - 2 file(s) will break

2. 🔴 HIGH **Update 4 failing test(s)**
   - CI pipeline will fail

3. 🔴 HIGH **Fix TestSprint1Negative feature**
   - 3 file(s) affected

4. 🟡 MEDIUM **Performance regression in TestSprint1Negative.java::processOrders**
   - N+1 query problem will slow down

## Quick Stats:
- **Total Issues**: [X]
- **High Priority**: [X]
- **Medium Priority**: [X]
- **Low Priority**: [X]
```

## Expected Comment Format

Comments should be human-like and conversational:

```
I noticed this change will break 2 call sites:
- CallingService.processOrderFlow() will fail
- CallingService.orderProcessing() will fail

Here's how I'd approach this:
[Code suggestion]
```

**NOT**:
```
**HIGH**: Breaking change detected. Issue: Method signature changed. Fix: Update call sites.
```

## Testing Steps

1. **Index the main branch**:
   ```bash
   npx tsx src/index.ts index --repo abhijeet1771/testDroogAI --branch main
   ```

2. **Run review**:
   ```bash
   npx tsx src/index.ts review --repo abhijeet1771/testDroogAI --pr [PR_NUMBER] --enterprise --post
   ```

3. **Verify**:
   - ✅ Consolidated summary posted (single comment, not per-file)
   - ✅ Human-like comments with "I noticed" tone
   - ✅ Impact-first structure (what will break, where, why)
   - ✅ Positive scenarios have ZERO issues
   - ✅ Negative scenarios properly detected

## Success Criteria

- [ ] Consolidated PR summary posted (not per-file)
- [ ] Summary shows merge risk, impact list, priority actions
- [ ] Comments use conversational tone ("I noticed", "I'd recommend")
- [ ] Comments show impact first (what will break, where, why)
- [ ] Positive scenarios: ZERO issues found
- [ ] Negative scenarios: All issues detected correctly
- [ ] Breaking changes detected with call sites
- [ ] Test failures predicted correctly
- [ ] Performance regressions detected

