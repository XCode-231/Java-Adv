public class Method02 {
    static void Arithmetic(int x, int y){
        System.out.println("Addition is "+(x+y));
        System.out.println("Substraction is "+(x-y));
        System.out.println("Multiplication is "+(x*y));
        System.out.println("Division is "+((double)x/y));
        System.out.println("Reminder is "+(x%y));
    }
    static double[] Arithmetic(int x, double y){
        return new double[] {
                x + y,
                x - y,
                x * y,
                (double)x / y,
                x % y
        };
    }

    public static void main(String[] args) {

        double [] result=Arithmetic(10,3.0);
        System.out.println("Addition is "+result[0]);
        System.out.println("Substraction is "+result[1]);
        System.out.println("Multiplication is "+result[2]);
        System.out.println("Division is "+result[3]);
        System.out.println("Reminder is "+result[4]);

    }
}
