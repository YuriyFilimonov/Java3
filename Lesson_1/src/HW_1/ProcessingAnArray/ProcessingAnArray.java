package HW_1.ProcessingAnArray;
// 1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
// 2. Написать метод, который преобразует массив в ArrayList

import java.util.ArrayList;
import java.util.Arrays;

public class ProcessingAnArray<T> {
    private T[] arr;
    ArrayList<T> arrayList;

    @SafeVarargs
    public ProcessingAnArray(T... arr) {
        this.arr = arr;
    }

    void changItemInArray(int a, int b) {
        try {
            T t;
            t = arr[a];
            arr[a] = arr[b];
            arr[b] = t;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.printf("Индекс превышает длину массива. Длина массива = %d\n", arr.length);
            e.printStackTrace();
        }
    }

    void arrayToArrayList(){
        arrayList = new ArrayList<>(Arrays.asList(arr));
    }

    @Override
    public String toString() {
        return "ProcessingAnArray{" +
                "arr=" + Arrays.toString(arr) +
                ", arrayList=" + arrayList +
                '}';
    }
}
