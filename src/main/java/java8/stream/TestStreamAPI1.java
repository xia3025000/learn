package java8.stream;

import java8.model.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamAPI1 {

    public static void main(String[] args) {
        TestStreamAPI1 testStreamAPI1 = new TestStreamAPI1();
        testStreamAPI1.test11();
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.FREE),
            new Employee("李四", 58, 5555.55, Employee.BUSY),
            new Employee("王五", 26, 3333.33, Employee.VOCATION),
            new Employee("老大", 36, 6666.66, Employee.FREE),
            new Employee("第二", 12, 8888.88, Employee.BUSY)
    );

    //创建Stream
    public void test01() {
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        Stream<Employee> stream1 = Arrays.stream(new Employee[10]);

        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //无限流迭代
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(10).forEach(System.out::println);

        //无限流生成
        Stream.generate(Math::random                                                                                                                            )
                .limit(5)
                .forEach(System.out::println);
    }

    public void test2() {
        Stream<Employee> stream = employees.stream()
                .filter((e) -> e.getAge() > 35);

        stream.forEach(System.out::println);
    }

    public void test3() {
        employees.stream()
                .filter((e) -> e.getSalary() > 5000)
                .limit(2)
                .forEach(System.out::println);


    }

    public void test4() {
        employees.stream()
                .map(Employee::getName).forEach(System.out::println);


    }

    public void test5() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        Stream<Stream<Character>> streamStream = list.stream().map(TestStreamAPI1::filterCharacter);
        streamStream.forEach((s) -> {
            System.out.println();
            s.forEach(System.out::println);});

        System.out.println();

        list.stream().flatMap(TestStreamAPI1::filterCharacter).forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    public void test7() {
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).forEach(System.out::println);

        employees.stream().sorted((e1, e2) -> e1.getAge() - e2.getAge()).forEach(System.out::println);
    }

    public void test8() {
        boolean allMatch = employees.stream().allMatch((e) -> e.getStatus() == Employee.BUSY);
        System.out.println(allMatch);

        //allMatch
        //anyMatch
        //noneMatch

        //findAny 随便取一个,串行取第一个,并行随意

        //对于返回结果有可能为空的,就封装到Optional中去
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first.orElse(employees.get(1)));


        Optional<Employee> op = employees.stream().filter((e) -> e.getStatus() == Employee.FREE).findAny();
        System.out.println(op.get());

        Optional<Employee> op2 = employees.parallelStream().findAny();
        System.out.println(op2.get());

        //count
        //max
        //min
    }

    public void test9() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //上一轮的结果作为x,与集合中新的y运算得到新值并作为下一轮的x
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(sum);

    }


    public void test10() {
        List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());

        Map<String, Double> map = employees.stream().collect(Collectors.toMap((e) -> e.getName(), (e) -> e.getSalary()));
        System.out.println(map);

        Map<String, Double> collect2 = employees.stream().collect(Collectors.toMap(Employee::getName, Employee::getSalary));

    }

    public void test11() {
        Map<Integer, List<Employee>> map = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);
        Map<Integer, List<Employee>> map2 = employees.stream().collect(Collectors.groupingBy(e -> e.getStatus()));
        Map<Integer, List<Employee>> map3 = employees.stream().collect(Collectors.groupingBy(new Function<Employee, Integer>() {
            @Override
            public Integer apply(Employee employee) {
                return employee.getStatus();
            }
        }));

        Map<Integer, Map<String, List<Employee>>> map5 = employees.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
            if (e.getAge() < 30) {
                return "青年";
            } else {
                return "老年";
            }
        })));
        System.out.println(map5);
    }

}
