package inertfacePkg;

/**
 *  接口（英文：Interface），在JAVA编程语言中是一个抽象类型，是抽象方法的集合，
 *  接口通常以interface来声明。一个类通过继承接口的方式，从而来继承接口的抽象方法。
 *
 *  接口并不是类，编写接口的方式和类很相似，但是它们属于不同的概念。
 *  类描述对象的属性和方法。接口则包含类要实现的方法。
 *
 *  除非实现接口的类是抽象类，否则该类要定义接口中的所有方法。
 *
 *  接口无法被实例化，但是可以被实现。一个实现接口的类，必须实现接口内所描述的所有方法，
 *  否则就必须声明为抽象类。另外，在 Java 中，接口类型可用来声明一个变量，他们可以成为一
 *  个空指针，或是被绑定在一个以此接口实现的对象。
 *
 *  接口与类相似点：
 *      一个接口可以有多个方法。
 *      接口文件保存在 .java 结尾的文件中，文件名使用接口名。
 *      接口的字节码文件保存在 .class 结尾的文件中。
 *      接口相应的字节码文件必须在与包名称相匹配的目录结构中。
 *
 *  接口与类的区别：
 *      接口不能用于实例化对象。
 *      接口没有构造方法。
 *      接口中所有的方法必须是抽象方法。
 *      接口不能包含成员变量，除了 static 和 final 变量。
 *      接口不是被类继承了，而是要被类实现。
 *      接口支持多继承。
 *
 * 接口特性:
 *      接口中每一个方法也是隐式抽象的,接口中的方法会被隐式的指定为 public abstract * （只能是 public abstract，
 *      其他修饰符都会报错）。
 *      接口中可以含有变量，但是接口中的变量会被隐式的指定为 public static final 变量（并且只能是 public，
 *      用 private 修饰会报编译错误）。
 *      接口中的方法是不能在接口中实现的，只能由实现接口的类来实现接口中的方法。
 *
 * 抽象类和接口的区别
 *      1. 抽象类中的方法可以有方法体，就是能实现方法的具体功能，但是接口中的方法不行。
 *      2. 抽象类中的成员变量可以是各种类型的，而接口中的成员变量只能是 public static final 类型的。
 *      3. 接口中不能含有静态代码块以及静态方法(用 static 修饰的方法)，而抽象类是可以有静态代码块和静态方法。
 *      4. 一个类只能继承一个抽象类，而一个类却可以实现多个接口。
 */

interface InterfaceXXX
{
    //任何类型 final, static 字段
    //抽象方法

    /**
     * 接口有以下特性：
     *      接口是隐式抽象的，当声明一个接口的时候，不必使用abstract关键字。
     *      接口中每一个方法也是隐式抽象的，声明时同样不需要abstract关键字。
     *      接口中的方法都是公有的。
     *
     *  1、成员变量只能是常量，默认修饰符 public static final
     *  2、成员方法只能是抽象方法。默认修饰符 public abstract
     */

}

interface Animal {
    public void eat();
    public void travel();
}

/**
 *   当类实现接口的时候，类要实现接口中所有的方法。否则，类必须声明为抽象的类。
 *   类使用implements关键字实现接口。在类声明中，Implements关键字放在class声明后面。
 */
abstract class MammalInt implements Animal{

    public void eat(){        System.out.println("Mammal eats");    }

    //public void travel(){        System.out.println("Mammal travels");    }

    public abstract void travel();  // 这种形式下 或者 不实现接口类方法， MammalInt需要声明为抽象类

    public int noOfLegs(){        return 0;    }

    public static void main(String args[]){

        class MamalIntObj extends MammalInt{
            public void travel() {}
        }

        MamalIntObj m = new MamalIntObj();
        m.eat();
        m.travel();
    }
}


/**
 *  一个接口能继承另一个接口，和类之间的继承方式比较相似。接口的继承使用extends关键字，子接口继承父接口的方法。
 */
interface Sports
{
    public void setHomeTeam(String name);
    public void setVisitingTeam(String name);
}

// 实现Football接口的类需要实现五个方法，其中两个来自于Sports接口
interface Football extends Sports    //接口继承使用 extends 关键字
{
    public void homeTeamScored(int points);
    public void visitingTeamScored(int points);
    public void endOfQuarter(int quarter);
}

// Hockey接口自己声明了四个方法，从Sports接口继承了两个方法，这样，实现Hockey接口的类需要实现六个方法。
interface Hockey extends Sports
{
    public void homeGoalScored();
    public void visitingGoalScored();
    public void endOfPeriod(int period);
    public void overtimePeriod(int ot);
}

/**
 *  在Java中，类的多继承是不合法，但接口允许多继承。在接口的多继承中extends关键字只需要使用一次，在其后跟着继承接口。
 *
 *
 */
interface HockeyMulti extends Sports, Football
{

}