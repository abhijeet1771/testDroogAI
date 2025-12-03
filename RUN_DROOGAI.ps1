# DroogAI Commands for testDroogAI Project
# Quick script to run DroogAI commands

param(
    [Parameter(Mandatory=$false)]
    [string]$Action = "help",
    
    [Parameter(Mandatory=$false)]
    [int]$PRNumber = 1
)

$DROOG_PATH = "D:\DROOG AI"
$REPO = "abhijeet1771/testDroogAI"
$BRANCH = "main"

Write-Host "🚀 DroogAI Commands for testDroogAI" -ForegroundColor Cyan
Write-Host "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━" -ForegroundColor Gray
Write-Host ""

Set-Location $DROOG_PATH

switch ($Action.ToLower()) {
    "index" {
        Write-Host "📦 Indexing main branch..." -ForegroundColor Yellow
        Write-Host "Repository: $REPO" -ForegroundColor White
        Write-Host "Branch: $BRANCH" -ForegroundColor White
        Write-Host ""
        npx tsx src/index.ts index --repo $REPO --branch $BRANCH
    }
    
    "review" {
        Write-Host "🔍 Reviewing PR #$PRNumber..." -ForegroundColor Yellow
        Write-Host "Repository: $REPO" -ForegroundColor White
        Write-Host "PR Number: $PRNumber" -ForegroundColor White
        Write-Host ""
        npx tsx src/index.ts review --repo $REPO --pr $PRNumber --enterprise
    }
    
    "help" {
        Write-Host "Usage:" -ForegroundColor Yellow
        Write-Host ""
        Write-Host "Index main branch:" -ForegroundColor White
        Write-Host "  .\RUN_DROOGAI.ps1 -Action index" -ForegroundColor Gray
        Write-Host ""
        Write-Host "Review PR:" -ForegroundColor White
        Write-Host "  .\RUN_DROOGAI.ps1 -Action review -PRNumber 1" -ForegroundColor Gray
        Write-Host ""
        Write-Host "Examples:" -ForegroundColor Yellow
        Write-Host "  .\RUN_DROOGAI.ps1 -Action index" -ForegroundColor Gray
        Write-Host "  .\RUN_DROOGAI.ps1 -Action review -PRNumber 1" -ForegroundColor Gray
        Write-Host "  .\RUN_DROOGAI.ps1 -Action review -PRNumber 2" -ForegroundColor Gray
    }
    
    default {
        Write-Host "❌ Unknown action: $Action" -ForegroundColor Red
        Write-Host "Use: index, review, or help" -ForegroundColor Yellow
    }
}

