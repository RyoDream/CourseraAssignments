package DataStructures;

import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class TreeHeight {
        int n;
        int parent[];

        void read() throws IOException {
            FastScanner in = new FastScanner();
            n = in.nextInt();
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = in.nextInt();
            }
        }

        int computeHeight() {
            Node root = buildTree();
            int res = recursiveComputeHeight(root);
            return res;
        }

        int recursiveComputeHeight(Node root) {
            if(root == null)
                return 0;

            if(root.child.size() == 0)
                return 1;

            int max = Integer.MIN_VALUE;

            for(int i=0;i<root.child.size();i++) {
                int temp = recursiveComputeHeight(root.child.get(i));
                max = (temp > max)?temp:max;
            }

            return max+1;
        }


        Node buildTree() {
            Node[] nodes = new Node[parent.length];
            for(int i=0;i<parent.length;i++) {
                nodes[i] = new Node(i);
            }

            int index = 0;

            for(int i=0;i<parent.length;i++) {
                int indexParent = parent[i];

                if(indexParent == -1) {
                    index = i;
                    continue;
                }

                nodes[indexParent].child.add(nodes[i]);
            }

            return nodes[index];
        }

        int computeHeight2() {
            // Replace this code with a faster implementation
            int maxHeight = 0;
            for (int vertex = 0; vertex < n; vertex++) {
                int height = 0;
                for (int i = vertex; i != -1; i = parent[i])
                    height++;
                maxHeight = Math.max(maxHeight, height);
            }
            return maxHeight;
        }
    }


    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new tree_height().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        TreeHeight tree = new TreeHeight();
        tree.read();
        System.out.println(tree.computeHeight());
    }


    class Node{
        int val;
        List<Node> child = new ArrayList<>();

        Node (int x) {
            val = x;
        }
    }

}
