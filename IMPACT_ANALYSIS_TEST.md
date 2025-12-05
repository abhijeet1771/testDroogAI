# Impact Analysis Test Branch

## Purpose
This branch tests DroogAI's **Pre-Merge Impact Analysis** feature to detect:
- Which files in master branch will be impacted
- Where methods are being called from
- Potential breakage scenarios
- Both negative (breaking) and positive (safe) scenarios

## Test Scenarios

### 🔴 NEGATIVE SCENARIO (Breaking Changes)

#### UserService.java - Breaking Changes
1. **`getUserById()` - Signature Changed (BREAKING)**
   - **OLD:** `public String getUserById(String userId)`
   - **NEW:** `public User getUserById(String userId, boolean includeDetails)`
   - **Impact:** 
     - Return type changed: `String` → `User`
     - New parameter added: `boolean includeDetails`
   - **Affected Files in Master:**
     - `OrderService.java` - calls `getUserById()` in 3 places
     - `PaymentProcessor.java` - calls `getUserById()` in 2 places
     - `NotificationService.java` - calls `getUserById()` in 2 places

2. **`validateUser()` - Visibility Reduced (BREAKING)**
   - **OLD:** `public boolean validateUser(String userId)`
   - **NEW:** `private boolean validateUser(String userId)`
   - **Impact:** External classes can no longer access this method
   - **Affected Files in Master:**
     - `OrderService.java` - calls `validateUser()` in 2 places
     - `PaymentProcessor.java` - calls `validateUser()` in 2 places

### ✅ POSITIVE SCENARIO (Safe Changes)

#### UserService.java - Safe Additions
1. **`isUserActive()` - New Method (SAFE)**
   - New public method added
   - No impact on existing code

2. **`getUserDisplayName()` - New Method (SAFE)**
   - New public method added
   - No impact on existing code

3. **`updateUser()` - Unchanged (SAFE)**
   - Method signature unchanged
   - No impact

#### SafeService.java - All Safe Changes
- All methods are either new or unchanged
- No breaking changes
- Should show zero or low impact

## Expected Impact Analysis Output

DroogAI should detect:

1. **Impacted Features:**
   - **Order** feature (HIGH Risk)
     - 1 file affected: `OrderService.java`
     - 5 call sites found
   - **Payment** feature (HIGH Risk)
     - 1 file affected: `PaymentProcessor.java`
     - 4 call sites found
   - **Notification** feature (HIGH Risk)
     - 1 file affected: `NotificationService.java`
     - 2 call sites found

2. **Breakage Predictions:**
   - "Method signature changes may cause compilation errors" (HIGH Probability)
   - "Visibility changes may break external access" (MEDIUM Probability)

3. **Call Sites:**
   - `OrderService.processOrder()` calls `getUserById()` and `validateUser()`
   - `PaymentProcessor.processPayment()` calls `getUserById()` and `validateUser()`
   - `NotificationService.sendNotification()` calls `getUserById()`

## How to Test

1. **Index Master Branch:**
   ```bash
   npx tsx src/index.ts index --repo abhijeet1771/testDroogAI --branch master
   ```

2. **Run Review on This Branch:**
   ```bash
   npx tsx src/index.ts review --repo abhijeet1771/testDroogAI --pr <PR_NUMBER> --enterprise --post
   ```

3. **Check Impact Analysis:**
   - Look for "Pre-Merge Impact Analysis" section in summary
   - Verify impacted files are listed
   - Verify call sites are shown with file:line
   - Verify breakage predictions are generated

## Files in This Branch

- `test-files/UserService.java` - Modified (breaking changes)
- `test-files/SafeService.java` - New file (safe changes)
- `test-files/OrderService.java` - Exists in master (will be impacted)
- `test-files/PaymentProcessor.java` - Exists in master (will be impacted)
- `test-files/NotificationService.java` - Exists in master (will be impacted)

## Success Criteria

✅ Impact analysis detects 3 impacted files  
✅ Impact analysis shows 11+ call sites  
✅ Impact analysis identifies 3 features at risk  
✅ Breakage predictions are generated  
✅ Call sites show exact file:line locations  
✅ Summary is human-readable and actionable  

