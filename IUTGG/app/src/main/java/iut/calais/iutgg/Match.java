package iut.calais.iutgg;

import java.util.List;

public class Match {
    Tournament tournament = new Tournament();

    List<Opponent> opponents;

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament_id) {
        this.tournament = tournament_id;
    }

    public List<Opponent> getOpponents() {
        return opponents;
    }

    public void setOpponents(List<Opponent> opponents) {
        this.opponents = opponents;
    }
}
