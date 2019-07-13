package SamplePackage;

public class MaxValue {

    int findMaxValue(int firstNumber, int secondNumber) {
        return firstNumber >= secondNumber ? firstNumber : secondNumber;
    }

    public static void main(String[] arg){

        MaxValue maxValue = new MaxValue();
        System.out.println(maxValue.findMaxValue(10, 7));
    }
}
