package FirstSteps;

public class Calculator {

    int numberOfCalculations = 0;

    public int division(int a, int b) {
        numberOfCalculations ++;
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }


    public int[] arrayDivision(int[]a , int[] b){
        numberOfCalculations ++;
        if (a.length != b.length){
            throw new RuntimeException("array mismatch sizes");
        }
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = division(a[i] , b[i]);
        }
        return res;
    }

}
