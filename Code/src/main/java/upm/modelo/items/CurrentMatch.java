package upm.modelo.items;

import upm.controlador.MatchService;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class CurrentMatch extends Match {
    private Scoreboard scoreboard;

    public CurrentMatch(Player player1, Player player2, Referee referee, int numOfSets) {
        super(player1, player2, referee);
        this.scoreboard = new Scoreboard(numOfSets);
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void setScoreboard(Scoreboard scoreboard) {
        this.scoreboard = scoreboard;
    }

    public void pointRest() {
        if(this.getDayMatch() == null) {
            this.setDayMatch(LocalDate.now());
        }
        this.scoreboard.restPoint();
    }

    public void pointService() {
        if(this.getDayMatch() == null) {
            this.setDayMatch(LocalDate.now());
        }
        this.scoreboard.servePoint();
    }

    public void faultService() {
        if(this.getDayMatch() == null) {
            this.setDayMatch(LocalDate.now());
        }
        this.scoreboard.newFault();
    }

    public void show() {
        Player[] players = this.getPlayers();
        this.scoreboard.show(players[0], players[1]);
        System.out.println();
    }


    public void JSONreadMatch() {
        Player[] players = this.getPlayers();
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            jsonBuilder.append("  {\n");
            jsonBuilder.append("    \"nombre\": \"").append(player.getName()).append("\",\n");
            jsonBuilder.append("    \"puntuacion\": \"").append(this.scoreboard.JSONSetShow(i)).append("\",\n");
            jsonBuilder.append("  }");
            if (i < (players.length - 1)) {
                jsonBuilder.append(",");
            }
            jsonBuilder.append("\n");
        }
        jsonBuilder.append("]");
        try (PrintWriter writer = new PrintWriter("./src/main/resources/readMatch.json")) {
            writer.println(jsonBuilder);
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void pointRest(MatchService matches) {
        if(this.getDayMatch() == null) {
            this.setDayMatch(LocalDate.now());
        }
        this.scoreboard.restPoint();
        if(this.scoreboard.isEnd()) {
            matches.endingMatch(this);
        }
    }

    @Override
    public void pointService(MatchService matches) {
        if(this.getDayMatch() == null) {
            this.setDayMatch(LocalDate.now());
        }
        this.scoreboard.servePoint();
        if(this.scoreboard.isEnd()) {
            matches.endingMatch(this);
        }
    }

    @Override
    public void faultService(MatchService matches) {
        if(this.getDayMatch() == null) {
            this.setDayMatch(LocalDate.now());
        }
        this.scoreboard.newFault();
        if(this.scoreboard.isEnd()) {
            matches.endingMatch(this);
        }
    }
}
