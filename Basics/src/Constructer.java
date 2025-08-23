public class Constructer {
    private String name;
    private int age;
    public Constructer(String name,int age ){
        this.name=name;
        this.age=age;
    }
    public void displayInfo(){
        System.out.println("Name is :"+name);
        System.out.println("Age is :"+age);
    }

    public static void main(String[] args) {
        Constructer obj= new Constructer("Devidutta",20);
        obj.displayInfo();
    }
}
