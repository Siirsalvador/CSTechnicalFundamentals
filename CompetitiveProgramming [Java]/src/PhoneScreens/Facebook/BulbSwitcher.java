package PhoneScreens.Facebook;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-31
 */
public class BulbSwitcher {

    public static void main(String[] args){
        System.out.println(bulbSwitch2(6));
    }

    /*
        factor of 6: 1,2,3,6
        factor of 7: 1,7
        factor of 9: 1,3,9

        so all number have even number of factors except square number(e.g: factor of 9:1,3,9).
        square number must turn on because of odd number of factors(9: turn on at 1st, off at 3rd, on at 9th)
        other number must turn off(6: turn on at 1st, off at 2nd, on at 3rd, off at 6th)
        so we only need to compute the number of square number less equal than n
     */
    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }


    // I don't get it
    public static int bulbSwitch2(int n) {
        if (n == 1) return 1;

        int totBulbsOn = 0;

        boolean[] bulbs = new boolean[n + 1];

        bulbs[1] = true;
        for (int i = 2; i <= n / 2; i++) {
            for (int j = 2 * i; j < n + 1; j += i) {
                bulbs[j] = !bulbs[j];
            }
        }

        for (int i = 1; i < bulbs.length; i++) {
            if (bulbs[i]) totBulbsOn++;
        }

        return totBulbsOn;
    }

    // Time Limit Exceeded
    public int bulbSwitch3(int n) {
        if(n == 1) return 1;

        boolean[] bulbs = new boolean[n];


        int j = 1;

        while(j <= n){

            if(j == n){
                bulbs[j - 1] = !bulbs[j - 1];
                break;
            }

            for(int i = 0; i < bulbs.length; i++){
                if((i + 1)% j == 0) bulbs[i] = !bulbs[i];
            }

            j++;
        }

        int on = 0;
        for(int i = 0; i < bulbs.length; i++){
            if(bulbs[i]) on++;
        }

        return on;
    }


}
