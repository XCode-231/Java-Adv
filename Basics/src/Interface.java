public class Interface {
    public static void main(String[] args) {
        Animals c= new Cat();
        Animals d=new Dog();
        c.makeSound();
        d.makeSound();
    }
    interface  Animals{
        void makeSound();
    }
    static class Cat implements Animals{
        public void makeSound(){
            System.out.println("Woof !");
        }
    }
    static class  Dog implements  Animals{
        public void makeSound(){
            System.out.println("Meow !");
        }
    }
}
