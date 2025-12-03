# Quick Test Script - DroogAI Application

Write-Host "🧪 DroogAI Application Test" -ForegroundColor Cyan
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor Gray
Write-Host ""

$DROOG_PATH = "D:\DROOG AI"
$TEST_REPO = "abhijeet1771/testDroogAI"
$TEST_PR = "1"

# Test 1: Check if DroogAI is built
Write-Host "1️⃣ Testing: Build Status" -ForegroundColor Yellow
Set-Location $DROOG_PATH
if (Test-Path "dist\index.js") {
    Write-Host "   ✅ DroogAI is built" -ForegroundColor Green
} else {
    Write-Host "   ⚠️  DroogAI not built, building now..." -ForegroundColor Yellow
    npm run build
    if ($LASTEXITCODE -eq 0) {
        Write-Host "   ✅ Build successful" -ForegroundColor Green
    } else {
        Write-Host "   ❌ Build failed" -ForegroundColor Red
        exit 1
    }
}
Write-Host ""

# Test 2: Check CLI commands
Write-Host "2️⃣ Testing: CLI Commands" -ForegroundColor Yellow
try {
    $helpOutput = npx tsx src/index.ts --help 2>&1
    if ($helpOutput -match "review|index|analyze") {
        Write-Host "   ✅ CLI commands available" -ForegroundColor Green
    } else {
        Write-Host "   ⚠️  CLI commands check failed" -ForegroundColor Yellow
    }
} catch {
    Write-Host "   ❌ CLI test failed: $_" -ForegroundColor Red
}
Write-Host ""

# Test 3: Check environment variables
Write-Host "3️⃣ Testing: Environment Variables" -ForegroundColor Yellow
$hasToken = [bool]$env:GITHUB_TOKEN
$hasGemini = [bool]$env:GEMINI_API_KEY

if ($hasToken) {
    Write-Host "   ✅ GITHUB_TOKEN is set" -ForegroundColor Green
} else {
    Write-Host "   ⚠️  GITHUB_TOKEN not set (required for index/review)" -ForegroundColor Yellow
}

if ($hasGemini) {
    Write-Host "   ✅ GEMINI_API_KEY is set" -ForegroundColor Green
} else {
    Write-Host "   ⚠️  GEMINI_API_KEY not set (optional, but recommended)" -ForegroundColor Yellow
}
Write-Host ""

# Test 4: Test Analyze Command (No API keys needed)
Write-Host "4️⃣ Testing: Analyze Command" -ForegroundColor Yellow
$testFile = "D:\testDroogAI\test-files\Calculator.java"
if (Test-Path $testFile) {
    try {
        $analyzeOutput = npx tsx src/index.ts analyze --file $testFile 2>&1 | Select-Object -First 10
        if ($analyzeOutput -match "symbols|Analysis complete") {
            Write-Host "   ✅ Analyze command works" -ForegroundColor Green
        } else {
            Write-Host "   ⚠️  Analyze command executed (check output)" -ForegroundColor Yellow
        }
    } catch {
        Write-Host "   ❌ Analyze test failed: $_" -ForegroundColor Red
    }
} else {
    Write-Host "   ⚠️  Test file not found: $testFile" -ForegroundColor Yellow
}
Write-Host ""

# Test 5: Check Index File
Write-Host "5️⃣ Testing: Index File" -ForegroundColor Yellow
$indexFile = Join-Path $DROOG_PATH ".droog-embeddings.json"
if (Test-Path $indexFile) {
    $size = (Get-Item $indexFile).Length
    Write-Host "   ✅ Index file exists ($([math]::Round($size/1KB, 2)) KB)" -ForegroundColor Green
} else {
    Write-Host "   ⚠️  Index file not found (run index command first)" -ForegroundColor Yellow
    Write-Host "   💡 Run: npx tsx src/index.ts index --repo $TEST_REPO --branch main" -ForegroundColor Cyan
}
Write-Host ""

# Summary
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor Gray
Write-Host "📊 Test Summary" -ForegroundColor Cyan
Write-Host ""
Write-Host "Next Steps:" -ForegroundColor Yellow
Write-Host "1. If environment variables missing, set them:" -ForegroundColor White
Write-Host "   `$env:GITHUB_TOKEN = 'your_token'" -ForegroundColor Gray
Write-Host "   `$env:GEMINI_API_KEY = 'your_key'" -ForegroundColor Gray
Write-Host ""
Write-Host "2. Test Index Command:" -ForegroundColor White
Write-Host "   npx tsx src/index.ts index --repo $TEST_REPO --branch main" -ForegroundColor Gray
Write-Host ""
Write-Host "3. Test Review Command:" -ForegroundColor White
Write-Host "   npx tsx src/index.ts review --repo $TEST_REPO --pr $TEST_PR" -ForegroundColor Gray
Write-Host ""

