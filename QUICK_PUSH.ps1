# Quick Push Script for testDroogAI

Write-Host "🚀 Pushing testDroogAI to GitHub..." -ForegroundColor Cyan
Write-Host ""

# Check if repository exists
Write-Host "📋 Step 1: Create repository on GitHub (if not exists)" -ForegroundColor Yellow
Write-Host "   Go to: https://github.com/new" -ForegroundColor White
Write-Host "   Repository name: testDroogAI" -ForegroundColor White
Write-Host "   DO NOT initialize with README/gitignore" -ForegroundColor Yellow
Write-Host "   Click 'Create repository'" -ForegroundColor White
Write-Host ""
Read-Host "Press Enter after creating the repository..."

# Push to GitHub
Write-Host "`n📤 Step 2: Pushing code..." -ForegroundColor Yellow
git push -u origin main

if ($LASTEXITCODE -eq 0) {
    Write-Host "`n✅ Successfully pushed to GitHub!" -ForegroundColor Green
    Write-Host "   Repository: https://github.com/abhijeet1771/testDroogAI" -ForegroundColor Cyan
} else {
    Write-Host "`n❌ Push failed. Make sure:" -ForegroundColor Red
    Write-Host "   1. Repository exists on GitHub" -ForegroundColor Yellow
    Write-Host "   2. You have push access" -ForegroundColor Yellow
    Write-Host "   3. Remote URL is correct" -ForegroundColor Yellow
}



