package AlgorithmsOnGraphs.week2;

import java.util.*;

public class StronglyConnected {
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        boolean[] isVisited = new boolean[adj.length];
        Stack stack = new Stack();

        for(int i=0;i<adj.length;i++) {
            if(!isVisited[i])
                fillOrder(adj, i, isVisited, stack);
        }

        adj = getTranspose(adj);
        isVisited = new boolean[adj.length];

        int count = 0;
        while(!stack.isEmpty()) {
            int i = (int)stack.pop();
            if (!isVisited[i]) {
                count++;
                DFSUtil(adj, i, isVisited);
            }
        }

        return count;
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
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }

    private static ArrayList<Integer>[] getTranspose(ArrayList<Integer>[] adj) {
        ArrayList<Integer>[] new_adj = new ArrayList[adj.length];

        for (int i=0;i<adj.length;i++) {
            new_adj[i] = new ArrayList<Integer>();
        }

        for (int i=0;i<adj.length;i++) {
            Iterator<Integer> iterator = adj[i].iterator();
            while(iterator.hasNext())
                new_adj[iterator.next()].add(i);
        }
        return new_adj;
    }

    private static void fillOrder(ArrayList<Integer>[] adj, int v, boolean isVisited[], Stack stack) {
        isVisited[v] = true;

        Iterator<Integer> iterator = adj[v].iterator();
        while(iterator.hasNext()) {
            int n = iterator.next();
            if(!isVisited[n])
                fillOrder(adj, n, isVisited, stack);
        }

        stack.push(v);
    }

    private static void DFSUtil(ArrayList<Integer>[] adj, int v, boolean[] isVisited) {
        isVisited[v] = true;
        int n;
        Iterator<Integer> iterator = adj[v].iterator();
        while(iterator.hasNext()) {
            n = iterator.next();
            if(!isVisited[n])
                DFSUtil(adj, n, isVisited);
        }
    }
}

