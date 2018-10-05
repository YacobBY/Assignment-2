//auteur: Y Ben Youb

package nl.hva.ict.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSortHighScores implements HighScoreList {
    private List<Player> players = new ArrayList<>();
    private List <List> bucketList = new ArrayList(players);



    @Override
    public void add(Player player) {
        players.add(player);
bucketList.add(players);
Player henk = new Player("aa", "ss", 222);
bucketList.get(0).add(henk);
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