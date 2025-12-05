# Index Command - Main Branch Parse Karne Ke Liye

## 📦 Index Command Kya Hai?

Index command se aap **main branch ka code parse karke store kar sakte ho**. Yeh DroogAI ko duplicate detection aur breaking change detection ke liye help karta hai.

## 🚀 Command Syntax

```bash
npx droog-ai index --repo owner/repo --branch main
```

## 📋 Example

```bash
# testDroogAI repository ko index karo
npx droog-ai index --repo abhijeet1771/testDroogAI --branch main
```

## 🔑 Required Parameters

- `--repo <owner/repo>` - GitHub repository (required)
- `--branch <branch>` - Branch name (default: main)
- `--token <token>` - GitHub token (optional, env variable se bhi le sakta hai)

## 📍 Index Kahan Store Hota Hai?

Index store hota hai:
- **`.droog-embeddings.json`** - Droog AI project directory mein
- In-memory index - symbols aur call graph

## ⚡ Kya Hota Hai Indexing Mein?

1. ✅ Repository se saare files fetch hote hain
2. ✅ Code files parse hote hain (Java, etc.)
3. ✅ Symbols extract hote hain (classes, methods)
4. ✅ Embeddings generate hote hain (similarity search ke liye)
5. ✅ Call graph build hota hai (method dependencies)

## 🎯 Kyon Important Hai?

- **Duplicate Detection** - Cross-repo duplicates find karne ke liye
- **Breaking Changes** - API changes detect karne ke liye
- **Better Analysis** - PR review mein better context

## 📝 First Time Setup

```bash
cd "D:\DROOG AI"
npx tsx src/index.ts index --repo abhijeet1771/testDroogAI --branch main
```

## ⚠️ Note

- Indexing time lag sakta hai (repo size ke hisab se)
- GitHub token required hai
- Gemini API key optional hai (embeddings ke liye)

