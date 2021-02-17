public class Isograms {
    public static void main(String[] args){
        System.out.println(isIsogram("abcfdef"));
    }
    public static boolean  isIsogram(String str) {
        int[] letters = new int[26];
        for(int i = 0;i < str.length(); i++){
          letters[str.charAt(i)-97] ++;
        }
        for(int count:letters){
            if(count > 1) return false;
        }
        return true;
    }
}
