package com.mashibing.stream;

import com.mashibing.ChiEngDTO;

import javax.sound.midi.Soundbank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MyDemo {

    public static void main(String[] args) {

        MyDemo demo = new MyDemo();

        // testStreamJumpLoop();
        // testOr();
        // testOr2();
        // testDistinctSortedJoining();
        // testStringBuilder();
        // testDoWhile();
        // testBigDecimal();
        // testDecimalFormat();
        demo.testLambdaSort();

    }

    private void testLambdaSort() {

        List<RefundDetailDTO> posList = new ArrayList<>();
        posList.add(new RefundDetailDTO("P200", "100.11", "2021-03-01"));
        posList.add(new RefundDetailDTO("P600", "99.66", "2021-04-01"));
        posList.add(new RefundDetailDTO("P500", "0.66", "2021-03-01"));
        posList.add(new RefundDetailDTO("P100", "88.22", "2021-03-02"));
        posList.add(new RefundDetailDTO("P500", "0.77", "2021-03-02"));
        posList.add(new RefundDetailDTO("P400", "111.11", "2021-03-03"));

        posList = posList.stream().sorted(Comparator.comparing(RefundDetailDTO::getDate)).collect(Collectors.toList());
        for (RefundDetailDTO item : posList) {
            System.out.println(item);
        }
    }

    class RefundDetailDTO implements Serializable {
        private static final long   serialVersionUID = 3479645079507527346L;
        private              String amount;
        private              Date   date;
        private              String feeType;

        public RefundDetailDTO(String feeType, String amount, String date) {
            this.amount = amount;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                this.date = sdf.parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.feeType = feeType;
        }

        @Override
        public String toString() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return "RefundDetailDTO{" + "feeType='" + feeType + '\'' + ", date=" + sdf.format(date) + ", amount='" + amount + '\'' + '\'' + '}';
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getFeeType() {
            return feeType;
        }

        public void setFeeType(String feeType) {
            this.feeType = feeType;
        }
    }

    class CapitalTransactionDTO implements Serializable {
        private static final long       serialVersionUID = 3878040099331642542L;
        private              ChiEngDTO  amount;
        private              BigDecimal amountDecimal;
        private              ChiEngDTO  date;
        private              String     dueDateStr;
        private              ChiEngDTO  content;
        private              int        order;

        public ChiEngDTO getAmount() {
            return amount;
        }

        public void setAmount(ChiEngDTO amount) {
            this.amount = amount;
        }

        public BigDecimal getAmountDecimal() {
            return amountDecimal;
        }

        public void setAmountDecimal(BigDecimal amountDecimal) {
            this.amountDecimal = amountDecimal;
        }

        public ChiEngDTO getDate() {
            return date;
        }

        public void setDate(ChiEngDTO date) {
            this.date = date;
        }

        public String getDueDateStr() {
            return dueDateStr;
        }

        public void setDueDateStr(String dueDateStr) {
            this.dueDateStr = dueDateStr;
        }

        public ChiEngDTO getContent() {
            return content;
        }

        public void setContent(ChiEngDTO content) {
            this.content = content;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }
    }

    private static void testDecimalFormat() {

        double pi = 3.1415927;//圆周率
        //取一位整数
        System.out.println(new DecimalFormat("0").format(pi));//3
        //取一位整数和两位小数
        System.out.println(new DecimalFormat("0.00").format(pi));//3.14
        //取两位整数和三位小数，整数不足部分以0填补。
        System.out.println(new DecimalFormat("00.000").format(pi));//03.142
        //取所有整数部分
        System.out.println(new DecimalFormat("#").format(pi));//3
        //以百分比方式计数，并取两位小数
        System.out.println(new DecimalFormat("#.##%").format(pi));//314.16%
        //整数部分每三位用逗号分隔,并且保留两位小数(四舍五入)
        System.out.println(new DecimalFormat("#,##0.00").format(new BigDecimal("123456.123456")));//123,456.12

        System.out.println("--------------------------");
        long c = 299792458;//光速
        //显示为科学计数法，并取五位小数
        System.out.println(new DecimalFormat("#.#####E0").format(c));//2.99792E8
        //显示为两位整数的科学计数法，并取四位小数
        System.out.println(new DecimalFormat("00.####E0").format(c));//29.9792E7
        //每三位以逗号进行分隔。
        System.out.println(new DecimalFormat(",###").format(c));//299,792,458
        //将格式嵌入文本
        System.out.println(new DecimalFormat("光速大小为每秒,###米").format(c)); //光速大小为每秒299,792,458米
    }

    private static void testBigDecimal() {

        System.out.println("-----------转换----------");
        // String -> BigDecimal
        System.out.println(new BigDecimal("0.1500").toString());    //0.1500
        System.out.println(new BigDecimal("-0.1500").toString());   //-0.1500

        System.out.println("-----------精度问题----------");
        // 浮点运算精度问题，float和double只能用来做科学计算和工程计算。商业运算中我们要使用BigDecimal。
        System.out.println(0.05 + 0.01);    //0.060000000000000005
        System.out.println(1.0 - 0.42);     //0.5800000000000001
        System.out.println(4.015 * 100);    //401.49999999999994
        System.out.println(123.3 / 100);    //1.2329999999999999
        //非BigDecimal(String)也会存在精度问题
        System.out.println(new BigDecimal(0.1500)); //0.1499999999999999944488848768742172978818416595458984375

        System.out.println("-----------小数位----------");
        // BigDecimal保留小数
        BigDecimal bigDecimal = new BigDecimal("0.126");
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_UP));        //恒入
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_DOWN));      //恒舍
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_CEILING));   //正恒入,如果正数恒入,如果负数恒舍
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_FLOOR));     //负恒入,如果正数恒舍,如果负数恒入
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));   //四舍五入 >=0.5
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_DOWN)); //四舍五入 >0.5
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
    private static void testStreamJumpLoop() {
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
