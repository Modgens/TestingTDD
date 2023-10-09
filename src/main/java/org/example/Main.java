package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    // 7 Варіант

    public static void main(String[] args) {
        Main main = new Main(); // Створення об'єкта класу Main

        double start = 0.1;
        double end = 1.0;
        double step = 0.001;

        // Виклик методу fillX та виведення результату
        List<Double> listX = main.fillX(start, end, step);
        System.out.println("List X:");
        for (double x : listX) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Виклик методу fillY та виведення результату
        double[] listY = main.fillY(start, end, step);
        System.out.println("List Y:");
        for (double y : listY) {
            System.out.print(y + " ");
        }
        System.out.println();

        // Виклик інших методів та виведення результатів, наприклад:
        int maxIndex = main.getMax(listY);
        int minIndex = main.getMin(listY);
        double sum = main.calculateSum(listY);
        double average = main.calculateAverage(listY);

        System.out.println("Max Y: " + listY[maxIndex]);
        System.out.println("Min Y: " + listY[minIndex]);
        System.out.println("Sum of Y: " + sum);
        System.out.println("Average of Y: " + average);
    }

    public double f(double x){
        double b = 1.5;
        if(b*x<=0.45)
            return b*x-Math.tan(b*x);
        return b*x + Math.log10(b*x);
    }
    public int getSize(double start, double end, double step) {
        return (int) Math.round((end - start)/step) + 1;
    }
    public List<Double> fillX(double start, double end, double step){
        int size = getSize(start, end, step);
        return IntStream.range(0, size).mapToDouble(i -> start + i*step).boxed().toList();
    }

    public double[] fillY(double start, double end, double step) {
        List<Double> listX = fillX(start, end, step);
        int size = listX.size();

        double[] result = new double[size];

        for (int i = 0; i < result.length; i++) {
            result[i] = f(listX.get(i));
        }
        return result;
    }
    public int getMax(double[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Масив порожній або не існує");
        }

        int maxIndex = 0;
        double maxValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public int getMin(double[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Масив порожній або не існує");
        }

        int minIndex = 0;
        double minValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue) {
                minValue = arr[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
    public double calculateSum(double[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Масив порожній або не існує");
        }

        double sum = 0.0;

        for (double num : arr) {
            sum += num;
        }

        return sum;
    }

    public double calculateAverage(double[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Масив порожній або не існує");
        }
        return calculateSum(arr) / arr.length;
    }
    public double getMaxFromArrByIndexes(List<Double> listX, int ... index) {
        double[] result = new double[index.length];
        int i2 = 0;
        for (int i : index) {
            result[i2++] = listX.get(i);
        }
        return getMax(result);
    }
    public double getMinFromArrByIndexes(List<Double> listX, int ... index) {
        double[] result = new double[index.length];
        int i2 = 0;
        for (int i : index) {
            result[i2++] = listX.get(i);
        }
        return getMin(result);
    }


}
