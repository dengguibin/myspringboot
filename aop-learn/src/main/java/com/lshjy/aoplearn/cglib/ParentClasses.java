package com.lshjy.aoplearn.cglib;

public class ParentClasses {

    public void ff(){

        System.out.println("dddddddd");
    }

    public String dd(){

        System.out.println("dddddddd");
        return "aaa";
    }

    public static void main(String[] args) {
        Object o = new CglibProxy().getProxy(ParentClasses.class);
        ParentClasses p = (ParentClasses)o;
        String result = p.dd();
        System.out.println(result);
    }
}
