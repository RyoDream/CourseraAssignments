package DukeJavaProgramming;


public class WordPlay {
    public static boolean isVowel(char ch) {
        switch (ch) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

    public static String replaceVowels(String phrase, char ch) {
        StringBuilder sb = new StringBuilder(phrase);
        for(int i=0;i<sb.length();i++) {
            if(isVowel(sb.charAt(i)))
                sb.setCharAt(i, ch);
        }
        return sb.toString();
    }

    public static String emphasize(String phrase, char ch) {
        StringBuilder sb = new StringBuilder(phrase);
        for(int i=0;i<sb.length();i++) {
            if(sb.charAt(i) == ch) {
                if(i%2 == 0)
                    sb.setCharAt(i, '*');
                else
                    sb.setCharAt(i, '+');
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceVowels("Hello World", '*'));
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}
