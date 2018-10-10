package nl.hva.ict.ds;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueHighSchores implements HighScoreList {
//Maakt een comparator object aan, lees documentatie van comparator class voor meer uitleg
    Comparator comparator = new PlayerComparator() ;
    //Maakt een priorityqueue en gebruikt de playerComparator om te sorteren op highscore basis
    PriorityQueue<Player> priorityQueue = new PriorityQueue<>(comparator);

    @Override
    /*Voeg een player toe aan de priority queue. De add methode gebruikt de comparator om uit
    te vinden waar het in de queue ge add moet worden.*/
    public void add(Player player) {
        priorityQueue.add(player);

    }

    @Override
    public List<Player> getHighScores(int numberOfHighScores) {
        //als er meer highscores worden opgevraagd dan er zijn
        if (numberOfHighScores > priorityQueue.size()) {
            //print hoeveel highscores er teveel zijn opgevraagd
            System.out.println("\n**You have demanded " + (numberOfHighScores - priorityQueue.size()) + " more highscores than availible**");
            //en voer de functie daarna uit met het maximale aantal highscores mogelijk
            return getAllHighScores();
        }
        List<Player> returnList = new ArrayList<>();
        //Haal alle players op uit de priorityqueue en zet ze in een player List
        int q = 0;
        for (Player play : priorityQueue){
            //onnodige optimalisatie
            if (q<=numberOfHighScores){
                returnList.add(play);}
            else {break;}
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
}
/*Custom comparator class, deze wordt gebruikt voor de priorityqueue om te beslissen
of een player grooter of kleiner is dan de volgende. De klasse bepaald dat deze comparison
op basis van highscore grootte van de player gaat.

Wat belangrijk is, is dat dit een descending queue is. Gewoonlijk komt het kleinste
nummer eerst en het grootste nummer laatst, maar onze comparator draait dit om.*/
 class PlayerComparator implements Comparator<Player> {

    public int compare(Player x, Player y) {
        //als de eerdere highscore groter is dan de tweede highscore, doe niks
        if (x.getHighScore() > y.getHighScore()) {
            return -1;
        }
        //Als de eerdere highscore kleiner is dan de tweede highscore, wissel ze om
        if (x.getHighScore() < y.getHighScore()) {
            return 1;
        }
        //Als de highscores hetzelfde zijn, doe niks.
        return 0;
    }
}