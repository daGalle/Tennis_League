package upm.modelo.items;

public class Scoreboard {
    private int[] puntuacion;
    private Set[] sets;
    private int actualSet;
    private final int numOfPlayers = 2;
    private int numOfSets;
    public Scoreboard(int numOfSets) {
        this.sets = new Set[numOfSets];
        this.numOfSets = sets.length;
        this.actualSet = 0;
        this.sets[0] = new Set();
        this.puntuacion = new int[this.numOfPlayers];
        this.puntuacion[0] = 0;
        this.puntuacion[1] = 0;
    }

    public Set[] getSets() {
        return sets;
    }

    public void setSets(Set[] sets) {
        this.sets = sets;
    }

    public int getActualSet() {
        return actualSet;
    }

    public void setActualSet(int actualSet) {
        this.actualSet = actualSet;
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public int getNumOfSets() {
        return numOfSets;
    }

    public void setNumOfSets(int numOfSets) {
        this.numOfSets = numOfSets;
    }

    public void servePoint() {
        int i = this.sets[this.actualSet].servePoint();
        newActualSet();
        this.puntuacion[i]++;
    }

    public void restPoint() {
        int i = this.sets[this.actualSet].restPoint();
        newActualSet();
        this.puntuacion[i]++;
    }

    public void newFault() {
        int i = this.sets[this.actualSet].newFault();
        newActualSet();
        this.puntuacion[i]++;
    }

    public void newActualSet() {
        if(this.sets[actualSet].isWinnerSet()) {
            this.actualSet++;
            this.sets[this.actualSet] = new Set();
        }
    }

    public int[] getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int[] puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void show(Player player1, Player player2) {
        System.out.println("Scoreboard:");
        this.sets[this.actualSet].getAsterisc(0);
        System.out.printf(player1.getName());
        for(int i = 0; i <= this.actualSet; i++) {
            System.out.printf(" " + String.valueOf(this.sets[i].getSetPoints()[1]));
            if(i == this.actualSet) {
                this.sets[i].showPlayer(0);
            }
        }
        this.sets[this.actualSet].getAsterisc(1);
        System.out.printf(player2.getName());
        for(int i = 0; i <= this.actualSet; i++) {
            System.out.printf(" " + String.valueOf(this.sets[i].getSetPoints()[0]));
            if(i == this.actualSet) {
                this.sets[i].showPlayer(1);

            }
        }
    }

    public String JSONSetShow(int numOfPlayers) {
        String result = "";
        for(Set set : this.sets) {
            int[] setResults = set.getSetPoints();
            for(int i = 0; i <= setResults.length; i++) {
                result.concat(setResults[(numOfPlayers == 0) ? 1 : 0] + " ");
            }
        }
        return result;
    }

    public boolean isEnd() {
        return puntuacion[0] > this.numOfSets % 2 || puntuacion[1] > this.numOfSets % 2;
    }
}
