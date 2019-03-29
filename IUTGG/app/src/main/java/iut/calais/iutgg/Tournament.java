package iut.calais.iutgg;

import java.util.Date;
import java.util.List;

public class Tournament {
    String name;
    Date begin_at;
    String slug;

    List<Team> teams;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getBegin_at() {
        return begin_at;
    }

    public void setBegin_at(Date begin_at) {
        this.begin_at = begin_at;
    }

    Player player = new Player();

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
