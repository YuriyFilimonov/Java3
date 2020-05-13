package HW_1;

public class ProcAnArrDemo {
    public static void main(String[] args) {
        ProcessingAnArray<String> strArray = new ProcessingAnArray<>("one", "two", "three", "fore", "five");
        ProcessingAnArray<Integer> intArray = new ProcessingAnArray<>(1, 2, 3, 4, 5);

        strArray.arrayToArrayList();
        intArray.arrayToArrayList();

        System.out.println(strArray);
        strArray.changItemInArray(2,4);
        strArray.arrayToArrayList();
        System.out.println(strArray);

        System.out.println(intArray);
        intArray.changItemInArray(2,4);
        intArray.arrayToArrayList();
        System.out.println(intArray);
    }
}
