public class Encapsulation {
    public static void main(String[] args) {
        Student1 s= new Student1();
        s.setName("Devi");
        s.setAge(10);
        System.out.println("Name is "+s.getName());
        System.out.println("Age is "+s.getAge());
    }
}
class Student1 {
    private String name;
    private int age;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(age>0){
            this.age=age;
        }else{
            System.out.println("PLease Enter a Valid Age...");
        }
    }
}
