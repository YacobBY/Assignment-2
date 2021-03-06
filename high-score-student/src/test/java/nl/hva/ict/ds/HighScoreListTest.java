package nl.hva.ict.ds;

import org.junit.Before;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * This class contains some unit tests. They by no means ensure that all the requirements are implemented
 * correctly.
 */
public class HighScoreListTest {
    private static final int MAX_HIGH_SCORE = 100000;
    private Random randomizer = new SecureRandom();
    private HighScoreList highScores;
    private Player nearlyHeadlessNick;
    private Player dumbledore;

    @Before
    public void setup() {
        // Here you should select your implementation to be tested.
//        highScores = new SelectionSortHighScores();
//        highScores = new InsertionSortHighScores();
//        highScores = new BucketSortHighScores();
        highScores = new PriorityQueueHighSchores();

        nearlyHeadlessNick = new Player("Nicholas", "de Mimsy-Porpington", getHighScore() % 200);
        dumbledore = new Player("Albus", "Dumbledore", nearlyHeadlessNick.getHighScore() * 1000);
    }

    @Test
    public void noPlayerNoHighScore() {
        assertTrue("There are high-score while there should be no high-scores!", highScores.getHighScores(1).isEmpty());
    }

    @Test
    public void whenNoHighScoreIsAskedForNonShouldBeGiven() {
        highScores.add(nearlyHeadlessNick);

        assertEquals(0, highScores.getHighScores(0).size());
    }

    //*ThanPresent
    @Test
    public void noMoreHighScoresCanBeGivenThenPresent() {
        highScores.add(nearlyHeadlessNick);
        highScores.add(dumbledore);

        System.out.println(highScores.getHighScores(10).size());
        assertEquals(2, highScores.getHighScores(10).size());
    }

    @Test
    public void keepAllHighScores() {
        highScores.add(nearlyHeadlessNick);
        highScores.add(dumbledore);

        assertEquals(2, highScores.getHighScores(2).size());
    }

    @Test
    public void singlePlayerHasHighScore() {
        highScores.add(dumbledore);

        assertEquals(dumbledore, highScores.getHighScores(1).get(0));
    }

    @Test
    public void harryBeatsDumbledore() {
        highScores.add(dumbledore);
        Player harry = new Player("Harry", "Potter", dumbledore.getHighScore() + 1);
        //Toegevoegde regel want harry wordt nooit ge-add dus anders kan er niet vergeleken worden
        highScores.add(harry);

        highScores.getHighScores(3);
        assertEquals(harry.getHighScore(), highScores.getHighScores(1).get(0).getHighScore());
    }

    // Extra unit tests go here

    private long getHighScore() {
        return randomizer.nextInt(MAX_HIGH_SCORE);
    }

//Haalt de hoogste testscore op
    @Test
    public void getHighestScore() {
        highScores.add(dumbledore);
        highScores.add(new Player("aaa", "xxxxx", dumbledore.getHighScore() + 2));
        highScores.add(new Player("bbbb", "wwww", dumbledore.getHighScore() + 3));
        Player harry = new Player("Harry", "Potter", dumbledore.getHighScore() + 30);
        highScores.add(harry);

        assertEquals(harry.getHighScore(), highScores.getHighScores(1).get(0).getHighScore());
    }
//test een klein aantal highscores
    @Test
    public void fewHighscoresTest() {
        int a = 10;
        for (int i = 0; i < a; i++) {
            highScores.add(new Player("aaa", "xxxxx", getHighScore() * 50));
        }
        assertEquals(a, highScores.getHighScores(a).size());
    }

    @Test
    //Test een enorm aantal highscores.
    public void manyHighscorestest() {
        int a = 1000;
        for (int i = 0; i < a; i++) {
            Player play = new Player("aaa", "xxxxx", getHighScore());
            highScores.add(play);
        }
        assertEquals(a, highScores.getHighScores(a).size());
    }
}