package DukeJavaProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shiyanch on 8/30/16.
 */
public class CodonCount {
    private HashMap<String, Integer> codonMap = new HashMap<>();

    public void buildCodonMap(int start, String dna) {
        codonMap.clear();
        int end = dna.length() - 1;
        while(end - start > 1) {
            String curCodon = dna.substring(start, start+3);
            if(codonMap.containsKey(curCodon))
                codonMap.put(curCodon, codonMap.get(curCodon)+1);
            else
                codonMap.put(curCodon, 1);
            start+=3;
        }
    }

    public void printCodonCounts(int start, int end) {
        for(Map.Entry<String, Integer> entry:codonMap.entrySet()) {
            if(entry.getValue() >= start && entry.getValue() <= end)
                System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public String getMostCommonCodon() {
        String mostCommon = "";
        int max = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> entry:codonMap.entrySet()) {
            if(entry.getValue() > max) {
                mostCommon = entry.getKey();
                max = entry.getValue();
            }
        }
        return mostCommon;
    }

    public void test() {
        String dna = "CGTTCAAGTTCAA";
        innerTest(dna, 0, 1, 5);
        innerTest(dna, 1, 1, 5);
        innerTest(dna, 2, 1, 5);

    }

    private void innerTest(String dna, int start, int low, int high) {
        buildCodonMap(start, dna);
        System.out.println("Reading frame starting with "+start
                +" results in "+codonMap.size()+" unique codons");

        String mostCommon = getMostCommonCodon();
        System.out.println("and most common codon is "+mostCommon
                +" with count "+codonMap.get(mostCommon));

        System.out.println("Counts of codons between "+low+" and "+high
                +" inclusive are:");
        printCodonCounts(low, high);
        System.out.println();
    }

    public static void main(String[] args) {
        CodonCount count = new CodonCount();
        count.test();
    }
}
