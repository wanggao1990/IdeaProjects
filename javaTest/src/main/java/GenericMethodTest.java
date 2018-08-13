import java.util.ArrayList;
import java.util.List;

/**
 * 定义泛型方法的规则：
 *
 *     所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面
 *  例子中的<E>）。
 *     每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是
 * 用于指定一个泛型类型名称的标识符。
 *     类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。
 *     泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）。
 */

public class GenericMethodTest {
    // 泛型方法 printArray
    public static < E > void printArray( E[] inputArray )
    {
        // 输出数组元素
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

    public static void main( String args[] )
    {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println( "整型数组元素为:" );
        printArray( intArray  ); // 传递一个整型数组

        System.out.println( "\n双精度型数组元素为:" );
        printArray( doubleArray ); // 传递一个双精度型数组

        System.out.println( "\n字符型数组元素为:" );
        printArray( charArray ); // 传递一个字符型数组
    }
}

/**
 * 要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。
 *
 *  例子：一个操作数字的方法可能只希望接受Number或者Number子类的实例
 *       演示了"extends"如何使用在一般意义上的意思"extends"（类）或者"implements"（接口）。
 *       该例子中的泛型方法返回三个可比较对象的最大值。
 */
class MaximumTest
{
    // 比较三个值并返回最大值
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        T max = x; // 假设x是初始最大值
        if ( y.compareTo( max ) > 0 ){
            max = y; //y 更大
        }
        if ( z.compareTo( max ) > 0 ){
            max = z; // 现在 z 更大
        }
        return max; // 返回最大对象
    }
    public static void main( String args[] )
    {
        System.out.printf( "%d, %d 和 %d 中最大的数为 %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ) );

        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear",
                "apple", "orange", maximum( "pear", "apple", "orange" ) );
    }
}

/**
 *  泛型类 的声明和非泛型类的声明类似，除了在类名后面添加了类型参数声明部分。
 *
 *      和泛型方法一样，泛型类的类型参数声明部分也包含一个或多个类型参数，参数间用逗号隔开。
 *   一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。因为他们接受
 *   一个或多个参数，这些类被称为参数化的类或参数化的类型。
 */
class Box<T> {

    private T t;

    public void add(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("菜鸟教程"));

        System.out.printf("整型值为 :%d\n", integerBox.get());
        System.out.printf("字符串为 :%s\n", stringBox.get());
    }
}


/**
 *   1、类型通配符一般是使用?代替具体的类型参数。例如 List<?> 在逻辑上是List<String>,List<Integer> 等
 *          所有List<具体类型实参>的父类。
 *
 *    <? extends T>和<? super T>的区别
 *          <? extends T>表示该通配符所代表的类型是T类型的子类。
 *          <? super T>表示该通配符所代表的类型是T类型的父类。
 */
 class GenericTest {

    public static void main(String[] args) {
        List<String> name = new ArrayList<String>();
        List<Integer> age = new ArrayList<Integer>();
        List<Number> number = new ArrayList<Number>();

        name.add("icon");
        age.add(18);
        number.add(314);

        getData(name);
        getData(age);
        getData(number);

       // getUperNumber(name);//1      // 这里是String, 但要求是 Number类型
        getUperNumber(age);//2
        getUperNumber(number);//3

    }

    public static void getData(List<?> data) {     // 所有list都可以用
        System.out.println("data :" + data.get(0));
    }

    public static void getUperNumber(List<? extends Number> data) {   // 只能使用 数值类型
        System.out.println("data :" + data.get(0));
    }
}