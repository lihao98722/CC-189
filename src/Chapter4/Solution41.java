package Chapter4;

import java.util.LinkedList;

/**
 * Created by Hao on 9/22/15.
 */
public class Solution41 {

    /* graph is represented by a two-dimensional integer array, int[u][v] > 0 means existing an edge from u to v,
     * while int[u][v] = 0 means there is no edge from u to v.
     * nodes in the graph are labeled from 0 - (n-1), n is the number of nodes in the graph
     */

    // breadth-first search
    public static boolean searchPath(int[][] graph, int start, int end) {
        if (start == end) {
            return true;
        }
        boolean[] visited = new boolean[graph.length];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int curNode = queue.removeFirst();
            if (curNode == end) {
                return true;
            }
            visited[curNode] = true;
            // find all unvisited adjacent
            for (int node = 0; node < graph.length; ++node) {
                if (visited[node] == false && graph[curNode][node] > 0) {
                    queue.add(node);
                }
            }
        }
        return false;
    }

    /* Other approaches:
     * depth-first search
     */
}
