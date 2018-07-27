package pkgTest;

import AbstractPkg.Employee;

public class MammalInt implements Animals{

    public void eat(){
        System.out.println("Mammal eats");
    }

    public void travel(){
        System.out.println("Mammal travels");
    }

    public int noOfLegs(){
        return 0;
    }

    public static void main(String args[]){
        MammalInt m = new MammalInt();
        m.eat();
        m.travel();

        Employee aaa= new Employee("小屎芳","尧化门",380107) {
            @Override
            public double computePay() {
                return super.computePay();
            }
        };

        aaa.mailCheck();

    }
}