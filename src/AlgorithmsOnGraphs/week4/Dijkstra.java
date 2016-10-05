package AlgorithmsOnGraphs.week4;
import java.util.*;

public class Dijkstra {
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        final int[] dist = new int[adj.length];
        final boolean[] isVisited = new boolean[adj.length];

        for(int i=0;i<adj.length;i++)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;

        for(int i=0;i<adj.length;i++) {
            final int cur = minVertex(dist, isVisited);
            isVisited[cur] = true;

            for(int neighbor : adj[cur]) {
                if(!isVisited[neighbor]) {
                    final int d = dist[cur] + cost[cur].get(adj[cur].indexOf(neighbor));
                    if (d < dist[neighbor])
                        dist[neighbor] = d;
                }
            }
        }
        return dist[t]==Integer.MAX_VALUE?-1:dist[t];
    }

    private static int minVertex (int[] dist, boolean[] isVisited) {
        int min = Integer.MAX_VALUE;
        int v = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!isVisited[i] && dist[i] <= min) {
                min = dist[i];
                v = i;
            }
        }
        return v;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

