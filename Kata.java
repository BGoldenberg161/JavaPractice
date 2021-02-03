import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Kata {

    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s %n");
        java.util.logging.Logger log = java.util.logging.Logger.getLogger("test Kata");
        String[] elements = new String[] { "name=james", "name=james%26mary&business=smt+company",
                "name=james%26mary%20camire&business=smt+company&type=",
                "name=james%26mary%20camire&business=smt+company&type=&name=Mike", "business=smt%3drules&" };
        // QS: {name=[james]}
        // QS: {business=[smt company], name=[james&mary]}
        // QS: {business=[smt company], name=[james&mary camire], type=[]}
        // QS: {business=[smt company], name=[james&mary camire, Mike], type=[]}
        // QS: {business=[smt=rules]}
        for (String qs : elements) {
            log.log(java.util.logging.Level.INFO, "QS: {0}", parseString(qs).toString());
        }
    }

    public static Map<String, List<String>> parseString(String input) {

        // Create hashmap with String[] of length &count +1
        Map<String, List<String>> myHashMap = new HashMap<String, List<String>>();
        // substring on '&' -> temp array
        String[] tmpArray = input.split("&");
        List<String> temp = Arrays.asList(tmpArray);

        // foreach string in temp array, substring on '=' -> decode value and add to
        // hashmap
        for (String s : temp) {
            String[] set = s.split("=");
            String key = set[0];
            StringBuilder value = (set.length != 1) ? new StringBuilder().append(set[1].replace("+", " ")) : new StringBuilder();
            // replace ascii chars in value
            // find all % places
            int place = 0;
            place = value.indexOf("%");
            while (place != -1) {
                String code = value.toString().substring(place + 1, place + 3);
                value.replace(place, place + 3, Character.toString((char) Integer.parseInt(code, 16)));
                place = value.indexOf("%");
            }
            addToMap(myHashMap, key, value);
        }

        return myHashMap;
    }

    // Create add function that takes hashmap and key:value pair and returns a
    // hashmap with the value appended to key

    public static Map<String, List<String>> addToMap(Map<String, List<String>> inputMap, String key,
            StringBuilder value) {

        if (inputMap.containsKey(key)) {
            List<String> current = inputMap.get(key);
            current.add(value.toString());
            // inputMap.put(key, current);
            // inputMap.get(key).add(value.toString());
        } else {
            List<String> output = new ArrayList<String>();
            output.add(value.toString());
            inputMap.put(key, output);
        }

        return inputMap;
    }
}