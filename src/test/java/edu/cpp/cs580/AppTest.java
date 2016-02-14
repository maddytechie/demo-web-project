package edu.cpp.cs580;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
       
    }
    
    public class Triangle {

      
        private String side1;
        private String side2;
        private String side3;

       
        public Triangle() {
           
            this("0", "0", "0");
        }
        
        public Triangle(String s1, String s2, String s3) {
            this.side1 = s1;
            this.side2 = s2;
            this.side3 = s3;
        }
        
        // -------------------------
        // Methods
        // -------------------------
        public String determineTriangleType() {
            
            String type = "";
            
            // This code runs when the user pushes the button
            int s1 = -1, s2=-1, s3 = -1;
            String err = "";
            try {
                s1 = Integer.parseInt(side1);
            } catch (NumberFormatException e) {
               err += "Side 1 is not a number!\n";
            }
            try {
                s2 = Integer.parseInt(side2);
            } catch (NumberFormatException e) {
               err += "Side 2 is not a number!\n";
            }
            try {
                s3 = Integer.parseInt(side3);
            } catch (NumberFormatException e) {
               err += "Side 3 is not a number!\n";
            }
            
            // Chceck that nothing is negative
            if (s1 <= 0 || s2 <= 0 || s3 <= 0) {
                   err += "At least one length is less than 0!\n";            
            }
            
            // Check for side length
            if ((s1 + s2 <= s3) || (s1 + s3 <= s2) || (s2 + s3 <= s1)) {
                   err += "The lengths of the triangles do not form a valid triangle!\n";
            }  
            
            if (s1 + s2 + s3 > 1000000) {
                err += "I feel your triangle is too big\n";
            } 
            
            if (err.length() > 0) {
               type = err;   
            } else {            
                if ((s1 == s2) && (s2 == s3)) {
                   type= "Equilateral";
               } else if (( s1 == s2) || (s2 == s3) || (s1 == s3)) {
                   type = "Isosceles";
               } else {
                   type = "Scalene";
               }                 
            }
            
            return type;        
        }

         
    }
    
    
    public class TriangleTest {
        // Create a new Triangle
        public TriangleTest() {
        }

        
        public void setUpClass() throws Exception {
            System.out.println("\nSETUP CLASS RUNNING -- Nothing to do though");
        }

        
        public void tearDownClass() throws Exception {
            System.out.println("\nTEARDOWN CLASS RUNNING -- Nothing to do though");
        }

       
        public void setUp() {
            System.out.println("\nSETUP IS RUNNING -- Nothing to do though");
        }

       
        public void tearDown() {
            System.out.println("TEARDOWN IS RUNNING -- Nothing to do though");
        }

       
        public void testScalene() {
            System.out.println("testScalene");

            Triangle instance = new Triangle("30", "40", "50");
            String expResult = "Scalene";
            String result = instance.determineTriangleType();
            assertEquals(expResult, result);
        }

        
        public void testEquilateral() {
            System.out.println("testEquilateral");
            Triangle instance = new Triangle("1", "1", "1");
            String expResult = "Equilateral";
            String result = instance.determineTriangleType();
            assertEquals(expResult, result);
        }

       
        public void testIsoceles() {
            System.out.println("testIsoceles");
            Triangle instance = new Triangle("30", "40", "30");
            String expResult = "Isosceles";
            String result = instance.determineTriangleType();
            assertEquals(expResult, result);
        }

       
        public void testGiantTriangle() {
            System.out.println("testGiantTriangle");
            Triangle instance = new Triangle("3000000", "4000000", "3000000");
            String expResult = "I feel your triangle is too big\n";
            String result = instance.determineTriangleType();
            assertEquals(expResult, result);
        }
    }
    
    //this is devika JUnit testing
    
    public class MyUnit {

        public String concatenate(String one, String two){
            return one + two;
        }
    }
    
    public class MyUnitTest {

        
        public void testConcatenate() {
            MyUnit myUnit = new MyUnit();

            String result = myUnit.concatenate("one", "two");

            assertEquals("onetwo", result);

        }
    }
    
    
    
}
