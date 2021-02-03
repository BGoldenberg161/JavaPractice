public class Kata0201 {
// Pangram
// Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan gramma, "every letter")
// is a sentence using every letter of the alphabet at least once. The best known English pangram is:
// The quick brown fox jumps over the lazy dog.
// The alphabet used consists of ASCII letters a to z, inclusive, and is case insensitive. Input will not contain non-ASCII symbols.
// Strings and Stringbuilders may be used, but Collections may not be used
public static void main(String args[]){
    System.out.println(isPangram("The quick brown fox jumps over the lazy dog")); // true
    System.out.println(isPangram("Waltz, bad nymph, for quick jigs vex")); // true
    System.out.println(isPangram("Crazy Fredrick bought many very exquisite opal jewels")); // true
    System.out.println(isPangram("Five quacking zephyrs jot my wax bed.")); // false
    System.out.println(isPangram("A mad boxer shot a quick, loved jab to the jaw of his dizzy opponent")); // false
}

public static boolean isPangram(String input){
    String[] alpha = "abcdefghijklmnopqrstuvwxyz".split("");
    for(int i = 0; i < alpha.length; i++){
        if(!input.toLowerCase().contains(alpha[i])){
            return false;
        }
    }
    return true;
}
}
