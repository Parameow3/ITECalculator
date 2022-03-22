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
            System.out.println("0. Exit");
            System.out.print("PLease Input your Option:");
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    Arithmetic arithmetic = new Arithmetic();
                    System.out.println("********** Arithmetic **********");
                    System.out.print("Please Input value A:");
                    Scanner valueA = new Scanner(System.in);
                    int a = valueA.nextInt();
                    System.out.print("Please Input value B:");
                    Scanner valueB = new Scanner(System.in);
                    int b = valueB.nextInt();
                    //display result
                    System.out.println("=====================================");
                    System.out.println("Sum: " + arithmetic.sum(a, b));
                    System.out.println("Minus: " + arithmetic.minus(a, b));
                    System.out.println("Multiply: " + arithmetic.multiply(a, b));
                    System.out.println("Divide: " + String.format("%.2f", arithmetic.divide(a, b)));
                    System.out.println("Modulo: " + arithmetic.modulo(a, b));
                }
                case 2 -> {
                    Bitwise bitwise = new Bitwise();
                    System.out.println("********** Bitwise **********");
                    System.out.print("Please Input value a:");
                    Scanner valueA = new Scanner(System.in);
                    int a = valueA.nextInt();
                    System.out.print("Please Input value b:");
                    Scanner valueB = new Scanner(System.in);
                    int b = valueB.nextInt();
                    //display result (AND, OR, XOR, <<, >>, ~)
                    System.out.println("=====================================");
                    System.out.println("AND: " + bitwise.AND(a, b));
                    System.out.println("OR: " + bitwise.OR(a, b));
                    System.out.println("XOR: " + bitwise.XOR(a, b));
                    System.out.println("Left-Shift: " + bitwise.leftShift(a, b));
                    System.out.println("Right-Shift: " + bitwise.rightShift(a, b));
                    System.out.println("Bit-Inversion: " + bitwise.bitInversion(a));
                }
                case 3 -> {
                    Trigonometry trigonometry = new Trigonometry();
                    System.out.println("********** Trigonometry **********");
                    System.out.print("PLease Input Degree of angle:");
                    Scanner degree = new Scanner(System.in);
                    double Degree = degree.nextDouble();
                    System.out.print("PLease Input Base of square 2/3 in floating point:");
                    Scanner base = new Scanner(System.in);
                    double Base = base.nextDouble();
                    //Display
                    System.out.println("=====================================");
                    System.out.println("Sin: " + String.format("%.2f", trigonometry.sin(trigonometry.degree2Radian(Degree))));
                    System.out.println("Sin Degree: " + String.format("%.2f", trigonometry.sind(Degree)));
                    System.out.println("Cos: " + String.format("%.2f", trigonometry.cos(trigonometry.degree2Radian(Degree))));
                    System.out.println("Cos Degree: " + String.format("%.2f", trigonometry.cosd(Degree)));
                    System.out.println("Tan: " + String.format("%.2f", trigonometry.tan(trigonometry.degree2Radian(Degree))));
                    System.out.println("Tan Degree: " + String.format("%.2f", trigonometry.tand(Degree)));
                    System.out.println("Square2 Integer: " + trigonometry.square2int(Base));
                    System.out.println("Square2 Floating point: " + String.format("%.2f", trigonometry.square2(Base)));
                    System.out.println("Square3 Integer: " + trigonometry.square3int(Base));
                    System.out.println("Square3 Floating point: " + String.format("%.2f", trigonometry.square3(Base)));
                    System.out.println("Radians: " + String.format("%.2f", trigonometry.degree2Radian(Degree)));
                }
                case 4 -> {
                    MoneyExchange moneyExchange = new MoneyExchange();
                    System.out.println("********** Money Exchange **********");
                    System.out.println("1. Riel to other Currency");
                    System.out.println("2. Other Currency to Riel");
                    System.out.print("PLease Input your choice:");
                    Scanner choice = new Scanner(System.in);
                    int Choice = choice.nextInt();
                    if (Choice == 1) {
                        System.out.print("Please Input value of money in Riel:");
                        Scanner money = new Scanner(System.in);
                        double riel = money.nextDouble();
                        System.out.println("=====================================");
                        System.out.println("Your money are " + String.format("%.2f", riel) + " Riel" + "\t\t\t|");
                        System.out.println("=====================================");
                        System.out.println("Here is the exchange rate:");
                        System.out.println("Dollar: " + String.format("%.2f", moneyExchange.RielToDollar(riel)) + " USD");
                        System.out.println("Euro: " + String.format("%.2f", moneyExchange.RielToEuro(riel)) + " EUR");
                        System.out.println("Pound: " + String.format("%.2f", moneyExchange.RielToPound(riel)) + " GBP");
                        System.out.println("Franc: " + String.format("%.2f", moneyExchange.RielToFranc(riel)) + " CHF");
                        System.out.println("Baht: " + String.format("%.2f", moneyExchange.RielToBaht(riel)) + " THB");
                    } else if (Choice == 2) {
                        System.out.println("=====================================");
                        System.out.print("Please Input value of money:");
                        Scanner money = new Scanner(System.in);
                        double currency = money.nextDouble();
                        System.out.println("=====================================");
                        System.out.println("Here is the exchange rate:");
                        System.out.println("Dollar to Riel: " + String.format("%.2f", moneyExchange.DollarToRiel(currency)) + " Riel");
                        System.out.println("Euro to Riel: " + String.format("%.2f", moneyExchange.EuroToRiel(currency)) + " Riel");
                        System.out.println("Pound to Riel: " + String.format("%.2f", moneyExchange.PoundToRiel(currency)) + " Riel");
                        System.out.println("Franc to Riel: " + String.format("%.2f", moneyExchange.FrancToRiel(currency)) + " Riel");
                        System.out.println("Baht to Riel: " + String.format("%.2f", moneyExchange.BahtToRiel(currency)) + " Riel");
                    } else System.out.println("Valid Input!");
                }
                case 5 -> {
                    StorageConverter storageConverter = new StorageConverter();
                    System.out.println("********** Storage Converter **********");
                    System.out.println("1. Byte");
                    System.out.println("2. Kilobyte");
                    System.out.println("3. Megabyte");
                    System.out.println("4. Gigabyte");
                    System.out.println("5. Terabyte");
                    System.out.println("6. Petabyte");
                    System.out.print("Please choose from 1 to 6:");
                    Scanner subCh = new Scanner(System.in);
                    int subChoise = subCh.nextInt();
                    if (subChoise == 1) {
                        System.out.print("Please Input Byte value: ");
                        Scanner numByte = new Scanner(System.in);
                        long byteValue = numByte.nextLong();
                        System.out.println("- Byte to Kilobyte: " + BigDecimal.valueOf(storageConverter.byte2KB(byteValue)).toPlainString());
                        System.out.println("- Byte to Megabyte: " + BigDecimal.valueOf(storageConverter.byte2MB(byteValue)).toPlainString());
                        System.out.println("- Byte to Gigabyte: " + BigDecimal.valueOf(storageConverter.byte2GB(byteValue)).toPlainString());
                        System.out.println("- Byte to Terabyte: " + BigDecimal.valueOf(storageConverter.byte2TB(byteValue)).toPlainString());
                        System.out.println("- Byte to Petabyte: " + BigDecimal.valueOf(storageConverter.byte2PB(byteValue)).toPlainString());
                    } else if (subChoise == 2) {
                        System.out.print("Please Input Kilobyte value: ");
                        Scanner numKB = new Scanner(System.in);
                        long kByte = numKB.nextLong();
                        System.out.println("- Kilobyte to Byte: " + BigDecimal.valueOf(storageConverter.kb2Byte(kByte)).toPlainString());
                        System.out.println("- Kilobyte to Megabyte: " + BigDecimal.valueOf(storageConverter.kb2MB(kByte)).toPlainString());
                        System.out.println("- Kilobyte to Gigabyte: " + BigDecimal.valueOf(storageConverter.kb2GB(kByte)).toPlainString());
                        System.out.println("- Kilobyte to Terabyte: " + BigDecimal.valueOf(storageConverter.kb2TB(kByte)).toPlainString());
                        System.out.println("- Kilobyte to Petabyte: " + BigDecimal.valueOf(storageConverter.kb2PB(kByte)).toPlainString());
                    } else if (subChoise == 3) {
                        System.out.print("Please Input Megabyte value: ");
                        Scanner numMB = new Scanner(System.in);
                        long mByte = numMB.nextLong();
                        System.out.println("- Megabyte to byte: " + BigDecimal.valueOf(storageConverter.mb2Byte(mByte)).toPlainString());
                        System.out.println("- Megabyte to Kilobyte: " + BigDecimal.valueOf(storageConverter.mb2KB(mByte)).toPlainString());
                        System.out.println("- Megabyte to Gigabyte: " + BigDecimal.valueOf(storageConverter.mb2GB(mByte)).toPlainString());
                        System.out.println("- Megabyte to Terabyte: " + BigDecimal.valueOf(storageConverter.mb2TB(mByte)).toPlainString());
                        System.out.println("- Megabyte to Petabyte: " + BigDecimal.valueOf(storageConverter.mb2PB(mByte)).toPlainString());
                    } else if (subChoise == 4) {
                        System.out.print("Please Input Gigabyte value: ");
                        Scanner numGB = new Scanner(System.in);
                        long gByte = numGB.nextLong();
                        System.out.println("- Gigabyte to byte: " + BigDecimal.valueOf(storageConverter.gb2Byte(gByte)).toPlainString());
                        System.out.println("- Gigabyte to Kilobyte: " + BigDecimal.valueOf(storageConverter.gb2KB(gByte)).toPlainString());
                        System.out.println("- Gigabyte to Megabyte: " + BigDecimal.valueOf(storageConverter.gb2MB(gByte)).toPlainString());
                        System.out.println("- Gigabyte to Terabyte: " + BigDecimal.valueOf(storageConverter.gb2TB(gByte)).toPlainString());
                        System.out.println("- Gigabyte to Petabyte: " + BigDecimal.valueOf(storageConverter.gb2PB(gByte)).toPlainString());
                    } else if (subChoise == 5) {
                        System.out.print("Please Input Terabyte value: ");
                        Scanner numTB = new Scanner(System.in);
                        long tByte = numTB.nextLong();
                        System.out.println("- Terabyte to byte: " + BigDecimal.valueOf(storageConverter.tb2Byte(tByte)).toPlainString());
                        System.out.println("- Terabyte to Kilobyte: " + BigDecimal.valueOf(storageConverter.tb2KB(tByte)).toPlainString());
                        System.out.println("- Terabyte to Megabyte: " + BigDecimal.valueOf(storageConverter.tb2MB(tByte)).toPlainString());
                        System.out.println("- Terabyte to Gigabyte: " + BigDecimal.valueOf(storageConverter.tb2GB(tByte)).toPlainString());
                        System.out.println("- Terabyte to Petabyte: " + BigDecimal.valueOf(storageConverter.tb2PB(tByte)).toPlainString());
                    } else if (subChoise == 6) {
                        System.out.print("Please Input Petabyte value: ");
                        Scanner numPB = new Scanner(System.in);
                        long pByte = numPB.nextLong();
                        System.out.println("- Petabyte to byte: " + BigDecimal.valueOf(storageConverter.pb2Byte(pByte)).toPlainString());
                        System.out.println("- Petabyte to Kilobyte: " + BigDecimal.valueOf(storageConverter.pb2KB(pByte)).toPlainString());
                        System.out.println("- Petabyte to Megabyte: " + BigDecimal.valueOf(storageConverter.pb2MB(pByte)).toPlainString());
                        System.out.println("- Petabyte to Gigabyte: " + BigDecimal.valueOf(storageConverter.pb2GB(pByte)).toPlainString());
                        System.out.println("- Petabyte to Terabyte: " + BigDecimal.valueOf(storageConverter.pb2TB(pByte)).toPlainString());
                    } else System.out.println("Valid Input!");
                }
                case 6 -> {
                    NumberSystemConversion numberSystemConversion = new NumberSystemConversion();
                    System.out.println("=====================================");
                    System.out.println("********** NumberSystemConversion **********");
                    System.out.println("1. Binary");
                    System.out.println("2. Octal");
                    System.out.println("3. Decimal");
                    System.out.println("4. Hexadecimal");
                    System.out.print("Please choose your Option:");
                    Scanner choose = new Scanner(System.in);
                    int option = choose.nextInt();
                    if (option == 1) {
                        System.out.println("=====================================");
                        System.out.println("***** Binary Converter *****");
                        System.out.println("Please Input Binary:");
                        Scanner input = new Scanner(System.in);
                        String binary = input.nextLine();
                        //Check digit of binary before convert
                        if (numberSystemConversion.isValidBinary(binary))
                            System.out.println("Valid Input Binary!");
                        else {
                            System.out.println("Octal: " + numberSystemConversion.binary2Octal(binary));
                            System.out.println("Decimal: " + numberSystemConversion.binary2Decimal(binary));
                            numberSystemConversion.binary2Hex(binary);
                        }
                    } else if (option == 2) {
                        System.out.println("=====================================");
                        System.out.println("***** Octal Converter *****");
                        System.out.print("Please Input Octal:");
                        Scanner input = new Scanner(System.in);
                        String octal = input.nextLine();
                        if (numberSystemConversion.isValidOctal(octal))
                            System.out.println("Valid Input Octal!");
                        else {
                            System.out.println("Decimal: " + numberSystemConversion.octal2Decimal(octal));
                            numberSystemConversion.octal2Binary(octal);
                            System.out.println();
                            numberSystemConversion.octal2Hex(octal);
                        }

                    } else if (option == 3) {
                        System.out.println("=====================================");
                        System.out.println("***** Decimal Converter *****");
                        System.out.print("Please Input Decimal:");
                        Scanner input = new Scanner(System.in);
                        long decimal = input.nextLong();
                        String decStr = input.nextLine();
                        if (numberSystemConversion.isValidDecimal(decStr))
                            System.out.println("Valid Input Decimal!");
                        else {
                            numberSystemConversion.decimal2Binary(decimal);
                            numberSystemConversion.decimal2Octal(decimal);
                            numberSystemConversion.decimal2Hex(decimal);
                        }
                    } else if (option == 4) {
                        System.out.println("=====================================");
                        System.out.println("***** Hexadecimal Converter *****");
                        System.out.print("Please Input Hexadecimal:");
                        Scanner input = new Scanner(System.in);
                        String hex = input.nextLine().toUpperCase();
                        //Display result
                        if (numberSystemConversion.isValidHex(hex))
                            System.out.println("Valid Input Hexadecimal!");
                        else {
                            System.out.println("Binary: " + numberSystemConversion.hex2Binary(hex));
                            numberSystemConversion.hex2Octal(hex);
                            System.out.println("Decimal: " + numberSystemConversion.hex2Decimal(hex));
                        }
                    } else System.out.println("InValid Input!");
                }
                case 7 -> {
                    BinaryArithmetic binaryArithmetic = new BinaryArithmetic();
                    NumberSystemConversion numberSystemConversion = new NumberSystemConversion();

                    // create object of inner class in other class
                    BinaryArithmetic.Complement binaryCom = binaryArithmetic.new Complement();

                    // user input
                    System.out.println("=====================================");
                    System.out.println("********** Binary Arithmetic **********");
                    System.out.println("Please Input:");
                    System.out.println("Binary1: ");
                    Scanner input1 = new Scanner(System.in);
                    String bin1 = input1.nextLine();
                    System.out.println("Binary2: ");
                    Scanner input2 = new Scanner(System.in);
                    String bin2 = input2.nextLine();

                    // checking binary is valid
                    if (numberSystemConversion.isValidBinary(bin1) || numberSystemConversion.isValidBinary(bin2))
                        System.out.println("Invalid Input Binary");
                    else {
                        System.out.println("=====================================");
                        System.out.println("Binary1 + Binary2 = " + binaryArithmetic.binaryAdd(bin1, bin2));
                        binaryArithmetic.binarySubtraction(bin1, bin2);
                        System.out.println("=====================================");
                        //first complement display
                        System.out.println("1's Complement of binary1: " + binaryCom.findFirstComplement(bin1));
                        System.out.println("1's Complement of binary2: " + binaryCom.findFirstComplement(bin2));
                        //second complement display
                        System.out.println("2's Complement of binary1: " + binaryCom.findSecondComplement(bin1));
                        System.out.println("2's Complement of binary2: " + binaryCom.findSecondComplement(bin2));
                        // Complement Arithmetic operator display
                        System.out.println("addWith2ndComplement: " + binaryArithmetic.addWith2ndComplement(bin1, bin2));
                        System.out.println("subtractWith2ndComplement: " + binaryArithmetic.subtractWith2ndComplement(bin1, bin2));
                    }
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
