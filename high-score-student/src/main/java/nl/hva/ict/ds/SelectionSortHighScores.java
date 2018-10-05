//auteur: Y Ben Youb

package nl.hva.ict.ds;

import java.util.ArrayList;
import java.util.List;

public class SelectionSortHighScores implements HighScoreList {
    private List<Player> players = new ArrayList<>();


    @Override
    public void add(Player player) {
//voeg een player toe aan het einde van de lijst
        players.add(player);
        //als de lijst slechts een player bevat hoef je niet te sorteren dus ben je klaar
        if (players.size() <= 1) {
            return;
        }
        //loopt van begin tot de totale grootte van de lijst
        for (int i = 0; i < players.size()-1; i++) {
            //zet de tijdelijke indexen gelijk aan de begin index
            int loopIndex = i;
            int holderIndex = i;
            //zolang de huidige vergelijk plaats kleiner is dan de maximum grootte min een
            while ((loopIndex) < players.size()-1) {
                //vergelijk de tijdelijke index met de volgende index
                if (players.get(holderIndex).getHighScore() < players.get(loopIndex+1).getHighScore()) {
                    //als de tijdelijke index kleiner is dan de volgende index is de volgende index de tijdelijke index
                    holderIndex = loopIndex+1;
                }
                //verhoog de huidige loop index met 1 zodat de while de volgende index checkt
                loopIndex++;
            }
            //als er een grotere waarde dan de eerste index is gevonden wordt de grootste waarde verwisseld met de eerste
            if (holderIndex > i){
            Player temp = players.get(holderIndex);
            players.set(holderIndex, players.get(i));
            players.set(i, temp);}
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