package AlgorithmsOnGraphs.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        // color[i] can be -1, 0, 1, each presents white, uncolored and black
        int[] colors = new int[adj.length];
        for(int i=0;i<adj.length;i++) {
            if(colors[i] == 0 && !BFS_bipartite(adj, colors, i))
                return 0;
        }
        return 1;
    }

    private static boolean BFS_bipartite(ArrayList<Integer>[] adj, int[] colors, int v) {
        int color = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        colors[v] = color;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int cur = queue.poll();
                for(int neighbor : adj[cur]) {
                    if(colors[neighbor] == color)
                        return false;

                    if(colors[neighbor] == 0) {
                        colors[neighbor] = -color;
                        queue.add(neighbor);
                    }
                }
            }
            color = -color;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(bipartite(adj));
    }
}

