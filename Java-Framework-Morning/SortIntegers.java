import java.util.*;
import java.util.Random;

public class SortIntegers {
    public static void main(String[] args){

        System.out.println("\nSORTING LIST OF INTEGERS USING Collections.sort()");

        ArrayList<Integer> listOfInt = new ArrayList<Integer>();

        // creating an object of Random class
        Random random = new Random();

        for(int i=0; i<20; i++){

            // Generates random integers 0 to 49
            int x = random.nextInt(50);
            listOfInt.add(x);
        }

        System.out.println("List Before Sorting :\n" + listOfInt);

        Collections.sort(listOfInt);

        System.out.println("List After Sorting :\n" + listOfInt);

    }
}

