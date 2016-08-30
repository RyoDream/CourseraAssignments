package DukeJavaProgramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by shiyanch on 8/27/16.
 */
public class WordFrequencies {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequencies() {
        myFreqs = new ArrayList<>();
        myWords = new ArrayList<>();
    }

    public void scanWords() {
        try{
            File file = new File("/Users/shiyanch/Documents/workspace/CourseraCourses/src/DukeJavaProgramming/likeit.txt");
            if(file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null) {
                    lineTxt = lineTxt.toLowerCase();
                    String[] words = lineTxt.split("[ \n]+");
                    for(String word : words) {
                        if(!myWords.contains(word)) {
                            myWords.add(word);
                            myFreqs.add(1);
                        }
                        else {
                            int index = myWords.indexOf(word);
                            myFreqs.set(index, myFreqs.get(index)+1);
                        }
                    }
                }
                read.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void countUnique() {
        int max = Integer.MIN_VALUE;
        String maxWord = "";
        int count = 0;
        for(int i=0;i<myFreqs.size();i++) {
            if(myFreqs.get(i) == 1 && myWords.get(i).matches("[a-z]+")) {
                count++;
                System.out.println(myFreqs.get(i)+"\t"+myWords.get(i));
            }

            if(myFreqs.get(i)>max && myWords.get(i).matches("[a-z]+")) {
                max = myFreqs.get(i);
                maxWord = myWords.get(i);
            }
        }

        System.out.println("Number of unique word: "+count);
        System.out.println("Max frequency is: "+max);
        System.out.println("Max frequencial word is: "+maxWord);

    }


    public void printRes() {
        for(int i=0;i<myFreqs.size();i++) {
            System.out.println(myFreqs.get(i)+"\t"+myWords.get(i));
        }
    }


    public static void main(String[] args) {
        WordFrequencies myWordFrequencies = new WordFrequencies();
        myWordFrequencies.scanWords();
//        myWordFrequencies.printRes();
        myWordFrequencies.countUnique();
    }

}
