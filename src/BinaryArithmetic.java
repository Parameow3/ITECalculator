import java.util.ArrayList;
import java.util.Collections;

/**
 * BinaryArithmetic.java    :    This class is created for calculate all
 *                               Binary Operator.
 * Created on Friday, February 11th 2022      by Tan Bunchhay
 */

public class BinaryArithmetic {

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
    //=======================================================
    /**
     * This method was created for summation of 2 binary and then display the result
     * @param bin1 get value of first binary from user input
     * @param bin2 get value of second binary from user input
     */
    void binaryAdd(String bin1, String bin2) {
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
        System.out.println("Binary1 + Binary2 = " + binStr);
        newBin.clear();
        binary1.clear();
        binary2.clear();
        remainder.clear();
    }
    //=================================================
    /**
     * This method was created for subtraction of 2 binary and then display the result
     * @param bin1 get value of first binary from user input
     * @param bin2 get value of second binary from user input
     */
    void binarySubtraction(String bin1, String bin2) {
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
        newBin.clear();
        binary1.clear();
        binary2.clear();
    }
    //=================================================

    /**
     * This method was created for covert from binary to 1's complement
     * @param binary get value of binary from user input
     * @return return the result of 1's complement
     */
    String findFirstComplement(String binary) {
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1')
                firstComplement.add("0");
            else
                firstComplement.add("1");
        }
        String firstCom = String.join("",firstComplement);
        firstComplement.clear();
        return firstCom;
    }
}
