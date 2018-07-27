package RunEncap;

/**
 *   采用 this 关键字是为了解决实例变量（private String name）和
 *   局部变量（setName(String name)中的name变量）之间发生的同名的冲突。
 */
class Person{
    private String name;
    private int age;

    public int getAge() {       return age;   }

    public String getName() {       return name;   }

    public void setAge(int age) {       this.age = age;   }

    public void setName(String name){       this.name = name;   }
}

class EncapTest{

    private String name;
    private String idNum;
    private int age;

    public int getAge(){     return age;  }

    public String getName(){     return name;   }

    public String getIdNum(){       return idNum;   }

    public void setAge( int newAge){      age = newAge;   }

    public void setName(String newName){       name = newName;   }

    public void setIdNum( String newId){       idNum = newId;   }
}


public class EncapsulationTest {
    public static void main(String args[]){
        EncapTest encap = new EncapTest();
        encap.setName("James");
        encap.setAge(20);
        encap.setIdNum("12343ms");

        System.out.print("Name : " + encap.getName()+  " Age : "+ encap.getAge());
    }
}
