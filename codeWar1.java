public class codeWar1 {
    
    public static void main(String[] args){
        System.out.println(isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'})); //true
        System.out.println(isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'})); //false
        System.out.println(isValid(new char[] {'w'}));//false
        System.out.println(isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));//false
    }

    public static boolean isValid(char[] walk) {
        // if (walk.length == 10){
        //     int ns = 0;
        //     int ew = 0;
        //     for(int i = 0; i < walk.length; i++){
        //         if(Character.toString(walk[i]) == "n"){
        //             ns++;
        //         }else if(Character.toString(walk[i]) == "s"){
        //             ns--;
        //         }else if(Character.toString(walk[i]) == "e"){
        //             ew++;
        //         }else if(Character.toString(walk[i]) == "w"){
        //             ew--;
        //         }
        //     }
        //     if(ns == 0 && ew == 0){
        //         return true;
        //     } else {
        //         return false;
        //     }
        // }
        // return false;
        if(walk.length != 10){
            return false;
        }
        int northSouth = 0;
        int westEast = 0;
        for(char direction : walk){
            switch (direction){
                case 'n' :
                northSouth++;
                break;
                case 'e' :
                westEast++;
                break;
                case 's' :
                northSouth--;
                break;
                case 'w' :
                westEast--;
                break;
                default :
                throw new IllegalStateException("direction not found: " + direction);
            }
        }
        return (northSouth == 0 && westEast == 0);
    }
}
