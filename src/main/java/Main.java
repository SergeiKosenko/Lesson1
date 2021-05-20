//        1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
//        2. Написать метод, который преобразует массив в ArrayList;
//        3. Задача:
//           Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
//           Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку
//           нельзя сложить и яблоки, и апельсины;
//           Для хранения фруктов внутри коробки можно использовать ArrayList;
//           Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
//           вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
//           Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
//           которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
//           Можно сравнивать коробки с яблоками и апельсинами;
//           Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов:
//           нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в
//           другую перекидываются объекты, которые были в первой;
//           Не забываем про метод добавления фрукта в коробку.


import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//############# Задание 1: ##############################################################

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        data(list1);
        System.out.println("Задание 1:\n" + list1);
        List<String> list2 = Arrays.asList("Кот", "Лошадь", "Собака", "Бык", "Теленок");
        data(list2);
        System.out.println(list2);

//############## Задание 2: ##############################################################

        String[] array = {"Кот", "Лошадь", "Собака", "Бык", "Теленок"};
        List<String> list = arrayToList(array);
        System.out.println("Задание 2:\nArrayList: " + list);

//############## Задание 3: ##############################################################

        int addapple = 150;
        int addorange = 200;
        Apple apl = new Apple();
        Orange orange = new Orange();
        Box<Apple> boxApple = new Box<Apple>();
        Box<Orange> boxOrange = new Box<Orange>();

        for (int i = 1; i <= addapple; i++) {
            boxApple.addFruit (apl);
        }

        for (int i = 1; i <= addorange; i++) {
            boxOrange.addFruit (orange);
        }

        if ((boxApple.compare (boxOrange.getTotalWeight () , boxApple.getTotalWeight ())) == true)
        {
            System.out.println ("Задание 3:\nВес коробок равен: по " + boxApple.getTotalWeight () + " в каждой");
        }
            else {
            System.out.println ("Задание 3:\nВес коробок не равен:");
            System.out.println ("Вес яблок: " + boxApple.getTotalWeight ());
            System.out.println ("Вес Апельсин: " + boxOrange.getTotalWeight ());

            }

//###########################################################################################
    }

    private static <T> List<T> data (List<T> list) {
        List <T> temp = list;
        T firstElement = temp.get (0);
        T lastElement = temp.get (list.size () - 1);
        temp.set (0, lastElement);
        temp.set (temp.size () - 1, firstElement);
        return temp;
    }

    private static <E> List <E> arrayToList (E [] array) {
        return Arrays.asList (array);
    }



}
