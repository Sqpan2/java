package com.mashibing.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyDemo {


    public static void main(String[] args) {

        testJumpLoop();

    }

    /** 跳出循环 */
    private static void testJumpLoop() {
        List<String> list = Arrays.asList("a", "b", "c");
        list.stream().forEach(val -> {
            if("b".equals(val)){
                return;
            }
            System.out.println(val);
        });
    }

}
