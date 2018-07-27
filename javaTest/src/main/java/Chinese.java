/**
 * JAVA 的类（外部类）有 2 种访问权限: public、default。
 *
 * 而方法和变量有 4 种：public、default、protected、private。
 *
 * 其中默认访问权限和 protected 很相似，有着细微的差别。
 *
 *  public 意味着任何地方的其他类都能访问。
 *  default 则是同一个包的类可以访问。
 *  protected 表示同一个包的类可以访问，其他的包的该类的子类也可以访问。
 *  private 表示只有自己类能访问。
 */

class Person {

    static final int i = 0;   //默认public

    public static void prt(String s) {
        System.out.println(s);
    }

    Person() {
        prt("父类·无参数构造方法： "+"A Person.");
    }//构造方法(1) 

    Person(String name) {
        prt("父类·含一个参数的构造方法： "+"A person's name is " + name);
    }//构造方法(2) 
}

public class Chinese extends Person {



    Chinese() {
        super(); // 调用父类构造方法（1）
        prt("子类·调用父类”无参数构造方法“： "+"A chinese coder.");

        // super().prt("显示调用父类方法");
    }

    Chinese(String name) {
        super(name);// 调用父类具有相同形参的构造方法（2）
        prt("子类·调用父类”含一个参数的构造方法“： "+"his name is " + name);
    }

    Chinese(String name, int age) {
        this(name);// 调用具有相同形参的构造方法（3）
        prt("子类：调用子类具有相同形参的构造方法：his age is " + age);
    }

    public static void main(String[] args) {

        Chinese cn = new Chinese();
        cn = new Chinese("codersai");
        cn = new Chinese("codersai", 18);

        final int fa = (char)65536;
        System.out.println("a = " + (byte)128);

        class MyDate implements Cloneable
        {
            int a=0;

            @Override
            public Object clone()
            {
                MyDate dat = null;
                try {
                    dat = (MyDate)super.clone();
                }catch (CloneNotSupportedException e){
                    e.printStackTrace();
                }
                return  dat;
            }
        }

        MyDate a,b;       // 在内存开辟两个引用空间
        a = new MyDate();       // 开辟MyDate对象的数据空间，并把该空间的首地址赋给a
        b = a;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);      // 和 q.equal(b)一样    类中相同


        System.out.println();

        b = (MyDate) a.clone();
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);

        System.out.println();

        /// 包装类中， == 是比较地址，  equal 比较的是值
        Integer aa = 10;
        Integer bb = 10;
        System.out.println(aa == bb);        // true
        System.out.println(aa.equals(bb));   // true
        //aa.valueOf(100);  // 重写内存区
        // aa = bb ;
        // aa = 100;     // 重新分配内存
        System.out.println(aa == bb);        // true
        System.out.println(a.equals(bb));   // false



        Float fb =  new Float(0);
        fb.doubleValue();


        String str ="123";
        byte by = Byte.parseByte(str);

    }
}