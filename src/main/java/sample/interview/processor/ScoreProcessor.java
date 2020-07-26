package sample.interview.processor;

import java.io.InputStream;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@FunctionalInterface
public interface ScoreProcessor {
    Integer processFile(InputStream inputStream);

    default Stream<String> streamScanner(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream, "UTF-8").useDelimiter("\\s*,\\s*");
        Spliterator<String> spliterator = Spliterators.spliteratorUnknownSize(scanner, Spliterator.ORDERED | Spliterator.NONNULL);

        return StreamSupport.stream(spliterator, false)
                .map(s -> s.replaceAll("^\"+|\"+$", "")) // replacing the double quotes with empty white space
                .sorted() // sorting the names
                .onClose(scanner::close);
    }
}
