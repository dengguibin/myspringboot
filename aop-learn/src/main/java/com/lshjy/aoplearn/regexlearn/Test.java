package com.lshjy.aoplearn.regexlearn;

public class Test {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("5678".matches("-?\\d+"));
        System.out.println("+991".matches("-?\\d+"));
        System.out.println("".matches("(-|\\+)?\\d+"));
        System.out.println("".matches(""));
    }
}
