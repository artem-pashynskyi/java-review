package streams;

import collections.ArrayLists;
import oop.encapsulation.Role;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TerminalOperations {
    public static void main(String[] args) {

        System.out.println("************COUNT***************");
        long count = Arrays.asList(1,2,3,4,5,6,6,6,7,8,9).stream().count();
        System.out.println(count);

        long count2 = Arrays.asList("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").stream()
                .filter(a -> a.equals("Apple")).count();
        System.out.println(count2);


        System.out.println("************FIND FIRST - FIND ANY***************");
        Role r = ArrayLists.createRoleList().stream().filter(role -> role.getDescription().equals("Employee"))
            .findFirst().get();
        System.out.println(r.getId());

        Role r2 = ArrayLists.createRoleList().stream().filter(role -> role.getDescription().equals("Employee"))
                .findAny().get();
        System.out.println(r2.getId());


        System.out.println("************COLLECT***************");
        List<String> appleList = Arrays.asList("Apple", "Orange", "Kiwi", "Banana", "Apple", "Cherry", "Mango").stream()
                .filter(a -> a.equals("Apple")).collect(Collectors.toList());
        appleList.stream().forEach(l -> System.out.println(l));


        System.out.println("************REDUCE***************");
        int total = Arrays.asList(3,4,5,6,12,20).stream().reduce(5,(x,y) -> x + y);
        System.out.println(total);

        String str = Arrays.asList("C", "Y", "B", "E", "R", "T", "E", "K").stream().reduce("", (a,b) -> a + b);
        System.out.println(str);


    }
}
