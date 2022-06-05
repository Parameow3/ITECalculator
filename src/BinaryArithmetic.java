import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * BinaryArithmetic.java    :    This class is created for calculate all
 *                               Binary Operator.
 * Created on Friday, February 11th 2022      by Tan Bunchhay
 */

public class BinaryArithmetic {
    private Complement complement;
    //Array List for bin1
    private ArrayList<Character> binary1 = new ArrayList<>();
    //Array Lise for bin2
    private ArrayList<Character> binary2 = new ArrayList<>();
    //Arraylist for newBin
    private ArrayList<String> newBin = new ArrayList<>();
    //Arraylist for remainder
    private ArrayList<Character> remainder = new ArrayList<>();
    //Arraylist for First Complement
    private ArrayList<String> firstComplement = new ArrayList<>();
    //Arraylist for multiply digit
    private ArrayList<Integer> multiplyDigit = new ArrayList<>();
    //Arraylist for store binary-multiply
    private ArrayList<String> binMultiply = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public void generateInterface() {

        NumberSystemConversion numberSystemConversion = new NumberSystemConversion();

        // create object of inner class in outer class
        Complement binaryCom = new Complement();

        // user input
        System.out.println("=====================================");
        System.out.println("********** Binary Arithmetic **********");
        System.out.println("1. Binary Add/Subtract");
        System.out.println("2. add/subtract With2ndComplement");
        System.out.println("3. Binary Multiply/Divide");
        System.out.println("PLease choose 1 to 3:");
        int ch = scanner.nextInt();

        switch (ch) {
            case 1 -> {

                System.out.println("Please Input:");

                System.out.println("Binary1: ");
                String bin1 = scanner.nextLine();

                System.out.println("Binary2: ");
                String bin2 = scanner.nextLine();

                // checking binary is valid
                if (numberSystemConversion.isValidBinary(bin1) || numberSystemConversion.isValidBinary(bin2))
                    System.out.println("Invalid Input Binary");
                else {
                    System.out.println("=====================================");
                    System.out.println("Binary1: " + bin1 + "\t[" + numberSystemConversion.binary2Decimal(bin1) + "]");
                    System.out.println("Binary2: " + bin2 + "\t[" + numberSystemConversion.binary2Decimal(bin2) + "]");
                    System.out.println("=====================================");
                    System.out.println("Binary1 + Binary2 = " + binaryAdd(bin1, bin2) + "\t["
                                        + (numberSystemConversion.binary2Decimal(bin1)
                                        + numberSystemConversion.binary2Decimal(bin2)) + "]");
                    System.out.println("Binary1 - Binary2 = " + binarySubtraction(bin1, bin2)
                                        + "\t[" + (numberSystemConversion.binary2Decimal(bin1)
                                        - numberSystemConversion.binary2Decimal(bin2)) + "]");
                }
            }
        case 2 -> {

                System.out.println("Instruction: if you want to input 2's, " +
                        "           \nplease make sure that your input is 32bit:");

                System.out.println("Binary1: ");
                String bin1 = scanner.nextLine();

                System.out.println("Binary2: ");
                String bin2 = scanner.nextLine();

                long DecOfB1, DecOfB2;
                // checking binary is valid
                if (numberSystemConversion.isValidBinary(bin1) || numberSystemConversion.isValidBinary(bin2))
                    System.out.println("Invalid Input Binary");
                else {
                    System.out.println("=====================================");
                    if (bin1.length() == 32) {
                        DecOfB1 = -numberSystemConversion.binary2Decimal(
                                binaryCom.findFirstComplement(binarySubtraction(bin1, "1")));
                        System.out.println("Binary1: " + bin1 + "\t[" + DecOfB1 + "]");
                    } else {
                        DecOfB1 = numberSystemConversion.binary2Decimal(bin1);
                        System.out.println("Binary1: " + bin1 + "\t[" + DecOfB1 + "]");
                    }
                    if (bin2.length() == 32) {
                        DecOfB2 = -numberSystemConversion.binary2Decimal(
                                binaryCom.findFirstComplement(binarySubtraction(bin2, "1")));
                        System.out.println("Binary2: " + bin2 + "\t[" + DecOfB2 + "]");
                    } else {
                        DecOfB2 = numberSystemConversion.binary2Decimal(bin2);
                        System.out.println("Binary2: " + bin2 + "\t[" + DecOfB2 + "]");
                    }
                    System.out.println("=====================================");
                    // Complement Arithmetic operator display
                    System.out.println("addWith2ndComplement: " + addWith2ndComplement(bin1, bin2)
                                        + "\t[" + (DecOfB1 + DecOfB2) + "]");
                    System.out.println("subtractWith2ndComplement: " + subtractWith2ndComplement(bin1, bin2)
                                        + "\t[" + (DecOfB1 - DecOfB2) + "]");
                }
            }
            case 3 -> {

                System.out.println("Binary1: ");
                String bin1 = scanner.nextLine();

                System.out.println("Binary2: ");
                String bin2 = scanner.nextLine();

                // checking binary is valid
                if (numberSystemConversion.isValidBinary(bin1) || numberSystemConversion.isValidBinary(bin2))
                    System.out.println("Invalid Input Binary");
                else {
                    System.out.println("=====================================");
                    System.out.println("Binary1: " + bin1 + "\t[" + numberSystemConversion.binary2Decimal(bin1) + "]");
                    System.out.println("Binary2: " + bin2 + "\t[" + numberSystemConversion.binary2Decimal(bin2) + "]");
                    System.out.println("=====================================");
                    System.out.println("Binary1 * Binary2 = " + multiplyBinary(bin1, bin2) + "\t["
                                        + numberSystemConversion.binary2Decimal(multiplyBinary(bin1, bin2)) + "]");
                    System.out.println("Binary1 / Binary2 = " + divideBinary(bin1, bin2) + "\t["
                            + numberSystemConversion.binary2Decimal(divideBinary(bin1, bin2)) + "]");
                }
            }
        }
    }

