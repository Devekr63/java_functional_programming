package org.example.lambda.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    record  Person(String firstName, String lastName){
        @Override
        public String toString(){
            return firstName+" "+lastName;
        }
    }
    public static void main(String[] args){
        List<Person> people = new ArrayList<>(
                Arrays.asList(
                        new Main.Person("Devendra", "Kumar"),
                        new Person("Deepak", "Kumar"),
                        new Person("Bunty", "Shunty"),
                        new Person("Rahul", "Verma")
                )
        );

        var sortByLastNameComparator = new Comparator<Person>(
        ) {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName().compareTo(o2.lastName());
            }
        };

//        people.sort(sortByLastNameComparator);
        people.sort((p1, p2) -> p1.lastName().compareTo(p2.lastName()));
        System.out.println(people);


        //Custom Comparator interface
        interface ExtendedComparator<T> extends Comparator<T> {
            int secondLevel(T p1, T p2);
        }

        var comparatorMixed = new ExtendedComparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                int result = p1.lastName().compareTo(p2.lastName());
                return result == 0 ? secondLevel(p1, p2) : result;
            }

            @Override
            public int secondLevel(Person p1, Person p2) {
                return p1.firstName().compareTo(p2.firstName());
            }
        };

        people.sort(comparatorMixed);
        System.out.println(people);
    }
}
