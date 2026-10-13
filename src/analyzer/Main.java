package analyzer;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static ArrayOperations array=new ArrayOperations(5);
    static CustomStack stack=new CustomStack();
    static CustomQueue queue=new CustomQueue();
    static CustomLinkedList list=new CustomLinkedList();
    static Graph graph=new Graph();

    public static void main(String[] args) {
        seed();
        boolean run=true;
        System.out.println("====================================================");
        System.out.println("     CIT300 DATA STRUCTURE AND GRAPH ANALYZER");
        System.out.println("             Graded Practical Assignment 2");
        System.out.println("====================================================");
        while(run) {
            System.out.println("\n                    MAIN MENU");
            System.out.println();
            System.out.println("  1. Array Operations");
            System.out.println("  2. Stack Operations");
            System.out.println("  3. Queue Operations");
            System.out.println("  4. Linked List Operations");
            System.out.println("  5. Searching Algorithms");
            System.out.println("  6. Graph Operations (BFS / DFS)");
            System.out.println("  7. Performance and Complexity Analysis");
            System.out.println("  8. Display All Data Structures");
            System.out.println("  9. Exit");
            System.out.println("----------------------------------------------------");
            int c=readInt("Enter your choice: ");
            switch(c) {
                case 1 -> arrayMenu();
                case 2 -> stackMenu();
                case 3 -> queueMenu();
                case 4 -> listMenu();
                case 5 -> searchMenu();
                case 6 -> graphMenu();
                case 7 -> PerformanceAnalyzer.runDemo();
                case 8 -> displayAll();
                case 9 -> run=false;
                default -> System.out.println("Invalid choice.");
            }
        }
        System.out.println("Program ended.");
    }

    static void arrayMenu() {
        while(true) {
            System.out.println("\nARRAY: 1 Insert 2 Delete 3 Search 4 Display 0 Back");
            int c=readInt("Choice: "); if(c==0)return;
            if(c==1){array.insert(readInt("Value: "));}
            else if(c==2)System.out.println(array.delete(readInt("Value: "))?"Deleted.":"Not found.");
            else if(c==3){int i=array.search(readInt("Value: "));System.out.println(i>=0?"Found at index "+i:"Not found.");}
            else if(c==4)array.display(); else System.out.println("Invalid choice.");
        }
    }
    static void stackMenu() {
        while(true) {
            System.out.println("\nSTACK: 1 Push 2 Pop 3 Peek 4 Display 0 Back");
            int c=readInt("Choice: "); if(c==0)return;
            if(c==1)stack.push(readInt("Value: "));
            else if(c==2)print("Popped",stack.pop());
            else if(c==3)print("Top",stack.peek());
            else if(c==4)stack.display(); else System.out.println("Invalid choice.");
        }
    }
    static void queueMenu() {
        while(true) {
            System.out.println("\nQUEUE: 1 Enqueue 2 Dequeue 3 Front 4 Display 0 Back");
            int c=readInt("Choice: "); if(c==0)return;
            if(c==1)queue.enqueue(readInt("Value: "));
            else if(c==2)print("Dequeued",queue.dequeue());
            else if(c==3)print("Front",queue.front());
            else if(c==4)queue.display(); else System.out.println("Invalid choice.");
        }
    }
    static void listMenu() {
        while(true) {
            System.out.println("\nLINKED LIST: 1 Front 2 End 3 Delete 4 Search 5 Display 0 Back");
            int c=readInt("Choice: "); if(c==0)return;
            if(c==1)list.insertFront(readInt("Value: "));
            else if(c==2)list.insertEnd(readInt("Value: "));
            else if(c==3)System.out.println(list.delete(readInt("Value: "))?"Deleted.":"Not found.");
            else if(c==4)System.out.println(list.search(readInt("Value: "))?"Found.":"Not found.");
            else if(c==5)list.display(); else System.out.println("Invalid choice.");
        }
    }
    static void searchMenu() {
        int[] d=array.toArray();
        if(d.length==0){System.out.println("Array is empty.");return;}
        System.out.println("Current data: "+Arrays.toString(d));
        int t=readInt("Target: ");
        int l=SearchingAlgorithms.linearSearch(d,t);
        int[] sorted = SearchingAlgorithms.sortedCopy(d);
        int b=SearchingAlgorithms.binarySearch(sorted,t);
        System.out.println(l>=0?"Linear: found at original index "+l:"Linear: not found.");
        System.out.println("Sorted copy for binary search: "+Arrays.toString(sorted));
        System.out.println(b>=0?"Binary: found in sorted copy at index "+b:"Binary: not found.");
        System.out.println("Note: the binary-search index refers to the sorted copy, not the original array.");
    }
    static void graphMenu() {
        while(true) {
            System.out.println("\nGRAPH: 1 Vertex 2 Edge 3 Display 4 Search 5 BFS 6 DFS 0 Back");
            int c=readInt("Choice: "); if(c==0)return;
            if(c==1){graph.addVertex(readText("Vertex: "));}
            else if(c==2){String a=readText("From: "),b=readText("To: ");System.out.println(graph.addEdge(a,b)?"Edge added.":"Both vertices must exist.");}
            else if(c==3)graph.display();
            else if(c==4)System.out.println(graph.containsVertex(readText("Vertex: "))?"Found.":"Not found.");
            else if(c==5)System.out.println("BFS: "+graph.bfs(readText("Start: ")));
            else if(c==6)System.out.println("DFS: "+graph.dfs(readText("Start: ")));
            else System.out.println("Invalid choice.");
        }
    }
    static void displayAll(){System.out.print("Array: ");array.display();stack.display();queue.display();System.out.print("List: ");list.display();System.out.println("Graph:");graph.display();}
    static void seed(){
        for(int x:new int[]{10,20,30,40,50})array.insert(x);
        for(int x:new int[]{100,200,300})stack.push(x);
        for(int x:new int[]{11,22,33})queue.enqueue(x);
        for(int x:new int[]{7,14,21})list.insertEnd(x);
        for(String v:new String[]{"A","B","C","D","E"})graph.addVertex(v);
        graph.addEdge("A","B");graph.addEdge("A","C");graph.addEdge("B","D");graph.addEdge("C","E");graph.addEdge("D","E");
    }
    static int readInt(String p){
        while(true){System.out.print(p);try{return Integer.parseInt(sc.nextLine().trim());}catch(Exception e){System.out.println("Enter a valid whole number.");}}
    }
    static String readText(String p){
        while(true){System.out.print(p);String s=sc.nextLine().trim();if(!s.isEmpty())return s;System.out.println("Cannot be blank.");}
    }
    static void print(String label,Integer v){System.out.println(v==null?label+": structure is empty.":label+": "+v);}
}