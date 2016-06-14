package AlgorithmicToolbox.week3;

import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        Arrays.sort(segments);
        int[] points = new int[segments.length*2];
        int counts = 0;
        int nextIndex = 1;

        points[2*counts] = segments[0].start;
        points[2*counts+1] = segments[0].end;

        while (nextIndex < segments.length) {

            Segment next = segments[nextIndex];

            if(next.start <= points[2*counts+1]) {
                points[2*counts] = next.start;
                if(next.end < points[2*counts+1])
                    points[2*counts+1] = next.end;
            }
            else {
                counts++;
                points[2*counts] = next.start;
                points[2*counts+1] = next.end;
            }
            nextIndex++;
        }

        int[] res = new int[(counts+1)];
        for(int i=0;i<res.length;i++)
            res[i] = points[i*2+1];

        return res;
    }

    private static class Segment implements Comparable<Segment>{
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment s) {
            return this.start - s.start;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}

