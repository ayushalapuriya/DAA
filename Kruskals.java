
import java.util.*;

public class Kruskals {
    private class Node {
        int val;
        Node parent;
        int rank;

        public Node(int val) {
            this.val = val;
            this.parent = this;
            this.rank = 0;
        }
    }

    private HashMap<Integer, Node> map = new HashMap<>();

    // CREATE
    public void create(int v) {
        if (!map.containsKey(v)) {
            Node nn = new Node(v);
            map.put(v, nn);
        }
    }

    // FIND
    public int findParent(int v) {
        if (!map.containsKey(v)) {
            throw new RuntimeException("Node not found");
        }
        Node nn = map.get(v);
        return findParent(nn).val;
    }

    private Node findParent(Node nn) {
        if (nn.parent == nn) {
            return nn;
        }
        Node n = findParent(nn.parent);
        nn.parent = n; // Path compression
        return n;
    }

    // UNION
    public void union(int v1, int v2) {
        if (!map.containsKey(v1) || !map.containsKey(v2)) {
            throw new RuntimeException("Both nodes must exist");
        }
        Node parent1 = findParent(map.get(v1));
        Node parent2 = findParent(map.get(v2));

        if (parent1.rank < parent2.rank) {
            parent1.parent = parent2;
        } else if (parent1.rank > parent2.rank) {
            parent2.parent = parent1;
        } else {
            parent2.parent = parent1;
            parent1.rank++;
        }
    }

    // ARRAY LIST
    public ArrayList<EdgePair> getAllEdges() {
        ArrayList<EdgePair> list = new ArrayList<>();
        for (int e1 : map.keySet()) {
            for (int e2 : map.keySet()) {
                if (e1 < e2) {
                    EdgePair eg = new EdgePair(e1, e2, 1); // Assuming cost is 1 for all edges
                    list.add(eg);
                }
            }
        }
        return list;
    }

    // SORT
    public void sortEdges(ArrayList<EdgePair> edges) {
        edges.sort(Comparator.comparingInt(e -> e.cost));
    }

    public class EdgePair {
        int v1;
        int v2;
        int cost;

        public EdgePair(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return this.v1 + "  " + this.v2 + "  " + this.cost;
        }
    }

    // KRUSKAL'S ALGORITHM
    public ArrayList<EdgePair> kruskalMST() {
        ArrayList<EdgePair> edges = getAllEdges();
        sortEdges(edges);
        ArrayList<EdgePair> mst = new ArrayList<>();

        for (EdgePair edge : edges) {
            if (findParent(edge.v1) != findParent(edge.v2)) {
                mst.add(edge);
                union(edge.v1, edge.v2);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        Kruskals kruskals = new Kruskals();
        kruskals.create(0);
        kruskals.create(1);
        kruskals.create(2);
        kruskals.create(3);

        ArrayList<EdgePair> mst = kruskals.kruskalMST();
        for (EdgePair edge : mst) {
            System.out.println(edge);
        }
    }
}
