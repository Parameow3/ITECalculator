/**
 * MoneyExchange.java    :    This class is created for Money Convertor
 * Created on Monday, January 10th 2022      by Tan Bunchhay
 */
public class MoneyExchange {
    /**
     * The method for exchange money from Riel to Dollar
     * @param riel Khmer Riel Currency
     * @return Converted to Dollar (a double)
     */
   public double RielToDollar(double riel){
       return riel / 4050;
   }

    /**
     * The method for exchange money from Riel to Euro
     * @param riel Khmer Riel Currency
     * @return Converted to Euro (a double)
     */
   public double RielToEuro(double riel){
        return riel / 5000;
   }

    /**
     * The method for exchange money from Riel to Franc
     * @param riel Khmer Riel Currency
     * @return Converted to Franc (a double)
     */
    public double RielToFranc(double riel){
        return riel / 4500;
    }

    /**
     * The method for exchange money from Riel to Pound
     * @param riel Khmer Riel Currency
     * @return Converted to Pound (a double)
     */
    public double RielToPound(double riel){
        return riel / 6000;
    }

    /**
     * The method for exchange money from Riel to Baht
     * @param riel Khmer Riel Currency
     * @return Converted to Baht (a double)
     */
    public double RielToBaht(double riel){
        return riel / 100;
    }

    /**
     * The method for exchange money from Dollar to Riel
     * @param dollar USA Currency
     * @return Converted to Riel
     */
    public double DollarToRiel(double dollar){
        return dollar * 4050;
    }

    /**
     * The method for exchange money from Euro to Riel
     * @param euro Europe Currency
     * @return Converted to Riel
     */
    public double EuroToRiel(double euro){
        return euro * 5000;
    }

    /**
     * The method for exchange money from Franc to Riel
     * @param franc French Currency
     * @return Converted to Riel
     */
    public double FrancToRiel(double franc){
        return franc * 4500;
    }

    /**
     * The method for exchange money from Pound to Riel
     * @param pound England Currency
     * @return Converted to Riel
     */
    public double PoundToRiel(double pound){
        return pound * 6000;
    }

    /**
     * The method for exchange money from Baht to Riel
     * @param baht Thailand Currency
     * @return Converted to Riel
     */
    public double BahtToRiel(double baht){
        return baht * 100;
    }
}
