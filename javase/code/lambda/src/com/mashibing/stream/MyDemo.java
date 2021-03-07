package com.mashibing.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MyDemo {

    public static void main(String[] args) {

        // testJumpLoop();
        // testOr();
        // testOr2();
        // testDistinctSortedJoining();
        // testStringBuilder();
        testDoWhile();
    }

    private static void testDoWhile() {
        int i = 0;
        do {
            System.out.println(i++);
        } while (i < 10);
    }

    private static void testStringBuilder() {
        StringBuilder builder = new StringBuilder();
        int index = builder.lastIndexOf(" AND ");
        System.out.println(index);
        builder.delete(index, builder.length());
    }

    private static void testDistinctSortedJoining() {
        List<String> nameList = Arrays.asList("门急诊", "住院", "住院");
        System.out.println(nameList.stream().distinct().sorted().collect(Collectors.joining("-")));
    }

    // 跳出循环
    private static void testJumpLoop() {
        List<String> list = Arrays.asList("a", "b", "c");
        list.stream().forEach(val -> {
            if ("b".equals(val)) {
                return;
            }
            System.out.println(val);
        });
    }

    private static void testOr() {
        Integer policyYear = 2;
        Integer status = 1;
        String extraInfo = "住院";
        System.out.println(Objects.equals(policyYear, 1) && Objects.equals(status, 0) || !Objects.equals(status, 0) && Objects.equals(extraInfo, "住院"));
    }

    private static void testOr2() {
        Integer i1 = 0;
        Integer i2 = 0;
        Integer i3 = 0;
        System.out.println(++i1 > 0 && ++i2 > 1 || ++i3 >= 0);
        System.out.println(i1 + "," + i2 + "," + i3);
    }

}
