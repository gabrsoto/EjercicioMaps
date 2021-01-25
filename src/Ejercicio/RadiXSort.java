package Ejercicio;

public class RadiXSort {
    public static void main(String[] args) {
        int[] arr= {16223,898,13,906,235,23,9,1532,6388,2511,8};
        RadiXSort(arr);

        for (int element : arr) {
            System.out.println(element);
        }
    }

    public static void RadiXSort(int[] arr)
    {
        String[] sArray = StringUtil.GetArrayString_Integer(arr); //punto 1

        StringUtil.Get_PadLeft_Array(sArray); //punto 2

        int[] newArr = StringUtil.Sort_Array(sArray, sArray[0].length());
        for (int i = 0; i < newArr.length; i++)
            arr[i] = newArr[i];

        String test = "   prueba  ";
        test = StringUtil.LTrim(test);
        test = StringUtil.RTrim(test);

        test = "    prueba       ";

        test = StringUtil.Trim(test);
    }
}
