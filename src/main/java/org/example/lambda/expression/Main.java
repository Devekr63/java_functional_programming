package org.example.lambda.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(
                Arrays.asList("Alpha","Bravo" ,"Charlie", "Delta")
        );

        for(String s:list){
            System.out.println(s);
        }

        System.out.println("__________");
        list.forEach(s -> System.out.println(s));

        System.out.println("__________");
        String nato = "nato";
        list.forEach(myString -> {
            char first = myString.charAt(0);
            System.out.println(nato+ " "+myString + " means " + first);
        });


        //nato = "NATO";
        //compiler through an error,
        //since value of local variables,
        //used in lambda cannot be changed.
    }
}
