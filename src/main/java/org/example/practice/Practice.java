package org.example.practice;

import org.example.lambda.functional_interface.Operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(
                Arrays.asList("Devendra", "Kumar", "Deepak", "Pradep")
        );

        list.forEach(name -> {
            System.out.println("Student: "+name);
        });
        int result = calculator(Integer::sum, 5, 2);
        System.out.println(result);

        result = calculator(Integer::max, 5, 9);
        System.out.println(result);

        result = calculator(Integer::divideUnsigned, 18, 3);
        System.out.println(result);
    }



    public static <T> T calculator(Operation<T> fun,  T value1, T value2){
        return fun.operate(value1, value2);
    }
}

@FunctionalInterface
interface Operator<T>{
    T operate(T t, T r);
}


