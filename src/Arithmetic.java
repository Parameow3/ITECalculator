import java.util.Scanner;

/**
 * Arithmetic.java    :    This class is created for simple calculator
 * Created on Monday, January 10th 2022      by Tan Bunchhay
 */
public class Arithmetic {

    private Scanner scanner = new Scanner(System.in);
    public void generateInterface() {

        System.out.println("********** Arithmetic **********");

        System.out.print("Please Input value A:");
        int a = scanner.nextInt();

        System.out.print("Please Input value B:");
        int b = scanner.nextInt();

        //display result
        System.out.println("=============== Result ==============");
        System.out.println("Sum: " + sum(a, b));
        System.out.println("Minus: " + minus(a, b));
        System.out.println("Multiply: " + multiply(a, b));
        System.out.println("Divide: " + String.format("%.2f", divide(a, b)));
        System.out.println("Modulo: " + modulo(a, b));
    }

    /**
     * The sum method of integer a and b : ( a + b)
     * @param a first Input parameter of value a
     * @param b second of value b
     * @return The sum of a and b
     */
    public int sum(int a, int b){
        return a + b;
    }

    /**
     * The divide method of integer a and b : ( a / b ), but we use explicit casting
     * @param a first Input parameter of value a
     * @param b second of value b
     * @return The divide of a and b
     */
    public double divide(int a, int b){
        return (double) a / b;
    }

    /**
     * The minus method of integer a and b : ( a - b )
     * @param a first Input parameter of value a
     * @param b second of value b
     * @return The minus of a and b
     */
    public int minus(int a, int b){
        return a - b;
    }

    /**
     * The multiple method of integer a and b ( a * b )
     * @param a first Input parameter of value a
     * @param b second of value b
     * @return The multiplication of a and b
     */
    public int multiply(int a, int b){
        return a * b;
    }

    /**
     * The modulo method of integer a and b : ( a (mod) b )
     * @param a first Input parameter of value a
     * @param b second of value b
     * @return The modulo of a and b
     */
    public int modulo(int a, int b){
        return a % b;
    }
}
