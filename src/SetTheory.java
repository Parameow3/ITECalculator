import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SetTheory { // A

    private ArrayList <Integer> set1 = new ArrayList<>();
    private ArrayList <Integer> set2 = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);


    public void createSet() { //C

        // get length of set 1
        System.out.print("Please Input the size of 1st set: ");
        int n1 = scanner.nextInt();

        // user input item to set 1 : { 1, 2, 3, 5, 7 }
        for (int i = 0; i < n1; i++) {
            System.out.print("1st Set [" + i + "]: ");
            set1.add(scanner.nextInt());
        }

        // get length of set 1
        System.out.print("Please Input the size of 2nd set: ");
        int n2 = scanner.nextInt();

        // user input item to set 1 : { 1, 2, 3, 5, 7 }
        for (int i = 0; i < n2; i++) {
            System.out.print("2nd Set [" + i + "]: ");
            set2.add(scanner.nextInt());
        }

        // display sets
        System.out.println("+--------------------------+");
        System.out.println("1st set: " + set1);
        System.out.println("2nd set: " + set2);
    }


    // method Union #H
    public void union() {

        // instantiate setUnion
        SetUnion setUnion = new SetUnion();

        // for user create 2 set
        createSet();

        // unionOperation + display result
        setUnion.display();
    }

    // *************** Inner Class ************* \\
    // SetUnion #G
    private class SetUnion implements UnionHelper{

        @Override
        public ArrayList <Integer> unionOperation() {

            boolean existed = true;
            ArrayList <Integer> unionResult = new ArrayList<>();
            unionResult.addAll(set1);

            for (int i = 0; i < set2.size(); i++) {
                // set2: { 1, 3, 4, 6, 7 }
                for (int j = 0; j < set1.size(); j++) {
                    //set1: { 1, 2, 5, 6, 9 }
                    if (set2.get(i) == set1.get(j)) {
                        existed = true;
                        break;
                    }
                    else
                        existed = false;
                }
                // if the item is not existed then add the item of set 2 to the list
                if (!existed)
                    unionResult.add(set2.get(i));
            }
            Collections.sort(unionResult);
            return unionResult;
        }
        @Override
        public void display() {
            System.out.println("+--------------------- Result --------------------+");
            System.out.println("Union of set1 and set2: " + unionOperation());
            System.out.println("+-------------------------------------------------+");
        }
    }

    // *************** Interface ************* \\

    // UnionHelper Interface #B
    public interface UnionHelper {

        // create two method as abstract #D
        ArrayList <Integer> unionOperation();
        void display();
    }
    // IntersectionHelper Interface #B
    public interface IntersectionHelper {

        // create two method as abstract #E
        ArrayList <Integer> intersectionOperation();
        void display();
    }
    //SetDifferenceHelper Interface #B
    public interface SetDifferenceHelper {

        // create two method as abstract #E
        ArrayList <Integer> differenceOperation();
        void display();
    }
}
