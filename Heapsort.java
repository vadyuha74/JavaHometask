/*
 * массив алгоритм сортировки пирамидой
 */
import java.util.Random;
public class Heapsort {
    public static void sort(int arr[])
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--){
            heapify(arr, n, i);
        }
        for (int i=n-1; i>=0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    public static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2
        if (l < n && arr[l] > arr[largest]){
            largest = l;
        }
        if (r < n && arr[r] > arr[largest]){
            largest = r;
        }
        if (largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] array = new int[12];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(30); // Задаем рандомный массив мз 12 элементов цифрами от 0 до 29
            System.out.printf("%d, ", array[i]);
        }
        Heapsort.sort(array);
        System.out.println("\n Отсортированый массив");
        for (int i : array) {
            System.out.printf("%d, ",i );
        }
    }
}
