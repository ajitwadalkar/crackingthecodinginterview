import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class amazonRekha1 {
    public static void main(String[] args) {

        String s = "jack and jill, went to the market to buy bread and cheese . Cheese is jack's and jill's favorite food";
        List<String> wordsToExclude = new ArrayList<>();
        List<String> myResult = new ArrayList<>();
        wordsToExclude.add("and");
        wordsToExclude.add("he");
        wordsToExclude.add("the");
        wordsToExclude.add("to");
        wordsToExclude.add("is");
        myResult = calculateFreq(s, wordsToExclude);
        myResult.forEach(System.out::println);
    }

    private static List<String> calculateFreq(String literatureText, List<String> wordsToExclude) {
        HashMap<String, Integer> myMap = new HashMap<>();
        List<String> strToReturn = new ArrayList<>();
        String[] myArray = literatureText.toLowerCase().split("'|\\s|\\.\\s|\\,\\s");
        for(String individualString: myArray){
            if(myMap.containsKey(individualString)){
                myMap.put(individualString,myMap.get(individualString)+1);
            }else{
                myMap.put(individualString,1);
            }
        }
        long maxCount = 0;
        for(String s: myMap.keySet()){
            if(wordsToExclude.contains(s)){
                continue;
            }else{
                if(myMap.get(s)==maxCount){
                    strToReturn.add(s);
                }
                if(myMap.get(s)>maxCount){
                    strToReturn.clear();
                    strToReturn.add(s);
                    maxCount = myMap.get(s);
                }
            }

        }
        Collections.sort(strToReturn);
        return strToReturn;
    }


}
