public class Kata0202 {
// Sherlock considers a string to be valid if all characters of the string appear
// the same number of times. It is also valid if he can remove just 1 character at
// 1 index in the string, and the remaining characters will occur the same number of times.
// Given a string str, determine if it is valid. If so, return "YES", otherwise return "NO".
// For example, If str = "abc", the string is valid because the frequencies of characters
// are all the same. If str = "abcc", the string is also valid, because we can
// remove 1 "c" and have one of each character remaining in the string. However,
// if str = "abccc", the string is not valid, because removing one character does not
// result in the same frequency of characters.
// No COLLECTIONS may be used in solving this. You may use Arrays class import to help manage your arrays
public static void main(String args[]){      
	System.out.println(isValid("abc")); //true
	System.out.println(isValid("abcc")); //true
	System.out.println(isValid("abccc")); //false
	System.out.println(isValid("aabccc")); //false
	System.out.println(isValid("aabbccc")); //true
	System.out.println(isValid("aaabbccc")); //false
}

public static String isValid(String letters){
    int countA = 0;
    int countB = 0;
    int countC = 0;
    char[] lets = letters.toCharArray();

    for (int i=0; i < lets.length; i++){
        if (lets[i] == 'a'){
            countA++;
        }else if (lets[i] == 'b'){
            countB++;
        }else if (lets[i] == 'c'){
            countC++;
        }
    }
    
    if ((countA+countB+countC)%3==0 && countB != (countC - 2)|| (countA+countB+countC)%3==1 ){
        return "YES";
    } 

    return "NO";
}
}
