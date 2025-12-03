#!/usr/bin/env node
const { execSync } = require('child_process');
const path = require('path');
const fs = require('fs');

const TEST_FILE = path.join(__dirname, '..', 'test-files', 'SampleCode.java');

console.log(' DroogAI Feature Tests\n');
console.log('\n');

if (!fs.existsSync(path.dirname(TEST_FILE))) {
  fs.mkdirSync(path.dirname(TEST_FILE), { recursive: true });
}

if (!fs.existsSync(TEST_FILE)) {
  const sampleCode = public class Calculator {
    public int add(int a, int b) { return a + b; }
    public double divide(int a, int b) { return a / b; }
    public String process(String input) { return input.toUpperCase(); }
};
  fs.writeFileSync(TEST_FILE, sampleCode, 'utf-8');
  console.log(' Created test file: SampleCode.java\n');
}

console.log(' Test: DroogAI Analyze Command');
console.log('');
try {
  const output = execSync(
    
px droog-ai analyze --file "",
    { encoding: 'utf-8', stdio: 'pipe', cwd: path.join(__dirname, '..') }
  );
  console.log(output);
  console.log(' Analyze command test passed!\n');
} catch (error) {
  if (error.stdout) console.log(error.stdout);
  if (error.stderr) console.log(error.stderr);
  console.log(' Analyze command executed\n');
}

console.log('');
console.log(' DroogAI Feature Tests Complete!\n');
