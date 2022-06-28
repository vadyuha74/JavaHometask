/*
 * массив алгоритм сортировки слиянием
 */
import java.util.Random;
public class Mergesort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[12];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(30); // Задаем рандомный массив мз 12 элементов цифрами от 0 до 29
            System.out.printf("%d, ", array[i]);
        }
        int[] result = new int[array.length];
        result = sortarray(array);
        System.out.println("\n Отсортированый массив");
        for (int i : result) {
            System.out.printf("%d, ",i );
        }
    }
    public static int [] sortarray(int[] array){
        int k = array.length;
        if (k < 2) {
            return array;
        }
            
        int [] array1 = new int[k / 2];
        System.arraycopy(array, 0, array1, 0, k / 2);
    
        int [] array2 = new int[k - k / 2];
        System.arraycopy(array, k / 2, array2, 0, k - k / 2);
    
        array1 = sortarray(array1); // левая часть возврат из рекурсии строкой return array;
        array2 = sortarray(array2); // правая часть возврат из рекурсии строкой return array;
    
        return mergearrays(array1, array2);
    }
    public static int[] mergearrays(int[] array1, int[] array2) {
        int[] res = new int[array1.length + array2.length];
        int n = array1.length;
        int m = array2.length;
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (array1[i] <= array2[j]) {
                res[k] = array1[i];
                i++;
            }
            else {
                res[k] = array2[j];
                j++;
            }
            k++;
        }
        while (i < n) {
            res[k] = array1[i];
            i++;
            k++;
        }
        while (j < m) {
            res[k] = array2[j];
            j++;
            k++;
        }
        return res;
    }
}

