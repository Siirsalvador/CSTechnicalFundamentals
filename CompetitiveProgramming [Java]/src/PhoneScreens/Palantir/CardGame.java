package PhoneScreens.Palantir;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-22
 */
public class CardGame {

    List<Deque<Integer>> playerDeck;

    CardGame() {
        playerDeck = new ArrayList<>();
    }

    void takeTurn() {

        List<Integer> cards = new ArrayList<>();
        int max = 0;

        for (Deque<Integer> p : playerDeck) {
            if (p.size() == 0) {
                cards.add(0);
                continue;
            }

            cards.add(p.removeFirst());
        }


        for (Integer c : cards) {
            max = Math.max(c, max);
        }

        List<Integer> tiedPlayers = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) == max) tiedPlayers.add(i);
        }

        if (tiedPlayers.size() == 1) {
            Deque<Integer> winner = playerDeck.get(tiedPlayers.get(0));
            winner.addAll(cards);
            return;
        }

        handleWar(cards, tiedPlayers);
    }

    private void handleWar(List<Integer> cards, List<Integer> tiedPlayers) {
        //We remove items one after other from list and find max
        //If more than one player still has the max, we call this method recursively
        /*
            Get Deck of tied players
            Get top most card, add to a new card list
            Get max
            Check if there are tied players

            If no, add all cards here and cards from argument to the back of winners deque
            If yes, pass new tied players and all the cards collected so far into the handleWar method again
         */
    }
}
