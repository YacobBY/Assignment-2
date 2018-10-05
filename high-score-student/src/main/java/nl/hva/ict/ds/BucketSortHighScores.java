//auteur: Y Ben Youb


package nl.hva.ict.ds;

import java.util.ArrayList;
import java.util.List;

public class BucketSortHighScores implements HighScoreList {
    private List<Player> players = new ArrayList<>();
    private List<List> bucketList = new ArrayList(players);


    @Override
    public void add(Player player) {
        //add snel 3 player lists
        bucketList.add(players);
        bucketList.add(players);
        bucketList.add(players);

        if (player.getHighScore() < 5000)
            bucketList.get(0).add(player);

        else if (player.getHighScore() < 8000)
            bucketList.get(1).add(player);

        else if (player.getHighScore() < 10000)
            bucketList.get(2).add(player);

    }

    @Override
    public List<Player> getHighScores(int numberOfHighScores) {
        //als er meer highscores worden opgevraagd dan er zijn
        if (numberOfHighScores > players.size()) {
            //print dit uit
            System.out.println("\n**You have demanded " + (numberOfHighScores - players.size()) + " more highscores than availible**");
            //en voer de functie daarna uit met het maximale aantal highscores mogelijk
            return getHighScores(players.size());
        }
        //Omdat het uigesloten is dat numberOfHighscores nu nog groter is dan Players kan dit weggelaten worden.
        return players.subList(0, numberOfHighScores);
    }

    @Override
    public List<Player> findPlayer(String firstName, String lastName) {
        List<Player> matchedPlayers = new ArrayList<>();
        for (Player player : players) {
            if (player.getFirstName().equals(firstName)) {
                matchedPlayers.add(player);
            }
        }
        return matchedPlayers;
    }
}