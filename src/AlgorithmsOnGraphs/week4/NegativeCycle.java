package AlgorithmsOnGraphs.week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NegativeCycle {
    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        cost = transformCost(cost);
        int[] dist = new int[adj.length];
        for(int i=0;i<dist.length;i++)
            dist[i] = Integer.MAX_VALUE;

        for(int i=0;i<adj.length-1;i++) {
            for(int v=0;v<adj.length;v++) {
                for(int neighbor : adj[v]) {
                    if(dist[v]+cost[v].get(adj[v].indexOf(neighbor)) < dist[neighbor]) {
                        dist[neighbor] = dist[v] + cost[v].get(adj[v].indexOf(neighbor));
                    }
                }
            }
        }

        for(int v=0;v<adj.length;v++) {
            for(int neighbor : adj[v]) {
                if(dist[neighbor] > dist[v]+cost[v].get(adj[v].indexOf(neighbor)))
                    return 1;
            }
        }

        return 0;
    }

    private static ArrayList<Integer>[] transformCost(ArrayList<Integer>[] cost) {
        ArrayList<Integer>[] newCost = new ArrayList[cost.length];
        for(int i=0;i<cost.length;i++) {
            newCost[i] = new ArrayList<>();
            for(int value : cost[i]) {
                newCost[i].add((int)(-Math.log(value)*1000));
            }
        }

        return newCost;
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
        System.out.println(negativeCycle(adj, cost));
    }
}

