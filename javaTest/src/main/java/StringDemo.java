/**
 * String：字符串常量，字符串长度不可变。
 *      Java中String 是immutable（不可变）的。用于存放字符的数组被声明为final的，因此只能赋值一次，不可再更改。
 *
 * StringBuffer：字符串变量（Synchronized，即线程安全）。
 *      如果要频繁对字符串内容进行修改，出于效率考虑最好使用 StringBuffer，
 *      如果想转成 String 类型，可以调用 StringBuffer 的 toString() 方法。
 *      Java.lang.StringBuffer 线程安全的可变字符序列。在任意时间点上它都包含某种特定的字符序列，
 *      但通过某些方法调用可以改变该序列的长度和内容。可将字符串缓冲区安全地用于多个线程。
 *
 * StringBuilder：字符串变量（非线程安全）。
 *      在内部 StringBuilder 对象被当作是一个包含字符序列的变长数组。
 *
 * 基本原则：
 *
 *      如果要操作少量的数据用 String ；
 *      单线程操作大量数据用StringBuilder ；
 *      多线程操作大量数据，用StringBuffer。
 */

import java.util.ArrayList;

public class StringDemo {

    public static void main(String args[]){
        System.out.println("============================================");

        char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
        String helloString = new String(helloArray);
        System.out.println( helloString );

        System.out.println("============================================");

        String site = "www.runoob.com";
        int len = site.length();
        System.out.println( "菜鸟教程网址长度 : " + len );

        System.out.println("============================================");

        System.out.println( "我的名字是 ".concat("Runoob"));
        String string1 = "菜鸟教程网址：";
        System.out.println("1、" + string1 + "www.runoob.com");

        System.out.println("============================================");

        float floatVar = 1;
        int intVar = 1;
        String stringVar = "abc";

        System.out.printf("格式化输出    浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                " %s\n", floatVar, intVar, stringVar);

        String fs;
        fs = String.format("格式化String  浮点型变量的值为 " +
                "%f, 整型变量的值为 " +
                " %d, 字符串变量的值为 " +
                " %s", floatVar, intVar, stringVar);
        System.out.println(fs);


        String str = "123";
        System.out.println(str.getBytes());

        System.out.println("============================================");

        String s0 = "Google";
        System.out.println("s0 = " + s0);
        String s1 = s0;                         // 这里是引用
        System.out.println("s1 = " + s1);

        System.out.println("s0 == s1  " + (s0 == s1));
        System.out.println("s1 = " + s1);

        s1 = "Runoob";   // s重新分配内存   String实际是一个 char[], 若改变则返回新的一个String
        System.out.println("s0 == s1  " + (s0 == s1));
        System.out.println("s1 = " + s1);


        // 当一个字符串是一个字面量时，它会被放到一个常量池中，等待复用。
        String sa = "saff";                        // 常量池 全局数据区
        String sb = "saff";                        // 常量池 全局数据区  sa\sb地址相同
        String sc = new String("saff");   // 堆中 地址不同于 sa\sb
        System.out.println(sa.equals(sb) + " " + sa.equals(sc));  // true true
        System.out.println((sa == sb )+ " " + (sa == sc));        // true false

        // 常量优化机制, ss1 已经成为 "abc" 在常量池中查找创建，ss2 不需要再创建。
        String ss1="a"+"b"+"c";
        String ss2="abc";
        System.out.println(ss1.equals(ss2) + " " + (ss1 == ss2 ));  // true true

        System.out.println("============================================");

        /// 包装类中， == 是比较地址，  equal 比较的是值
        Integer aa = 10;
        Integer bb = 10;
        System.out.println(aa == bb);        // true
        System.out.println(aa.equals(bb));   // true
        // aa.valueOf(100);  // 重写内存区
        aa = bb ;        // 引用
        // aa = 100;     // 重新分配内存
        System.out.println(aa == bb);        // true
        System.out.println(aa.equals(bb));   // false

        System.out.println("============================================");

        String []list={"ma","cao","yuan"};
        String a="macaoyuan";
        ArrayList array=new ArrayList();   array.add(a);

        System.out.println(list.length);  // 3
        System.out.println(a.length());   // 9
        System.out.println(array.size()); // 1


        System.out.println("============================================");
        /**
         *  当对字符串进行修改的时候，需要使用 StringBuffer 和 StringBuilder 类。
         *
         *  和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
         *
         *  StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
         *
         *  由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
         *  然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。
         *
         *        String 长度大小不可变
         *        StringBuffer 和 StringBuilder 长度可变
         *        StringBuffer 线程安全 StringBuilder 线程不安全
         *        StringBuilder 速度快
         *    stringbuffer 的线程安全，仅仅是保证 jvm 不抛出异常顺利的往下执行而已，它可不保证逻辑正确和调用顺序正确(!!!!!!!1)
         */
            StringBuffer sBuffer = new StringBuffer("菜鸟教程官网：");
            sBuffer.append("www");
            sBuffer.append(".runoob");
            sBuffer.append(".com");
            System.out.println(sBuffer);

            StringBuilder sBuilder = new StringBuilder("你这么牛逼，你爸妈知道吗？");
            sBuilder.append(13213216546546L);
            System.out.println(sBuilder);
    }
}

