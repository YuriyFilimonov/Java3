package HW_1.Fruit;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Storage {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int quantityBox;
        int quantityBoxMin = 5;
        int quantityBoxMax = 10;
        int capacityMin = 10;
        int capacityMax = 10;

        ArrayList<Box<?>> boxes = new ArrayList<>();

        System.out.printf("Введите число коробок на складе (от %d до %d): ", quantityBoxMin, quantityBoxMax);
        while (true) {
            try {
                quantityBox = scanner.nextInt();
                if (quantityBox >= quantityBoxMin && quantityBox <= quantityBoxMax) break;
                System.out.printf("Введите число от %d до %d: ", quantityBoxMin, quantityBoxMin + quantityBoxMax);
            } catch (NumberFormatException e) {
                System.out.printf("Введите число от %d до %d: ", quantityBoxMin, quantityBoxMin + quantityBoxMax);
            }
        }

//       Поставим коробки на учет
        for (int i = 0; i < quantityBox; i++) {
            int idFruit = random.nextInt(2);
            int capacity = capacityMin + random.nextInt(capacityMax + 1);
            if (idFruit == 0)
                boxes.add(new Box<Apple>(new Apple(), capacity));
            else
                boxes.add(new Box<Orange>(new Orange(), capacity));
        }

//  Коробки заполнены фруктами хаотично
        for (Box<?> box : boxes) {
            box.put(random.nextInt(Math.round(box.getQuantityMax() * 1.5f)));
            System.out.println(box);
        }

//  Сравним вес коробок
        for (int i = 0; i <= (int) ((boxes.size() - 1) / 2); i++) {
            for (int j = boxes.size() - 1; j > i; j--) {
                if (boxes.get(i).compare(boxes.get(j))) {
                    System.out.printf("Weight of Box %d = weight of Box %d = %f\n", i, j, boxes.get(i).getWeight());
                } else {
                    System.out.printf("Weight of Box %d = %f. Weight of Box %d = %f\n", i, boxes.get(i).getWeight(), j,
                            boxes.get(j).getWeight());
                }
            }
        }

//  Разложим имеющиеся фрукты, до верха заполнив коробки
        for (int i = boxes.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.println(boxes.get(i));
                System.out.println(boxes.get(j));
                System.out.println(boxes.get(i).compareFruits(boxes.get(j)));
                if (boxes.get(i).compareFruits(boxes.get(j)) && boxes.get(j).getStock() > 0 &&
                        boxes.get(i).getQuantity() > 0) {
                    boxes.get(i).shift(boxes.get(j), boxes.get(i).getQuantity());
                    System.out.printf("После пересыпания from Box %d: %s\nto Box %d: %s\n", i, boxes.get(i), j, boxes.get(j));
                } else
                    System.out.printf("from Box %d: %s\nto Box %d: %s\nне пересыпали\n", i, boxes.get(i), j, boxes.get(j));
            }
        }

//  Повторно сравним вес коробок
        for (int i = 0; i <= (int) ((boxes.size() - 1) / 2); i++) {
            for (int j = boxes.size() - 1; j > i; j--) {
                if (boxes.get(i).compare(boxes.get(j))) {
                    System.out.printf("Weight of Box %d = weight of Box %d = %f\n", i, j, boxes.get(i).getWeight());
                } else {
                    System.out.printf("Weight of Box %d = %f. Weight of Box %d = %f\n", i, boxes.get(i).getWeight(), j,
                            boxes.get(j).getWeight());
                }
            }
        }

        System.out.println("test");
        System.out.println("test2");
    }
}