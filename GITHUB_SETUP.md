# GitHub Setup Guide - Auto PR Review

## 🎯 Goal
Setup DroogAI to automatically review PRs and post comments.

---

## 📋 Step 1: Add GitHub Secrets

### Go to Repository Settings:
1. Open: https://github.com/abhijeet1771/testDroogAI
2. Click: **Settings** → **Secrets and variables** → **Actions**
3. Click: **New repository secret**

### Add These Secrets:

#### 1. GEMINI_API_KEY
- **Name:** `GEMINI_API_KEY`
- **Value:** Your Gemini API key
- **Click:** Add secret

#### 2. GITHUB_TOKEN (Optional)
- Usually auto-provided by GitHub Actions
- If needed, create Personal Access Token with `repo` permissions

---

## ✅ Step 2: Verify Workflow

1. Go to **Actions** tab
2. You should see: **"Droog AI Code Review"** workflow
3. Workflow is ready!

---

## 🚀 Step 3: Test It!

### Create a Test PR:
1. Create a new branch
2. Make some changes
3. Create PR
4. **DroogAI will automatically:**
   - Index main branch (first time only)
   - Review the PR
   - Post comments on PR

---

## 📋 How It Works

### First PR:
```
1. PR Created
2. Workflow Triggers
3. Check if index exists → No
4. Index main branch (auto)
5. Review PR
6. Post comments
```

### Subsequent PRs:
```
1. PR Created
2. Workflow Triggers
3. Check if index exists → Yes
4. Review PR (skip indexing)
5. Post comments
```

---

## 🔧 Workflow Features

- ✅ **Auto-trigger** on PR open/update
- ✅ **Auto-index** main branch (first time)
- ✅ **Auto-review** PR
- ✅ **Auto-post** comments
- ✅ **Enterprise features** enabled
- ✅ **Report artifact** uploaded

---

## 📝 Manual Trigger

If you want to manually trigger review:

1. Go to **Actions** tab
2. Select **"Droog AI Code Review"**
3. Click **"Run workflow"**
4. Enter PR number
5. Click **"Run workflow"**

---

## ⚠️ Troubleshooting

### Issue: Workflow not triggering
**Solution:** Check if workflow file is in `.github/workflows/` folder

### Issue: "DroogAI repository not found"
**Solution:** Ensure DroogAI is pushed to GitHub at `abhijeet1771/AI-reviewer`

### Issue: "GitHub token required"
**Solution:** Check if `GITHUB_TOKEN` secret is set (usually auto-provided)

### Issue: "Gemini API key required"
**Solution:** Add `GEMINI_API_KEY` secret in repository settings

---

## ✅ Checklist

- [ ] GitHub Secrets added (GEMINI_API_KEY)
- [ ] Workflow file exists (`.github/workflows/droog-review.yml`)
- [ ] Test PR created
- [ ] Workflow runs automatically
- [ ] Comments posted on PR

---

## 🎉 Done!

Once setup is complete:
- Every PR will be automatically reviewed
- Comments will be posted automatically
- No manual intervention needed!



