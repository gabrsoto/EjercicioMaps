package Ejercicio;

import java.util.ArrayList;
import java.util.HashMap;

public class StringUtil {

    public static String[] GetArrayString_Integer(int[] arr){

        String[] sArr = new String[arr.length];

        for (int i = 0; i < arr.length; i++){
            sArr[i] = Integer.toString(arr[i]);
        }

        return sArr;
    }

    public static void Get_PadLeft_Array(String[] arr) {

        int valueMax = 0;

        for (String element : arr) {
            if(valueMax == 0 || valueMax < element.length())
                valueMax = element.length();
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lPad(arr[i], '0',valueMax);
        }
    }

    private static ArrayList<String> Assigne_Position(ArrayList<String>  arr, int indexSearch){
        ArrayList<String> arrResult = new ArrayList<>();
        HashMap<String, ArrayList<String>> hmListas = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            hmListas.put("L"+i, new ArrayList<>());
        }

        for (String element : arr) {
            char charPosition = element.charAt(indexSearch);
            ArrayList<String> lstResult = hmListas.get("L"+charPosition);
            lstResult.add(element);
        }

        for (int i = 0; i < 10; i++) {
            ArrayList<String>  lstIndex = hmListas.get("L"+i);
            arrResult.addAll(lstIndex);
        }

        return arrResult;
    }

    public static int[] Sort_Array(String[] arr, int maxCaracter){
        int[] arrSort = new int[arr.length];

        ArrayList<String> arrElements = new ArrayList<>();

        for (String element: arr) {
            arrElements.add(element);
        }

        for (int i = maxCaracter -1; i >= 0 ; i--) {
            arrElements = Assigne_Position(arrElements,i);
        }

        for (int i = 0; i < arrSort.length; i++) {
            arrSort[i] = Integer.parseInt(arrElements.get(i));
        }

        return arrSort;
    }

    private static String lPad(String text, char character, int count){
        return String.format("%"+count+"s",text).replace(' ',character);
    }

    private static String rPad(String text, char character, int count){
        return text + String.format("%"+count+"s","").replace(' ',character);
    }

    public static String LTrim( String text){
        int start = 0;
        while (start < text.length() && Character.isWhitespace(text.charAt(start))) {
            start++;
        }

        return text.substring(start);
    }

    public static String RTrim(String text){
        int end = text.length()-1;
        while (end >= 0 && Character.isWhitespace(text.charAt(end))) {
            end--;
        }
        return text.substring(0,end+1);
    }

    public static String Trim(String text){
        text = LTrim(text);
        text = RTrim(text);
        return text;
    }

    public static int IndexOfN(String text, String character, int index){
        int location = -1;

        if(text.indexOf(character,index) != 0)
            location = text.indexOf(character);

        return location;
    }
}
