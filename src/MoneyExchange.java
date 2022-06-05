import java.util.Scanner;

/**
 * MoneyExchange.java    :    This class is created for Money Convertor
 * Created on Monday, January 10th 2022      by Tan Bunchhay
 */
public class MoneyExchange {

    private Scanner scanner = new Scanner(System.in);

    public void generateInterface() {
        System.out.println("********** Money Exchange **********");
        System.out.println("1. Riel to other Currency");
        System.out.println("2. Other Currency to Riel");

        System.out.print("PLease Input your choice:");
        int choice = scanner.nextInt();

        if (choice == 1) {

            System.out.print("Please Input value of money in Riel:");
            double riel = scanner.nextDouble();

            System.out.println("=====================================");
            System.out.println("Your money are " + String.format("%.2f", riel) + " Riel" + "\t\t\t|");
            System.out.println("=====================================");
            System.out.println("Here is the exchange rate:");
            System.out.println("Dollar: " + String.format("%.2f", RielToDollar(riel)) + " USD");
            System.out.println("Euro: " + String.format("%.2f", RielToEuro(riel)) + " EUR");
            System.out.println("Pound: " + String.format("%.2f", RielToPound(riel)) + " GBP");
            System.out.println("Franc: " + String.format("%.2f", RielToFranc(riel)) + " CHF");
            System.out.println("Baht: " + String.format("%.2f", RielToBaht(riel)) + " THB");
        } else if (choice == 2) {

            System.out.println("=====================================");
            System.out.print("Please Input value of money:");
            double currency = scanner.nextDouble();

            System.out.println("=====================================");
            System.out.println("Here is the exchange rate:");
            System.out.println("Dollar to Riel: " + String.format("%.2f", DollarToRiel(currency)) + " Riel");
            System.out.println("Euro to Riel: " + String.format("%.2f", EuroToRiel(currency)) + " Riel");
            System.out.println("Pound to Riel: " + String.format("%.2f", PoundToRiel(currency)) + " Riel");
            System.out.println("Franc to Riel: " + String.format("%.2f", FrancToRiel(currency)) + " Riel");
            System.out.println("Baht to Riel: " + String.format("%.2f", BahtToRiel(currency)) + " Riel");
        } else System.out.println("Valid Input!");
    }

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
