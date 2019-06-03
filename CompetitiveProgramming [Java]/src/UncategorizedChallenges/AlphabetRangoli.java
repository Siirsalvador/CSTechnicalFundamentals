package UncategorizedChallenges;

/**
 * You are given an integer, . Your task is to print an alphabet rangoli of size . (Rangoli is a form of Indian folk art based on creation of patterns.)
 * <p>
 * Different sizes of alphabet rangoli are shown below
 * <p>
 * #size 3
 * <p>
 * ----c----
 * --c-b-c--
 * c-b-a-b-c
 * --c-b-c--
 * ----c----
 * <p>
 * 1. Store all strings in a array
 * 2. For i in n (so create n lines):
 * 3. Solve the right side of the line which is if i+1, there will be i+1 characters on the right (n^2)
 * 4. Get a substring of the reverse string from the first item to the dash before the first character
 */
public class AlphabetRangoli {

    static String[] arrayOfStrings = {"a", "b", "c", "d", "e", "f"};

    public static void createRangoli(int n) {

        StringBuilder outputBuilder = new StringBuilder();

        //Start from the middle of the Rangoli and from the right side of the line
        for (int i = 0; i < n; i++) {

            //Create a new builder for each line
            StringBuilder builder = new StringBuilder();
            builder.append(arrayOfStrings[i]);

            for (int j = i + 1; j < n; j++) {
                builder.append("-");
                builder.append(arrayOfStrings[j]);
            }

            while (builder.length() < (n + (n - 1))) {
                builder.append("-");
            }

            //After the right side of the line is done, replicate it to left side
            StringBuilder tempBuilder = new StringBuilder(builder.toString());
            tempBuilder.delete(0, 1).reverse().append(builder);

            outputBuilder.append(tempBuilder.toString());

            //Create a new line if we are not on the last line
            if (i != n - 1) {
                outputBuilder.append("\n");
            }

        }

        //The bottom half of the Rangoli has been completed, replicate it to the top
        StringBuilder stringBuilder = new StringBuilder(outputBuilder.toString());
        stringBuilder.insert(0, outputBuilder.reverse().toString(), 0, (((n * 2) - 1) + ((n * 2) - 2)) * n + (n - 1) - (((n * 2) - 1) + ((n * 2) - 2)));
        System.out.println(stringBuilder);
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("A-y-o-m-i-d-e");

        StringBuilder tempBuilder = new StringBuilder(builder.toString());
        tempBuilder.delete(0, 1).reverse();
        tempBuilder.append(builder);

        createRangoli(3);
        createRangoli(4);
        createRangoli(5);
    }

}
