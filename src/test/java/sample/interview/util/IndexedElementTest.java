package sample.interview.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class IndexedElementTest {

    @Test
    public void indexedFunction() {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");

        Map<String, Integer> map =
                fruits.stream().map(IndexedElement.indexed()).collect(Collectors.toMap(IndexedElement::value, IndexedElement::index));

        assertEquals(3, map.size());
        assertEquals(1, map.get("Apple").intValue());
        assertEquals(2, map.get("Banana").intValue());
        assertEquals(3, map.get("Orange").intValue());
    }
}