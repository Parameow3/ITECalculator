package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SetTheory { // A

    private ArrayList <Integer> set1 = new ArrayList<>();
    private ArrayList <Integer> set2 = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public void generateInterface() {

        System.out.println("+********* Set Theory *********+");
        System.out.println("+ 1. Union Helper              +");
        System.out.println("+ 2. Intersection Helper       +");
        System.out.println("+ 3. Difference Helper         +");
        System.out.println("+*************************--->>>");
        System.out.print("+ => Please choose your choice: ");

        // user input choice
        switch (scanner.nextInt()) {
            case 1 -> {
                union();
            }

            case 2 -> {
                intersection();
            }

            case 3 -> {
                setDiff();
            }
        }
    }

    private void createSet() { //C

        // get length of set 1
        System.out.println("+*************************--->>>");
        System.out.print("Please Input the size of 1st set: ");
        int n1 = scanner.nextInt();

        // user input item to set 1 : { 1, 2, 3, 5, 7 }
        for (int i = 0; i < n1; i++) {
            System.out.print("1st Set [" + i + "]: ");
            set1.add(scanner.nextInt());
        }

        // get length of set 2
        System.out.print("Please Input the size of 2nd set: ");
        int n2 = scanner.nextInt();

        // user input item to set 2 : { 1, 2, 3, 5, 7 }
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
    private void union() {

        // instantiate setUnion
        SetUnion setUnion = new SetUnion();

        // for user create 2 set
        createSet();

        // unionOperation + display result
        setUnion.display();
    }

    // method intersection #I
    public void intersection() {

        // local class
        class SetIntersection implements IntersectionHelper {

            // override 2 method from intersectionHelper
            @Override
            public ArrayList<Integer> intersectionOperation() {

                ArrayList <Integer> intersectionResult = new ArrayList<>();

                for (int i = 0; i < set1.size(); i++) {
                    for (int j = 0; j < set2.size(); j++) {
                        if (set1.get(i) == set2.get(j)) {
                            intersectionResult.add(set1.get(i));
                            break;
                        }
                    }
                }

                return intersectionResult;
            }

            @Override
            public void display() {

                if (!intersectionOperation().isEmpty()) {
                    System.out.println("+--------------------- Result --------------------+");
                    System.out.println("Intersection of set1 and set2: " + intersectionOperation());
                    System.out.println("+-------------------------------------------------+");
                } else {
                    System.out.println("+--------------------- Result --------------------+");
                    System.out.println("Intersection of set1 and set2: null!");
                    System.out.println("+-------------------------------------------------+");
                }
            }
        }

        // instantiate local class
        SetIntersection setIntersection = new SetIntersection();

        // for user create 2 set
        createSet();

        // intersectionOperation + display result
        setIntersection.display();
    }

    // method setDiff #J

    private void setDiff() {
        abstract class SetDifference implements SetDifferenceHelper, IntersectionHelper { }

        SetDifference setDifference = new SetDifference() {
            @Override
            public ArrayList<Integer> differenceOperation() {

                boolean dif = true;
                ArrayList <Integer> difResult = new ArrayList<>();

                for (int i = 0; i < set1.size(); i++) {
                    for (int j = 0; j < intersectionOperation().size(); j++) {
                        if (set1.get(i) == intersectionOperation().get(j)) {
                            dif = false;
                            break;
                        }
                        else {
                            dif = true;
                        }
                    }
                    if (dif)
                        difResult.add(set1.get(i));
                }

                return difResult;
            }

            @Override
            public ArrayList<Integer> intersectionOperation() {
                ArrayList <Integer> intersectionResult = new ArrayList<>();

                for (int i = 0; i < set1.size(); i++) {
                    for (int j = 0; j < set2.size(); j++) {
                        if (set1.get(i) == set2.get(j)) {
                            intersectionResult.add(set1.get(i));
                            break;
                        }
                    }
                }

                return intersectionResult;
            }

            @Override
            public void display() {
                if (!differenceOperation().isEmpty()) {
                    System.out.println("+--------------------- Result --------------------+");
                    System.out.println("Difference of set1 and set2: " + differenceOperation());
                    System.out.println("+-------------------------------------------------+");
                } else {
                    System.out.println("+--------------------- Result --------------------+");
                    System.out.println("Difference of set1 and set2: null!");
                    System.out.println("+-------------------------------------------------+");
                }
            }
        };

        // for user create 2 set
        createSet();

        // differenceOperation + display result
        setDifference.display();
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
