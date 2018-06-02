/*
Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
*/

public class uniqueCharString {
    public static void main(String args[])
    {
        String inputString = "test String"; //Output:False
        String inputString2 = "qwertyuio asdfghjkl"; //Output:true
        System.out.println(byUsingString(inputString));
        System.out.println(byUsingCharArray(inputString));
        System.out.println(byUsingString(inputString2));
        System.out.println(byUsingCharArray(inputString2));
    }

    private static boolean byUsingCharArray(String inputString) {
        boolean[] myArray = new boolean[256];//Assuming ascii string
        for (int i = 0; i <inputString.length() ; i++) {
            char myChar = inputString.charAt(i);
            if(myArray[myChar])return false;
            myArray[myChar]=true;
        }
        return true;
    }

    public static boolean byUsingString(String inputString)
    {
        String myString = "";
        for(int i=1; i<=inputString.length();i++){
            if(myString.contains(inputString.substring(i-1,i))){
                return false;
            }else{
                myString=myString+inputString.substring(i-1,i);
            }
        }
        return true;
    }
}
