import java.util.ArrayList;

public class SetTheory { // A

    public void createSet() { // C

    }

    public void union() { // H

        // instantiate SetUnion
        SetUnion setUnion = new SetUnion();

        // call createSet from outer class
        createSet();

        // call unionOperation and display from setUnion
        setUnion.unionOperation();
        setUnion.display();
    }

    public void intersection() { // I

        // local class SetIntersection
        class SetIntersection implements IntersectionHelper{

            // override method implements from interface
            @Override
            public ArrayList<Integer> intersectionOperation() {
                return null;
            }
            @Override
            public void display() {
            }
        }

        // instantiate SetUnion
        SetIntersection setIntersection = new SetIntersection();

        // call createSet from outer class
        createSet();

        // call intersectionOperation and display from setIntersection
        setIntersection.intersectionOperation();
        setIntersection.display();
    }

    public void setDiff() { // J

        // anonymous inner class
        abstract class SetDifference implements SetDifferenceHelper { }

        SetDifference setDifference = new SetDifference() {
            @Override
            public ArrayList<Integer> differenceOperation() {
                return null;
            }

            @Override
            public void display() {

            }
        };

        // call createSet from outer class
        createSet();

        // call differenceOperation and display from setIntersection
        setDifference.differenceOperation();
        setDifference.display();
    }

    public interface UnionHelper { // B
        // D
        ArrayList <Integer> unionOperation();
        void display();
    }

    public interface IntersectionHelper { // B
        // E
        ArrayList <Integer> intersectionOperation();
        void display();
    }

    public interface SetDifferenceHelper { // B
        // F
        ArrayList <Integer> differenceOperation();
        void display();
    }

    public class SetUnion implements UnionHelper{ // G

        @Override
        public ArrayList<Integer> unionOperation() {
            return null;
        }

        @Override
        public void display() {

        }
    }

}
