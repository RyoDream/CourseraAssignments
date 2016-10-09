package AlgorithmsOnGraphs.week5;

import java.util.Scanner;

public class ConnectingPoints {
    private static double minimumDistance(int[] x, int[] y) {
        double result = 0.;

        double[][] adj = new double[x.length][y.length];
        int[] pre = new int[x.length];

        for(int i=0;i<x.length;i++) {
            for(int j=i;j<x.length;j++) {
                adj[i][j] = distance(x[i], x[j], y[i], y[j]);
                adj[j][i] = adj[i][j];
            }
        }

        double[] dist = new double[x.length];
        for(int i=0;i<x.length;i++)
            dist[i] = Double.MAX_VALUE;
        dist[0] = 0d;
        pre[0] = 0;

        final boolean[] isVisited = new boolean[x.length];
        for(int i=0;i<x.length;i++) {
            int cur = minVertex(dist, isVisited);
            isVisited[cur] = true;

            for(int j=0;j<x.length;j++) {
                if(!isVisited[j] && adj[cur][j] != 0d) {
                    if(adj[cur][j] < dist[j]) {
                        dist[j] = adj[cur][j];
                        pre[j] = cur;
                    }
                }
            }
        }

        for(double distance : dist)
            result += distance;

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        System.out.println(minimumDistance(x, y));
    }

    private static double distance(int x1, int x2, int y1, int y2) {
        return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    }

    private static int minVertex (double[] dist, boolean[] isVisited) {
        double min = Integer.MAX_VALUE;
        int v = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!isVisited[i] && dist[i] <= min) {
                min = dist[i];
                v = i;
            }
        }
        return v;
    }
}

