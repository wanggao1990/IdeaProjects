package AbstractPkg;

public class OtherTip {

    /**
     * 声明抽象方法会造成以下两个结果：
     *
     * 如果一个类包含抽象方法，那么该类必须是抽象类。
     * 任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
     */
    abstract class Employee
    {
        private String name;
        private String address;
        private int number;

        public abstract double computePay();  // 如果一个类包含抽象方法，那么该类必须是抽象类。

        //其余代码
        public String getName() {
            return name;
        }
    }

    class Salary extends Employee
    {
        private double salary; // Annual salary

        public double computePay() // 任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
        {
            System.out.println("Computing salary pay for " + getName());
            return salary/52;
        }

        //其余代码
    }


}
