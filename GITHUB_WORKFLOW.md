# GitHub collaboration workflow

Use this workflow for genuine, reviewable project changes. Do not create commits or claim work on behalf of another member; each person should make commits for the work they actually completed.

## 1. Open the local project

Open Command Prompt in the project folder and verify the files:

```bat
dir
```

## 2. Clone the GitHub repository

```bat
git clone https://github.com/Hiruni-dell/CIT300-DataStructureGraphAnalyzer.git
cd CIT300-DataStructureGraphAnalyzer
```

Copy the contents of this project folder into the cloned repository folder, including `src`, `.project`, `.classpath`, `.gitignore`, and documentation. Do not copy any `out` build directory.

## 3. First commit and push

```bat
git add .
git commit -m "Add Java data structure and graph analyzer project"
git branch -M main
git push -u origin main
```

## 4. Create a feature branch for a real change

After the first push, make a focused change and use a branch:

```bat
git checkout -b feature/improve-graph-validation
javac -d out src/analyzer/*.java
java -cp out analyzer.AnalyzerSelfTest
git add .
git commit -m "Improve graph input validation"
git push -u origin feature/improve-graph-validation
```

Open the repository on GitHub, create a pull request targeting `main`, review it, and merge it when ready.

## Important

A pull request is genuine evidence only after it exists on GitHub. Do not list PR numbers as merged until GitHub confirms the merge. Use branches and commits for real feature work, not to simulate work that did not happen.
