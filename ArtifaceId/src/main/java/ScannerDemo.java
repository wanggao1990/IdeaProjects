import java.util.Scanner;
import java.util.StringTokenizer;

public class ScannerDemo {
    public static void main(String[] args) {

       // scanTest();

       // nextFun();

       // sumScan();

        strToken();
    }


    static void scanTest()
    {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }

    /**
     *   next():
     *         1、一定要读取到有效字符后才可以结束输入。
     *         2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
     *         3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
     *             next() 不能得到带有空格的字符串。
     *
     *  nextLine()：
     *         1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
     *         2、可以获得空白。
     *
     *   如果要输入 int 或 float 类型的数据，在 Scanner 类中也有支持，但是在输入之前
     *   最好先使用 hasNextXxx() 方法进行验证，再使用 nextXxx() 来读取：
     *
     */
    static void nextFun()
    {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        int i = 0;
        float f = 0.0f;
        System.out.print("输入整数：");
        if (scan.hasNextInt()) {
            // 判断输入的是否是整数
            i = scan.nextInt();
            // 接收整数
            System.out.println("整数数据：" + i);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是整数！");
        }
        System.out.print("输入小数：");
        if (scan.hasNextFloat()) {
            // 判断输入的是否是小数
            f = scan.nextFloat();
            // 接收小数
            System.out.println("小数数据：" + f);
        } else {
            // 输入错误的信息
            System.out.println("输入的不是小数！");
        }
        scan.close();
    }

    static void sumScan()
    {
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        int m = 0;
        while (scan.hasNextDouble()) {
            double x = scan.nextDouble();
            m = m + 1;
            sum = sum + x;
        }
        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + (sum / m));
        scan.close();
    }


    /**
     *     分解输入的整行得到的带空格的字符串
     *     默认情况下，StringTokenizer以空格，制表符，换行符和回车符作为分割依据。
     */
    static void strToken()
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入数据：");
        StringTokenizer stringTokenizer=new StringTokenizer(scanner.nextLine());
        System.out.println("分隔后：");
        while(stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }
    }
}
