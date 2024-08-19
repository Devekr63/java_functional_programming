package org.example.practice;

import org.example.practice.Operation;

import java.util.Arrays;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
//        System.out.println(calculator(3,4,(a, b) -> a*b));

        int res = 0;
        var list = Arrays.asList(1,2,3,4,5);
        for(int x : list){
            res = sum(res, x, (a,b) -> a+b);
        }
        System.out.println(res);

        Test t1 = new Test(){
            @Override
            public int doSomething(String s){
                return s.length();
            }
        };

        System.out.println(t1.doSomething("Devndra"));
    }

//    public static <T> T calculator(T value1, T value2, Operation<T> function){
//        T result = function.operate(value1, value2);
//        return result;
//    }

    public static <T> T sum(T value1, T value2, Operation<T, T> function){
        return function.operate(value1, value2);
    }


}

interface Test{
    int doSomething(String s);
}
