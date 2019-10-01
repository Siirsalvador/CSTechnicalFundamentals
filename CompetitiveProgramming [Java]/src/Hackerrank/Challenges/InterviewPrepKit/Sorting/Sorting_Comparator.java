package Hackerrank.Challenges.InterviewPrepKit.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-17
 */
class Player {

    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

class Checker implements Comparator<Player> {

    public int compare(Player p1, Player p2) {
        int pos = p2.score - p1.score;
        return pos == 0 ? p1.name.compareTo(p2.name) : pos;
    }
}

public class Sorting_Comparator {

    public static void main(String[] main) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Player[] players = new Player[n];
        Checker checker = new Checker();

        for (int i = 0; i < n; i++) {
            players[i] = new Player(scanner.next(), scanner.nextInt());
        }
        scanner.close();

        Arrays.sort(players, checker);
        for (int i = 0; i < n; i++) {
            System.out.printf("%s %s \n", players[i].name, players[i].score);
        }


    }
}