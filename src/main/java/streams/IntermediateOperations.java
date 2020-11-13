package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {

        Integer[] numbersArray = {1,2,3,4,5,6,7,8,9,10};
        Stream<Integer> numbersStream = Arrays.stream(numbersArray);

        System.out.println("************FILTER***************");
        System.out.println(numbersStream.filter(number -> number % 2 != 0).count());

        Stream<String> strStream = Arrays.asList("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").stream();
        System.out.println(strStream.filter(a -> a.length() == 5).count());

//        System.out.println(strStream.filter(str -> str.startsWith("A")).count()); - Stream is closed - ERROR
        Arrays.asList("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").stream().filter(a -> a.equals("Apple"))
                .forEach(a -> System.out.println(a));


        System.out.println("************MAP***************");
        Arrays.asList("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").stream().map(a -> a.toUpperCase())
                .forEach(str -> System.out.println(str));


        System.out.println("************DISTINCT***************");
        Arrays.asList("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").stream().distinct()
                .forEach(a -> System.out.println(a));


        System.out.println("************SORTED ORDER***************");
        Arrays.asList(1,2,3,4,5,6,7,8,9).stream().sorted().forEach(a -> System.out.println(a));


        System.out.println("************REVERSED ORDER***************");
        Arrays.asList(1,2,3,4,5,6,7,8,9).stream().sorted(Comparator.reverseOrder()).forEach(a -> System.out.println(a));



    }
}
