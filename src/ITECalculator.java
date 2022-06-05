import java.math.BigDecimal;
import java.util.Scanner;

/**
 * ITECalculator.java   (Main class) :    This class is created for Math Calculator
 * Created on Monday, January 10th 2022      by Tan Bunchhay
 */
public class  ITECalculator {


    /**
     * This is the main class of our project
     * @param args standard
     */
    public static void main(String[ ] args){

        while (true){
            System.out.println("\n=====================================");
            System.out.println("Menu:");
            System.out.println("1. Arithmetic");
            System.out.println("2. Bitwise");
            System.out.println("3. Trigonometry");
            System.out.println("4. Money Exchange");
            System.out.println("5. Storage Converter");
            System.out.println("6. Number System Conversion");
            System.out.println("7. Binary Arithmetic");
            System.out.println("8. Set Theory");
            System.out.println("0. Exit");
            System.out.print("PLease Input your Option:");
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    Arithmetic arithmetic = new Arithmetic();
                    arithmetic.generateInterface();
                }
                case 2 -> {
                    Bitwise bitwise = new Bitwise();
                    bitwise.generateInterface();
                }
                case 3 -> {
                    Trigonometry trigonometry = new Trigonometry();
                    trigonometry.generateInterface();
                }
                case 4 -> {
                    MoneyExchange moneyExchange = new MoneyExchange();
                    moneyExchange.generateInterface();
                }
                case 5 -> {
                    StorageConverter storageConverter = new StorageConverter();
                    storageConverter.generateInterface();
                }
                case 6 -> {
                    NumberSystemConversion numberSystemConversion = new NumberSystemConversion();
                    numberSystemConversion.generateInterface();
                }
                case 7 -> {
                    BinaryArithmetic binaryArithmetic = new BinaryArithmetic();
                    binaryArithmetic.generateInterface();
                }
                case 8 -> {

                    // instantiate SetTheory class
                    SetTheory setTheory = new SetTheory();
                    setTheory.generateInterface();
                }
                case 0 -> {
                    System.out.println("\n=====================================");
                    System.out.println("You are exiting...");
                    System.exit(1);
                }
                default -> System.out.println("Valid Input!");
            }
        }
    }
}
