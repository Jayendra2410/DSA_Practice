import java.util.*;
import java.io.*;
public class HybridBananas {
    private static final int MAX_SPOTS = 151; 
    private static final long INFINITY = Long.MAX_VALUE;
    static class State implements Comparable<State> {
        int id;
        int tree; 
        long energy;
        public State(int id, int tree, long energy) {
            this.id = id;
            this.tree = tree;
            this.energy = energy;
        }
        @Override
        public int compareTo(State other) {
            return Long.compare(this.energy, other.energy);
        }
    }
    static class Edge {
        int destination;
        int tree;
        int weight;

        public Edge(int destination, int tree, int weight) {
            this.destination = destination;
            this.tree = tree;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        List<List<int[]>> treeSegments = new ArrayList<>(); 
        List<int[]> currentTree = new ArrayList<>();
        Map<Integer, Set<Integer>> spotToTrees = new HashMap<>(); 
        int treeIndex = 0;
        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();
            if ("break".equals(line)) {
                if (!currentTree.isEmpty()) {
                    treeSegments.add(currentTree);
                }
                currentTree = new ArrayList<>();
                treeIndex++;
                continue;
            }
            String[] parts = line.split("\\s+");
            if (parts.length == 0 || (parts.length == 1 && parts[0].isEmpty())) {
                continue;
            }
            int A = Integer.parseInt(parts[0]);
            spotToTrees.computeIfAbsent(A, k -> new HashSet<>()).add(treeIndex);
            for (int j = 1; j < parts.length; j++) {
                int B = Integer.parseInt(parts[j]);
                spotToTrees.computeIfAbsent(B, k -> new HashSet<>()).add(treeIndex);  
                currentTree.add(new int[]{A, B});
            }
        }
        if (!currentTree.isEmpty()) {
            treeSegments.add(currentTree);
        }
        int totalTrees = treeSegments.size();
        List<Edge>[][] adj = new List[MAX_SPOTS][totalTrees];
        for (int i = 0; i < MAX_SPOTS; i++) {
            for (int j = 0; j < totalTrees; j++) {
                adj[i][j] = new ArrayList<>();
            }
        }
        for (int t = 0; t < totalTrees; t++) {
            for (int[] relation : treeSegments.get(t)) {
                int A = relation[0]; 
                int B = relation[1]; 
                adj[A][t].add(new Edge(B, t, 1));
                adj[B][t].add(new Edge(A, t, 0));
            }
        }
        for (Map.Entry<Integer, Set<Integer>> entry : spotToTrees.entrySet()) {
            int spot = entry.getKey();
            Set<Integer> trees = entry.getValue();
            if (trees.size() > 1) { 
                List<Integer> treeList = new ArrayList<>(trees);
                for (int t1_index = 0; t1_index < treeList.size(); t1_index++) {
                    for (int t2_index = t1_index + 1; t2_index < treeList.size(); t2_index++) {
                        int t1 = treeList.get(t1_index);
                        int t2 = treeList.get(t2_index);
                        adj[spot][t1].add(new Edge(spot, t2, 1));
                        adj[spot][t2].add(new Edge(spot, t1, 1));
                    }
                }
            }
        }
        String lastLine = br.readLine().trim();
        String[] spots = lastLine.split("\\s+");
        int startSpot = Integer.parseInt(spots[0]);
        int destSpot = Integer.parseInt(spots[1]);
        long result = dijkstra(adj, startSpot, destSpot, totalTrees);
        System.out.println(result);
    }
    private static long dijkstra(List<Edge>[][] adj, int start, int destination, int totalTrees) {
        long[][] energy = new long[MAX_SPOTS][totalTrees];
        for (int i = 0; i < MAX_SPOTS; i++) {
            Arrays.fill(energy[i], INFINITY);
        }
        PriorityQueue<State> pq = new PriorityQueue<>();  
        for (int t = 0; t < totalTrees; t++) {
             if (adj[start][t].isEmpty() && totalTrees > 1) continue;      
             energy[start][t] = 0;
             pq.add(new State(start, t, 0));
        }
        while (!pq.isEmpty()) {
            State current = pq.poll();
            int u = current.id;
            int uTree = current.tree;
            long uEnergy = current.energy;
            if (uEnergy > energy[u][uTree]) {
                continue;
            }
            if (u == destination) {
                return uEnergy;
            }
            List<Edge> neighbors = adj[u][uTree];
            for (Edge edge : neighbors) {
                int v = edge.destination;
                int vTree = edge.tree;
                int weight = edge.weight;
                long newEnergy = uEnergy + weight;
                if (newEnergy < energy[v][vTree]) {
                    energy[v][vTree] = newEnergy;
                    pq.add(new State(v, vTree, newEnergy));
                }
            }
        }
        return -1; 
    }
}