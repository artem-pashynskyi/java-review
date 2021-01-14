package streams.mosh;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemo {
    public static void main(String[] args) {
        List<Movie> movies = List.of(
            new Movie("a", 10, Genre.THRILLER),
            new Movie("b", 15, Genre.ACTION),
            new Movie("c", 20, Genre.ACTION)
        );

        var stream = Stream.generate(() -> Math.random());
        stream
                .limit(4)
                .forEach(n -> System.out.println(n));

        Stream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> System.out.println(n));

        var stream2 = Stream.of(List.of(1,2,3), List.of(4,5,6));
        stream2
                .flatMap(list -> list.stream())
                .forEach(i -> System.out.println(i));

        movies.stream()
                .limit(2)
                .forEach(m -> System.out.println(m));

        movies.stream()
                .skip(2)
                .forEach(m -> System.out.println(m));

        movies.stream()
//                .sorted((a,b) -> a.getTitle().compareTo(b.getTitle()))
                .sorted(Comparator.comparing(Movie::getTitle))
                .forEach(m -> System.out.println(m.getTitle()));

        movies.stream()
                .filter(m -> m.getLikes() > 10)
                .peek(m -> System.out.println("filtered: " + m))
                .map(Movie::getTitle)
                .peek(m -> System.out.println("mapped: " + m))
                .forEach(System.out::println);

        movies.stream().count(); //returns 3
        movies.stream().anyMatch(m -> m.getLikes() > 20); //Checks if there is any element which satisfies the condition, returns true
        movies.stream().allMatch(m -> m.getLikes() > 20); //Checks if all elements satisfy the condition, returns false
        movies.stream().allMatch(m -> m.getLikes() > 20); //Checks if none of the elements satisfy the condition, returns false
        movies.stream().min(Comparator.comparing(Movie::getLikes)).get(); //returns "a"
        movies.stream().max(Comparator.comparing(Movie::getLikes)).get(); //returns "c"

        Integer sum = movies.stream()
                .map(m -> m.getLikes())
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        var result = movies.stream()
                .filter(m -> m.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getTitle, Function.identity())); //returns Map<String, Movie>
        System.out.println(result);

        var result2 = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.mapping(Movie::getTitle, Collectors.joining(", "))
                ));
        System.out.println(result2);
    }
}
