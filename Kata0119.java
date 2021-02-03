public class Kata0119 {
    // Longest Palindromic Substring
    // Write a program that finds the longest palindromic substring of a given string. Try to be as efficient as possible!  Checks a given string to find the largest palindrome contained inside the word.  Returns an empty string if no palindrome. Strings may be used, but no collections or String builders
    public static void main(String args[]){      
        System.setProperty("java.util.logging.SimpleFormatter.format","%5$s %n");
        java.util.logging.Logger log = java.util.logging.Logger.getLogger("Kata Class");
        String[] phrases = new String[] {
            "caramel", // ara
            "AbbA", // abba
            "Monster", // ""
            "Acrobats stab orca", // bats stab
            "We Deified her as a god" // Deified
        };
        for (String phrase : phrases) {
            // log.log(Level.INFO, "{0}: {1}", new String[]{ phrase, find(phrase) });
            System.out.println(find(phrase));
        }
    }

    public static String find(String word){
        String result = "";
        char[] letters = word.toLowerCase().toCharArray();
        
        for(int i=0; i < letters.length; i++){
            int end = word.indexOf(letters[i], i+1);
            // System.out.println(letters[i]);
            if(end != -1){
                int start = i;
                String subWord = word.substring(start, end + 1).toLowerCase(); 
                String reversed = reverse(subWord);
                if (subWord.equals(reversed) && subWord.length() > result.length()){
                    result = word.substring(start, end + 1);
                }
            }
        }

        return result;
    }

    public static String reverse(String word){
        char[] in = word.toCharArray();
        char[] out = word.toCharArray();

        int l = in.length - 1;
        for(int i = 0; i < in.length; i++){
            out[l] = in[i];
            l--;
        }
        return String.valueOf(out);
    }
}
