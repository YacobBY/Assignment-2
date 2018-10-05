//auteur: Y Ben Youb

package nl.hva.ict.ds;

import java.util.ArrayList;
import java.util.List;

public class SelectionSortHighScores implements HighScoreList {
    private List<Player> players = new ArrayList<>();


    @Override
    public void add(Player player) {

        players.add(player);
        if (players.size() <= 1) {
            return;
        }
        for (int i = 0; i < players.size()-1; i++) {
            int loopIndex = i;
            int holderIndex = i;
            while ((loopIndex) < players.size()-1) {
                if (players.get(holderIndex).getHighScore() < players.get(loopIndex+1).getHighScore()) {
                    holderIndex = loopIndex+1;

                }
                //verhoog de huidige loop index met 1 zodat de while de volgende index checkt
                loopIndex++;
            }
            Player temp = players.get(holderIndex);
            players.set(holderIndex, players.get(i));
            players.set(i, temp);
        }

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