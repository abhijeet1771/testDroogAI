# Verification Script - DroogAI Parsing Verify Karne Ke Liye

Write-Host "🔍 DroogAI Parsing Verification" -ForegroundColor Cyan
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor Gray
Write-Host ""

$REPO = "abhijeet1771/testDroogAI"
$DROOG_PATH = "D:\DROOG AI"

# Step 1: Check if index file exists
Write-Host "1️⃣ Checking for index file..." -ForegroundColor Yellow
$indexFile = Join-Path $DROOG_PATH ".droog-embeddings.json"
if (Test-Path $indexFile) {
    $fileSize = (Get-Item $indexFile).Length
    Write-Host "   ✅ Index file found: .droog-embeddings.json" -ForegroundColor Green
    Write-Host "   📊 Size: $([math]::Round($fileSize/1KB, 2)) KB" -ForegroundColor White
} else {
    Write-Host "   ⚠️  Index file not found" -ForegroundColor Yellow
    Write-Host "   💡 Run: cd '$DROOG_PATH' ; npx tsx src/index.ts index --repo $REPO --branch main" -ForegroundColor Cyan
}

Write-Host ""

# Step 2: Test analyze command on a file
Write-Host "2️⃣ Testing analyze command..." -ForegroundColor Yellow
$testFile = Join-Path $PSScriptRoot "test-files\Calculator.java"
if (Test-Path $testFile) {
    Write-Host "   📄 Testing file: Calculator.java" -ForegroundColor White
    try {
        Set-Location $DROOG_PATH
        $output = npx tsx src/index.ts analyze --file $testFile 2>&1
        if ($LASTEXITCODE -eq 0) {
            Write-Host "   ✅ Analyze command successful!" -ForegroundColor Green
            Write-Host ""
            Write-Host "   Output:" -ForegroundColor Gray
            $output | Select-Object -First 20
        } else {
            Write-Host "   ⚠️  Analyze command had issues" -ForegroundColor Yellow
            $output | Select-Object -First 10
        }
    } catch {
        Write-Host "   ❌ Error: $_" -ForegroundColor Red
    }
} else {
    Write-Host "   ⚠️  Test file not found: $testFile" -ForegroundColor Yellow
}

Write-Host ""

# Step 3: Check if symbols were extracted
Write-Host "3️⃣ Verifying symbol extraction..." -ForegroundColor Yellow
if (Test-Path $indexFile) {
    try {
        $indexContent = Get-Content $indexFile -Raw | ConvertFrom-Json
        if ($indexContent.symbols) {
            $symbolCount = $indexContent.symbols.Count
            Write-Host "   ✅ Found $symbolCount symbols in index" -ForegroundColor Green
        } else {
            Write-Host "   ⚠️  No symbols found in index" -ForegroundColor Yellow
        }
    } catch {
        Write-Host "   ⚠️  Could not read index file" -ForegroundColor Yellow
    }
} else {
    Write-Host "   ⚠️  Index file not found - run index command first" -ForegroundColor Yellow
}

Write-Host ""
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor Gray
Write-Host "✅ Verification Complete!" -ForegroundColor Green
Write-Host ""

