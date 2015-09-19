package Chapter3;

import java.util.LinkedList;

/**
 * Created by Hao on 9/19/15.
 */
public class Solution36 {

    public static void main(String[] args) {
        AnimalShelter<String> animalShelter = new AnimalShelter<>();
        for (int count = 0; count < 7; ++count) {
            if (count % 2 == 0) {
                animalShelter.enqueue("dog");
            } else {
                animalShelter.enqueue("cat");
            }
        }
        System.out.println(animalShelter.toString());
        System.out.println(animalShelter.dequeueCat());
        System.out.println(animalShelter.toString());
        System.out.println(animalShelter.dequeueCat());
        System.out.println(animalShelter.toString());
        System.out.println(animalShelter.dequeueAny());
        System.out.println(animalShelter.dequeueDog());
        System.out.println(animalShelter.toString());
    }

    // use doubly linked list as basic data structure.
    private static class AnimalShelter<T> {

        // add to the last
        public void enqueue(T animal) {
            list.addLast(animal);
        }

        // get "oldest" animal (dog or cat)
        public T dequeueAny() {
            return list.removeFirst();
        }

        // get first dog
        public T dequeueDog() {
            int index = list.indexOf("dog");
            T animal = list.get(index);
            list.remove(index);
            return animal;
        }

        // get first cat
        public T dequeueCat() {
            int index = list.indexOf("cat");
            T animal = list.get(index);
            list.remove(index);
            return animal;
        }

        @Override public String toString() {
            String str = "";
            for (int pos = 0; pos < list.size(); ++pos) {
                str += list.get(pos) + " ";
            }
            return str;
        }

        private LinkedList<T> list = new LinkedList<>();
    }
}
