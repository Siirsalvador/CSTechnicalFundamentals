package UncategorizedChallenges;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-01-28
 */
public class EnumTest {

    enum Color{
        RED_PAYMENT,
        BLUE
    }

    public static void main(String[] args){
        //printEnum(Color.valueOf("RED_PAYMENT"));


        N n = new N(2);
        for(int i  = 0; i < 5; i++){
            System.out.println(n.val + 1);
        }
    }

    public static void printEnum(Color c){
        System.out.println(c);
    }
}

class N{
    int val;

    N(int val){
        this.val = val;
    }
}