//auteur: Y Ben Youb

package nl.hva.ict.ds;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort implements HighScoreList {
    private List<Player> players = new ArrayList<>();

    @Override
    public void add(Player player) {
        players.add(player);

        int i = 0;
        System.out.println(players.size());

        for (int j = 0; j < players.size(); j++) {
            {
                if (i <= (players.size()-1)){return;}
                //Als je niet bij het einde van de lijst bent **EN** de huidige highscore groter is dan die van de volgende player
                if ( (players.get(i).getHighScore() > players.get(i + 1).getHighScore())) {
                    while (players.get(i).getHighScore() > players.get(i + 1).getHighScore()) {
                        i++;
                    }
                    //maakt kopie van volgende player
                    Player temp = players.get(i + 1);
                    //vervangt volgende player in lijst met huidige player en kopiert volgende over huidige heen
                    players.set(i + 1, players.get(i));
                    players.set(i, temp);
                    i = j;
                }
            }
        }
    }
        @Override
        public List<Player> getHighScores ( int numberOfHighScores){
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
        public List<Player> findPlayer (String firstName, String lastName){
            List<Player> matchedPlayers = new ArrayList<>();
            for (Player player : players) {
                if (player.getFirstName().equals(firstName)) {
                    matchedPlayers.add(player);
                }
            }
            return matchedPlayers;
        }
    }