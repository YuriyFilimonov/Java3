package HW_1.ProcessingAnArray;

public class ProcAnArrDemo {
    public static void main(String[] args) {
        ProcessingAnArray<String> strArray = new ProcessingAnArray<>("one", "two", "three", "fore", "five");
        ProcessingAnArray<Integer> intArray = new ProcessingAnArray<>(1, 2, 3, 4, 5);

        strArray.arrayToArrayList();
        intArray.arrayToArrayList();

        System.out.println("Массив и список до модификации: " + strArray);
        strArray.changItemInArray(2,4);
        strArray.arrayToArrayList();
        System.out.println("Массив и список после модификации: " + strArray);

        System.out.println("Массив и список до модификации: " + intArray);
        intArray.changItemInArray(2,4);
        intArray.arrayToArrayList();
        System.out.println("Массив и список после модификации: " + intArray);
    }
}
