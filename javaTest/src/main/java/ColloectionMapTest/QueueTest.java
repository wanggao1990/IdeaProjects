package ColloectionMapTest;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {

        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        ((ArrayDeque<Integer>) queue).addFirst(0);
        ((ArrayDeque<Integer>) queue).addLast(2);
        ((ArrayDeque<Integer>) queue).push(3);

        System.out.println("--1 for 遍历");
        for (Integer i : queue) {
            System.out.println(i);
        }

        System.out.println("--2 转换成数组");
        Integer[] intArr = new Integer[queue.size()];
        queue.toArray(intArr);
        for (Integer i:intArr ) {
            System.out.println(i);
        }

        System.out.println("--3 iterator");
        Iterator<Integer>  it = queue.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }



        Integer p = ((ArrayDeque<Integer>) queue).pop();  //弹出队头，返回值

        ((ArrayDeque<Integer>) queue).removeFirst();
        queue.remove();

        p = queue.peek();   // 获取值，队列不修改


    }
}
