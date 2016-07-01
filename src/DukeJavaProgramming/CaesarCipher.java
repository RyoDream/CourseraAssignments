package DukeJavaProgramming;

public class CaesarCipher {
    public static String encrypt(String input, int key) {
        String[] shifted = shiftKey(key);
        String alphabet = shifted[0];
        String newAlphabet = shifted[1];

        StringBuilder sb = new StringBuilder(input);
        for(int i=0;i<sb.length();i++) {
            int index = alphabet.indexOf(sb.charAt(i));
            if( index != -1){
                sb.setCharAt(i, newAlphabet.charAt(index));
            }
        }

        return sb.toString();
    }

    public static String encryptTwoKeys(String input, int key1, int key2) {
        String[] shifted = shiftKey(key1);
        String alphabet1 = shifted[0];
        String newAlphabet1 = shifted[1];
        shifted = shiftKey(key2);
        String alphabet2 = shifted[0];
        String newAlphabet2 = shifted[1];

        StringBuilder sb = new StringBuilder(input);

        for(int i=0;i<sb.length();i++) {
            int index = (i%2==0)? (alphabet1.indexOf(sb.charAt(i))):(alphabet2.indexOf(sb.charAt(i)));
            if(index != -1) {
                if(i%2==0) {
                    sb.setCharAt(i, newAlphabet1.charAt(index));
                }
                else {
                    sb.setCharAt(i, newAlphabet2.charAt(index));
                }
            }
        }

        return sb.toString();
    }

    private static String[] shiftKey(int key) {
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newUpperAlphabet = upperAlphabet.substring(key) + upperAlphabet.substring(0,key);
        String lowerAlphabet = upperAlphabet.toLowerCase();
        String newLowerAlphabet = newUpperAlphabet.toLowerCase();
        String[] res = new String[] {upperAlphabet+lowerAlphabet, newUpperAlphabet+newLowerAlphabet};

        return res;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", 15));
        System.out.println(encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?", 21, 8));
    }

}
