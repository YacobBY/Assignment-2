package nl.hva.ict.ds;

public class Main {
    public static void main(String[] args) {
        DummyHighScores dummy = new DummyHighScores();
        Player mattie = new Player("mattie", "devries",2232);
        Player aattie = new Player("aattie", "devries",2233);
        Player sattie = new Player("sattie", "devries",2234);
        Player cattie = new Player("cattie", "devries",2235);
        dummy.add(mattie);

    }
}
