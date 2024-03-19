package dz_5;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> box;
    private float weight;
    private int amount;
    private String name;

    public Box(String name) {
        this.box = new ArrayList<>();
        this.weight = 0.0f;
        this.amount = 0;
        this.name = name;
    }

    //Getters & Setters start

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Getters & Setters end

    private boolean checkBox(T fruit) {
        return this.getAmount() == 0 || this.box.get(0).getClass() == fruit.getClass();
    }

    public void addFruit(T fruit, int amount) {
        if (this.checkBox(fruit)) {
            for (int i = 0; i < amount; i++) {
                this.box.add(fruit);
            }
            setWeight(this.weight + (fruit.getWeight() * amount));
            setAmount(this.amount + amount);
            System.out.println("В коробку " + this.getName() + " добавлены " +
                                fruit.getName() + ": " + amount + " шт. Текущее количество: " + this.getAmount());
        } else {
            System.out.println("Нельзя положить " + fruit.getName() +
                    " в коробку " + this.getName() + " . В ней уже лежат " + this.box.get(0).getName());
        }
    }

    public boolean compare(Box<T> otherBox) {
        return this.getWeight() == otherBox.getWeight();
    }

    public void moveToAnotherBox(Box<T> otherBox) {
        if (this.getAmount() == 0) {
            System.out.println("Текущая коробка пуста. Нечего пересыпать");
        } else {
            System.out.printf("Попытка переместить %d шт. %s из коробки %s в коробку %s...\t", this.getAmount(),
                    this.box.get(0).getName(), this.getName(), otherBox.getName());

            otherBox.addFruit(this.box.get(0), this.getAmount());
            if (otherBox.checkBox(this.box.get(0))) {
                this.box.clear();
                this.setWeight(0.0f);
                this.setAmount(0);
            }
        }
    }

    public String toString() {
        if (this.getAmount() == 0) {
            return ("Коробка " + this.getName() + " пуста");
        } else {
            return String.format("В коробке %s лежат %s: %d шт; Вес коробки: %.2f",
                                this.getName(), this.box.get(0).getName(), this.getAmount(), this.getWeight());
        }
    }


}



