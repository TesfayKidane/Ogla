package blind75.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    static class Node {
        int val;
        List<Node> neighbors;

        Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        Node(int value) {
            this.val = value;
            neighbors = new ArrayList<>();
        }

        Node(int value, List<Node> neighbours) {
            this.val = value;
            this.neighbors = neighbours;
        }
    }

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> oldToNewMap = new HashMap<>();
        return dfs(oldToNewMap, node);
    }

    private Node dfs(Map<Node, Node> oldToNewMap, Node node) {

        if(oldToNewMap.containsKey(node))
            return oldToNewMap.get(node);

        Node copy = new Node(node.val);
        oldToNewMap.put(node, copy);
        for(Node nei : node.neighbors) {
            copy.neighbors.add(dfs(oldToNewMap, nei));
        }

        return copy;
    }
}
