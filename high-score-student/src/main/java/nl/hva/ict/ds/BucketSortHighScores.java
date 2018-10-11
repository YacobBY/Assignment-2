//auteur: Y Ben Youb


package nl.hva.ict.ds;

import java.util.ArrayList;
import java.util.List;

public class BucketSortHighScores implements HighScoreList {
    SelectionSortHighScores selectionSort = new SelectionSortHighScores();
    private List<List<Player>> bucketList = new ArrayList<>();

    private int bucket1MinScore = 70000;
    private int bucket2MinScore = 70000;
    private int bucket3MinScore = 70000;
    private int bucket4MinScore = 70000;
    private int bucket5MinScore = 70000;

    public BucketSortHighScores() {

        bucketList.add(new ArrayList<>());
        bucketList.add(new ArrayList<>());
        bucketList.add(new ArrayList<>());
        bucketList.add(new ArrayList<>());
        bucketList.add(new ArrayList<>());
    }

    @Override
    public void add(Player player) {

        if (player.getHighScore() > bucket1MinScore) {
            bucketList.get(0).add(player);
            bucketList.set(0, selectionSort.selectionSort(bucketList.get(0)));
//            printAllBucketHighScores();

            return;
        }

        if (player.getHighScore() > bucket2MinScore) {
            bucketList.get(1).add(player);
            bucketList.set(1, selectionSort.selectionSort(bucketList.get(1)));
//            printAllBucketHighScores();
            return;
        }
        if (player.getHighScore() > bucket3MinScore) {
            bucketList.get(2).add(player);
            bucketList.set(2, selectionSort.selectionSort(bucketList.get(2)));
//            printAllBucketHighScores();
            return;
        }
        if (player.getHighScore() > bucket4MinScore) {
            bucketList.get(3).add(player);
            bucketList.set(3, selectionSort.selectionSort(bucketList.get(3)));
//            printAllBucketHighScores();
            return;
        }

        {
            bucketList.get(4).add(player);
            bucketList.set(4, selectionSort.selectionSort(bucketList.get(4)));
//            printAllBucketHighScores();
        }
    }
public void printAllBucketHighScores (){
    List<Player> allPlayersFromBucketList = getAllPlayersFromBucketList(bucketList);
    System.out.println("PRINT ALL HIGHSCORES IN THE BUCKET");
    for (Player play : allPlayersFromBucketList) {
        System.out.println(play.getHighScore());
    }
    System.out.println("END PRINT METHOD");

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
//        System.out.println("GEVRAAGDE HIGHSCORES");
//        for (Player plaay : returnHighscores) {
//            System.out.println(plaay.getHighScore());
//        }
        return returnHighscores;
    }

    public List<Player> getAllPlayersFromBucketList(List<List<Player>> bucketList) {
        List<Player> returnList = new ArrayList<>();
        for (List<Player> playerList : bucketList) {
            for (Player player : playerList) {
                returnList.add(player);
//                System.out.println(player.getHighScore());
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