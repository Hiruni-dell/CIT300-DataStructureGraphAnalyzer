package analyzer;
import java.util.*;

public class Graph {
    private final Map<String, Set<String>> adjacency = new LinkedHashMap<>();

    public void addVertex(String v) {
        if (v == null || v.trim().isEmpty()) throw new IllegalArgumentException("Vertex cannot be blank.");
        adjacency.putIfAbsent(v.trim(), new LinkedHashSet<>());
    }
    public boolean addEdge(String a, String b) {
        if (a == null || b == null) return false;
        String from = a.trim();
        String to = b.trim();
        if (!adjacency.containsKey(from) || !adjacency.containsKey(to)) return false;
        adjacency.get(from).add(to);
        adjacency.get(to).add(from);
        return true;
    }
    public boolean containsVertex(String v) { return v != null && adjacency.containsKey(v.trim()); }
    public void display() {
        if (adjacency.isEmpty()) { System.out.println("Graph is empty."); return; }
        for (Map.Entry<String,Set<String>> e : adjacency.entrySet()) System.out.println(e.getKey()+" -> "+e.getValue());
    }
    public List<String> bfs(String start) {
        if (!containsVertex(start)) return Collections.emptyList();
        List<String> order = new ArrayList<>(); Set<String> seen = new LinkedHashSet<>();
        Queue<String> q = new ArrayDeque<>(); q.add(start.trim()); seen.add(start.trim());
        while (!q.isEmpty()) {
            String v=q.remove(); order.add(v);
            for(String n:adjacency.get(v)) if(seen.add(n)) q.add(n);
        }
        return order;
    }
    public List<String> dfs(String start) {
        if (!containsVertex(start)) return Collections.emptyList();
        List<String> order=new ArrayList<>(); Set<String> seen=new LinkedHashSet<>();
        dfsVisit(start.trim(),seen,order); return order;
    }
    private void dfsVisit(String v, Set<String> seen, List<String> order) {
        seen.add(v); order.add(v);
        for(String n:adjacency.get(v)) if(!seen.contains(n)) dfsVisit(n,seen,order);
    }
}