package analyzer;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayOperations array = new ArrayOperations(5);
    static CustomStack stack = new CustomStack();
    static CustomQueue queue = new CustomQueue();
    static CustomLinkedList list = new CustomLinkedList();
    static Graph graph = new Graph();

    public static void main(String[] args) {
        seed();
        boolean run = true;

        System.out.println("=============================================");
        System.out.println("       DATA STRUCTURE & GRAPH ANALYZER");
        System.out.println("          Graded Practical Assignment 2");
        System.out.println("=============================================");

        while (run) {
            System.out.println("\n--------------- MAIN MENU ----------------");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            System.out.println("-------------------------------------------");

            int choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1 -> arrayMenu();
                case 2 -> stackMenu();
                case 3 -> queueMenu();
                case 4 -> listMenu();
                case 5 -> searchMenu();
                case 6 -> graphMenu();
                case 7 -> PerformanceAnalyzer.runDemo();
                case 8 -> displayAll();
                case 9 -> run = false;
                default -> System.out.println("Invalid choice. Please select 1-9.");
            }
        }
        System.out.println("Program ended.");
    }

    static void arrayMenu() {
        while (true) {
            System.out.println("\n------------- ARRAY OPERATIONS ------------");
            System.out.println("1. Insert Value");
            System.out.println("2. Delete Value");
            System.out.println("3. Search Value");
            System.out.println("4. Display Array");
            System.out.println("0. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            if (choice == 0) return;
            if (choice == 1) {
                array.insert(readInt("Enter value to insert: "));
                System.out.println("Value inserted.");
            } else if (choice == 2) {
                System.out.println(array.delete(readInt("Enter value to delete: ")) ? "Value deleted." : "Value not found.");
            } else if (choice == 3) {
                int index = array.search(readInt("Enter value to search: "));
                System.out.println(index >= 0 ? "Value found at index " + index + "." : "Value not found.");
            } else if (choice == 4) {
                System.out.print("Array values: ");
                array.display();
            } else {
                System.out.println("Invalid choice. Please select 0-4.");
            }
        }
    }

    static void stackMenu() {
        while (true) {
            System.out.println("\n------------- STACK OPERATIONS ------------");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek at Top");
            System.out.println("4. Display Stack");
            System.out.println("0. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            if (choice == 0) return;
            if (choice == 1) {
                stack.push(readInt("Enter value to push: "));
                System.out.println("Value pushed.");
            } else if (choice == 2) {
                print("Popped value", stack.pop());
            } else if (choice == 3) {
                print("Top value", stack.peek());
            } else if (choice == 4) {
                stack.display();
            } else {
                System.out.println("Invalid choice. Please select 0-4.");
            }
        }
    }

    static void queueMenu() {
        while (true) {
            System.out.println("\n-------------- QUEUE OPERATIONS ------------");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. View Front");
            System.out.println("4. Display Queue");
            System.out.println("0. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            if (choice == 0) return;
            if (choice == 1) {
                queue.enqueue(readInt("Enter value to enqueue: "));
                System.out.println("Value added to queue.");
            } else if (choice == 2) {
                print("Dequeued value", queue.dequeue());
            } else if (choice == 3) {
                print("Front value", queue.front());
            } else if (choice == 4) {
                queue.display();
            } else {
                System.out.println("Invalid choice. Please select 0-4.");
            }
        }
    }

    static void listMenu() {
        while (true) {
            System.out.println("\n----------- LINKED LIST OPERATIONS ---------");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete Value");
            System.out.println("4. Search Value");
            System.out.println("5. Display Linked List");
            System.out.println("0. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            if (choice == 0) return;
            if (choice == 1) {
                list.insertFront(readInt("Enter value to insert at front: "));
                System.out.println("Value inserted.");
            } else if (choice == 2) {
                list.insertEnd(readInt("Enter value to insert at end: "));
                System.out.println("Value inserted.");
            } else if (choice == 3) {
                System.out.println(list.delete(readInt("Enter value to delete: ")) ? "Value deleted." : "Value not found.");
            } else if (choice == 4) {
                System.out.println(list.search(readInt("Enter value to search: ")) ? "Value found." : "Value not found.");
            } else if (choice == 5) {
                System.out.print("Linked list: ");
                list.display();
            } else {
                System.out.println("Invalid choice. Please select 0-5.");
            }
        }
    }

    static void searchMenu() {
        while (true) {
            System.out.println("\n----------- SEARCHING OPERATIONS -----------");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Compare Both Search Methods");
            System.out.println("0. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            if (choice == 0) return;

            int[] data = array.toArray();
            if (data.length == 0) {
                System.out.println("Array is empty. Insert values before searching.");
                continue;
            }
            if (choice < 1 || choice > 3) {
                System.out.println("Invalid choice. Please select 0-3.");
                continue;
            }

            System.out.println("Current array: " + Arrays.toString(data));
            int target = readInt("Enter target value: ");
            if (choice == 1) {
                int index = SearchingAlgorithms.linearSearch(data, target);
                System.out.println(index >= 0 ? "Linear search: found at original index " + index + "." : "Linear search: value not found.");
            } else if (choice == 2) {
                int[] sorted = SearchingAlgorithms.sortedCopy(data);
                int index = SearchingAlgorithms.binarySearch(sorted, target);
                System.out.println("Sorted array used for binary search: " + Arrays.toString(sorted));
                System.out.println(index >= 0 ? "Binary search: found at sorted-array index " + index + "." : "Binary search: value not found.");
                System.out.println("Note: the index refers to the sorted array.");
            } else {
                int linearIndex = SearchingAlgorithms.linearSearch(data, target);
                int[] sorted = SearchingAlgorithms.sortedCopy(data);
                int binaryIndex = SearchingAlgorithms.binarySearch(sorted, target);
                System.out.println("Linear search result (original array): " + (linearIndex >= 0 ? "found at index " + linearIndex : "not found"));
                System.out.println("Sorted array for binary search: " + Arrays.toString(sorted));
                System.out.println("Binary search result (sorted array): " + (binaryIndex >= 0 ? "found at index " + binaryIndex : "not found"));
            }
        }
    }

    static void graphMenu() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS -----------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge");
            System.out.println("3. Display Graph");
            System.out.println("4. Search Vertex");
            System.out.println("5. BFS Traversal");
            System.out.println("6. DFS Traversal");
            System.out.println("0. Return to Main Menu");
            int choice = readInt("Enter your choice: ");
            if (choice == 0) return;
            if (choice == 1) {
                try {
                    graph.addVertex(readText("Enter vertex name: "));
                    System.out.println("Vertex added (or already exists).");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (choice == 2) {
                String from = readText("Enter starting vertex: ");
                String to = readText("Enter destination vertex: ");
                System.out.println(graph.addEdge(from, to) ? "Edge added." : "Both vertices must exist before adding an edge.");
            } else if (choice == 3) {
                System.out.println("Graph adjacency list:");
                graph.display();
            } else if (choice == 4) {
                System.out.println(graph.containsVertex(readText("Enter vertex to search: ")) ? "Vertex found." : "Vertex not found.");
            } else if (choice == 5) {
                System.out.println("BFS traversal order: " + graph.bfs(readText("Enter starting vertex: ")));
            } else if (choice == 6) {
                System.out.println("DFS traversal order: " + graph.dfs(readText("Enter starting vertex: ")));
            } else {
                System.out.println("Invalid choice. Please select 0-6.");
            }
        }
    }

    static void displayAll() {
        System.out.println("\n------------- DISPLAY ALL RESULTS ----------");
        System.out.print("Array: ");
        array.display();
        stack.display();
        queue.display();
        System.out.print("Linked list: ");
        list.display();
        System.out.println("Graph adjacency list:");
        graph.display();
    }

    static void seed() {
        for (int value : new int[]{10, 20, 30, 40, 50}) array.insert(value);
        for (int value : new int[]{100, 200, 300}) stack.push(value);
        for (int value : new int[]{11, 22, 33}) queue.enqueue(value);
        for (int value : new int[]{7, 14, 21}) list.insertEnd(value);
        for (String vertex : new String[]{"A", "B", "C", "D", "E"}) graph.addVertex(vertex);
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "E");
        graph.addEdge("D", "E");
    }

    static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("Input cannot be blank.");
        }
    }

    static void print(String label, Integer value) {
        System.out.println(value == null ? label + ": structure is empty." : label + ": " + value);
    }
}
