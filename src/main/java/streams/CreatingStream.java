package streams;

import collections.ArrayLists;
import oop.encapsulation.Role;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreatingStream {
    public static void main(String[] args) {

        //Creating stream from an Array
        String[] courses = {"Java", "JS", "TS", "API"};
        Stream<String> courseStream = Arrays.stream(courses);

        //Creating stream from a Collection
        Stream<Role> roleStream = ArrayLists.createRoleList().stream();

        //Creating stream from Specified values
        Stream<Integer> stream = Stream.of(1,2,3,4,5);

    }
}
