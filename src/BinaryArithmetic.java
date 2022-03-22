import java.util.ArrayList;
import java.util.Collections;

/**
 * BinaryArithmetic.java    :    This class is created for calculate all
 *                               Binary Operator.
 * Created on Friday, February 11th 2022      by Tan Bunchhay
 */

public class BinaryArithmetic {
    private Complement complement;
    //Array List for bin1
    ArrayList<Character> binary1 = new ArrayList<>();
    //Array Lise for bin2
    ArrayList<Character> binary2 = new ArrayList<>();
    //Arraylist for newBin
    ArrayList<String> newBin = new ArrayList<>();
    //Arraylist for remainder
    ArrayList<Character> remainder = new ArrayList<>();
    //Arraylist for First Complement
    ArrayList<String> firstComplement = new ArrayList<>();

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
    void binarySubtraction(String bin1, String bin2) {
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
        System.out.println("Binary1 - Binary2 = " + binStr);
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
