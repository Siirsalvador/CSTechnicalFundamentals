package SamplePackage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class MaxValueTest {

    private int expectedValue;
    private int firstValue;
    private int secondValue;

    public MaxValueTest(int expectedValue, int firstValue, int secondValue){
        this.expectedValue = expectedValue;
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    @Parameters
    public static Collection testInputData(){
        return Arrays.asList(new Integer[][]{
                        {10, 10, 7}, {12, 2, 12}, {1, 1, 1}, {14, 14, 12}
                });
    }

    @Test
    public void findMaxValueTest() {

        MaxValue maxValue = new MaxValue();
        System.out.println(String.format("Comparing %s and %s", firstValue, secondValue));

        assertEquals(expectedValue, maxValue.findMaxValue(firstValue, secondValue));

    }
}