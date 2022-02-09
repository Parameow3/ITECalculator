/**
 * StorageConverter.java    :   This class will consist of wide ranges of methods to perform conversion.
 * Created on Sunday, January 16th 2022      by Tan Bunchhay
 */
public class StorageConverter {
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
