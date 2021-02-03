public class Kata0120 {
//     Compress a string such that 'AAABCCDDDD' becomes 'A3BCCD4'. Only compress the string if it saves space. Pay attention to the spaces.
//     No imports of any kind are allowed.
    public static void main(String args[]){      
        System.out.println(compress("AAABCCDDDDLL")); // A3BCCD4LL
        System.out.println(compress("AAABCCDDDDL")); // A3BCCD4L
        System.out.println(compress("JJJJAAAAAMEEEESSSSSSS")); // J4A5ME4S7
        System.out.println(compress("MARY")); // MARY
        System.out.println(compress("HELLO     WORLD")); // HELLO 5WORLD
        System.out.println(compress("   HHH   OOO")); // " 3H3 3O3"
    }

    public static String compress(String input){
        //for each letter, count
        //if count > 2 replace with letter and count

        char[] in = input.toCharArray();
        String result = "";
        char previous = in[0];
        int count = 1;
        for(int i = 1; i < in.length ; i++){
            char current = in[i];
            if(current == previous){
                count++;
            } else if(count == 1){
                result += Character.toString(previous);
            } else if(count == 2){
                result += Character.toString(previous);
                result += Character.toString(previous);
                count = 1;
            } else {
                result += Character.toString(previous);
                result += String.valueOf(count);
                count = 1;
            }
            previous = current;
            if(i ==in.length-1){
                result += Character.toString(current);
                if(count == 2){
                    result += Character.toString(current);
                }
                if(count>2){
                    result += String.valueOf(count);
                }
            }

        }
        return result;
    }
}
