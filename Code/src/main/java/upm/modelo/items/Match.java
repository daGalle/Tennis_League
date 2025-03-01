package upm.modelo.items;

import java.time.LocalDate;

public abstract class Match implements MatchVisitor{
    int id;
    private Player[] players;
    private Referee referee;
    private LocalDate dayMatch;

    public Match(Player player1, Player player2, Referee referee) {
        this.players = new Player[]{player1, player2};
        this.referee = referee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public LocalDate getDayMatch() {
        return dayMatch;
    }

    public void setDayMatch(LocalDate dayMatch) {
        this.dayMatch = dayMatch;
    }
    public abstract void show();
    public abstract void JSONreadMatch();
}
