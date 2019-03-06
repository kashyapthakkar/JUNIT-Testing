package assignment5;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A number of methods that will assist with the processing of integer data
 * sets. ArrayLists are used to hold the contents of the sets
 *
 * @author mark.yendt
 *
 */
public final class ArraySetUtilities {

    /**
     * Method will generate a set of integers between the minimum and maximum of
     * the requested size. If the uniqueElements is true the set will consist of
     * unique integer values
     *
     * @param size the number of elements for the array
     * @param minimum the lower value of the range of integers to generate
     * @param maximum the upper value of the range of integers to generate
     * @param uniqueElements flag for unique values
     * @return
     */
    public static ArrayList<Integer> createSet(int size, int minimum, int maximum, boolean uniqueElements) {
        boolean filled = false;
        int i = 0;
        ArrayList<Integer> arraySet = null;
        if (size > 0) {
            arraySet = new ArrayList<Integer>();
            boolean isUnique = false;
            while (!filled) {
                int randi = (int) (Math.random() * (maximum - minimum)) + minimum;

                isUnique = true;
                for (int j = 0; j < i && uniqueElements; j++) {
                    isUnique = randi != arraySet.get(j);
                }

                if (isUnique || !uniqueElements) {
                    arraySet.add(randi);
                    i++;
                }

                filled = (i == size);
            }
        }
        return arraySet;
    }

    /**
     * Method will determine if all elements in the input set are all unique
     *
     * @param arraySet the input array to check
     * @return true if there are no duplicates, false if duplicates exists
     */

    public static boolean isUnique(ArrayList<Integer> arraySet) {
        boolean isUniqueflag = true;

        for (int i = 0; i < arraySet.size() && isUniqueflag; i++) {
            for (int j = i + 1; j < arraySet.size() && isUniqueflag; j++) {
                isUniqueflag = arraySet.get(i) != arraySet.get(j);
            }
        }
        return isUniqueflag;
    }

    /**
     * Determines the common elements (intersection) between setA and setB
     *
     * @param setA The first of the two Sets
     * @param setB The second of the two sets
     * @return a new set that consists of the common elements between A and B
     * @throws IllegalArgumentException when one of setA or setB is null or
     * empty
     */
    public static ArrayList<Integer> intersection(ArrayList<Integer> setA, ArrayList<Integer> setB)
            throws IllegalArgumentException {
        ArrayList<Integer> setCommon = new ArrayList<Integer>();
        if (null == setA || null == setB) {
            throw new IllegalArgumentException("Arraylist arguments cannot be null");
        }
        if (setA.size() == 0 || setB.size() == 0) {
            throw new IllegalArgumentException("Arraylist arguments cannot be empty");
        }
        for (int i = 0; i < setA.size(); i++) {
            for (int j = 0; j < setB.size(); j++) {
                if (setA.get(i) == setB.get(j)) {
                    boolean canAddToCommon = true;
                    for (int k = 0; k < setCommon.size(); k++) {
                        if (setA.get(i) == setCommon.get(k)) {
                            canAddToCommon = false;
                            break;
                        }
                    }
                    if (canAddToCommon) {
                        setCommon.add(setA.get(i));
                    }
                }
            }
        }

        return setCommon;
    }

    /**
     * Determine the union of two sets
     *
     * @param setA the first of the two sets for the union
     * @param setB the second of the two sets for the union
     * @return a union between setA and setB
     * @throws IllegalArgumentException when one of setA or setB is null or
     * empty
     */
    public static ArrayList<Integer> union(ArrayList<Integer> setA, ArrayList<Integer> setB)
            throws IllegalArgumentException {
        ArrayList<Integer> uniqueSet = new ArrayList<Integer>();
        if (null == setA || null == setB) {
            throw new IllegalArgumentException("Arralist arguments cannot be null");
        }
        if (setA.size() == 0 || setB.size() == 0) {
            throw new IllegalArgumentException("Arraylist arguments cannot be empty");
        }

        for (int i = 0; i < setA.size(); i++) {
            boolean canAddToUnique = true;
            for (int j = 0; j < uniqueSet.size() && canAddToUnique; j++) {
                canAddToUnique = setA.get(i) != uniqueSet.get(j);
            }
            if (canAddToUnique) {
                uniqueSet.add(setA.get(i));
            }
        }

        for (int i = 0; i < setB.size(); i++) {
            boolean canAddToUnique = true;
            for (int j = 0; j < uniqueSet.size() && canAddToUnique; j++) {
                canAddToUnique = setB.get(i) != uniqueSet.get(j);
            }
            if (canAddToUnique) {
                uniqueSet.add(setB.get(i));
            }
        }

        return uniqueSet;
    }

    /**
     * Determines if setB is a subSet of setA
     *
     * @param setA the full set for the comparison
     * @param setB the sub set to be tested
     * @return true if setB is a subSet of setA
     * @throws IllegalArgumentException when one of setA or setB is null or
     * empty
     */
    public static boolean subSet(ArrayList<Integer> setA, ArrayList<Integer> setB) {
        
        if (setA.size() == 0 || setB.size() == 0) {
            throw new IllegalArgumentException("Arraylist arguments cannot be empty");
        }

        boolean isInSet = true;
        for (int i = 0; i < setA.size() && isInSet; i++) {
            isInSet = false;
            for (int j = 0; j < setB.size() && !isInSet; j++) {
                isInSet = setA.get(i) == setB.get(j);
            }
        }

        return isInSet;
    }

}
