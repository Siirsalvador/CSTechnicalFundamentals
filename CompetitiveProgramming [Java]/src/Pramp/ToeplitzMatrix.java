package Pramp;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-10-26
 */
public class ToeplitzMatrix {

    static boolean isToeplitz(int[][] arr) {
        // your code goes here

        if (arr == null || arr.length == 0) return false;

        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {

                if (arr[i][j] != arr[i + 1][j + 1])
                    return false;

            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}

/*
rows = r
cols = c
r+c-1
[0,i]

[i,0]

[1,2,1]
[3,1,1]
[1,2,3]
*/

/*
Work on something that matters
You don't have to come to work to get work done

Be more specific about technologies within the project
Problem:
Solution:

Make it dry?
Obviously

Why would you be a perfect team member?

What are the perfect traits that
make a perfect team member?


*/