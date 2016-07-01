package DukeJavaProgramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DecryptCaesar {
    public static List<String> eyeballDecrypt(String encrypted) {
        List<String> res = new ArrayList<>();
        for(int k=0;k<26;k++) {
            String s = CaesarCipher.encrypt(encrypted, k);
            res.add(s);
        }

        return res;
    }

    public static int getKey(String text) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0;k<text.length();k++) {
            char ch = Character.toLowerCase(text.charAt(k));
            int index = alph.indexOf(ch);
            if(index != -1) {
                counts[index]++;
            }
        }
        return maxIndex(counts);
    }

    public static int maxIndex(int[] counts) {
        int index = 0;

        for(int i=0;i<counts.length;i++) {
            if(counts[i] > counts[index]) {
                index = i;
            }
        }
        System.out.println(index);
        return index;
    }

    public static String decrypt(String encrypted) {
        int maxDex = getKey(encrypted);
        int dkey = (maxDex >= 4)? (maxDex-4):(22+maxDex);

        return CaesarCipher.encrypt(encrypted, 26-dkey);
    }

    public static String decryptTwoKeys(String encrypted) {
        String[] halves = halfOfString(encrypted);
        int key1 = getKey(halves[0]);
        int key2 = getKey(halves[1]);
        System.out.println(key1+" "+key2);
        int dkey1 = (key1 >= 4)? (key1-4):(22+key1);
        int dkey2 = (key2 >= 4)? (key2-4):(22+key2);

        String res = CaesarCipher.encryptTwoKeys(encrypted, 9, 22);
        return res;
    }

    public static void eyeballDecryptTwoKeys(String encrypted) {
        for(int i=0;i<26;i++) {
            for(int j=0;j<26;j++) {
                System.out.println(i+" "+j+" : "+CaesarCipher.encryptTwoKeys(encrypted,i,j));
            }
        }
    }

    public static String[] halfOfString(String text) {
        StringBuilder sb1 = new StringBuilder("");
        StringBuilder sb2 = new StringBuilder("");
        for(int i=0;i<text.length();i++) {
            if(i%2 == 0)
                sb1.append(text.charAt(i));
            else
                sb2.append(text.charAt(i));
        }

        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        return new String[] {sb1.toString(), sb2.toString()};
    }

    public static void main(String[] args) {
//        System.out.println(decrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!"));
//        System.out.println(decrypt("Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!"));
//        eyeballDecrypt("Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!");

//        System.out.println(decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko"));
//        System.out.println(CaesarCipher.encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx",20,2));
//        eyeballDecryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko");
//        System.out.println(decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko"));

        StringBuilder text = new StringBuilder("");

        try{
            File file = new File("/Users/shiyanch/Documents/workspace/CourseraCourses/src/DukeJavaProgramming/quiz.txt");
            if(file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null)
                    text.append(lineTxt);
                read.close();

//                System.out.println(decryptTwoKeys(text.toString()));
//                System.out.println(CaesarCipher.encryptTwoKeys(text.toString(), 22, 9));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

//        String temp = "Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin";
//        System.out.println(CaesarCipher.encryptTwoKeys("Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin", 22, 9));
//        System.out.println(CaesarCipher.encryptTwoKeys(temp, 22, 9));
        eyeballDecryptTwoKeys("Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin");

    }

}
