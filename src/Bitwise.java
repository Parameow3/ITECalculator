/**
 * Bitwise.java    :    This class is created for bitwise calculator
 * Created on Monday, January 10th 2022      by Tan Bunchhay
 */
public class Bitwise {
    /**
     * The Bitwise operator AND method of integer a and b
     * @param a first Input parameter of value a
     * @param b second of value b
     * @return The result of AND operator
     */
   public int AND(int a, int b){
       return a & b;
   }

    /**
     * The Bitwise operator OR method of integer a and b
     * @param a first Input parameter of value a
     * @param b second of value b
     * @return The result of OR operator
     */
   public int OR(int a, int b){
       return  a | b;
   }

    /**
     * The Bitwise operator XOR method of integer a and b
     * @param a first Input parameter of value a
     * @param b second of value b
     * @return The result of XOR operator
     */
   public int XOR(int a, int b){
       return a ^ b;
   }

    /**
     * The Bitwise operator leftShift method of integer a and b
     * @param a first Input parameter of value a
     * @param b second of value b
     * @return The result of leftShift operator
     */
   public int leftShift(int a, int b){
       return a << b;
   }

    /**
     * The Bitwise operator rightShift method of integer a and b
     * @param a first Input parameter of value a
     * @param b second of value b
     * @return The result of rightShift operator
     */
    public int rightShift(int a, int b){
        return a >> b;
    }

    /**
     * The Bitwise operator bitInversion method of integer a and b
     * @param a first Input parameter of value a
     * @return The result of bitInversion operator
     */
    public int bitInversion(int a){
       return ~a;
    }
}
