/**
 * Box.com Locators
 * Centralized locator definitions for Box.com elements
 */

const BoxLocators = {
  // Login Page
  login: {
    emailInput: 'input[type="email"], input[name="login"], input[id*="login"]',
    passwordInput: 'input[type="password"], input[name="password"]',
    loginButton: 'button[type="submit"], button:has-text("Log In"), button:has-text("Sign In")',
    forgotPasswordLink: 'a:has-text("Forgot"), a:has-text("Reset")',
    errorMessage: '.error, .alert, [role="alert"]',
    signUpLink: 'a:has-text("Sign Up"), a:has-text("Create Account")',
  },

  // Dashboard
  dashboard: {
    userMenu: '[aria-label*="Account"], [data-testid*="user"], button:has-text("Account")',
    uploadButton: 'button:has-text("Upload"), [aria-label*="Upload"]',
    newButton: 'button:has-text("New"), [aria-label*="New"]',
    filesList: '[data-testid*="file"], .file-item, [role="row"]',
    searchInput: 'input[type="search"], input[placeholder*="Search"]',
    logoutButton: 'button:has-text("Log Out"), a:has-text("Log Out")',
    sidebar: '[data-testid*="sidebar"], .sidebar, nav',
  },

  // File Operations
  files: {
    fileItem: '[data-testid*="file"], .file-item',
    folderItem: '[data-testid*="folder"], .folder-item',
    fileActions: '[aria-label*="Actions"], .file-actions',
    downloadButton: 'button:has-text("Download"), [aria-label*="Download"]',
    shareButton: 'button:has-text("Share"), [aria-label*="Share"]',
    deleteButton: 'button:has-text("Delete"), [aria-label*="Delete"]',
  },

  // Upload
  upload: {
    uploadButton: 'button:has-text("Upload"), [aria-label*="Upload"]',
    fileInput: 'input[type="file"]',
    uploadProgress: '.upload-progress, [data-testid*="progress"]',
    uploadComplete: '.upload-complete, [data-testid*="complete"]',
  },

  // Navigation
  navigation: {
    homeLink: 'a:has-text("Home"), [aria-label*="Home"]',
    allFilesLink: 'a:has-text("All Files"), [aria-label*="All Files"]',
    recentLink: 'a:has-text("Recent"), [aria-label*="Recent"]',
    sharedLink: 'a:has-text("Shared"), [aria-label*="Shared"]',
  },
};

module.exports = { BoxLocators };

