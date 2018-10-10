package nl.hva.ict.ds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueHighSchores implements HighScoreList {

    Comparator comparator = new PlayerComparator() ;
    PriorityQueue<Player> priorityQueue = new PriorityQueue<>(comparator);

    @Override
    public void add(Player player) {
        priorityQueue.add(player);
        System.out.println(priorityQueue);
    }

    @Override
    public List<Player> getHighScores(int numberOfHighScores) {
        //als er meer highscores worden opgevraagd dan er zijn
        if (numberOfHighScores > priorityQueue.size()) {
            //print dit uit
            System.out.println("\n**You have demanded " + (numberOfHighScores - priorityQueue.size()) + " more highscores than availible**");
            //en voer de functie daarna uit met het maximale aantal highscores mogelijk
            return getAllHighScores();
        }
        List<Player> returnList = new ArrayList<>();
        for (Player play : priorityQueue){
            returnList.add(play);
//            System.out.println(play.getHighScore());
        }
        //Omdat het uigesloten is dat numberOfHighscores nu nog groter is dan Players kan dit weggelaten worden.
        return returnList.subList(0, numberOfHighScores);
    }

    public List<Player> getAllHighScores() {
        return getHighScores(priorityQueue.size());
    }
    @Override
    public List<Player> findPlayer(String firstName, String lastName) throws IllegalArgumentException {
        return null;
    }



//    @Override
//    public List<Player> getHighScores(int numberOfHighScores) {
//        for (Player play : priorityQueue){
//            System.out.println(play.getHighScore());
//        }
//        return null;
//    }
//
//    @Override
//    public List<Player> findPlayer(String firstName, String lastName) throws IllegalArgumentException {
//        return null;
//    }

}
 class PlayerComparator implements Comparator<Player> {

    public int compare(Player x, Player y) {
        // Assume neither string is null. Real code should
        // probably be more robust
        // You could also just return x.length() - y.length(),
        // which would be more efficient.
        if (x.getHighScore() > y.getHighScore()) {
            return -1;
        }
        if (x.getHighScore() < y.getHighScore()) {
            return 1;
        }
        return 0;
    }
}