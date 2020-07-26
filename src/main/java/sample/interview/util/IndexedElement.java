package sample.interview.util;

import java.util.function.Function;

public class IndexedElement<T> {
    private int index;
    private T value;

    private IndexedElement(int index, T value) {
        this.index = index;
        this.value = value;
    }

    public int index() {
        return index;
    }

    public T value() {
        return value;
    }

    public static <T> Function<T, IndexedElement<T>> indexed() {
        return new Function<T, IndexedElement<T>>() {
            int index = 1;

            @Override
            public IndexedElement<T> apply(T t) {
                return new IndexedElement<>(index++, t);
            }
        };
    }
}
