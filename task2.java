/*
 * массив алгоритм сортировки слиянием
 */
import java.util.Random;
public class task2 {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[12];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(30);
            System.out.println(array[i]);
        }
        int[] result = new int[array.length];
        result = sortArray(array);
        for (int item : result) {
            System.out.println(item);
        }
    }
    public static int [] sortArray(int[] arrayA){
        if (arrayA == null) {
            return null;
        }
        if (arrayA.length < 2) {
            return arrayA;
        }
            
        int [] arrayB = new int[arrayA.length / 2];
        System.arraycopy(arrayA, 0, arrayB, 0, arrayA.length / 2);
    
        int [] arrayC = new int[arrayA.length - arrayA.length / 2];
        System.arraycopy(arrayA, arrayA.length / 2, arrayC, 0, arrayA.length - arrayA.length / 2);
    
        arrayB = sortArray(arrayB); // левая часть возврат из рекурсии строкой return arrayA;
        arrayC = sortArray(arrayC); // правая часть возврат из рекурсии строкой return arrayA;
    
        return mergeArray(arrayB, arrayC);
    }
    public static int [] mergeArray(int [] arrayА, int [] arrayB) {

        int [] arrayC = new int[arrayА.length + arrayB.length];
        int positionA = 0, positionB = 0;
            
        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayА.length){
                arrayC[i] = arrayB[i - positionB];
                positionB++;
            }
            else if (positionB == arrayB.length) {
                arrayC[i] = arrayА[i - positionA];
                positionA++;
            }
            else if (arrayА[i - positionA] < arrayB[i - positionB]) {
                arrayC[i] = arrayА[i - positionA];
                positionB++;
            }
            else {
                arrayC[i] = arrayB[i - positionB];
                positionA++;
            }
        }
        return arrayC;
    }
}
