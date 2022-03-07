package graph.classic;

import java.util.*;

/**
 * Problem :
 * <p>
 * Given a directed graph.
 * <p>
 * The task is to do Breadth First Traversal of this graph starting from 0.
 * <p>
 * Note: One can move from node u to node v only if there's an edge from u to v
 * <p>
 * find the BFS traversal of the graph starting from the 0th vertex
 */

/**
 * =============
 * APPROACH :
 * =============
 * <p>
 * <p>
 * ===========
 * TC = O(v+e)
 * <p>
 * every edge is considered exactly twice, and every node is processed exactly once,
 * so the complexity has to be a constant multiple of the number of edges as well as the number of vertices.
 * <p>
 * <p>
 * SC = O(v)
 * array of visited nodes ,
 * plus recursion stack , all nodes can be there , if graph is star like
 */

public class p1_bfs {

    public static void main(String[] args) {
        p1_bfs_using_adj_list.driver_function();
        p1_bfs_using_2d_matrix.driver_function();

    }
}


class p1_bfs_using_adj_list {


    static void driver_function() {
        System.out.println("BFS using adj list : ");


        List<List<Integer>> adj_list = new LinkedList<>();

        // graph with 5 nodes : expected 0 1 2 3 4
        adj_list.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3))); //neighbours of 0 (directed - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 1 (directed - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList(4))); //neighbours of 2 (directed - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 3 (directed - edge)
        adj_list.add(new ArrayList<Integer>(Arrays.asList())); //neighbours of 4 (directed - edge)


        List<Integer> answer = get_bfs(adj_list);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static List<Integer> get_bfs(List<List<Integer>> adj_list) {
        List<Integer> bfs = new LinkedList<>();

        int num_nodes = adj_list.size();
        boolean[] vis = new boolean[num_nodes];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        vis[0] = true;

        while (q.size() > 0) {
            Integer polled = q.poll();
            bfs.add(polled);

            List<Integer> ngbrs = adj_list.get(polled);
            for (Integer ngbr : ngbrs) {
                if (!vis[ngbr]) {
                    q.offer(ngbr);
                    vis[ngbr] = true;
                }
            }
        }

        return bfs;
    }

}


/**
 * Given a matrix of size M x N consisting of integers,
 * <p>
 * the task is to print the matrix elements in BFS way
 */

class p1_bfs_using_2d_matrix {

    static void driver_function() {
        System.out.println("BFS using 2d matrix : ");


        // 3x3 matrix
        int[][] graph = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        List<Integer> answer = get_bfs(graph);
        for (Integer i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    private static List<Integer> get_bfs(int[][] grid) {

        List<Integer> bfs = new LinkedList<>();

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        int[] x_ngbr = new int[]{-1, 1, 0, 0};
        int[] y_ngbr = new int[]{0, 0, -1, 1};


        vis[0][0] = true;
        q.add(new int[]{0, 0});

        while (q.size() > 0) {
            int[] popped = q.poll();

            bfs.add(grid[popped[0]][popped[1]]);

            for (int i = 0; i < x_ngbr.length; i++) {
                int nx = popped[0] + x_ngbr[i];
                int ny = popped[1] + y_ngbr[i];

                if (is_safe(nx, ny, vis)) {
                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }

        }

        return bfs;
    }


    private static boolean is_safe(int x, int y, boolean[][] vis) {
        int r = vis.length;
        int c = vis[0].length;
        return (x > -1 && x < r && y > -1 && y < c && !vis[x][y]);
    }


}
