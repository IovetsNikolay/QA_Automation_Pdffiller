package lesson14.Homework;
/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

import java.util.*;


public class SetSimple {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);
        System.out.println();

        removeCats(pets);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> catSet = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            catSet.add(new Cat());
        }
        return catSet;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> dogSet = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            dogSet.add(new Dog());
        }
        return dogSet;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> joinedSet = new HashSet<>();
            joinedSet.addAll(cats);
            joinedSet.addAll(dogs);
            return joinedSet;
    }

    public static void removeCats(Set<Object> pets) {
        Iterator iterator = pets.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getClass().toString().contains("Cat")) {
                iterator.remove();
            }
        }
    }

    public static void printPets(Set<Object> pets) {
        Iterator iterator = pets.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static class Cat {}

    public static class Dog {}
}

