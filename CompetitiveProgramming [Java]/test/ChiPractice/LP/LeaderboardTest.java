package ChiPractice.LP;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static ChiPractice.LP.Leaderboard.updatePlayerPosition;
import static org.junit.Assert.*;

public class LeaderboardTest {



    @Test
    public void testUpdatePlayerPosition(){

        String[] currentPositionArr = {"Ayomide", "Chinemerem", "Patricia", "Thanos", "Wande", "Tiger", "NeverExperred"};

        HashMap<String, LinkedList<Integer>> athletesToMarkerPostions = new HashMap<>();
        updatePlayerPosition(currentPositionArr, athletesToMarkerPostions);

        assertNotNull(athletesToMarkerPostions);
    }

}