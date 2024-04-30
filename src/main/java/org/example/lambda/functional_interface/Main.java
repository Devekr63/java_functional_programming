package org.example.lambda.functional_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        int result = calculator((a,b) -> a+b, 5 , 2);
        doOperationOnList(num -> num*2, Arrays.asList(1,2,3,4));

        var coords = Arrays.asList(
                new double[]{43.564, -98.765},
                new double[]{52.123, -89.023},
                new double[]{54.211, -92.412}
        );

        coords.forEach(coord ->
                processPoint(coord[0], coord[1],
                        (lat1, lat2) -> System.out.printf("[latitude: %.3f, longitude: %.3f]\n", lat1, lat2)));

        List<String> list = new ArrayList<>(
                Arrays.asList("Alpha","Bravo" ,"Charlie", "Delta")
        );

        list.removeIf(s -> s.equalsIgnoreCase("Bravo"));
        list.forEach(System.out::println);

        System.out.println("____________");
        list.addAll(Arrays.asList("echo", "easy", "earnest"));
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(System.out::println);
    }
    public static <T> T calculator(Operation<T> function, T value1, T value2){
        T result = function.operate(value1, value2);
        System.out.println("Result of operation: "+result);
        return result;
    }

    public static <T> void doOperationOnList(ListOperation<T> filter, List<T> list){
        for(T value: list) {
            T result = filter.operate(value);
            System.out.println(result);
        }
    }

    //BiConsumer interfaces
    public static <T> void processPoint(T p1, T p2, BiConsumer<T,T> consumer){
        consumer.accept(p1, p2);
    }
}
