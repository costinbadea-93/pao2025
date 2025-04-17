import model.Animal;
import model.Persoana;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //agregare
        //compozitie
        /**
         * "extends" -> A extends B -> relatie de tip is-a
         * "implements" -> pentru interfete -> relatie de tip is-a
         *
         * relatii de tip has-a
         * -agregare -> asociere de tip slab (obiecte pot exista unul fara celalt)
         * -compozitie -> asociere de tip "tare"(strong) (obiectele nu pot exista unul fara celalalt)
         *
         */
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("P1"));
        players.add(new Player("P2"));
        players.add(new Player("P3"));

        Team team = new Team(players);
        players.remove(0);

        System.out.println(team);

        /**
         * compozitia -> imutabilitate
         */

//        Persoana persoana = new Persoana("P4", 20);
//        persoana.getNume();

        //records -> clase imutabile finale  care vin by default cu:
        //-constructor canonic pentru atribute
        //-geters pentru atribute
        //-tostring pentru record
        //-definit by default equals si hash code
        Animal animal = new Animal("A1", "C1");
        animal.color();
        animal.name();


    }
}

class Team {
    private List<Player> players;

    public Team(List<Player> players) {
        //compozitie
//        this.players = new ArrayList<>(players);

        //agregare
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return "Team{" +
                "players=" + players +
                '}';
    }
}

class Player {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
