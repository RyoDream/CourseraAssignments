package DataStructures.week3;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class HashSubstring {

    private static FastScanner in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        printOccurrences(getOccurrences(readInput()));
        out.close();
    }

    private static Data readInput() throws IOException {
        String pattern = in.next();
        String text = in.next();
        return new Data(pattern, text);
    }

    private static void printOccurrences(List<Integer> ans) throws IOException {
        if(ans.size() != 0) {
            for (Integer cur : ans) {
                out.print(cur);
                out.print(" ");
            }
        }
        else
            out.print("");
    }

    private static List<Integer> getOccurrences(Data input) {
        List<Integer> occurrences = new ArrayList<Integer>();
        String pat = input.pattern;
        String txt = input.text;

        int R = 256;
        int M = pat.length();
        int N = txt.length();
        long Q = BigInteger.probablePrime(31, new Random()).longValue();
        long RM = 1;
        long patHash = polyHash(pat, Q, R, M);

        for(int i=1;i<=M-1;i++)
            RM = (R*RM)%Q;

        if(N < M)
            return occurrences;

        long txtHash = polyHash(txt.subSequence(0,M).toString(), Q, R, M);
        if((patHash == txtHash) && areEqual(pat, txt.subSequence(0,M).toString())) {
            occurrences.add(0);
        }

        for(int i=M;i<N;i++) {
            txtHash = (txtHash + Q - RM*txt.charAt(i-M)%Q)%Q;
            txtHash = (txtHash*R + txt.charAt(i))%Q;

            if((patHash == txtHash) && areEqual(pat, txt.subSequence(i-M+1,i+1).toString()))
                occurrences.add(i-M+1);
        }

        return occurrences;
    }

    private static boolean areEqual(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;

        for(int i=0;i<s1.length();i++)
            if(s1.charAt(i) != s2.charAt(i))
                return false;

        return true;
    }

    private static long[] precomputeHashes(String t, int patternLength, long prime, int x) {
        long[] hashValues = new long[t.length()-patternLength+1];
        String s = t.substring(t.length()-patternLength, t.length());
        hashValues[t.length()-patternLength] = polyHash(s, prime, x, s.length());

        long y = 1;
        for(int i=1;i<=patternLength;i++)
            y = (y*x) % prime;

        for(int i=t.length()-patternLength-1; i>=0;i--)
            hashValues[i] = (x*hashValues[i+1] + t.charAt(i) - y*t.charAt(i+patternLength)) % prime;

        return hashValues;
    }


    private static long polyHash(String s, long prime, int x, int size) {
        long hashValue = 0;

        for(int i=0;i<size;i++)
            hashValue = (hashValue*x + s.charAt(i))%prime;
        return hashValue;
    }

    static class Data {
        String pattern;
        String text;
        public Data(String pattern, String text) {
            this.pattern = pattern;
            this.text = text;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}

