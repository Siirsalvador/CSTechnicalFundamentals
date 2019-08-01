package Hackerrank.Challenges.InterviewPrepKit.DictionariesAndHashMaps;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SherlockandAnagramsTest {

    private String word;
    private int numberOfAnagrammaticPairs;
    private SherlockandAnagrams findAnagrams;

    public SherlockandAnagramsTest(String word, int numberOfAnagrammaticPairs) {
        this.word = word;
        this.numberOfAnagrammaticPairs = numberOfAnagrammaticPairs;
    }

    @Parameters
    public static Collection testInputData() {
        return Arrays.asList(new Object[][]{
                {"mom", 2},
                {"kkkk", 10},
                {"ifailuhkqq", 3},
                {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 166650}
        });
    }

    @Before
    public void init() {
        findAnagrams = new SherlockandAnagrams();
    }

    @Test
    public void findAllSubstrings() {
        System.out.println(String.format("String being test now is %s", word));
        assertEquals(numberOfAnagrammaticPairs, findAnagrams.sherlockAndAnagrams(word));
    }
}