package AlgorithmsOnGraphs.week2;

import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {

        int[] isVisited = new int[adj.length];

        for(int i=0;i<isVisited.length;i++) {
            if(isVisited[i] != 2 && dfs(adj, i, isVisited))
                return 1;
        }

        return 0;
    }

    private static boolean dfs(ArrayList<Integer>[] adj, int start, int[] isVisited) {
        isVisited[start] = 1;
        for(int neighbour : adj[start]) {
            if(isVisited[neighbour] == 2)
                continue;

            if(isVisited[neighbour] == 1)
                return true;

            if(dfs(adj, neighbour, isVisited))
                return true;
        }

        isVisited[start] = 2;
        return false;
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
        }
        System.out.println(acyclic(adj));
    }
}

