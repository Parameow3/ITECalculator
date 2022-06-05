import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * NumberSystemConversion.java    :    This class is created for Covert System of number
 * Created on Tuesday, January 25th 2022      by Tan Bunchhay
 */
public class NumberSystemConversion {

    private Scanner scanner = new Scanner(System.in);

    public void generateInterface() {

        System.out.println("=====================================");
        System.out.println("********** NumberSystemConversion **********");
        System.out.println("1. Binary");
        System.out.println("2. Octal");
        System.out.println("3. Decimal");
        System.out.println("4. Hexadecimal");

        System.out.print("Please choose your Option:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {

                System.out.println("=====================================");
                System.out.println("***** Binary Converter *****");

                System.out.println("Please Input Binary:");
                String binary = scanner.nextLine();

                //Check digit of binary before convert
                if (isValidBinary(binary))
                    System.out.println("Valid Input Binary!");
                else {
                    System.out.println("Octal: " + binary2Octal(binary));
                    System.out.println("Decimal: " + binary2Decimal(binary));
                    binary2Hex(binary);
                }
            }
            case 2 -> {

                System.out.println("=====================================");
                System.out.println("***** Octal Converter *****");

                System.out.print("Please Input Octal:");
                String octal = scanner.nextLine();

                if (isValidOctal(octal))
                    System.out.println("Valid Input Octal!");
                else {
                    System.out.println("Decimal: " + octal2Decimal(octal));
                    octal2Binary(octal);
                    System.out.println();
                    octal2Hex(octal);
                }

            }
            case 3 -> {

                System.out.println("=====================================");
                System.out.println("***** Decimal Converter *****");

                System.out.print("Please Input Decimal:");
                long decimal = scanner.nextLong();
                String decStr = scanner.nextLine();

                if (isValidDecimal(decStr))
                    System.out.println("Valid Input Decimal!");
                else {
                    System.out.println("Binary: " + decimal2Binary(decimal));
                    decimal2Octal(decimal);
                    decimal2Hex(decimal);
                }
            }
            case 4 -> {

                System.out.println("=====================================");
                System.out.println("***** Hexadecimal Converter *****");

                System.out.print("Please Input Hexadecimal:");
                String hex = scanner.nextLine().toUpperCase();
                //Display result
                if (isValidHex(hex))
                    System.out.println("Valid Input Hexadecimal!");
                else {
                    System.out.println("Binary: " + hex2Binary(hex));
                    hex2Octal(hex);
                    System.out.println("Decimal: " + hex2Decimal(hex));
                }
            }
            default -> System.out.println("InValid Input!");
        }
    }

    ArrayList<Character> HexDigit = new ArrayList<>(); // Create an ArrayList object
    ArrayList<String> Binary3Digit = new ArrayList<>();
    ArrayList<String> BinaryDigit = new ArrayList<>();
    ArrayList<Character> OctalDigit = new ArrayList<>();
    ArrayList<String> Binary4Digit = new ArrayList<>();

    /**
     * This method is for convert from binary to decimal
     * @param binary get value in Sting type for covert
     * @return return full value of decimal
     */
    long binary2Decimal(String binary){
        long decimal = 0;
        long[] digit = new long[binary.length()];
        for (int i = 0; i < binary.length(); i++) {
            digit[i] = binary.charAt(i) - '0';
            decimal = decimal + (digit[i] * (long) Math.pow(2, binary.length() - i - 1));
        }
        return decimal;
    }

    /**
     * This method is for convert from binary to octal
     * @param binary get value in String type for covert
     * @return return full value of octal
     */
    long binary2Octal(String binary){
        long octal3Digit;
        long count3Digit = 0;
        long octal = 0;
        int n = binary.length();
        long[] digit = new long[n];
        for (int i = 0; i < n; i++){
            digit[i] = binary.charAt(i) - '0';
        }

        for (int i = n - 1 ; i >= 0; i-=3){
            if (i == 1)
                octal3Digit = digit[i] + (digit[i-1] * 2);
            else if (i == 0)
                octal3Digit = digit[i];
            else
                octal3Digit = digit[i] + (digit[i-1] * 2) + (digit[i-2]* 4);
            octal = octal + (octal3Digit * (long) Math.pow(10, count3Digit));
            count3Digit++;
        }
        return octal;
    }

    /**
     * This method is for convert from binary to Hexadecimal
     * @param binary get value in Sting type for covert
     */
    void binary2Hex(String binary){
        long Hex4Digit;
        int n = binary.length();
        long[] digit = new long[n];
        for (int i = 0; i < n; i++) {
            digit[i] = binary.charAt(i) - '0';
        }
        System.out.print("Hexadecimal: ");
        for (int i = n - 1 ; i >= 0; i-=4){
            if (i == 3)
                Hex4Digit = digit[i] + (digit[i-1] * 2) + (digit[i-2]* 4) + (digit[i-3]* 8);
            else if (i == 2)
                Hex4Digit = digit[i] + (digit[i-1] * 2) + (digit[i-2]* 4);
            else if (i == 1)
                Hex4Digit = digit[i] + (digit[i-1] * 2);
            else if (i == 0)
                Hex4Digit = digit[i];
            else
                Hex4Digit = digit[i] + (digit[i-1] * 2) + (digit[i-2]* 4) + (digit[i-3]* 8);

            if (Hex4Digit == 15)
                HexDigit.add('F');
            else if (Hex4Digit == 14)
                HexDigit.add('E');
            else if (Hex4Digit == 13)
                HexDigit.add('D');
            else if (Hex4Digit == 12)
                HexDigit.add('C');
            else if (Hex4Digit == 11)
                HexDigit.add('B');
            else if (Hex4Digit == 10)
                HexDigit.add('A');
            else
                HexDigit.add(Character.forDigit((int) Hex4Digit, 10));
        }
        for (int i = HexDigit.size() - 1; i >= 0; i--){
            System.out.print(HexDigit.get(i));
        }
    }

    /**
     * This method is for convert from octal to decimal
     * @param octal get value in String type for covert
     * @return return full value of decimal
     */
    long octal2Decimal(String octal){
        long decimal = 0;
        long[] digit = new long[octal.length()];
        for (int i = 0; i < octal.length(); i++) {
            digit[i] = octal.charAt(i) - '0';
            decimal = decimal + (digit[i] * (long) Math.pow(8, octal.length() - i - 1));
        }
        return decimal;
    }

    /**
     * This method is for convert from octal to binary
     * @param octal get value in String type for covert and then print result out
     */
    void octal2Binary(String octal){
        long[] digit = new long[octal.length()];
        System.out.print("Binary: ");
        for (int i = 0; i < octal.length(); i++) {
            digit[i] = octal.charAt(i) - '0';
            if (digit[i] - 7 == 0)
                Binary3Digit.add("111");
            else if (digit[i] - 7 == -1)
                Binary3Digit.add("110");
            else if (digit[i] - 7 == -2)
                Binary3Digit.add("101");
            else if (digit[i] - 7 == -3)
                Binary3Digit.add("100");
            else if (digit[i] - 7 == -4)
                Binary3Digit.add("011");
            else if (digit[i] - 7 == -5)
                Binary3Digit.add("010");
            else if (digit[i] - 7 == -6)
                Binary3Digit.add("001");
            else if (digit[i] - 7 == -7)
                Binary3Digit.add("000");
            System.out.print(Binary3Digit.get(i));
        }
    }

    /**
     * This method is for convert from octal to Hex
     * @param octal get value in String type for covert and then print result out
     */
    void octal2Hex(String octal){
        long decimal = octal2Decimal(octal);
        long Remainder;
        System.out.print("Hexadecimal: ");
        while (decimal != 0){
            Remainder = decimal % 16;
            if (Remainder == 15)
                HexDigit.add('F');
            else if (Remainder == 14)
                HexDigit.add('E');
            else if (Remainder == 13)
                HexDigit.add('D');
            else if (Remainder == 12)
                HexDigit.add('C');
            else if (Remainder == 11)
                HexDigit.add('B');
            else if (Remainder == 10)
                HexDigit.add('A');
            else
                HexDigit.add(Character.forDigit((int) Remainder, 10));
            decimal = decimal / 16;
        }
        for (int i = HexDigit.size() - 1; i >= 0; i--){
            System.out.print(HexDigit.get(i));
        }
    }

    /**
     * This method is for convert from decimal to binary
     * @param decimal get value in long integer type for covert
     * @return and then return result out
     */
    String decimal2Binary(long decimal) {
        long remainder;
        if(decimal == 0)
            BinaryDigit.add("0");
        while(decimal != 0) {
            remainder = decimal % 2;
            decimal /= 2;
            if (remainder == 1)
                BinaryDigit.add("1");
            else
                BinaryDigit.add("0");
        }
        Collections.reverse(BinaryDigit);
        String binStr = String.join("", BinaryDigit);
        return binStr;
    }

    /**
     * This method is for convert from decimal to octal
     * @param decimal get value in long integer type for covert and then print result out
     */
    void decimal2Octal(long decimal) {
        long remainder;
        if (decimal == 0)
            OctalDigit.add('0');
        while(decimal != 0){
            remainder = decimal % 8;
            decimal /= 8;
            if (remainder == 1)
                OctalDigit.add('1');
            else if (remainder == 2)
                OctalDigit.add('2');
            else if (remainder == 3)
                OctalDigit.add('3');
            else if (remainder == 4)
                OctalDigit.add('4');
            else if (remainder == 5)
                OctalDigit.add('5');
            else if (remainder == 6)
                OctalDigit.add('6');
            else if (remainder == 7)
                OctalDigit.add('7');
            else OctalDigit.add('0');
        }
        //display result
        System.out.print("\nOctal: ");
        for (int i = OctalDigit.size() - 1; i >= 0; i--) {
            System.out.print(OctalDigit.get(i));
        }
    }

    /**
     * This method is for convert from decimal to Hexadecimal
     * @param decimal get value in long integer type for covert and then print result out
     */
    void decimal2Hex(long decimal) {
        long remainder;
        if (decimal == 0)
            HexDigit.add('0');
        while (decimal != 0) {
            remainder = decimal % 16;
            decimal /= 16;
            if (remainder == 1)
                HexDigit.add('1');
            else if (remainder == 2)
                HexDigit.add('2');
            else if (remainder == 3)
                HexDigit.add('3');
            else if (remainder == 4)
                HexDigit.add('4');
            else if (remainder == 5)
                HexDigit.add('5');
            else if (remainder == 6)
                HexDigit.add('6');
            else if (remainder == 7)
                HexDigit.add('7');
            else if (remainder == 8)
                HexDigit.add('8');
            else if (remainder == 9)
                HexDigit.add('9');
            else if (remainder == 10)
                HexDigit.add('A');
            else if (remainder == 11)
                HexDigit.add('B');
            else if (remainder == 12)
                HexDigit.add('C');
            else if (remainder == 13)
                HexDigit.add('D');
            else if (remainder == 14)
                HexDigit.add('E');
            else if (remainder == 15)
                HexDigit.add('F');
            else HexDigit.add('0');
        }
        //display result
        System.out.print("\nHexadecimal: ");
        for (int i = HexDigit.size() - 1; i >= 0; i--) {
            System.out.print(HexDigit.get(i));
        }
    }

    /**
     * This method is for convert from Hexadecimal to Binary
     * @param hex get value in String type for covert and then return result
     * @return return Binary
     */
    String hex2Binary(String hex) {
        char bin;
        for (int i = 0; i < hex.length(); i++) {
            bin = hex.charAt(i);

            if (bin == '0')
                Binary4Digit.add("0000");
            else if (bin == '1')
                Binary4Digit.add("0001");
            else if (bin == '2')
                Binary4Digit.add("0010");
            else if (bin == '3')
                Binary4Digit.add("0011");
            else if (bin == '4')
                Binary4Digit.add("0100");
            else if (bin == '5')
                Binary4Digit.add("0101");
            else if (bin == '6')
                Binary4Digit.add("0110");
            else if (bin == '7')
                Binary4Digit.add("0111");
            else if (bin == '8')
                Binary4Digit.add("1000");
            else if (bin == '9')
                Binary4Digit.add("1001");
            else if (bin == 'A')
                Binary4Digit.add("1010");
            else if (bin == 'B')
                Binary4Digit.add("1011");
            else if (bin == 'C')
                Binary4Digit.add("1100");
            else if (bin == 'D')
                Binary4Digit.add("1101");
            else if (bin == 'E')
                Binary4Digit.add("1110");
            else if (bin == 'F')
                Binary4Digit.add("1111");
        }
        StringBuilder fullBinaryDigit = new StringBuilder();
        for (String binary4D : Binary4Digit) {
            fullBinaryDigit.append(binary4D);
        }
        return String.valueOf(fullBinaryDigit);
    }

    /**
     * This method is for convert from Hexadecimal to Octal
     * @param hex get value in String type for covert and then return result
     */
    void hex2Octal(String hex) {
        Binary4Digit.clear();
        String bin = hex2Binary(hex);
        System.out.println("Octal: " + binary2Octal(bin));
    }

    /**
     * This method is for convert from Hexadecimal to Decimal
     * @param hex get value in String type for covert and then return result
     * @return return Decimal
     */
    long hex2Decimal(String hex) {
        int n = hex.length();
        int hexToDec;
        long decimal = 0;
        char hexDigit;
        for (int i = 0; i < n; i++) {
            hexDigit = hex.charAt(i);

            if (hexDigit == '0')
                hexToDec = 0;
            else if (hexDigit == '1')
                hexToDec = 1;
            else if (hexDigit == '2')
                hexToDec = 2;
            else if (hexDigit == '3')
                hexToDec = 3;
            else if (hexDigit == '4')
                hexToDec = 4;
            else if (hexDigit == '5')
                hexToDec = 5;
            else if (hexDigit == '6')
                hexToDec = 6;
            else if (hexDigit == '7')
                hexToDec = 7;
            else if (hexDigit == '8')
                hexToDec = 8;
            else if (hexDigit == '9')
                hexToDec = 9;
            else if (hexDigit == 'A')
                hexToDec = 10;
            else if (hexDigit == 'B')
                hexToDec = 11;
            else if (hexDigit == 'C')
                hexToDec = 12;
            else if (hexDigit == 'D')
                hexToDec = 13;
            else if (hexDigit == 'E')
                hexToDec = 14;
            else if (hexDigit == 'F')
                hexToDec = 15;
            else return 0;
            decimal = (long) (decimal + (hexToDec * Math.pow(16, n - i - 1)));
        }
        return decimal;
    }

    /**
     * This method is for check Binary digit that user input is valid or not
     * @param binary receive binary input from user
     * @return return true or false for confirm that input is right
     */
    boolean isValidBinary(String binary) {
        int n = binary.length();
        char temp;
        boolean check = false;
        for (int i = 0; i < n; i++) {
            temp = binary.charAt(i);
            if (temp == '0' || temp == '1'){
                check = false;
            }
            else {
                check = true;
                break;
            }
        }return check;
    }

    /**
     * This method is for check Octal digit that user input is valid or not
     * @param octal receive octal input from user
     * @return return true or false for confirm that input is right
     */
    boolean isValidOctal(String octal) {
        boolean check = false;
        for (int i = 0; i < octal.length(); i++){
            if (octal.charAt(i) == '0' || octal.charAt(i) == '1' || octal.charAt(i) == '2'
                    || octal.charAt(i) == '3' || octal.charAt(i) == '4' || octal.charAt(i) == '5'
                    || octal.charAt(i) == '6' || octal.charAt(i) == '7' ) {
                check = false;
            }
            else {
                check = true;
                break;
            }
        }
        return check;
    }

    /**
     * This method is for check Decimal digit that user input is valid or not
     * @param decimal receive octal input from user
     * @return return true or false for confirm that input is right
     */
    boolean isValidDecimal(String decimal) {
        boolean check = false;
        for (int i = 0; i < decimal.length(); i++) {
            if (decimal.charAt(i) == '0' || decimal.charAt(i) == '1' || decimal.charAt(i) == '2'
                    || decimal.charAt(i) == '3' || decimal.charAt(i) == '4' || decimal.charAt(i) == '5'
                    || decimal.charAt(i) == '6' || decimal.charAt(i) == '7' || decimal.charAt(i) == '8'
                    || decimal.charAt(i) == '9') {
                check = false;
            } else {
                check = true;
                break;
            }
        }return check;
    }

    /**
     * This method is for check Hexadecimal digit that user input is valid or not
     * @param hex receive octal input from user
     * @return return true or false for confirm that input is right
     */
    boolean isValidHex(String hex) {
        boolean check = false;
        for (int i = 0; i < hex.length(); i++) {
            if (hex.charAt(i) == '0' || hex.charAt(i) == '1' || hex.charAt(i) == '2'
                    || hex.charAt(i) == '3' || hex.charAt(i) == '4' || hex.charAt(i) == '5'
                    || hex.charAt(i) == '6' || hex.charAt(i) == '7' || hex.charAt(i) == '8'
                    || hex.charAt(i) == '9' || hex.charAt(i) == 'A' || hex.charAt(i) == 'B'
                    || hex.charAt(i) == 'C' || hex.charAt(i) == 'D' || hex.charAt(i) == 'E'
                    || hex.charAt(i) == 'F') {
                check = false;
            } else {
                check = true;
                break;
            }
        } return check;
    }
}
