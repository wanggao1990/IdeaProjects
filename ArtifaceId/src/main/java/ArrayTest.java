import java.util.Arrays;
import java.util.List;

public class ArrayTest {

    public static void main(String[] args) {

        System.out.println("============================================");

        java.util.Scanner scan = new java.util.Scanner(System.in);   //键盘输入

        int jjj = 10;
        int[] arra = new int[10] ;

        while( --jjj >= 0 )
        {
            arra[jjj] = scan.nextInt();
        }
        System.out.printf("arr = " + arra.toString());

        System.out.println("============================================");


        // 数组大小
        int size = 10;
        // 定义数组
        double[] myList = new double[size];
        myList[0] = 5.6;                        // 初始化方法1
        myList[1] = 4.5;
        myList[2] = 3.3;
        myList[3] = 13.2;
        myList[4] = 4.0;
        myList[5] = 34.33;
        myList[6] = 34.0;
        myList[7] = 45.45;
        myList[8] = 99.993;
        myList[9] = 11123;
        // 计算所有元素的总和
        double total = 0;
        for (int i = 0; i < size; i++) {
            System.out.printf("List[%d] = %f\n", i, myList[i]);
            total += myList[i];
        }
        System.out.println("总和为： " + total);

        System.out.println("============================================");

        double[] myList2 = {1.9, 2.9, 3.4, 3.5};   // 初始化方法2

        // 打印所有数组元素
        for (int i = 0; i < myList2.length; i++) {
            System.out.println(myList2[i] + " ");
        }
        // 计算所有元素的总和
        double total2 = 0;
        for (int i = 0; i < myList2.length; i++) {
            total2 += myList2[i];
        }
        System.out.println("Total is " + total2);
        // 查找最大元素
        double max = myList2[0];
        for (int i = 1; i < myList2.length; i++) {
            if (myList2[i] > max) max = myList2[i];
        }
        System.out.println("Max is " + max);

        System.out.println("============================================");
        // 打印所有数组元素
        for (double element: myList2) {
            System.out.println(element);
        }

        printArray(new int[]{3, 1, 2, 6, 4, 2});

        printArray(reverse(new int[]{3, 1, 2, 6, 4, 2}));

        System.out.println("============================================");

        int a[][] = new int[2][3];  // 2行三列

        String s[][] = new String[2][];  // 种类类似于c++ 中 vector<string> [2]
        s[0] = new String[2];
        s[0][0] = new String("Good");
        s[0][1] = new String("Luck");
        s[1] = new String[3];
        s[1][0] = new String("to");
        s[1][1] = new String("you");
        s[1][2] = new String("!");

        System.out.println("============================================");
        // Array 操作
        int[] arr = new int[]{3, 1, 2, 6, 4, 2, 7, 9, 8};
        List l = Arrays.asList(arr);
        Arrays.fill(arr,1,3,5);
        Arrays.sort(arr, 2, 7);
        Arrays.sort(arr);
        int ll = arr.length;



    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static int[] reverse(int[] list) {
        int[] result = new int[list.length];

        for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
            result[j] = list[i];
        }
        return result;
    }
}
