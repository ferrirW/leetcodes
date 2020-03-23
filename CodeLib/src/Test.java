import java.util.function.IntConsumer;

public class Test {

    public static void repeat(int count, IntConsumer action) {
        for (int i = 0; i < count; i++) {
            action.accept(i);
        }
    }

    public static void main(String[] args) {
        repeat(10, x -> System.out.print((10 - x) + " "));
        repeat(10, System.out::print);
    }
}
