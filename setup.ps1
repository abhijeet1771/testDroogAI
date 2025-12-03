# Setup script for testDroogAI project

Write-Host "🚀 Setting up testDroogAI project..." -ForegroundColor Cyan
Write-Host ""

# Check if Node.js is installed
Write-Host "1️⃣ Checking Node.js..." -ForegroundColor Yellow
try {
    $nodeVersion = node --version
    Write-Host "   ✓ Node.js $nodeVersion found" -ForegroundColor Green
} catch {
    Write-Host "   ✗ Node.js not found. Please install Node.js first." -ForegroundColor Red
    exit 1
}

# Install npm dependencies
Write-Host "`n2️⃣ Installing dependencies..." -ForegroundColor Yellow
npm install
if ($LASTEXITCODE -eq 0) {
    Write-Host "   ✓ Dependencies installed" -ForegroundColor Green
} else {
    Write-Host "   ✗ Failed to install dependencies" -ForegroundColor Red
    exit 1
}

# Install Playwright browsers
Write-Host "`n3️⃣ Installing Playwright browsers..." -ForegroundColor Yellow
npx playwright install chromium
if ($LASTEXITCODE -eq 0) {
    Write-Host "   ✓ Playwright browsers installed" -ForegroundColor Green
} else {
    Write-Host "   ⚠️  Playwright installation had issues" -ForegroundColor Yellow
}

Write-Host "`n✅ Setup complete!" -ForegroundColor Green
Write-Host ""
Write-Host "📋 Next steps:" -ForegroundColor Cyan
Write-Host "   npm run test:box    - Test Box login page" -ForegroundColor White
Write-Host "   npm run test:droog  - Test DroogAI features" -ForegroundColor White
Write-Host "   npm test           - Run all tests" -ForegroundColor White

