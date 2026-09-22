package tn.esprit;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test public void testAdd()             { assertEquals(5,   App.add(2, 3)); }
    @Test public void testAddNegative()     { assertEquals(-1,  App.add(-3, 2)); }
    @Test public void testAddZero()         { assertEquals(7,   App.add(7, 0)); }

    @Test public void testMultiply()        { assertEquals(12,  App.multiply(3, 4)); }
    @Test public void testMultiplyByZero()  { assertEquals(0,   App.multiply(5, 0)); }
    @Test public void testMultiplyNeg()     { assertEquals(-6,  App.multiply(-2, 3)); }

    @Test public void testFactZero()        { assertEquals(1,   App.factorial(0)); }
    @Test public void testFactOne()         { assertEquals(1,   App.factorial(1)); }
    @Test public void testFact()            { assertEquals(120, App.factorial(5)); }
    @Test(expected = IllegalArgumentException.class)
    public void testFactNeg()              { App.factorial(-1); }

    @Test public void testIsEvenTrue()      { assertTrue(App.isEven(4)); }
    @Test public void testIsEvenFalse()     { assertFalse(App.isEven(7)); }
    @Test public void testIsEvenZero()      { assertTrue(App.isEven(0)); }

    @Test public void testMaxFirst()        { assertEquals(9, App.max(9, 3)); }
    @Test public void testMaxSecond()       { assertEquals(8, App.max(2, 8)); }
    @Test public void testMaxEqual()        { assertEquals(5, App.max(5, 5)); }
}
