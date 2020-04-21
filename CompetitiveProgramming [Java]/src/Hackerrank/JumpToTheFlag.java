package Hackerrank;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-25
 */
public class JumpToTheFlag {

    public static int jumps(int flagHeight, int bigJump) {
        // Write your code here
        int steps = 0;
        int count = 0;

        System.out.println("Flag Height: "+ flagHeight);
        System.out.println("Big Jump: "+ bigJump);

        while(count + bigJump <= flagHeight){
            count += bigJump;
            steps++;
        }

        System.out.println("Count: " + count);
        System.out.println("Steps: " + steps);

        if(count < flagHeight){
            steps += flagHeight - count;
        }

        return steps;
    }

    public static void main(String[] args){
        System.out.println(jumps(458777924, 7237710));
    }
}
