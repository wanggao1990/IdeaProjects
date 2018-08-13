package ColloectionMapTest;

import sun.text.normalizer.UnicodeSetIterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a");

        System.out.println("--1 直接用for遍历集合set");
        for (String str: set){
            System.out.println(str);
        }

        System.out.println("--2 用iterator遍历set");
        Iterator<String> it = set.iterator();
        while (it.hasNext())     {
            String str = it.next();
            System.out.println(str);
        }

        System.out.println("--2 将set转换成数组");
        String[] strArr = new String[set.size()];
        set.toArray(strArr);
        for (String str:strArr ){
            System.out.println(str);
        }
    }
}
