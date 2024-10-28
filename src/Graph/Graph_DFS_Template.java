package Graph;

import java.util.*;

public class Graph_DFS_Template {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph_DFS_Template() {
        adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
    }

    // DFS template
    public void dfs(int node, Set<Integer> visited) {
        // Base case: If already visited, return
        if (visited.contains(node)) return;

        // Mark the node as visited
        visited.add(node);
        // Process the node (e.g., print it)
        System.out.print(node + " ");

        // Recur for all adjacent nodes
        for (int neighbor : adjacencyList.getOrDefault(node, Collections.emptyList())) {
            dfs(neighbor, visited);
        }
    }

    public void startDFS(int start) {
        Set<Integer> visited = new HashSet<>();
        dfs(start, visited);
    }


    // DFS using stack
    public void dfsUsingStack(int start) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            // If already visited, continue
            if (visited.contains(node)) continue;

            // Mark the node as visited
            visited.add(node);
            // Process the node (e.g., print it)
            System.out.print(node + " ");

            // Push all unvisited adjacent nodes onto the stack
            for (int neighbor : adjacencyList.getOrDefault(node, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }
    }
}

