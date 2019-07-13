package ChiPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Given a marathon route with markers that track runners' progress as they cross them
 * Implement a system to keep track of the leaderboard.
 * <p>
 * Implement a notification system that pushes a notification every time a specified runner,
 * the three runners behind them or the three runners in front of them change their position in the leaderboard.
 */

public class Leaderboard {

    public static void main(String[] args) {

        HashMap<String, LinkedList<Integer>> athletesToMarkerPostions = new HashMap<>();
        String[] currentPositionArr = {"Ayomide", "Chinemerem", "Patricia", "Thanos", "Wande", "Tiger", "NeverExperred"};

        updatePlayerPosition(currentPositionArr, athletesToMarkerPostions);
        System.out.println(athletesToMarkerPostions.entrySet());

        currentPositionArr = new String[]{"NeverExperred", "Chinemerem", "Ayomide", "Patricia", "Thanos", "Wande", "Tiger"};
        updatePlayerPosition(currentPositionArr, athletesToMarkerPostions);

        checkIfLeaderboardChanged("Ayomide", athletesToMarkerPostions, 1, 2);
        System.out.println(athletesToMarkerPostions.entrySet());

    }

    static HashMap<String, LinkedList<Integer>> updatePlayerPosition(String[] playerMarkerPositionArr,
                                                                             HashMap<String, LinkedList<Integer>> athletesToMarkerPostions) {

        for (int i = 0; i < playerMarkerPositionArr.length; i++) {

            String nameOfAthlete = playerMarkerPositionArr[i];

            if (athletesToMarkerPostions.containsKey(nameOfAthlete)) {

                LinkedList<Integer> existingPositionList = athletesToMarkerPostions.get(nameOfAthlete);
                existingPositionList.add(i + 1);
                continue;
            }

            LinkedList<Integer> newPositionList = new LinkedList<>();
            newPositionList.add(i + 1);
            athletesToMarkerPostions.put(nameOfAthlete, newPositionList);
        }

        return athletesToMarkerPostions;
    }

    private static void checkIfLeaderboardChanged(String nameOfAthlete, HashMap<String,
            LinkedList<Integer>> athletesToMarkerPostions, int previousMarker, int currentMarker) {

        if (athletesToMarkerPostions.get(nameOfAthlete) != null && athletesToMarkerPostions.get(nameOfAthlete).size() > 1) {
            LinkedList<Integer> currentPositions = athletesToMarkerPostions.get(nameOfAthlete);

            //If athlete has changed position
            if (!currentPositions.get(previousMarker - 1).equals(currentPositions.get(currentMarker - 1))) {
                System.out.println(String.format("Notification Sent: Player Changed Postion from Position %s to Position %s", previousMarker, currentMarker));
            }

            //If any of 3 athletes to the left of athlete has changed position
            ArrayList<String> leftList = getPlayersBehindAtParticularMarker(nameOfAthlete, athletesToMarkerPostions, previousMarker, 3);

            sendNotification(athletesToMarkerPostions, previousMarker, currentMarker, leftList);

            //If any of 3 athletes to the right of athlete has changed position
            ArrayList<String> rightList = getPlayersAheadAtParticularMarker(nameOfAthlete, athletesToMarkerPostions, previousMarker, 3);

            sendNotification(athletesToMarkerPostions, previousMarker, currentMarker, rightList);

        }
    }

    private static void sendNotification(HashMap<String, LinkedList<Integer>> athletesToMarkerPostions, int previousMarker, int currentMarker, ArrayList<String> list) {
        if (list.size() != 0){
            for (String athleteName : list){
                LinkedList<Integer> listOfAthletesPositions = athletesToMarkerPostions.get(athleteName);
                if(!listOfAthletesPositions.get(previousMarker-1).equals(listOfAthletesPositions.get(currentMarker-1))){
                    System.out.println(String.format("Notification Sent: Player %s Changed Postion from Position %s to Position %s", athleteName, listOfAthletesPositions.get(previousMarker-1), listOfAthletesPositions.get(currentMarker-1)));

                }
            }
        }
    }

    private static ArrayList<String> getPlayersAheadAtParticularMarker(String nameOfAthlete, HashMap<String, LinkedList<Integer>> athletesToMarkerPostions, int previousMarker,
                                                                       int numberOfAthletes) {
        ArrayList<String> athletesAhead = new ArrayList<>();

        int positionOfCurrentAthlete = athletesToMarkerPostions.get(nameOfAthlete).get(previousMarker - 1);
        int rightLimit = positionOfCurrentAthlete + numberOfAthletes;

        for (Map.Entry<String, LinkedList<Integer>> entry : athletesToMarkerPostions.entrySet()) {
            if (entry.getValue().get(previousMarker - 1) >= positionOfCurrentAthlete && entry.getValue().get(previousMarker - 1) <= rightLimit && !entry.getKey().equals(nameOfAthlete)) {
                athletesAhead.add(entry.getKey());
            }
        }

        return athletesAhead;

    }

    private static ArrayList<String> getPlayersBehindAtParticularMarker(String nameOfAthlete, HashMap<String, LinkedList<Integer>> athletesToMarkerPostions,
                                                                        int previousMarker, int numberOfAthletes) {

        ArrayList<String> athletesBehind = new ArrayList<>();

        int positionOfCurrentAthlete = athletesToMarkerPostions.get(nameOfAthlete).get(previousMarker - 1);
        int leftLimit = positionOfCurrentAthlete - numberOfAthletes;

        for (Map.Entry<String, LinkedList<Integer>> entry : athletesToMarkerPostions.entrySet()) {
            if (entry.getValue().get(previousMarker - 1) >= leftLimit && entry.getValue().get(previousMarker - 1) <= positionOfCurrentAthlete && !entry.getKey().equals(nameOfAthlete)) {
                athletesBehind.add(entry.getKey());
            }
        }

        return athletesBehind;
    }

}
