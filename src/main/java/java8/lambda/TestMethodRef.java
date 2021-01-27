package java8.lambda;

import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class TestMethodRef {

    public static void main(String[] args) {
        TestMethodRef testMethodRef = new TestMethodRef();
        testMethodRef.test1();
    }

    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("hello world");
        con1.accept("hello world1");
        Consumer<String> con2 = System.out::println;
        con2.accept("hello world2");

        BiPredicate<String, String> bp = String::equals;
        System.out.println(bp.test("x", "xy"));
    }



}
