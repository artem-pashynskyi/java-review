package lambda.mosh;

import java.util.List;
import java.util.function.*;

public class LambdasDemo {
    public static void show() {
        greet(message -> System.out.println(message));

        Printer printer = message -> System.out.println(message);

        List<String> list = List.of("a", "b", "c");
        Consumer<String> print = System.out::println;
        Consumer<String> printUpperCase = item -> System.out.println(item.toUpperCase());
        list.forEach(print.andThen(printUpperCase).andThen(print));

        Supplier<Double> getRandom = () -> Math.random();
        var random = getRandom.get();
        System.out.println(random);

        Function<String, Integer> map = str -> str.length();
        var length = map.apply("Sky");
        System.out.println(length);

        Predicate<String> isLongetThan5 = str -> str.length() > 5;
        var result = isLongetThan5.test("sky");
        System.out.println(result);

//        greet(new Printer() {
//            @Override
//            public void print(String message) {
//                System.out.println(message);
//            }
//        });
    }

    public static void greet(Printer printer) {
        printer.print("Hello");
    }
}
