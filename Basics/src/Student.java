public class Student {
    String name;
    int age ,roll;
    static String dept="CSE";
    void Display(){
        System.out.println("Roll No is "+roll);
        System.out.println("Name is "+name);
        System.out.println("Age is "+age);
        System.out.println("Department is "+dept);
    }

    public static void main(String[] args) {
        Student s1 = new Student();//Default Constructor
        s1.name="Devi";
        s1.roll=23;
        s1.age=30;
        s1.Display();
    }
}
