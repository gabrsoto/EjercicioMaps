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

        for (int i = 0; i < arr.length; i++) {
            if(valueMax == 0 || valueMax < arr[i].length())
                valueMax = arr[i].length();
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = String.format("%"+valueMax+"s",arr[i]).replace(' ','0');
        }
    }

    private static ArrayList<String> Assigne_Position(ArrayList<String>  arr, int indexSearch){
        ArrayList arrResult = new ArrayList();
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
            ArrayList<String> lstIndex = hmListas.get("L"+i);
            for (String element : lstIndex) {
                arrResult.add(element);
            }
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
}
