package upm.modelo.items;

import upm.controlador.MatchService;

import java.io.IOException;
import java.io.PrintWriter;

public class EndMatch extends Match {
    private int[] scores;

    public EndMatch(Player player1, Player player2, Referee referee, int[] scores) {
        super(player1, player2, referee);
        this.scores = scores;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    @Override
    public void show() {
        Player[] players = this.getPlayers();
        for(int i = 0; i < players.length; i++){
            System.out.println(players[i] + ": " + this.scores[i]);
        }
    }

    @Override
    public void JSONreadMatch() {
        Player[] players = this.getPlayers();
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[\n");
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            jsonBuilder.append("  {\n");
            jsonBuilder.append("    \"nombre\": \"").append(player.getName()).append("\",\n");
            jsonBuilder.append("    \"puntuacion\": \"").append(this.scores[0]).append("\",\n");
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

    public void matchChange(MatchService matches) {
        matches.endMatch();
    }

    @Override
    public void pointRest(MatchService matches) {
        matchChange(matches);
    }

    @Override
    public void pointService(MatchService matches) {
        matchChange(matches);
    }

    @Override
    public void faultService(MatchService matches) {
        matchChange(matches);
    }
}
