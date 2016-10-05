package AlgorithmsOnGraphs.week4;

import java.util.*;

public class ShortestPaths {

    private static void shortestPaths(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, long[] distance, int[] reachable, int[] shortest) {
        Queue<Integer> queue = new LinkedList<>();
        int[] prev = new int[adj.length];
        bfs(adj, s, reachable);
        negativeCycle(s, adj, cost, distance, prev, reachable);

        for(int v=0;v<adj.length;v++) {
            if(reachable[v] == 1) {
                for (int neighbor : adj[v]) {
                    if (cost[v].get(adj[v].indexOf(neighbor)) < distance[neighbor] - distance[v]) {
                        distance[neighbor] = distance[v] + cost[v].get(adj[v].indexOf(neighbor));
                        queue.offer(neighbor);
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int pre = prev[cur];
            shortest[cur] = 0;
            while(pre != cur && shortest[pre]!=0) {
                shortest[pre] = 0;
                pre = prev[pre];
            }
        }

        shortest[s] = 1;
        distance[s] = 0;
    }

    private static void negativeCycle(int start, ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, long[] dist, int[] prev, int[] reachable) {
        dist[start] = 0;
        for(int i=0;i<adj.length-1;i++) {
            for(int v=0;v<adj.length;v++) {
                if(reachable[v] == 1) {
                    for (int neighbor : adj[v]) {
                        if (cost[v].get(adj[v].indexOf(neighbor)) < dist[neighbor] - dist[v]) {
                            dist[neighbor] = dist[v] + cost[v].get(adj[v].indexOf(neighbor));
                            prev[neighbor] = v;
                        }
                    }
                }
            }
        }
    }

    private static void bfs(ArrayList<Integer>[] adj, int s, int[] reachable) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            reachable[cur] = 1;

            for(int neihbor : adj[cur]) {
                if(reachable[neihbor] != 1) {
                    queue.add(neihbor);
                }
            }
        }
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
        int s = scanner.nextInt() - 1;
        long distance[] = new long[n];
        int reachable[] = new int[n];
        int shortest[] = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Long.MAX_VALUE;
            reachable[i] = 0;
            shortest[i] = 1;
        }
        shortestPaths(adj, cost, s, distance, reachable, shortest);
        for (int i = 0; i < n; i++) {
            if (reachable[i] == 0) {
                System.out.println('*');
            } else if (shortest[i] == 0) {
                System.out.println('-');
            } else {
                System.out.println(distance[i]);
            }
        }
    }

}

