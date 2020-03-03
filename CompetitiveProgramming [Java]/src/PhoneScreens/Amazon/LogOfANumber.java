package PhoneScreens.Amazon;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-16
 */
public class LogOfANumber {

    public static void main(String[] args){
        System.out.println(log2(62));
    }

    public static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2) + 1e-10);
    }

}
