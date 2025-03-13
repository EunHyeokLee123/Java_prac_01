package etc.lambda;

@FunctionalInterface
public interface GenericFunction<T, Y> {

    // T에서 Y를 추출하는 메소드
    Y apply(T t);

}
