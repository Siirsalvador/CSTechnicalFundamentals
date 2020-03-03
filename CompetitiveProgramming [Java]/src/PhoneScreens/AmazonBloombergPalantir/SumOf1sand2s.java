package PhoneScreens.AmazonBloombergPalantir;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-15
 */
public class SumOf1sand2s {

    public static void main(String[] args){
        System.out.println(numOfWay(3));
    }
    public static int numOfWay(int n) {

        if (n < 3) return n;
        return numOfWay(n - 1) + numOfWay(n - 2);
    }
}
