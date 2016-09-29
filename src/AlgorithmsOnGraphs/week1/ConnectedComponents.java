package AlgorithmsOnGraphs.week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        boolean[] isVisited = new boolean[adj.length];
        for(int i=0;i<isVisited.length;i++) {
            if(!isVisited[i]) {
                result++;
                bfs(adj, i, isVisited);
            }
        }
        return result;
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
        System.out.println(numberOfComponents(adj));
    }

    private static void bfs(ArrayList<Integer>[] adj, int start, boolean[] isVisited) {
        if(isVisited[start])
            return;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int neighbour : adj[cur]) {
                if(!isVisited[neighbour])
                    queue.add(neighbour);
            }
            isVisited[cur] = true;
        }

    }
}


