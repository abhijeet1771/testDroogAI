# Script to create test branch with 2 small files for reusable workflow testing
# Run this from testDroogAI repository directory

param(
    [string]$BranchName = "test-reusable-workflow"
)

Write-Host "🚀 Creating test branch for reusable workflow test..." -ForegroundColor Cyan
Write-Host ""

# Check if we're in a git repo
if (-not (Test-Path ".git")) {
    Write-Host "❌ Not a git repository. Please run this from testDroogAI directory." -ForegroundColor Red
    exit 1
}

# Get current branch
$currentBranch = git branch --show-current
Write-Host "📋 Current branch: $currentBranch" -ForegroundColor Cyan

# Fetch latest
Write-Host ""
Write-Host "📥 Fetching latest changes..." -ForegroundColor Yellow
git fetch origin

# Checkout main/master
$mainBranch = "main"
if (-not (git branch -r | Select-String "origin/main")) {
    $mainBranch = "master"
}

Write-Host "🔄 Switching to $mainBranch branch..." -ForegroundColor Yellow
git checkout $mainBranch
git pull origin $mainBranch

# Create and checkout new branch
Write-Host ""
Write-Host "🌿 Creating branch: $BranchName" -ForegroundColor Yellow
git checkout -b $BranchName

# Create test directory if it doesn't exist
$testDir = "test-files"
if (-not (Test-Path $testDir)) {
    New-Item -ItemType Directory -Path $testDir | Out-Null
    Write-Host "📁 Created directory: $testDir" -ForegroundColor Green
}

# Create first test file (Calculator.java)
$file1 = Join-Path $testDir "CalculatorTest.java"
$file1Content = @"
public class CalculatorTest {
    // Missing null check - will be flagged
    public int add(int a, int b) {
        return a + b;
    }
    
    // O(n²) complexity - performance issue
    public int sumArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sum += arr[i] * arr[j];
            }
        }
        return sum;
    }
    
    // Magic number - code smell
    public double calculateTax(double amount) {
        return amount * 0.15; // Should be a constant
    }
}
"@

Set-Content -Path $file1 -Value $file1Content
Write-Host "✅ Created: $file1" -ForegroundColor Green

# Create second test file (UserServiceTest.java)
$file2 = Join-Path $testDir "UserServiceTest.java"
$file2Content = @"
import java.util.List;

public class UserServiceTest {
    // Missing error handling
    public String getUserName(int userId) {
        // No null check or exception handling
        return getUserById(userId).getName();
    }
    
    // Duplicate code pattern (similar to Calculator)
    public int calculateTotal(List<Integer> numbers) {
        int total = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                total += numbers.get(i) * numbers.get(j);
            }
        }
        return total;
    }
    
    // Hardcoded value - should be configurable
    public boolean isAdmin(int userId) {
        return userId == 12345; // Magic number
    }
    
    private User getUserById(int userId) {
        // Placeholder - would normally fetch from database
        return new User(userId, "Test User");
    }
}

class User {
    private int id;
    private String name;
    
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
"@

Set-Content -Path $file2 -Value $file2Content
Write-Host "✅ Created: $file2" -ForegroundColor Green

# Stage files
Write-Host ""
Write-Host "📦 Staging files..." -ForegroundColor Yellow
git add $file1 $file2

# Commit
Write-Host "💾 Committing changes..." -ForegroundColor Yellow
git commit -m "test: add 2 test files for reusable workflow testing

- CalculatorTest.java: Performance issues, magic numbers
- UserServiceTest.java: Error handling, duplicate code, hardcoded values

This PR is for testing the reusable workflow with auto-fix enabled."

# Push branch
Write-Host ""
Write-Host "📤 Pushing branch to remote..." -ForegroundColor Yellow
git push -u origin $BranchName

Write-Host ""
Write-Host "✅ Test branch created successfully!" -ForegroundColor Green
Write-Host ""
Write-Host "📝 Next steps:" -ForegroundColor Cyan
Write-Host "   1. Go to: https://github.com/abhijeet1771/testDroogAI/compare/main...$BranchName" -ForegroundColor Yellow
Write-Host "   2. Click 'Create Pull Request'" -ForegroundColor Yellow
Write-Host "   3. The reusable workflow will automatically run" -ForegroundColor Yellow
Write-Host ""
Write-Host "💡 The workflow now uses reusable workflow (no installation needed!)" -ForegroundColor Green
Write-Host ""

