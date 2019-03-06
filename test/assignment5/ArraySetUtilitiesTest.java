/*
1. CreateSet method is not giving unique values when passing true as aparameter at uniqueElements. that's why test method a that test case is failing
2. CreateSet method should throw an Illegal Argument Exception when passing a negative number as a size but it's fails to thrown an Exception
3. CreateSet should throw an Illegal Argument Exception when passing wrong values for minimum and maximum (minimum > maximum). But the method doesn't throw an exception for that
4. Subset method is not working properly as it should work. The method return false when setB is a subset of setA. It only returns true when both of sets values are the same
5. Subset method should throw an Illegal Argument Exception when passing null Array as any of Data Set (A or B), but it doesn't    
6. IsUnique method should throw an Illegal Argument Exception when passing a null Array as a parameter but it doesn't
7. Subset method should throw an Illegal Argument Exception when passing SetA smaller than SetB, but it doesn't
*/


package assignment5;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kashyap Thakkar, 000742712
 */
public class ArraySetUtilitiesTest {
    
    public ArraySetUtilitiesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    
    

    /**
     * Test of createSet method for small data set with no duplicates, To check size and bound
     */
    @Test
    public void testCreateSetSmallDataSetNotUnique() {
        System.out.println("createSet for Small Data");
        int size = 10;
        int minimum = 0;
        int maximum = 10;
        boolean uniqueElements = false;
        
        ArrayList<Integer> result = ArraySetUtilities.createSet(size, minimum, maximum, uniqueElements);
        assertEquals(size, result.size());
        
        for(int i =0 ; i<result.size(); i++)
        {
            assertTrue(result.get(i)>=minimum && result.get(i)<=maximum);   
        }
    }
    
    
    
    /**
     * Test of createSet method for large data set with no duplicates to check size and bound
     */
    @Test
    public void testCreateSetLargeDataSetNotUnique() {
        System.out.println("createSet for Large data");
        int size = 1000000;
        int minimum = 0;
        int maximum = 10;
        boolean uniqueElements = false;
        
        ArrayList<Integer> result = ArraySetUtilities.createSet(size, minimum, maximum, uniqueElements);
        assertEquals(size, result.size());
        
        for(int i =0 ; i<result.size(); i++)
        {
            assertTrue(result.get(i)>=minimum && result.get(i)<=maximum);   
        }
    }
    
    
    
    /**
     * Test of createSet method with duplicates to check method is avoiding duplicates or not
     */
    @Test
    public void testCreateSetUnique() {
        System.out.println("createSet with Unique values");
        int size = 10;
        int minimum = 0;
        int maximum = 10;
        boolean uniqueElements = true;
        
        ArrayList<Integer> result = ArraySetUtilities.createSet(size, minimum, maximum, uniqueElements);
        
        
        
        for(int i = 0;i<result.size() - 1;i++)
        {
            for(int j = i + 1;j<result.size();j++)
            {
                assertTrue(result.get(i) != result.get(j));
            }
        }
        
    }
    
    
    
    /**
     * Test of createSet method with no duplicates, to check that method is creating duplicates or not
     */
    
    @Test
    public void testCreateSetNotUnique() {
        System.out.println("createSet with duplicate values");
        int size = 100;
        int minimum = 0;
        int maximum = 100;
        boolean uniqueElements = false;
        
        ArrayList<Integer> result = ArraySetUtilities.createSet(size, minimum, maximum, uniqueElements);
        
        boolean temp = false;
        for(int i = 0;i<result.size() - 1;i++)
        {
            for(int j = i + 1;j<result.size();j++)
            {
                if(result.get(i) == result.get(j)){
                    temp = true;
                }
            }
            assertTrue(temp);
        }
        
    }
    
    
    
    /**
     * To test that method is throwing an IllegalArgumentException if providing bad size parameter
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateSetBadSize() {
        System.out.println("createSet with bad size");
        int size = -1;
        int minimum = 0;
        int maximum = 10;
        boolean uniqueElements = false;
        
        ArrayList<Integer> result = ArraySetUtilities.createSet(size, minimum, maximum, uniqueElements);
        
    }
    
    
    
    
    /**
     * To test that method is throwing an IllegalArgumentException if minimum is greater than maximum
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateSetWrongMinimumAndMaximum() {
        System.out.println("createSet with wrong minimum - maximum");
        int size = 10;
        int minimum = 20;
        int maximum = 10;
        boolean uniqueElements = false;
        
        ArrayList<Integer> result = ArraySetUtilities.createSet(size, minimum, maximum, uniqueElements);
        
    }
    
    

    
    /**
     * To test that isUnique returns true for without duplicates
     */
    @Test
    public void testIsUniqueWithoutDuplicates() {
        System.out.println("isUnique without duplicates");
        ArrayList<Integer> arraySet = new ArrayList<>(Arrays.asList(0,543,62,876,974,87,653));
        
        boolean expResult = true;
        boolean result = ArraySetUtilities.isUnique(arraySet);
        assertEquals(expResult, result);
        
    }
    
    
    
