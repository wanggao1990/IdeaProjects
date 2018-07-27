import Pkg1.OOO;

class FreshJuice {
    enum FreshJuiceSize{ SMALL, MEDIUM , LARGE }
    FreshJuiceSize size;
}


class userInfo
{
    int userId;
    void fun(){  System.out.println("userInfo func()");  }
}
class student extends userInfo
{
    int studentid;
    void fun(){  System.out.println("student func()");  } //重写
    void fun2(){  System.out.println("student func2()");  }
}

////////////////////////////////////////
class Cake extends Object {
    private int id;
    public Cake(int id) {
        this.id = id;
        System.out.println("Cake Object " + id + " is created");
    }

    protected void finalize() throws java.lang.Throwable {
        super.finalize();
        System.out.println("Cake Object " + id + " is disposed");
    }
}

public class Test {
    static OOO a = new OOO();
    public static void main(String[] args) {
        /////////////////////////////////////////////////////////////////
        Cake c1 = new Cake(1);
        Cake c2 = new Cake(2);
        Cake c3 = new Cake(3);

        c2 = c3 = null;
        System.gc(); //调用Java垃圾收集器


        //////////////////////////////////////////////////////////////////

        // 可变参数时，两者都可
        printMax(1,2,3,11,5,6);
        printMax(new double[]{1,2,3,11,5,6});  // 参数为数组时，只能这个方法

        ////////////////////////////////////////////////////////////

        student s1 = new student();
        s1.fun();
        s1.fun2();
        s1.userId = 0;
        s1.studentid = 0;

        userInfo s2 = new student();
        s2.fun();      // 这里是子类的方法
        // s2.fun2();
        s2.userId = 0;
        // s2.studentid = 0;

        /////////////////////////////////////////////////////////////

        System.out.println(); // 空行

        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSize.MEDIUM;

        System.out.println("juice = " + juice.size);

        System.out.println("111111111111");
        fun();

       // OOO.ptrPStr(":asdsadsa");

//        OOO a = new OOO();
//        a.main1("12321");

    }

    public void main1(String[] args) {

    }


    public static void fun() {
        OOO.prtStr("123123");
    }

     public static void printMax(  double  .../*[]*/  numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed");
            return;
        }

        double result = numbers[0];

        // 可变参时，实参为对应数据格式的数组， true
        System.out.println(numbers instanceof double[]);

        for (int i = 1; i <  numbers.length; i++){
            if (numbers[i] >  result) {
                result = numbers[i];
            }
        }
        System.out.println("The max value is " + result);
    }
}


