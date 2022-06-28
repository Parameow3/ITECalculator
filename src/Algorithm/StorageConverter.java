package Algorithm;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Algorithm.StorageConverter.java    :   This class will consist of wide ranges of methods to perform conversion.
 * Created on Sunday, January 16th 2022      by Tan Bunchhay
 */
public class StorageConverter {

    private Scanner scanner = new Scanner(System.in);

    public void generateInterface() {

        System.out.println("********** Storage Converter **********");
        System.out.println("1. Byte");
        System.out.println("2. Kilobyte");
        System.out.println("3. Megabyte");
        System.out.println("4. Gigabyte");
        System.out.println("5. Terabyte");
        System.out.println("6. Petabyte");

        System.out.print("Please choose from 1 to 6:");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("Please Input Byte value: ");
                Scanner numByte = new Scanner(System.in);
                long byteValue = numByte.nextLong();
                System.out.println("- Byte to Kilobyte: " + BigDecimal.valueOf(byte2KB(byteValue)).toPlainString());
                System.out.println("- Byte to Megabyte: " + BigDecimal.valueOf(byte2MB(byteValue)).toPlainString());
                System.out.println("- Byte to Gigabyte: " + BigDecimal.valueOf(byte2GB(byteValue)).toPlainString());
                System.out.println("- Byte to Terabyte: " + BigDecimal.valueOf(byte2TB(byteValue)).toPlainString());
                System.out.println("- Byte to Petabyte: " + BigDecimal.valueOf(byte2PB(byteValue)).toPlainString());
            }
            case 2 -> {
                System.out.print("Please Input Kilobyte value: ");
                Scanner numKB = new Scanner(System.in);
                long kByte = numKB.nextLong();
                System.out.println("- Kilobyte to Byte: " + BigDecimal.valueOf(kb2Byte(kByte)).toPlainString());
                System.out.println("- Kilobyte to Megabyte: " + BigDecimal.valueOf(kb2MB(kByte)).toPlainString());
                System.out.println("- Kilobyte to Gigabyte: " + BigDecimal.valueOf(kb2GB(kByte)).toPlainString());
                System.out.println("- Kilobyte to Terabyte: " + BigDecimal.valueOf(kb2TB(kByte)).toPlainString());
                System.out.println("- Kilobyte to Petabyte: " + BigDecimal.valueOf(kb2PB(kByte)).toPlainString());
            }
            case 3 -> {
                System.out.print("Please Input Megabyte value: ");
                Scanner numMB = new Scanner(System.in);
                long mByte = numMB.nextLong();
                System.out.println("- Megabyte to byte: " + BigDecimal.valueOf(mb2Byte(mByte)).toPlainString());
                System.out.println("- Megabyte to Kilobyte: " + BigDecimal.valueOf(mb2KB(mByte)).toPlainString());
                System.out.println("- Megabyte to Gigabyte: " + BigDecimal.valueOf(mb2GB(mByte)).toPlainString());
                System.out.println("- Megabyte to Terabyte: " + BigDecimal.valueOf(mb2TB(mByte)).toPlainString());
                System.out.println("- Megabyte to Petabyte: " + BigDecimal.valueOf(mb2PB(mByte)).toPlainString());
            }
            case 4 -> {
                System.out.print("Please Input Gigabyte value: ");
                Scanner numGB = new Scanner(System.in);
                long gByte = numGB.nextLong();
                System.out.println("- Gigabyte to byte: " + BigDecimal.valueOf(gb2Byte(gByte)).toPlainString());
                System.out.println("- Gigabyte to Kilobyte: " + BigDecimal.valueOf(gb2KB(gByte)).toPlainString());
                System.out.println("- Gigabyte to Megabyte: " + BigDecimal.valueOf(gb2MB(gByte)).toPlainString());
                System.out.println("- Gigabyte to Terabyte: " + BigDecimal.valueOf(gb2TB(gByte)).toPlainString());
                System.out.println("- Gigabyte to Petabyte: " + BigDecimal.valueOf(gb2PB(gByte)).toPlainString());
            }
            case 5 -> {
                System.out.print("Please Input Terabyte value: ");
                Scanner numTB = new Scanner(System.in);
                long tByte = numTB.nextLong();
                System.out.println("- Terabyte to byte: " + BigDecimal.valueOf(tb2Byte(tByte)).toPlainString());
                System.out.println("- Terabyte to Kilobyte: " + BigDecimal.valueOf(tb2KB(tByte)).toPlainString());
                System.out.println("- Terabyte to Megabyte: " + BigDecimal.valueOf(tb2MB(tByte)).toPlainString());
                System.out.println("- Terabyte to Gigabyte: " + BigDecimal.valueOf(tb2GB(tByte)).toPlainString());
                System.out.println("- Terabyte to Petabyte: " + BigDecimal.valueOf(tb2PB(tByte)).toPlainString());
            }
            case 6 -> {
                System.out.print("Please Input Petabyte value: ");
                Scanner numPB = new Scanner(System.in);
                long pByte = numPB.nextLong();
                System.out.println("- Petabyte to byte: " + BigDecimal.valueOf(pb2Byte(pByte)).toPlainString());
                System.out.println("- Petabyte to Kilobyte: " + BigDecimal.valueOf(pb2KB(pByte)).toPlainString());
                System.out.println("- Petabyte to Megabyte: " + BigDecimal.valueOf(pb2MB(pByte)).toPlainString());
                System.out.println("- Petabyte to Gigabyte: " + BigDecimal.valueOf(pb2GB(pByte)).toPlainString());
                System.out.println("- Petabyte to Terabyte: " + BigDecimal.valueOf(pb2TB(pByte)).toPlainString());
            }
            default -> System.out.println("Valid Input!");
        }
    }

    Trigonometry trigonometry = new Trigonometry();
    /**
     * This method use to convert from byte to kilobyte.
     * @param numByte this parameter use to get value of byte for convert to kilobyte.
     * @return return kilobyte in floating-point (double).
     */
    double byte2KB(long numByte){
        return (double) numByte/1024;
    }

    /**
     * This method use to convert from byte to megabyte.
     * @param numByte this parameter use to get value of byte for convert to megabyte.
     * @return return megabyte in floating-point (double).
     */
    double byte2MB(long numByte){
        return (double) numByte / trigonometry.square2(1024);
    }

    /**
     * This method use to convert from byte to gigabyte.
     * @param numByte this parameter use to get value of byte for convert to gigabyte.
     * @return return gigabyte in floating-point (double).
     */
    double byte2GB(long numByte){
        return (double) numByte / trigonometry.square3(1024);
    }

    /**
     * This method use to convert from byte to terabyte.
     * @param numByte this parameter use to get value of byte for convert to terabyte.
     * @return return terabyte in floating-point (double).
     */
    double byte2TB(long numByte){
        return (double) numByte / trigonometry.square2(Math.pow(1024, 2));
    }

    /**
     * This method use to convert from byte to petabyte.
     * @param numByte this parameter use to get value of byte for convert to petabyte.
     * @return return petabyte in floating-point (double).
     */
    double byte2PB(long numByte){
        return (double) numByte/Math.pow(1024, 5);
    }

    /**
     * This method use to convert from kilobyte to byte.
     * @param kilobyte this parameter use to get value of kilobyte for convert to byte.
     * @return return byte in long integer (long).
     */
    long kb2Byte(long kilobyte){
        return kilobyte * 1024;
    }

    /**
     * This method use to convert from kilobyte to megabyte.
     * @param kilobyte this parameter use to get value of kilobyte for convert to megabyte.
     * @return return megabyte in floating-point (double).
     */
    double kb2MB(long kilobyte){
        return (double) kilobyte/1024;
    }

    /**
     * This method use to convert from kilobyte to gigabyte.
     * @param kilobyte this parameter use to get value of kilobyte for convert to gigabyte.
     * @return return gigabyte in floating-point (double).
     */
    double kb2GB(long kilobyte){
        return (double) kilobyte / Math.pow(1024, 2);
    }

    /**
     * This method use to convert from kilobyte to terabyte.
     * @param kilobyte this parameter use to get value of kilobyte for convert to terabyte.
     * @return return terabyte in floating-point (double).
     */
    double kb2TB(long kilobyte){
        return (double) kilobyte / Math.pow(1024, 3);
    }

    /**
     * This method use to convert from kilobyte to petabyte.
     * @param kilobyte this parameter use to get value of kilobyte for convert to petabyte.
     * @return return petabyte in floating-point (double).
     */
    double kb2PB(long kilobyte){
        return (double) kilobyte / Math.pow(1024, 4);
    }

    /**
     * This method use to convert from megabyte to byte.
     * @param megabyte this parameter use to get value of megabyte for convert to byte.
     * @return return byte in long integer (long).
     */
    long mb2Byte(long megabyte){
        return megabyte * kb2Byte(1024);
    }

    /**
     * This method use to convert from megabyte to kilobyte.
     * @param megabyte this parameter use to get value of megabyte for convert to kilobyte.
     * @return return kilobyte in long integer (long).
     */
    long mb2KB(long megabyte){
        return megabyte*1024;
    }

    /**
     * This method use to convert from megabyte to gigabyte.
     * @param megabyte this parameter use to get value of megabyte for convert to gigabyte.
     * @return return gigabyte in floating-point (double).
     */
    double mb2GB(long megabyte){
        return (double) megabyte/1024;
    }

    /**
     * This method use to convert from megabyte to terabyte.
     * @param megabyte this parameter use to get value of megabyte for convert to terabyte.
     * @return return terabyte in floating-point (double).
     */
    double mb2TB(long megabyte){
        return (double) megabyte * trigonometry.square2(1.0/1024);
    }

    /**
     * This method use to convert from megabyte to petabyte.
     * @param megabyte this parameter use to get value of megabyte for convert to petabyte.
     * @return return petabyte in floating-point (double).
     */
    double mb2PB(long megabyte){
        return (double) megabyte * trigonometry.square3(1.0/1024);
    }

    /**
     * This method use to convert from gigabyte to byte.
     * @param gigabyte this parameter use to get value of gigabyte for convert to byte.
     * @return return byte in long integer (long).
     */
    long gb2Byte(long gigabyte){
        return gigabyte * mb2Byte(1024);
    }

    /**
     * This method use to convert from gigabyte to kilobyte.
     * @param gigabyte this parameter use to get value of gigabyte for convert to kilobyte.
     * @return return kilobyte in long integer (long).
     */
    long gb2KB(long gigabyte){
        return gigabyte * mb2KB(1024);
    }

    /**
     * This method use to convert from gigabyte to megabyte.
     * @param gigabyte this parameter use to get value of gigabyte for convert to megabyte.
     * @return return megabyte in long integer (long).
     */
    long gb2MB(long gigabyte){
        return gigabyte * 1024;
    }

    /**
     * This method use to convert from gigabyte to terabyte.
     * @param gigabyte this parameter use to get value of gigabyte for convert to teraabyte.
     * @return return terabyte in floating-point (double).
     */
    double gb2TB(long gigabyte){
        return (double) gigabyte/1024;
    }

    /**
     * This method use to convert from gigabyte to petabyte.
     * @param gigabyte this parameter use to get value of gigabyte for convert to petabyte.
     * @return return petabyte in floating-point (double).
     */
    double gb2PB(long gigabyte){
        return (double) gigabyte * trigonometry.square2(1.0/1024);
    }

    /**
     * This method use to convert from terabyte to byte.
     * @param terabyte this parameter use to get value of terabyte for convert to byte.
     * @return return byte in long integer (long).
     */
    long tb2Byte(long terabyte){
        return terabyte * gb2Byte(1024);
    }

    /**
     * This method use to convert from terabyte to kilobyte.
     * @param terabyte this parameter use to get value of terabyte for convert to kilobyte.
     * @return return kilobyte in long integer (long).
     */
    long tb2KB(long terabyte){
        return terabyte * gb2KB(1024);
    }

    /**
     * This method use to convert from terabyte to megabyte.
     * @param terabyte this parameter use to get value of terabyte for convert to megabyte.
     * @return return megabyte in long integer (long).
     */
    long tb2MB(long terabyte){
        return terabyte * gb2MB(1024);
    }

    /**
     * This method use to convert from terabyte to gigabyte.
     * @param terabyte this parameter use to get value of terabyte for convert to gigabyte.
     * @return return gigabyte in long integer (long).
     */
    long tb2GB(long terabyte){
        return terabyte*1024;
    }

    /**
     * This method use to convert from terabyte to petabyte.
     * @param terabyte this parameter use to get value of terabyte for convert to petabyte.
     * @return return petabyte in floating-point (double).
     */
    double tb2PB(long terabyte){
        return (double) terabyte/1024;
    }

    /**
     * This method use to convert from petabyte to byte.
     * @param petabyte this parameter use to get value of petabyte for convert to byte.
     * @return return byte in long integer (long).
     */
    long pb2Byte(long petabyte){
        return petabyte * tb2Byte(1024);
    }

    /**
     * This method use to convert from petabyte to kilobyte.
     * @param petabyte this parameter use to get value of petabyte for convert to kilobyte.
     * @return return kilobyte in long integer (long).
     */
    long pb2KB(long petabyte){
        return petabyte * tb2KB(1024);
    }

    /**
     * This method use to convert from petabyte to megabyte.
     * @param petabyte this parameter use to get value of petabyte for convert to megabyte.
     * @return return megabyte in long integer (long).
     */
    long pb2MB(long petabyte){
        return petabyte * tb2MB(1024);
    }

    /**
     * This method use to convert from petabyte to gigabyte.
     * @param petabyte this parameter use to get value of petabyte for convert to gigabyte.
     * @return return gigabyte in long integer (long).
     */
    long pb2GB(long petabyte){
        return petabyte * tb2GB(1024);
    }

    /**
     * This method use to convert from petabyte to terabyte.
     * @param petabyte this parameter use to get value of petabyte for convert to terabyte.
     * @return return terabyte in long integer (long).
     */
    long pb2TB(long petabyte){
        return petabyte * 1024;
    }
}
