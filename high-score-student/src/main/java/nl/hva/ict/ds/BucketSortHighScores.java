//auteur: Y Ben Youb


package nl.hva.ict.ds;

import java.util.ArrayList;
import java.util.List;

public class BucketSortHighScores implements HighScoreList {
    SelectionSortHighScores selectionSort = new SelectionSortHighScores();
    private List<List<Player>> bucketList = new ArrayList<>();
    //Score waarvanaf de buckets cijfers accepteren.
    private int bucket1MinScore = 80000;
    private int bucket2MinScore = 60000;
    private int bucket3MinScore = 40000;
    private int bucket4MinScore = 20000;

    //Maakt 5 bucketlists aan
    public BucketSortHighScores() {

        bucketList.add(new ArrayList<>());
        bucketList.add(new ArrayList<>());
        bucketList.add(new ArrayList<>());
        bucketList.add(new ArrayList<>());
        bucketList.add(new ArrayList<>());
    }

    @Override
    //Voegt players toe in bijbehordende bucket en voert daarna selectionsort uit op de bucket waarin een player is toegevoegd.
    public void add(Player player) {
//Als score hoger is dan 80.000, voeg de player toe in deze bucket. Voor de andere buckets wordt vergeleken met 60k, 40k en 20k en daarna automatisch in de laatste bucket
// zodat negatieve scores ook ingevoerd kunnen worden.
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

    public void printAllBucketHighScores() {
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

    //Haalt alle players stuk voor stuk uit elke bucketlist.
    public List<Player> getAllPlayersFromBucketList(List<List<Player>> bucketList) {
        //Maak een araylist aan waarin alle elementen bij elkaar gevoegd kunnen worden.
        List<Player> returnList = new ArrayList<>();
        //Voor elke bucket in de bucketlist
        for (List<Player> playerList : bucketList) {
            //Voor elke player in de bucket
            for (Player player : playerList) {
                //Voeg de player toe aan de returnlist.
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