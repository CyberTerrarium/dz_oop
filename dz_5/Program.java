package dz_5;

import java.util.ArrayList;
import java.util.Random;

public class Program {

    public static ArrayList<Box<Fruit>> createBoxes(int amount) {
        ArrayList<Box<Fruit>> boxes = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            boxes.add(new Box<>("BOX" + (i+1)));
        }

        return boxes;
    }

    public static void printBoxes(ArrayList<Box<Fruit>> boxes) {
        System.out.println("\n***\n");
        for (Box<Fruit> box : boxes) {
            System.out.println(box);
        }
        System.out.println("\n***\n");
    }

    public static void fillBoxes(ArrayList<Box<Fruit>> boxes) {
        for(Box<Fruit> box : boxes) {
            boolean selectFruit = new Random().nextBoolean();
            if (selectFruit) {
                box.addFruit(new Apple(), new Random().nextInt(11));
            } else {
                box.addFruit(new Orange(), new Random().nextInt(11));
            }
        }
    }

    public static void compareBoxes(ArrayList<Box<Fruit>> boxes) {
        for (int i = 0; i < boxes.size() - 1; i++) {
            if (boxes.get(i).compare(boxes.get(i+1))) {
                System.out.printf("Вес коробки %s равен весу коробки %s - %.2f\n",
                        boxes.get(i).getName(), boxes.get(i+1).getName(), boxes.get(i).getWeight());
            } else {
                System.out.printf("Вес коробки %s - %.2f не равен весу коробки %s - %.2f\n",
                        boxes.get(i).getName(), boxes.get(i).getWeight(), boxes.get(i+1).getName(), boxes.get(i+1).getWeight());
            }
        }
    }

    public static void shuffleBoxes(ArrayList<Box<Fruit>> boxes) {
        for (Box<Fruit> box : boxes) {
            int randomIdx = new Random().nextInt(boxes.size());
            while(randomIdx == boxes.indexOf(box)) {
                randomIdx = new Random().nextInt(boxes.size());
            }
            box.moveToAnotherBox(boxes.get(randomIdx));
        }
    }

    public static void main(String[] args) {

        ArrayList<Box<Fruit>> boxes = createBoxes(new Random().nextInt(11));

        printBoxes(boxes);
        fillBoxes(boxes);
        printBoxes(boxes);
        compareBoxes(boxes);
        System.out.println("\n***\n");
        shuffleBoxes(boxes);
        printBoxes(boxes);

    }
}
