/**
 * Created by alexey on 08.03.16.
 */

import static org.junit.Assert.assertEquals;

public class ParabolaTest {

    private Parabola parabola;

    @org.junit.Before
    public void setUp() throws Exception {
        parabola = new Parabola();
    }

    @org.junit.Test
    public void testCalculateAllZeroes() throws Exception {
        parabola.setA(0.0);
        parabola.setB(0.0);
        parabola.setC(0.0);

        assertEquals(0.0, parabola.calculate(10.0), 0.01);
    }

    @org.junit.Test
    public void testCalculateAllZeroesExceptC() throws Exception {
        parabola.setA(0.0);
        parabola.setB(0.0);
        parabola.setC(10.0);

        assertEquals(10.0, parabola.calculate(10.0), 0.01);
    }

    @org.junit.Test
    public void testCalculateAllZeroesExceptB() throws Exception {
        parabola.setA(0.0);
        parabola.setB(10.0);
        parabola.setC(0.0);

        assertEquals(10.0, parabola.calculate(1.0), 0.01);
    }

    @org.junit.Test
    public void testCalculateAllZeroesExceptA() throws Exception {
        parabola.setA(10.0);
        parabola.setB(0.0);
        parabola.setC(0.0);

        assertEquals(1000.0, parabola.calculate(10.0), 0.01);
    }

    @org.junit.Test
    public void testCalculateAllZeroesExceptBAndC() throws Exception {
        parabola.setA(0.0);
        parabola.setB(10.0);
        parabola.setC(10.0);

        assertEquals(110.0, parabola.calculate(10.0), 0.01);
    }

    @org.junit.Test
    public void testCalculateAllZeroesExceptAAndC() throws Exception {
        parabola.setA(10.0);
        parabola.setB(0.0);
        parabola.setC(10.0);

        assertEquals(1010.0, parabola.calculate(10.0), 0.01);
    }

    @org.junit.Test
    public void testCalculateAllZeroesExceptAAndB() throws Exception {
        parabola.setA(10.0);
        parabola.setB(10.0);
        parabola.setC(0.0);

        assertEquals(1100.0, parabola.calculate(10.0), 0.01);
    }

    @org.junit.Test
    public void testCalculateAllNotZeroes() throws Exception {
        parabola.setA(10.0);
        parabola.setB(10.0);
        parabola.setC(10.0);

        assertEquals(1110.0, parabola.calculate(10.0), 0.01);
    }

    @org.junit.Test
    public void testDoBackwardCalculationAllZeroes() throws Exception {
        parabola.setA(0.0);
        parabola.setB(0.0);
        parabola.setC(0.0);

        assertEquals(0, parabola.doBackwardCalculation(10).length);
    }

    @org.junit.Test
    public void testDoBackwardCalculationAllZeroesExceptC() throws Exception {
        parabola.setA(0.0);
        parabola.setB(0.0);
        parabola.setC(10.0);

        assertEquals(0, parabola.doBackwardCalculation(10).length);
    }

    @org.junit.Test
    public void testDoBackwardCalculationAllZeroesExceptB() throws Exception {
        parabola.setA(0.0);
        parabola.setB(10.0);
        parabola.setC(0.0);

        assertEquals(1.0, parabola.doBackwardCalculation(10)[0], 0.01);
    }

    @org.junit.Test
    public void testDoBackwardCalculationAllZeroesExceptA() throws Exception {
        parabola.setA(10.0);
        parabola.setB(0.0);
        parabola.setC(0.0);

        assertEquals(-1.0, parabola.doBackwardCalculation(10)[0], 0.01);
        assertEquals(1.0, parabola.doBackwardCalculation(10)[1], 0.01);
    }

    @org.junit.Test
    public void testDoBackwardCalculationAllZeroesExceptBAndC() throws Exception {
        parabola.setA(0.0);
        parabola.setB(10.0);
        parabola.setC(10.0);

        assertEquals(0.0, parabola.doBackwardCalculation(10)[0], 0.01);
    }

    @org.junit.Test
    public void testDoBackwardCalculationAllZeroesExceptAAndC() throws Exception {
        parabola.setA(10.0);
        parabola.setB(0.0);
        parabola.setC(10.0);

        assertEquals(0.0, parabola.doBackwardCalculation(10)[0], 0.01);
        assertEquals(0.0, parabola.doBackwardCalculation(10)[1], 0.01);
    }

    @org.junit.Test
    public void testDoBackwardCalculationAllZeroesExceptAAndB() throws Exception {
        parabola.setA(10.0);
        parabola.setB(10.0);
        parabola.setC(0.0);

        assertEquals((-1.0 - Math.sqrt(5)) / 2, parabola.doBackwardCalculation(10)[0], 0.01);
        assertEquals((-1.0 + Math.sqrt(5)) / 2, parabola.doBackwardCalculation(10)[1], 0.01);
    }

    @org.junit.Test
    public void testDoBackwardCalculationAllNotZeroes() throws Exception {
        parabola.setA(10.0);
        parabola.setB(10.0);
        parabola.setC(10.0);

        assertEquals(-1.0, parabola.doBackwardCalculation(10)[0], 0.01);
    }
}