package HW_1.Fruit;

import java.util.ArrayList;

public class Box<F extends Fruit> {
    private float capacity;
    F fruit;
    ArrayList<F> fruits = new ArrayList<>();
    private int quantity; //Количество фруктов в коробке
    private int stock; //Свободное место
    private int remains; //Не влезло в коробку
    float weight;

    public Box(F fruit, float capacity) {
        this.capacity = capacity;
        this.fruit = fruit;
    }

    public int getQuantityMax() {
        return Math.round(capacity / fruit.getWeight());
    }

    public Box<F> put(int quantity) {
        int sizeStart;
        sizeStart = fruits.size();
        if (quantity + fruits.size() > getQuantityMax()) {
            remains = quantity - getQuantityMax() + sizeStart;
            stock = 0;
            for (int i = fruits.size(); i < getQuantityMax(); i++) {
                fruits.add(fruit);
            }
        } else {
            for (int i = 0; i < quantity; i++) {
                fruits.add(fruit);
            }
            remains = 0;
            stock = getQuantityMax() - fruits.size();
        }
        this.quantity = fruits.size();
        weight = getWeight();
        return this;
    }

    public Box<F> out(int quantity) {
        System.out.println(quantity);
        if (fruits.size() > 0) {
            int size = fruits.size();
            if (quantity > fruits.size()) {
                for (int i = size - 1; i >= 0; i--) {
                    fruits.remove(i);
                }
            } else {
                for (int i = size - 1; i >= size - quantity; i--) {
                    System.out.print(i + " ");
                    fruits.remove(i);
                }
            }
        }
        System.out.println();
        this.quantity = fruits.size();
        remains = 0;
        stock = getQuantityMax() - quantity;
        weight = getWeight();
        return this;
    }

    //  Метод позволяет пересыпать из коробки в другую коробку заданное количество фруктов с сохранением информации о коробках
    public Box<F> shift(Box<?> fruits, int quantity) {
//        if (this.quantity<quantity) quantity = this.quantity;
        if (quantity > fruits.stock) {
            System.out.println(quantity + " " + fruits.stock);
            quantity = fruits.stock;
            fruits.put(quantity);
            return out(quantity);
        } else {
            fruits.put(this.quantity);
            return out(this.quantity);
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public int getStock() {
        return stock;
    }

    public int getRemains() {
        return remains;
    }

    public float getWeight() {
        return fruit.getWeight() * quantity;
    }

    public boolean compare(Box<?> fruits) {
        if (Math.abs(this.getWeight() - fruits.getWeight()) < 0.0001f) return true;
        return false;
    }

    public boolean compareFruits(Box<?> fruit) {
        return this.fruit.getClass().equals(fruit.fruit.getClass());
    }

    @Override
    public String toString() {
        return "Box{" +
                "capacity=" + capacity +
                ", fruit=" + fruit +
                ", quantity=" + quantity +
                ", stock=" + stock +
                ", remains=" + remains +
                ", weight=" + weight +
                '}';
    }
}
