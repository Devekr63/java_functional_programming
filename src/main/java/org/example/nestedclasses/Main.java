package org.example.nestedclasses;

import org.w3c.dom.ls.LSOutput;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static class SomeClass{
        private String name= "Devendra.";
    }

    class InnerClass{
        String name = "Kumar";
    }
    public static void main(String[] args) {
        SomeClass sc = new SomeClass();
        System.out.println(sc.name);
        Main main = new Main();
        main.doSomeThing();
    }

    private void doSomeThing(){
        SomeClass sc = new SomeClass();
        InnerClass ic = new InnerClass();
        System.out.println(sc.name+" "+ic.name);
    }
}




