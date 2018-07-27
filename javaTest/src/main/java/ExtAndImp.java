/**
 * 修饰符：abstract、static、final
 *
 *  abstract: 表示是抽象类。 使用对象：类、接口、方法
 *  static: 可以当做普通类使用，而不用先实例化一个外部类。（用他修饰后，就成了静态内部类了）。
 *           使用对象：类、变量、方法、初始化函数（注意：修饰类时只能修饰 内部类 ）
 *  final: 表示类不可以被继承。 使用对象：类、变量、方法
 */



//定义一个Runner接口
interface Runner        // 接口类只有声明
{
    int ID = 1;
    void run ();
}

//定义了一个接口Flyer
interface Flyer         // 接口类只有声明
{
    void fly ();
}

//定义一个interface Animal,它继承于父类Runner
interface Animal extends Runner
{
    void breathe ();   // 还继承了父类的方法 run()
}

//定义Fish类，它实现了Animal接口的方法run()和breather()
class Fish implements Animal     // 类实现接口类的方法, "implements"后面只能跟接口类
{
    int xxx;
    public void fun(){} //其他的方法

    public void run ()    //实现了Animal方法run()
    {
        System.out.println("fish is swimming");
    }
    public void breathe() //实现了Animal的方法breath()
    {
        System.out.println("fish is bubbing");
    }
}

//定义了一个抽象类LandAnimal，它实现了接口Animal的方法breath()。
abstract class LandAnimal implements Animal{
    public void breathe ()
    {
        System.out.println("LandAnimal is breathing");
    }

    public void myFun() {}   // 抽象类可以有普通方法
}


//定义了一个类Student，它继承了类Person，并实现了Runner接口的方法run()。
class Student extends Person implements Runner
{
    Student() {super();   prt("123123");}


    public void run ()
    {
        System.out.println("the student is running");
    }

//    @Override
//    public static void prt(String s) {
//        System.out.println("Student prt方法： " + s);
//    }
}

//定义了一个类Bird，它实现了Runner和Flyer这两个接口定义的方法。
class Bird implements Runner , Flyer
{
    public void run ()   //Runner接口定义的方法。
    {
        System.out.println("the bird is running");
    }
    public void fly ()   //Flyer接口定义的方法。
    {
        System.out.println("the bird is flying");
    }
}

//////////////////////////////////////////////////////
abstract class AAA{
    public void fun1(){}
    public abstract void fun2();
}

class BBB extends AAA{
    public void fun() {}
    public void fun2() {}
}

/////////////////////////////////////////////////////////////

class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    ThreadDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

////////////////////////////////////////////////////////////

/**
 *      子类不能继承父类的构造器（构造方法或者构造函数），如果父类的构造器带有参数，
 *      则必须在子类的构造器中显式地通过 super 关键字调用父类的构造器并配以适当的参数列表。
 *      （c++中在初始化列表中实现该功能）
 *
 *      如果父类构造器没有参数，则在子类的构造器中不需要使用 super 关键字调用父类构造器，
 *      系统会自动调用父类的无参构造器。
 *      (通常为该情况)
 *
 *      静态方法中不能使用 super 关键字。
 */
class SuperClass {
    private int n;
    SuperClass(){
        System.out.println("SuperClass()");
    }
    SuperClass(int n) {
        System.out.println("SuperClass(int n)");
        this.n = n;
    }
}
class SubClass extends SuperClass{
    private int n;

    SubClass(){
        super(300);
        System.out.println("SubClass");
    }

    public SubClass(int n){
        System.out.println("SubClass(int n):"+n);
        this.n = n;
    }


    public static void testSuperSub()
    {
        SubClass sc = new SubClass();
        SubClass sc2 = new SubClass(200);
    }
}
//////////////////////////////////////////////////////////////
class Animal11{
    void go(){
        System.out.println("animal go");
    }
}

class Dog11 extends Animal11
{
    void go(){        // 实际这里为多次一举  // 除非这里还有自己的成员变量要处理，相当于覆盖
        //调用父类方法
        super.go();
    }

    //驱动函数
    public static void  main(String[] args){
        Dog11 dog=new Dog11();
        dog.go();
    }
}

/////////////////////////////////////////////////////
class Animal111{
    public void move(){
        System.out.println("动物可以移动");
    }
}

class Dog111 extends Animal111{

    @Override  // 提示而已。。。。。。。
    public void move(){
        System.out.println("狗可以跑和走");
    }

    public void bark(){
        System.out.println("狗可以吠叫");
    }
}

/////////////////////////////////////////////////////
/**
 *  重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。
 *  每个重载的方法（或者构造函数）都必须有一个独一无二的参数类型列表。
 *  最常用的地方就是构造器的重载。
 *
 *  重载规则:
 *      被重载的方法必须改变参数列表(参数个数或类型不一样)；
 *      被重载的方法可以改变返回类型；
 *      被重载的方法可以改变访问修饰符；
 *      被重载的方法可以声明新的或更广的检查异常；
 *      方法能够在同一个类中或者在一个子类中被重载。
 *      无法以返回值类型作为重载函数的区分标准。
 */
class Overloading {
    public int test(){
        System.out.println("test1");
        return 1;
    }

    public void test(int a){
        System.out.println("test2");
    }

    //以下两个参数类型顺序不同
    public String test(int a,String s){
        System.out.println("test3");
        return "returntest3";
    }

    public String test(String s,int a){
        System.out.println("test4");
        return "returntest4";
    }

    public static void main(String[] args){
        Overloading o = new Overloading();
        System.out.println(o.test());
        o.test(1);
        System.out.println(o.test(1,"test3"));
        System.out.println(o.test("test4",1));
    }
}
///////////////////////////////////////////////////

public class ExtAndImp {
    public static void main (String args[])
    {
//        for(int i=1;i<=9;i++){
//            for(int j=1;j<=i;j++){
//                System.out.print(j+"*"+i+"="+i*j+" ");
//            }
//            System.out.println();
//        }

//        ThreadDemo T1 = new ThreadDemo( "Thread-1");
//        T1.start();
//
//        ThreadDemo T2 = new ThreadDemo( "Thread-2");
//        T2.start();

//        Student p = new Student();
//        p.run();

//        Fish f = new Fish();
//        int j = 0;
//        j = Runner.ID;
//        j = f.ID;


       // SubClass.testSuperSub();

        testOverride();

    }

    static void testOverride()    {
        Animal111 a = new Animal111(); // Animal 对象
        Animal111 b = new Dog111(); // Dog 对象

        a.move();// 执行 Animal 类的方法
        b.move();//执行 Dog 类的方法

       // ((Dog111) b).bark();  // 使用麻烦。。。。 向上转换，增加东西

        Dog111 d = new Dog111();
        d.move();
        d.bark();
    }

}
