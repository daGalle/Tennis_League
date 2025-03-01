package upm.modelo.items;

public class Set {
    private int[] setPoints;
    private Game actualGame;
    private int numOfGames;
    private static final int numOfPlayers = 2;
    public Set() {
        this.setPoints = new int[numOfPlayers];
        this.actualGame = new RegularGame();
        this.numOfGames = 0;
    }

    public void setActualGame(RegularGame actualRegularGame) {
        this.actualGame = actualRegularGame;
    }

    public int getNumOfGames() {
        return numOfGames;
    }

    public void setNumOfGames(int numOfGames) {
        this.numOfGames = numOfGames;
    }

    public int[] getSetPoints() {
        return setPoints;
    }

    public void setSetPoints(int[] setPoints) {
        this.setPoints = setPoints;
    }

    public int servePoint() {
        this.actualGame.servePoint();
        if(this.actualGame.isWinner()) {
            this.setPoints[(this.numOfGames) % 2]++;
            this.numOfGames++;
            if(this.numOfGames == 12) {
                this.actualGame = new TieBrakeGame();
            } else {
                this.actualGame = new RegularGame();
            }
        }
        return (this.numOfGames + 1) % 2;
    }

    public int restPoint() {
        this.actualGame.restPoint();
        if(this.actualGame.isWinner()) {
            this.setPoints[(this.numOfGames + 1) % 2]++;
            this.numOfGames++;
            if(this.numOfGames == 12) {
                this.actualGame = new TieBrakeGame();
            } else {
                this.actualGame = new RegularGame();
            }
        }
        return (this.numOfGames + 1) % 2;
    }

    public int newFault() {
        actualGame.newFault();
        if(this.actualGame.isWinner()) {
            this.setPoints[(this.numOfGames + 1) % 2]++;
            this.numOfGames++;
            if(this.numOfGames == 12) {
                this.actualGame = new TieBrakeGame();
            } else {
                this.actualGame = new RegularGame();
            }
        }
        return (this.numOfGames + 1) % 2;
    }



    public boolean isWinnerSet() {
        return ((this.setPoints[0] == 6 && this.setPoints[1] <= 4) || (this.setPoints[0] == 7)) || (this.setPoints[1] == 7 || (this.setPoints[1] == 6 && this.setPoints[0] <= 4));
    }

    public void showPlayer(int i) {
        if (i == 0 || i == 1) {
            if ((this.numOfGames % 2) == i) {
                System.out.println(" " + this.actualGame.showRestPoints());
            } else {
                System.out.println(" " + this.actualGame.showServicePoints());
            }
        }
    }
        

    public void getAsterisc(int i) {
        if(i == 0 || i == 1) {
            if((this.numOfGames % 2) == i) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
        }
        System.out.print(" ");
    }
}
