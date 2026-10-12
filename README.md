# CIT300 Data Structure and Graph Performance Analyzer

**Module:** CIT300 – Data Structures and Algorithms  
**Assessment:** Graded Practical Assignment 2 (Week 12)  
**Application:** Java console-based system

## 1. Project Description

The Data Structure and Graph Performance Analyzer is a menu-driven Java console application for demonstrating common data structures, searching algorithms, graph operations, and algorithmic complexity. Users can interact with arrays, a linked list, a stack, a queue, searching algorithms, and a graph, and can run a basic performance comparison.

## 2. Implemented Features

- **Array operations:** insert, delete, search, display, and automatic capacity growth.
- **Stack:** push, pop, peek, and display; empty-stack operations are handled.
- **Queue:** enqueue, dequeue, front, and display using a resizable circular array; empty-queue operations are handled.
- **Linked list:** insert at the front or end, delete, search, and display.
- **Searching:** linear search and binary search. The performance demonstration reports comparison counts and elapsed time.
- **Graph:** add vertices and edges, display the adjacency-list representation, search for a vertex, and run Breadth-First Search (BFS) and Depth-First Search (DFS).
- **Performance/complexity:** compare searching approaches and display theoretical complexity for the implemented structures and algorithms.
- **Input validation:** menu input is checked, and blank graph labels are rejected.
- **Testing:** a dependency-free self-test class checks array, stack, queue, linked-list, searching, and graph behaviour.

## 3. Technologies

- Java (JDK 17 or newer)
- Eclipse IDE (optional)
- Standard Java library only; no external dependencies required

## 4. Project Structure

```text
CIT300-DataStructureGraphAnalyzer/
├── src/
│   └── analyzer/
│       ├── Main.java
│       ├── ArrayOperations.java
│       ├── CustomLinkedList.java
│       ├── CustomStack.java
│       ├── CustomQueue.java
│       ├── SearchingAlgorithms.java
│       ├── Graph.java
│       ├── PerformanceAnalyzer.java
│       └── AnalyzerSelfTest.java
├── README.md
├── .gitignore
├── .project
└── .classpath
```

## 5. How to Compile and Run

Open a terminal in the repository root and check that Java is installed:

```bash
java -version
javac -version
```

Compile the Java source files:

```bash
javac -d out src/analyzer/*.java
```

Run the application:

```bash
java -cp out analyzer.Main
```

Use the numbered main menu to open the different modules. Select **9** to exit.

## 6. Run the Self-Tests

From the repository root, run:

```bash
javac -d out src/analyzer/*.java
java -cp out analyzer.AnalyzerSelfTest
```

The expected success message is:

```text
All AnalyzerSelfTest checks passed.
```

## 7. Performance and Complexity

The program demonstrates search comparison counts and elapsed time. Elapsed time can vary with JVM warm-up, hardware, and system load, so comparison counts and theoretical complexity are also useful for explaining differences.

| Structure / algorithm | Operation | Typical time complexity |
|---|---|---:|
| Dynamic array | Search / delete | O(n) |
| Dynamic array | Append | O(1) amortized |
| Singly linked list | Search / delete / insert at end | O(n) |
| Singly linked list | Insert at front | O(1) |
| Stack | Push | O(1) amortized |
| Stack | Pop / peek | O(1) |
| Circular queue | Enqueue | O(1) amortized |
| Circular queue | Dequeue / front | O(1) |
| Linear search | Search | O(n) |
| Binary search | Search sorted data | O(log n) |
| Adjacency-list graph | BFS / DFS | O(V + E) |

**V** is the number of vertices and **E** is the number of edges. Binary search requires ascending-sorted data; the application uses a sorted copy for its comparison.

## 8. Group Members, Responsibilities, and Contributions

The assignment requires each member's responsibility and actual contribution to be documented. The responsibilities below are a proposed allocation aligned with the current code and the assignment's suggested roles. They must not be treated as proof of authorship. The current source code alone does not reliably establish who wrote each class.

| Student name | Student ID | Assigned responsibility | Contribution status |
|---|---|---|---|
| **E.A. Chamod Maleesha** | **23DA2-0043** | Array operations and searching algorithms (ArrayOperations.java, SearchingAlgorithms.java) | As reported by the group, no contribution has yet been made by this member. Do not claim implementation until the member completes and can explain their work. |
| **Nushrath Ahamed** | **23DA2-0439** | Stack and queue (CustomStack.java, CustomQueue.java) | As reported by the group, no contribution has yet been made by this member. Do not claim implementation until the member completes and can explain their work. |
| **W.H.D.S. Fernando** | **23DA2-0261** | Linked list and/or integration, performance analysis, and testing (CustomLinkedList.java, Main.java, PerformanceAnalyzer.java, AnalyzerSelfTest.java) | Confirm and document only the implementation, integration, and testing work personally completed. |
| **P.H. Yashodha Amashi** | **23DA2-0346** | Graph representation and traversal (Graph.java) | As reported by the group, no contribution has yet been made by this member. Do not claim implementation until the member completes and can explain their work. |

### Contribution and collaboration note

The repository contains the required main categories of functionality, but a class being present does not prove which student implemented it. Individual contributions should be updated only after the relevant member has genuinely completed, tested, and understood their assigned work. This README update is a repository documentation change; it is not evidence of commits made by the other students.

The assignment requires genuine collaboration evidence. Do not create commits or pull requests that falsely appear to have been authored by someone else. Each member should use their own GitHub account for their own work, or the group should accurately document any assistance and shared work.

## 9. Demonstration Video Checklist

Prepare **one merged video shorter than 15 minutes**. Each member's section should include:

1. Their face clearly visible while presenting.
2. Their name, student ID, and actual responsibility.
3. The relevant code and a live demonstration of the functionality they completed.
4. An explanation of the data structure or algorithm and its complexity.
5. How the component works in the integrated application.

Do not include a presentation as an individual contribution unless that member actually participates and can explain the work.

## 10. Final Submission Checklist

- [ ] Compile and run the complete Java project.
- [ ] Run AnalyzerSelfTest and investigate any failed check.
- [ ] Demonstrate arrays, stack, queue, linked list, searching, graph, BFS, DFS, and performance comparison.
- [ ] Verify every member's full name and student ID.
- [ ] Replace any pending contribution status with an accurate description after genuine work is completed.
- [ ] Keep genuine branches, commits, and pull requests as collaboration evidence where applicable.
- [ ] Prepare one merged demonstration video shorter than 15 minutes, with each member's face visible during their own presentation.
- [ ] If using Google Drive because the files are too large for the LMS, place the folder link in a TXT file and give Editor access to **asanka.r@sltc.ac.lk** and **kaushika.w@sltc.ac.lk**.
- [ ] Submit through the designated LMS link before the deadline stated by the lecturer.

**Submission status:** The code currently documents the core required data structures and graph/search features. However, the group contribution and demonstration requirements are not complete until the actual contributions are confirmed and the required video and collaboration evidence are prepared.
