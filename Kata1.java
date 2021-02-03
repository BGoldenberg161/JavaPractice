// Write a method to replace all spaces in a string with ‘%20’. You may assume that the string has sufficient space at the end of the string to hold the additional characters, and that you are given the “true” length of the string. (Note: if implementing in Java, please use a character array or loop each character so that you can perform this operation in place.)  DO NOT USE Strings, StringBuilders or any string manipulation other than as the source sentence.
// Output : Hello World : Hello%20World
// Output : Quick Brown fox jumps over the lazy dog : Quick%20Brown%20fox%20jumps%20over%20the%20lazy%20dog
// Output : Test of  double space : Test%20of%20%20double%20space
// Output : Test of double space at end : Test%20of%20double%20space%20at%20end%20%20
// Output : Test of double space at beginning : %20%20Test%20of%20double%20space%20at%20begining

public class Kata1 {
	public static void main(String args[]) {
		System.out.println(replace("Hello World"));
		System.out.println(replace("Quick Brown fox jumps over the lazy dog"));
		System.out.println(replace("Test of  double space"));
		System.out.println(replace("Test of double space at end  "));
		System.out.println(replace("  Test of double space at beginning"));
    }
    
	public static String replace(String input) {
        
        char[] stringArr = input.toCharArray();
        String replacement = "%20";
        char[] rep = replacement.toCharArray();

        int spaceCount = 0;
        for (char c : stringArr) {
            if (c == ' ') {
                spaceCount++;
            }
        }

        char[] result = new char[stringArr.length + (spaceCount * 2)];

        int j = 0;
        for (int i = 0; i < stringArr.length; i++){
            if (stringArr[i] == ' '){
                result[j] = rep[0];
                result[j+1] = rep[1];
                result[j+2] = rep[2];
                j = j+2;
            } else {
                result[j] = stringArr[i];
            };
            j++;
        };
        return new String(result);
    }

}