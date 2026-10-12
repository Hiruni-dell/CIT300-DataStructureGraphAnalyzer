# Contribution and Testing Guide

This document explains how the team can collaborate transparently on the CIT300 Data Structure and Graph Analyzer.

## Before submitting

1. Import the project into Eclipse or use JDK 17+ from a terminal.
2. Compile all classes:
   ```bash
   javac -d out src/analyzer/*.java
   ```
3. Run the regression checks:
   ```bash
   java -cp out analyzer.AnalyzerSelfTest
   ```
4. Run the interactive application:
   ```bash
   java -cp out analyzer.Main
   ```
5. Test normal input, missing values, and empty data structures.

## Team contribution record

The following allocation is a suggested starting point, not proof of completed work. The group should confirm or edit it so it matches the work each person actually completed.

| Member | Suggested focus | Evidence to record |
|---|---|---|
| 23DA2-0043 — E.A. Chamod Maleesha | Arrays and searching | Actual code changes, test results, and commits made by the member |
| 23DA2-0439 — Nushrath Ahamed | Stack and queue | Actual code changes, test results, and commits made by the member |
| 23DA2-0261 — W.H.D.S. Fernando | Linked list and integration/testing | Actual code changes, test results, and commits made by the member |
| 23DA2-0346 — P.H. Yashodha Amashi | Graph and performance analysis | Actual code changes, test results, and commits made by the member |

Update this table based on the team's actual work before submitting. Do not attribute a commit to a person who did not make it.

## Suggested Git workflow

Each member should use their own GitHub account for the work they perform.

```bash
git checkout main
git pull origin main
git checkout -b feature/short-description
# Make and test your own changes
git add .
git commit -m "Describe the change made"
git push -u origin feature/short-description
```

Then open a pull request on GitHub, describe the change and how it was tested, and ask a teammate to review it. Merge only after the review and checks required by the lecturer or team.

## Pull request checklist

- [ ] The change has a clear purpose and is limited to the stated task.
- [ ] The project compiles.
- [ ] `AnalyzerSelfTest` passes.
- [ ] The PR description explains what changed and how it was tested.
- [ ] The author and contribution description are accurate.
