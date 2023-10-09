package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MainTest {

    Main main;
    double epsilon = 0.000001;

    @BeforeClass
    public void setUp() {
        main = new Main();
    }

    @Test
    public void testF() {
        Assert.assertEquals(-0.00113522, main.f(0.1), epsilon);
        Assert.assertEquals(1.67609125, main.f(1), epsilon);
        Assert.assertEquals(0.625061, main.f(0.5), epsilon);
    }
    @Test
    public void testF_Wrong() {
        Assert.assertNotEquals(-0.00213522, main.f(0.1), epsilon);
        Assert.assertNotEquals(-1.67609, main.f(1), epsilon);
        Assert.assertNotEquals(0.625066, main.f(0.5), epsilon);
    }
    @Test void testFillX() {
        Assert.assertEquals(main.fillX(0.1, 1, 0.001).size(), 901);
        Assert.assertEquals(main.fillX(0.0, 0.0, 0.001).size(), 1);
    }
    @Test
    public void testFillY() {
        double[] result = main.fillY(0.1, 1.0, 0.001);
        // Перевірка розміру масиву та деяких значень
        Assert.assertEquals(result.length, 901);
        Assert.assertEquals(result[500], 0.854242, epsilon);
        Assert.assertEquals(result[400], 0.625061, epsilon);
    }

    @Test
    public void testGetMax() {
        double[] arr = main.fillY(0.1, 1.0, 0.001);
        int result = main.getMax(arr);
        Assert.assertEquals(result, 900);
    }
    @Test
    public void testGetMin() {
        double[] arr = main.fillY(0.1, 1.0, 0.001);
        int result = main.getMin(arr);
        Assert.assertEquals(result, 199);
    }

    @Test
    public void testCalculateSum() {
        double[] arr = main.fillY(0.1, 1.0, 0.001);
        double result = main.calculateSum(arr);
        Assert.assertEquals(result, 657.145924, epsilon);
    }

    @Test
    public void testCalculateAverage() {
        double[] arr = main.fillY(0.1, 1.0, 0.001);
        double result = main.calculateAverage(arr);
        Assert.assertEquals(result, 0.7293517, epsilon);
    }

    @Test
    public void testGetMaxFromArrByIndexes() {
        List<Double> listX = main.fillX(0.1, 1.0, 0.001);
        double result = main.getMaxFromArrByIndexes(listX, 0, 200, 900);
        Assert.assertEquals(result, 2.0);
    }

    @Test
    public void testGetMinFromArrByIndexes() {
        List<Double> listX = main.fillX(0.1, 1.0, 0.001);
        double result = main.getMinFromArrByIndexes(listX, 0, 200, 900);
        Assert.assertEquals(result, 0.0); // Очікуємо мінімум серед вибраних значень
    }

}