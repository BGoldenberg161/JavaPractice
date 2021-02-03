import java.text.MessageFormat;

public class kata0203 {
    // Disarium Number
    // A number is said to be Disarium if the sum of its digits raised to their respective positions is the number itself.
    // Create a method that determines whether a number is a Disarium or not.
    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format","%5$s %n");
        java.util.logging.Logger log = java.util.logging.Logger.getLogger(kata0203.class.getName());
        int[] numbers = new int[] {
            75, // false
            135, //true
            518, // true
            8, // true
            2456, // false
            1306, // true
            2427, // true
            34237, // false
        };
        for (int number : numbers) {
            String s = MessageFormat.format("{0} is a disarium number: {1}", number, isDisarium(number));
            log.info(s);
        }
    } 

    public static boolean isDisarium(int number){
        String[] numArr = ("" + number).split("");
        int sum = 0;
        for(int i = 0; i < numArr.length; i++){
            int current = Integer.parseInt(numArr[i]);
            sum += Math.pow(current, (i+1));
        }
        if(sum == number){
            return true;
        }
        return false;
    }
}