    public BinaryArithmetic() {
        complement = new Complement();
    }
    //=======================================================
    /**
     * This method was created for summation of 2 binary and then return the result
     * @param bin1 get value of first binary from user input
     * @param bin2 get value of second binary from user input
     * @return return binary addition result
     */
    String binaryAdd(String bin1, String bin2) {
        newBin.clear();
        binary1.clear();
        binary2.clear();
        remainder.clear();
        int nBin1 = bin1.length();
        int nBin2 = bin2.length();
        int tempN;
        if (nBin1 > nBin2)
            tempN = nBin1;
        else tempN = nBin2;
        for (int i = tempN - 1; i >= 0; i--){
            //Split Binary digit for bin1
            if (nBin1 < 1){
                binary1.add('0'); }
            else {  binary1.add(bin1.charAt(nBin1 - 1)); }
            //Split Binary digit for bin2
            if (nBin2 < 1) {
                binary2.add('0'); }
            else { binary2.add(bin2.charAt(nBin2 - 1)); }
            nBin1--;
            nBin2--;
        }

        //operator
        remainder.add('0');
        for (int i = 0; i < tempN; i++) {
            if (i == tempN - 1) {
                if (remainder.get(i) == '0' && binary1.get(i) == '0' && binary2.get(i) == '1')
                    newBin.add("1");
                else if (remainder.get(i) == '0' && binary1.get(i) == '1' && binary2.get(i) == '1')
                    newBin.add("10");
                else if (remainder.get(i) == '0' && binary1.get(i) == '1' && binary2.get(i) == '0')
                    newBin.add("1");
                else if (remainder.get(i) == '1' && binary1.get(i) == '1' && binary2.get(i) == '1')
                    newBin.add("11");
                else if (remainder.get(i) == '1' && binary1.get(i) == '0' && binary2.get(i) == '1')
                    newBin.add("10");
                else if (remainder.get(i) == '1' && binary1.get(i) == '1' && binary2.get(i) == '0')
                    newBin.add("10");
                else if (remainder.get(i) == '1' && binary1.get(i) == '0' && binary2.get(i) == '0')
                    newBin.add("1");
            }
            else {
                {
                    if (remainder.get(i) == '0' && binary1.get(i) == '0' && binary2.get(i) == '0') {
                        newBin.add("0");
                        remainder.add('0');
                    }
                    else if (remainder.get(i) == '1' && binary1.get(i) == '0' && binary2.get(i) == '0') {
                        newBin.add("1");
                        remainder.add('0');
                    }
                    else if (remainder.get(i) == '1' && binary1.get(i) == '1' && binary2.get(i) == '0') {
                        newBin.add("0");
                        remainder.add('1');
                    } else if (remainder.get(i) == '1' && binary1.get(i) == '1' && binary2.get(i) == '1') {
                        newBin.add("1");
                        remainder.add('1');
                    } else if (remainder.get(i) == '0' && binary1.get(i) == '1' && binary2.get(i) == '0') {
                        newBin.add("1");
                        remainder.add('0');
                    }
                    else if (remainder.get(i) == '0' && binary1.get(i) == '0' && binary2.get(i) == '1') {
                        newBin.add("1");
                        remainder.add('0');
                    }
                    else if (remainder.get(i) == '0' && binary1.get(i) == '1' && binary2.get(i) == '1') {
                        newBin.add("0");
                        remainder.add('1');
                    } else if (remainder.get(i) == '1' && binary1.get(i) == '0' && binary2.get(i) == '1'){
                        newBin.add("0");
                        remainder.add('1');
                    }
                }
            }
        }
        Collections.reverse(newBin);
        String binStr = String.join("", newBin);
        return binStr;
    }
    //=================================================
    /**
     * This method was created for subtraction of 2 binary and then display the result
     * @param bin1 get value of first binary from user input
     * @param bin2 get value of second binary from user input
     */
    String binarySubtraction(String bin1, String bin2) {
        newBin.clear();
        binary1.clear();
        binary2.clear();
        remainder.clear();
        NumberSystemConversion numberSystemConversion = new NumberSystemConversion();

        int nBin1 = bin1.length();
        int nBin2 = bin2.length();
        int tempN;
        if (nBin1 > nBin2)
            tempN = nBin1;
        else tempN = nBin2;
        for (int i = tempN - 1; i >= 0; i--){
            //Split Binary digit for bin1
            if (nBin1 < 1){
                binary1.add('0'); }
            else {  binary1.add(bin1.charAt(nBin1 - 1)); }
            //Split Binary digit for bin2
            if (nBin2 < 1) {
                binary2.add('0'); }
            else { binary2.add(bin2.charAt(nBin2 - 1)); }
            nBin1--;
            nBin2--;
        }
        //operator
        remainder.add('0');
        for (int i = 0; i < tempN; i++) {
            if (i == tempN - 1){
                if (remainder.get(i) == '1' && binary1.get(i) == '0' && binary2.get(i) == '1')
                    newBin.add("-1");
                else if (remainder.get(i) == '1' && binary1.get(i) == '1' && binary2.get(i) == '0')
                    newBin.add("");
                else if (remainder.get(i) == '1' && binary1.get(i) == '1' && binary2.get(i) == '1')
                    newBin.add("-1");
                else if (remainder.get(i) == '0' && binary1.get(i) == '0' && binary2.get(i) == '0')
                    newBin.add("");
                else if (remainder.get(i) == '0' && binary1.get(i) == '0' && binary2.get(i) == '1')
                    newBin.add("-1");
                else if (remainder.get(i) == '0' && binary1.get(i) == '1' && binary2.get(i) == '0')
                    newBin.add("1");
                else if (remainder.get(i) == '0' && binary1.get(i) == '1' && binary2.get(i) == '1')
                    newBin.add("");
            }
            else {
                if (remainder.get(i) == '0' && binary1.get(i) == '1' && binary2.get(i) == '1') {
                    newBin.add("0");
                    remainder.add('0');
                } else if (remainder.get(i) == '0' && binary1.get(i) == '0' && binary2.get(i) == '1') {
                    newBin.add("1");
                    remainder.add('1');
                } else if (remainder.get(i) == '0' && binary1.get(i) == '0' && binary2.get(i) == '0') {
                    newBin.add("0");
                    remainder.add('0');
                } else if (remainder.get(i) == '0' && binary1.get(i) == '1' && binary2.get(i) == '0') {
                    newBin.add("1");
                    remainder.add('0');
                } else if (remainder.get(i) == '1' && binary1.get(i) == '0' && binary2.get(i) == '1') {
                    newBin.add("0");
                    remainder.add('1');
                } else if (remainder.get(i) == '1' && binary1.get(i) == '1' && binary2.get(i) == '1') {
                    newBin.add("1");
                    remainder.add('1');
                } else if (remainder.get(i) == '1' && binary1.get(i) == '1' && binary2.get(i) == '0') {
                    newBin.add("0");
                    remainder.add('0');
                } else if (remainder.get(i) == '1' && binary1.get(i) == '0' && binary2.get(i) == '0') {
                    newBin.add("1");
                    remainder.add('1');
                }
            }
        }
        Collections.reverse(newBin);
        String binStr = String.join("", newBin);
        return binStr;
    }
    //=================================================
    /**
     * This method was created for add operation of two binary with 2nd Complement then return the result of binary addition
     * @param bin1 get value of first binary from user input
     * @param bin2 get value of Second binary from user input
     * @return return binary addition result
     */
    String addWith2ndComplement(String bin1, String bin2) {
        String binary1, binary2;
        StringBuilder bin32bit1 = new StringBuilder(32);
        StringBuilder bin32bit2 = new StringBuilder(32);
        if (bin1.length() + 1 == 32){ binary1 = bin1; }
        else {
            for (int i = 0; i < 32 - bin1.length(); i++){
                bin32bit1.append("0");
            }
            bin32bit1.append(bin1);
            binary1 = bin32bit1.toString();
        }
        if (bin2.length() + 1 == 32){ binary2 = bin2; }
        else {
            for (int i = 0; i < 32 - bin2.length(); i++){
                bin32bit2.append("0");
            }
            bin32bit2.append(bin2);
            binary2 = bin32bit2.toString();
        }
        return binaryAdd(binary1, binary2);
    }
    //=================================================
    /**
     * This method was created for subtract operation of two binary with 2nd Complement then return the result of binary subtraction
     * @param bin1 get value of first binary from user input
     * @param bin2 get value of Second binary from user input
     * @return return binary subtraction result
     */
    String subtractWith2ndComplement(String bin1, String bin2) {
        String secComplementBin2;
        StringBuilder bin32bit2 = new StringBuilder(32);
        if (bin2.length() + 1 == 32) {
            secComplementBin2 = bin2;
        } else {
            for (int i = 0; i < 32 - bin2.length(); i++) {
                bin32bit2.append("0");
            }
            bin32bit2.append(bin2);
            secComplementBin2 = complement.findSecondComplement(bin32bit2.toString());
        }
        String result = addWith2ndComplement(bin1, secComplementBin2);
        String finalResult;
        if (result.length() == 33)
        finalResult = result.replaceFirst("1", "");
        else finalResult = result;
        return finalResult;
    }
    //=================================================
    /**
     * This method was created for multiplication of two binary
     * @param bin1  get value of first binary from user input
     * @param bin2  get value of Second binary from user input
     * @return return binary multiplication result
     */
    String multiplyBinary(String bin1, String bin2) {
        multiplyDigit.clear();
        binMultiply.clear();

        int nTemp;
        String bin1stTemp;
        if(bin2.length() > bin1.length()) {
            nTemp = bin1.length();
            bin1stTemp = bin2;
            //split and add bin1 to arraylist of integer
            for (int i = nTemp - 1; i >= 0; i--){
                multiplyDigit.add(bin1.charAt(i) - '0');
            }
        }else{
            nTemp = bin2.length();
            bin1stTemp = bin1;
            //split and add bin2 to arraylist of integer
            for (int i = nTemp - 1; i >= 0; i--){
                multiplyDigit.add(bin2.charAt(i) - '0');
            }
        }

        // operator mode...
        int upper = nTemp - 1;
        int lower = 0;
        StringBuilder upperBit = new StringBuilder();
        StringBuilder lowerBit = new StringBuilder();
        // split and append mode
        for (int i = 0; i < nTemp; i++) {
            if (multiplyDigit.get(i) == 1) {
                upperBit.setLength(0);
                lowerBit.setLength(0);
                for (int j = 0; j < upper; j++) {
                    upperBit.append("0");
                }
                for (int k = lower; k > 0; k--){
                    lowerBit.append("0");
                }
                upperBit.append(bin1stTemp);
                upperBit.append(lowerBit);
                binMultiply.add(upperBit.toString());
            }
            upper--;
            lower++;
        }

        // addition mode...
        String result = binaryAdd(binMultiply.get(0), binMultiply.get(1));
        for (int i = 2; i < binMultiply.size(); i++){
            result = binaryAdd(result, binMultiply.get(i));
        }
        return result;
    }
    //=================================================

    /**
     * This method was created for division of two binary
     * @param bin1 get value of first binary from user input
     * @param bin2 get value of Second binary from user input
     * @return return binary division result,but it doesn't have floating point yet!
     */
    String divideBinary(String bin1, String bin2) {
        NumberSystemConversion numberSystemConversion = new NumberSystemConversion();
        return numberSystemConversion.decimal2Binary(numberSystemConversion.binary2Decimal(bin1) / numberSystemConversion.binary2Decimal(bin2));
    }
    //=================================================
    //Nested class
    public class Complement {
        /**
         * This method was created for covert from binary to 1's complement
         *
         * @param binary get value of binary from user input
         * @return return the result of 1's complement
         */
        String findFirstComplement(String binary) { //10011
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1')
                    firstComplement.add("0");
                else
                    firstComplement.add("1");
            }
            String firstCom = String.join("", firstComplement);
            firstComplement.clear();
            return firstCom; //01100
        }

        /**
         * This method was created for covert from binary to 2's complement
         *
         * @param binary get value of binary from user input
         * @return return the result of 2's complement
         */
        String findSecondComplement(String binary) { //100100
            return binaryAdd(findFirstComplement(binary), "1");
        }
    }
}
