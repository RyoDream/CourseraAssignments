package AlgorithmicToolbox.week3;

import java.text.DecimalFormat;
import java.util.*;

public class FractionalKnapsack {

    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;

        List<ValuePair> list = new ArrayList<>();
        for(int i=0;i<values.length;i++) {
            ValuePair temp = new ValuePair(values[i]/(1.0*weights[i]), i);
            list.add(temp);
        }

        Collections.sort(list);
        int[] index = new int[values.length];

        for(int i=0;i<values.length;i++) {
            index[i] = list.get(i).index;
        }

        int tempIndex = 0;

        while(capacity>0 && tempIndex<values.length) {
            int curIndex = index[tempIndex];
            if(capacity >= weights[curIndex]) {
                capacity -= weights[curIndex];
                value += values[curIndex];
            }
            else {
                value += list.get(tempIndex).unitValue*capacity;
                capacity = 0;
            }

            tempIndex++;

        }



        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        double res = getOptimalValue(capacity, values, weights);
        DecimalFormat df = new DecimalFormat("#.0000");

        System.out.println(df.format(res));
    }
}

class ValuePair implements Comparable<ValuePair>{
    double unitValue;
    int index;

    ValuePair(double unitValue, int index) {
        this.unitValue = unitValue;
        this.index = index;
    }

    @Override
    public int compareTo(ValuePair pair) {
        return (this.unitValue > pair.unitValue)?-1:1;
    }
}
