public class Kata0121 {
    // ISBN
    // The ISBN-10 format is 9 digits (0 to 9) plus one check character (either a digit or an X only).
    // In the case the check character is an X, this represents the value '10'. These may be communicated
    // with or without hyphens, and can be checked for their validity by the following formula:
    // (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9 * 2 + x10 * 1) mod 11 == 0
    // If the result is 0, then it is a valid ISBN-10, otherwise it is invalid.
    // No imports of any kind!
    public static void main(String args[]){      
		System.out.println("Is ISBN: " + isISBN("1-84356-028-3")); //true
		System.out.println("Is ISBN: " + isISBN("0-684-84328-5")); //true
		System.out.println("Is ISBN: " + isISBN("0-8044-2957-X")); //true
		System.out.println("Is ISBN: " + isISBN("0-85131-041-9")); //true
		System.out.println("Is ISBN: " + isISBN("93-86954-21-4")); //true
		System.out.println("Is ISBN: " + isISBN("0-943396-04-2")); //true
		System.out.println("Is ISBN: " + isISBN("0-9752398-0-X")); //false
		System.out.println("Is ISBN: " + isISBN("1-85121-041-9")); //false
    }
    
    public static boolean isISBN(String isbn){

        String noDash = isbn.replace("-", "");
        char[] numbers = noDash.toCharArray();
        int result = 0;
        int times = 10;
        for(int i=0; i < numbers.length; i++){
            String current = Character.toString(numbers[i]);
            if(numbers[i] == 'X'){
                current = "10";
            }
            result += Integer.parseInt(current) * times;
            times--;
        }
        if(result % 11 == 0){
            return true;
        } else {
            return false;
        }
    }
}