    /**
     * To test that isUnique returns false for duplicates
     */
    @Test
    public void testIsUniqueWithDuplicates() {
        System.out.println("isUnique with duplicates");
        ArrayList<Integer> arraySet = new ArrayList<>(Arrays.asList(0,5,2,65,5,5,6));
        
        
        boolean expResult = false;
        boolean result = ArraySetUtilities.isUnique(arraySet);
        assertEquals(expResult, result);
        
    }
    
   
    
    /**
     * To test that method is throwing an IllegalArgumentException if arrayList is null
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIsUniqueNullArray() {
        System.out.println("isUnique with null array");
        ArrayList<Integer> arraySet = null;
       
        boolean expResult = false;
        boolean result = ArraySetUtilities.isUnique(arraySet);
     
    }
    
    
    
    
    /**
     * .To test that method is throwing an IllegalArgumentException if arrayList is set to null(setB)
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIntersectionWithNullArray1() {
        System.out.println("intersection with null array");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(5,65,2,98,10,2));
        ArrayList<Integer> setB = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = ArraySetUtilities.intersection(setA, setB);
        
    }
    
    
    
    
    /**
     * To test that method is throwing an IllegalArgumentException if arrayList is set to null(setA)
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIntersectionWithNullArray2() {
        System.out.println("intersection with null array");
        ArrayList<Integer> setA = null;
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(5,2,87,10,2));
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = ArraySetUtilities.intersection(setA, setB);
        
    }
    
    
    
    
    /**
     * To test that method is throwing an IllegalArgumentException if setA is Empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIntersectionWithEmptyArray1() {
        System.out.println("intersection with empty array");
        ArrayList<Integer> setA = new ArrayList<>();
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(5,65,2,98,10,2));
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = ArraySetUtilities.intersection(setA, setB);
        
    }
    
    
    
    
    /**
     * To test that method is throwing an IllegalArgumentException if setB is empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIntersectionWithEmptyArray2() {
        System.out.println("intersection with empty array");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(5,65,2,98,10,2));
        ArrayList<Integer> setB = new ArrayList<>();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = ArraySetUtilities.intersection(setA, setB);
        
    }
    
    
    
    /**
     * To test that method is providing the intersection of two partial arrays
     */
    @Test
    public void testIntersectionPartialArray() {
        System.out.println("intersection with partial array");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(10,20,30,40,50,60));
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(50,20,870,100,20));
        ArrayList<Integer> expResult = new ArrayList<>(Arrays.asList(20,50));
        ArrayList<Integer> result = ArraySetUtilities.intersection(setA, setB);
        assertEquals(expResult,result);
        
    }
    
    
    
    
    /**
     * To test that method is providing intersection for two different arrays
     */
    @Test
    public void testIntersectionDifferentArray() {
        System.out.println("intersection with different arrays");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(10,20,30,40,50,60));
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(70,80,90,100,110,120));
        ArrayList<Integer> expResult = new ArrayList<>();
        ArrayList<Integer> result = ArraySetUtilities.intersection(setA, setB);
        assertEquals(expResult,result);
        
    }
    
    
    
    
    /**
     * To test that method is providing intersection for two same arrays
     */
    @Test
    public void testIntersectionSameArray() {
        System.out.println("intersection with same array");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> expResult = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> result = ArraySetUtilities.intersection(setA, setB);
        assertEquals(expResult,result);
        
    }
    
    
    
    
    /**
     * To test that method is giving union of two partial arrays with no duplicates
     */
    @Test
    public void testUnionWithOutDuplicates() {
        System.out.println("union without duplicates");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(10,20,30,40));
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(30,40,50,60));
        ArrayList<Integer> expResult = new ArrayList<>(Arrays.asList(10,20,30,40,50,60));
        ArrayList<Integer> result = ArraySetUtilities.union(setA, setB);
        assertEquals(expResult, result);
        
    }
    
    
    
    
    
    /**
     * To test that method is giving union of two partial arrays with duplicates
     */
    @Test
    public void testUnionWithDuplicates() {
        System.out.println("union with duplicates");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(10,20,30,40,20,10,30));
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(30,40,50,60,40,30));
        ArrayList<Integer> expResult = new ArrayList<>(Arrays.asList(10,20,30,40,50,60));
        ArrayList<Integer> result = ArraySetUtilities.union(setA, setB);
        assertEquals(expResult, result);
        
    }
    
    
    
    
    /**
     * To test that method is giving union of two different arrays 
     */
    @Test
    public void testUnionDifferentArray() {
        System.out.println("union with different arrays");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(10,20,30,40));
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(50,60,0,330));
        ArrayList<Integer> expResult = new ArrayList<>(Arrays.asList(10,20,30,40,50,60,0,330));
        ArrayList<Integer> result = ArraySetUtilities.union(setA, setB);
        assertEquals(expResult, result);
        
    }
    
    
    
    /**
     * To test that method is throwing an IllegalArgumentException if setA is null
     */
    @Test(expected = IllegalArgumentException.class)
    public void testUnionNullArray1() {
        System.out.println("union with null array");
        ArrayList<Integer> setA = null;
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(5,6,0,33));
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = ArraySetUtilities.union(setA, setB);
                
    }
    
    
    
    /**
     * To test that method is throwing an IllegalArgumentException if setB is null
     */
    @Test(expected = IllegalArgumentException.class)
    public void testUnionNullArray2() {
        System.out.println("union with null array");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(5,6,0,33));
        ArrayList<Integer> setB = null;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = ArraySetUtilities.union(setA, setB);
                
    }

    
    
    /**
     * To test that method is throwing an IllegalArgumentException if setA is Empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testUnionEmptyArray1() {
        System.out.println("union with empty array");
        ArrayList<Integer> setA = new ArrayList<>();
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(5,6,0,33));
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = ArraySetUtilities.union(setA, setB);
                
    }
    
    
    
    /**
     * To test that method is throwing an IllegalArgumentException if setB is Empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testUnionEmptyArray2() {
        System.out.println("union with empty array");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(5,6,0,33));
        ArrayList<Integer> setB = new ArrayList<>();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = ArraySetUtilities.union(setA, setB);
                
    }
    

    
    /**
     * Test of subSet method when setB is not subset of setA
     */
    @Test
    public void testSubSetNotSubset() {
        System.out.println("subSet where SetB is not subset of setA");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(2,50,10,540,50,660,40,220));
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(50,1,980,880,520));
        boolean expResult = false;
        boolean result = ArraySetUtilities.subSet(setA, setB);
        assertEquals(expResult, result);
        
    }
    
    
    
    /**
     * Test of subSet method when setB is subset of setA
     */
    @Test
    public void testSubSetIsSubset1() {
        System.out.println("subSet where setB is subset of setA");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(10,20,30,40,50,60));
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(40,20,60));
        boolean expResult = true;
        boolean result = ArraySetUtilities.subSet(setA, setB);
        assertEquals(expResult, result);
        
    }
    
    
    
    /**
     * Test of subSet method when setB is not subset of setA
     */
    @Test
    public void testSubSetIsSubset2() {
        System.out.println("subSet where setB is subset of setA");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        boolean expResult = true;
        boolean result = ArraySetUtilities.subSet(setA, setB);
        assertEquals(expResult, result);
        
    }
    
    
    /**
     * To test that method is throwing IllegalArgumentAcception when setB is greater than setA
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSubSetGreaterDataSetB() {
        System.out.println("subSet with wrong parameters");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(20,5,1,54,5,66,4,22));
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(20,5,1,54,5,66,4,22,54,98,20));
        boolean expResult = false;
        boolean result = ArraySetUtilities.subSet(setA, setB);    
    }
    
    
    
    /**
     * To test that method is throwing an IllegalArgumentException if setA is Empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSubSetEmptyArray1() {
        System.out.println("subSet with empty array");
        ArrayList<Integer> setA = new ArrayList<>();
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(20,5,1,54,5,66,4,22));
        boolean expResult = false;
        boolean result = ArraySetUtilities.subSet(setA, setB);    
    }
    
    
    /**
     * To test that method is throwing an IllegalArgumentException if setB is Empty
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSubSetEmptyArray2() {
        System.out.println("subSet with empty array");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(20,5,1,54,5,66,4,22));
        ArrayList<Integer> setB = new ArrayList<>();
        boolean expResult = false;
        boolean result = ArraySetUtilities.subSet(setA, setB);
        
        
    }
    
    
    
    /**
     * To test that method is throwing an IllegalArgumentException if setA is null
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSubSetNullArray1() {
        System.out.println("subSet with null array");
        ArrayList<Integer> setA = null;
        ArrayList<Integer> setB = new ArrayList<>(Arrays.asList(20,5,1,54,5,66,4,22));
        boolean expResult = false;
        boolean result = ArraySetUtilities.subSet(setA, setB);    
    }
    
    
    
    /**
     * To test that method is throwing an IllegalArgumentException if setB is null
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSubSetNullArray2() {
        System.out.println("subSet with null array");
        ArrayList<Integer> setA = new ArrayList<>(Arrays.asList(20,5,1,54,5,66,4,22));
        ArrayList<Integer> setB = null;
        boolean expResult = false;
        boolean result = ArraySetUtilities.subSet(setA, setB);    
    }
    
}

