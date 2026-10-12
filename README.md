# CIT300 Data Structure Graph Analyzer

A Java console application developed for demonstrating fundamental data structures, searching algorithms, graph traversal, and basic performance analysis.

## Project Features

- **Array operations:** insert, delete, search, display, and automatic capacity growth.
- **Custom linked list:** insert at the front or end, delete, search, and display integer values.
- **Custom stack:** push, pop, peek, and display using LIFO order.
- **Custom queue:** enqueue, dequeue, front, and display using FIFO order with a resizable circular array.
- **Searching algorithms:** linear search and binary search, including comparison counts and elapsed-time measurements.
- **Graph operations:** add vertices and edges, display adjacency lists, check vertices, and traverse using Breadth-First Search (BFS) and Depth-First Search (DFS).
- **Performance analysis:** demonstrate measured search performance and discuss theoretical time complexity.
- **Self-tests:** dependency-free checks for the main data structures, searching, and graph traversal.

## Technologies and Requirements

- Java Development Kit (JDK) 17 or newer
- Eclipse IDE (optional)
- No external libraries are required

## Project Structure

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

## How to Compile and Run

Open a terminal in the repository's root directory. Check that Java is installed:

```bash
java -version
javac -version
```

Compile the source files:

```bash
javac -d out src/analyzer/*.java
```

Run the interactive application:

```bash
java -cp out analyzer.Main
```

The menu lets you select array, stack, queue, linked-list, searching, graph, and performance-analysis features. Select **9** to exit.

## Run the Tests

Compile the project and run the self-test class:

```bash
javac -d out src/analyzer/*.java
java -cp out analyzer.AnalyzerSelfTest
```

A successful run prints:

```text
All AnalyzerSelfTest checks passed.
```

## Data Structures and Algorithm Complexity

The following are the main theoretical complexities for the implementations in this repository. Actual elapsed time depends on input size and the running environment.

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

Here, **V** is the number of vertices and **E** is the number of edges. Binary search requires data sorted in ascending order; the application uses a sorted copy for its demonstration.

## Individual Contributions

The contribution descriptions supplied for the group refer to a Student BST, hash table, student records, service-request processing, and a campus-specific graph. Those features are **not present in the current source files**. The table below is therefore a suggested mapping to the modules that do exist, not verification of who authored each part. Confirm and adjust it to reflect each member's actual work before submission.

| Group member | Existing project area to verify |
|---|---|
| **E.A. Chamod Maleesha** | Custom linked list: node structure and insert, delete, search, and display operations. The current list stores integers, not Student records. |
| **Nushrath Ahamed** | Custom stack and FIFO queue operations. The current classes are general-purpose integer structures; action logging and service-request processing are not implemented. |
| **W.H.D.S. Fernando** | Arrays, searching algorithms, and performance-analysis integration. The current project does not contain the Student BST or hash table described in the original contribution notes. |
| **P.H. Yashodha Amashi** | Graph adjacency-list implementation and BFS/DFS traversal. The current graph uses general vertex labels; campus-location management is not implemented. |
| **All members** | Integration, validation, testing, debugging, documentation, and demonstration, as actually completed by the group. |

**Important:** If the assignment specifically requires Student records, a BST, a hash table, service requests, or campus-location management, those requirements must be implemented and tested before the project can be described as complete. Do not list an unimplemented feature as finished.

## Group Members

- E.A. Chamod Maleesha
- Nushrath Ahamed
- W.H.D.S. Fernando
- P.H. Yashodha Amashi

## Notes

This README documents the code currently present in the repository. Update the contribution allocation and feature list if the code changes, and ensure the final submission matches the official assignment brief.
