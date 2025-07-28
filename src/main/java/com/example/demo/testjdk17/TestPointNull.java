package com.example.demo.testjdk17;


import java.util.List;

public class TestPointNull {
    public static void main(String[] args) {
        try {
            //简单的空指针
            String str = null;
            str.length();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*try {
            //复杂一点的空指针
            var arr = List.of(null);
            String str = (String)arr.get(0);
            str.length();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
