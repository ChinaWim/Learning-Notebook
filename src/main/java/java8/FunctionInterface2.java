package java8;

@FunctionalInterface
public interface FunctionInterface2<T, R> {

    R getValue(T t, T k);
}
