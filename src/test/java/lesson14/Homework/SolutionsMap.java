package lesson14.Homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SolutionsMap {
    /* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        Map<String, Cat> mapCat = new HashMap<String, Cat>();
        for (int i = 0; i < 11; i++) {
            Cat cat = new Cat("cat" + i);
            mapCat.put(cat.toString(), cat);
        }
        return mapCat;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> catSet = new HashSet<>();
        for (int i = 0; i < map.size(); i++) {
            catSet.add(map.get("Cat cat" + i));
       }
        return catSet;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat.name);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }
}
