import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kata0122 {
    
    // RegEx: Validate PIN
    // Create a function that will test if a string is a valid PIN or not via a regular expression.
    // Use any Java classes. Validation itself must be accomplished with RegEx. You can use google/stackoverflow or other sites to aid in this
    // A valid PIN has:
    // Exactly 4 or 6 characters.
    // Only numeric characters (0-9).
    // No whitespace.
public static void main(String args[]){      
	System.out.println(validate("121317")); // true
	System.out.println(validate("1234")); // true
	System.out.println(validate("45135")); // false
	System.out.println(validate("89abc1")); // false
	System.out.println(validate("900876")); // true
	System.out.println(validate(" 4983")); // false
	System.out.println(validate(" 49835")); // false
	System.out.println(validate("498356")); // true
}

    static boolean validate(String pin) {
        Pattern pattern = Pattern.compile("^[\\d]{4}$|^[\\d]{6}$");
        Matcher match = pattern.matcher(pin);
        return match.find();
    }
      
}
