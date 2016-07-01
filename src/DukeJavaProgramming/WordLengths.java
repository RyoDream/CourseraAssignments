package DukeJavaProgramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class WordLengths {
    public static int testCountWordLengths(String text) {
        int max = Integer.MIN_VALUE;
        int[] counts = new int[31];
        String[] words = text.split("[ \n]+");
        for(String word: words) {
            int count = word.length();
            if(!Character.isLetter(word.charAt(0)))
                count--;
            if(!Character.isLetter(word.charAt(word.length()-1)))
                count--;

            if(count < 0) {
                System.out.println(word);
                int index = text.indexOf(word);
                System.out.println(words[index-1]);
                System.out.println(words[index+1]);
            }

            if(count >= counts.length)
                count = counts.length-1;
            counts[count]++;
            if(counts[count] > max)
                max = counts[count];
        }

        for(int i=0;i<counts.length;i++) {
            System.out.println(i+" : "+counts[i]);
        }
        System.out.println(max);
        return max;
    }

    public static void main(String[] args) {
//        StringBuilder text = new StringBuilder("Laer. My necessaries are embark'd. Farewell.\n" +
//                "\n" +
//                "And, sister, as the winds give benefit");
        StringBuilder text = new StringBuilder("");

        try{
            File file = new File("/Users/shiyanch/Documents/workspace/CourseraCourses/src/DukeJavaProgramming/manywords.txt");
            if(file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null)
                    text.append(lineTxt);
                read.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        testCountWordLengths(text.toString());
    }
}
