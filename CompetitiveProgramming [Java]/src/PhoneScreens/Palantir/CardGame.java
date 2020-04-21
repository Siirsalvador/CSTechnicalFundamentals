package PhoneScreens.Palantir;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-02-22
 */
public class CardGame {

    List<Queue<Integer>> playerDeck;

    CardGame() {
        playerDeck = new ArrayList<>();
    }

    void takeTurn() {
        List<Integer> tiedPlayers = new ArrayList<>();
        for (int i = 0; i < playerDeck.size(); i++) tiedPlayers.add(i);
        handleWar(new ArrayList<>(), tiedPlayers);
    }

    private void handleWar(List<Integer> prevCards, List<Integer> prevTiedPlayers) {
        /*
            Get Deck of tied players
            Get top most card, add to a new card list
            Get max
            Check if there are tied players

            If no, add all cards here and cards from argument to the back of winners deque
            If yes, pass new tied players and all the cards collected so far into the handleWar method again
         */

        //Find winner -> check if a player has all the cards
        for (Queue<Integer> cardCnt : playerDeck) {
            if (cardCnt.size() == 52) return;
        }

        List<Integer> cards = new ArrayList<>(playerDeck.size());
        int max = 0;

        for (int i = 0; i < 3; i++) {
            for (Integer player : prevTiedPlayers) {
                Queue<Integer> currDeck = playerDeck.get(player);
                if (currDeck.size() != 0) prevCards.add(currDeck.poll());
            }
        }

        for (Integer player : prevTiedPlayers) {
            Queue<Integer> currDeck = playerDeck.get(player);
            if (currDeck.size() != 0) cards.set(player, currDeck.poll());
        }

        for (Integer c : cards) {
            max = Math.max(c, max);
        }

        List<Integer> tiedPlayers = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i) == max) tiedPlayers.add(i);
        }

        for (Integer card : cards) {
            if (card != 0) prevCards.add(card);
        }

        if (tiedPlayers.size() == 1) {
            Queue<Integer> winner = playerDeck.get(tiedPlayers.get(0));
            winner.addAll(cards);
            return;
        }

        handleWar(cards, tiedPlayers);
    }
}
