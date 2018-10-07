//auteur: Y Ben Youb


package nl.hva.ict.ds;

import java.util.ArrayList;
import java.util.List;

public class BucketSortHighScores implements HighScoreList {
    SelectionSortHighScores selectionSort = new SelectionSortHighScores();
    private List<List<Player>> bucketList = new ArrayList<>();

    private int gBucketMinScore = 1000000;
    private int mBucketMinScore = 100000;
    public BucketSortHighScores() {

        bucketList.add(new ArrayList<>());
        bucketList.add(new ArrayList<>());
        bucketList.add(new ArrayList<>());
    }


    @Override
    public void add(Player player) {
        //add snel 3 player lists
//        Player tempie = new Player("aaaa", "aaaasdfasfaw", 3541241);
//        bucketList.get(0).add(player);
//        bucketList.get(1).add(tempie);
//        bucketList.get(2).add(tempie);
//        for (Player play : getAllPlayersFromBucketList(bucketList)) {
//            System.out.println(play.getHighScore());
//        }

        if (player.getHighScore() > gBucketMinScore) {
            bucketList.get(0).add(player);
            bucketList.set(0,selectionSort.selectionSort(bucketList.get(0)));
            return;
        }
        if (player.getHighScore() > mBucketMinScore) {
            bucketList.get(1).add(player);
            bucketList.set(0,selectionSort.selectionSort(bucketList.get(0)));
            return;
        }
        {
            bucketList.get(2).add(player);
            bucketList.set(0,selectionSort.selectionSort(bucketList.get(0)));
        }
    }

    @Override
    public List<Player> getHighScores(int numberOfHighScores) {
        //maakt list aan om te returnen
        List<Player> returnList = getAllPlayersFromBucketList(bucketList);
        //als er meer highscores worden opgevraagd dan er zijn
        if (numberOfHighScores > returnList.size()) {
            //print dit uit
            System.out.println("\n**You have demanded " + (numberOfHighScores - returnList.size()) + " more highscores than available**");
            //en voer de functie daarna uit met het maximale aantal highscores mogelijk
            return getHighScores(returnList.size());
        }
        //Omdat het uigesloten is dat numberOfHighscores nu nog groter is dan Players kan dit weggelaten worden.
        List<Player> returnHighscores = new ArrayList(returnList.subList(0, numberOfHighScores));
        System.out.println("ALLE HIGHSCORES OP VOLGORDE");
        for (Player plaay :returnHighscores){
            System.out.println(plaay.getHighScore());
        }
        return returnHighscores;
    }

    public List<Player> getAllPlayersFromBucketList(List<List<Player>> bucketList) {
        List<Player> returnList = new ArrayList<>();
        for (List<Player> playerList : bucketList) {
            for (Player player : playerList) {
                returnList.add(player);
            }
        }
        return returnList;
    }

    @Override
    public List<Player> findPlayer(String firstName, String lastName) throws IllegalArgumentException {
        return null;
    }

//    @Override
//    public List<Player> findPlayer(String firstName, String lastName) {
//        List<Player> matchedPlayers = new ArrayList<>();
//        for (Player player : playerList) {
//            if (player.getFirstName().equals(firstName)) {
//                matchedPlayers.add(player);
//            }
//        }
//        return matchedPlayers;
//    }
}