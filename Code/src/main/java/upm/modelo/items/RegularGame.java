package upm.modelo.items;

public class RegularGame extends Game<Point> {


    public RegularGame() {
        setRestPoints(Point.CERO);
        setServicePoints(Point.CERO);
    }

    public void servePoint() {
        this.addPointService();
        this.setNumOfFaults(0);
    }

    @Override
    public boolean isWinner() {
        return getServicePoints() == Point.WIN || getRestPoints() == Point.WIN;
    }

    public void restPoint() {
        this.addPointRest();
        this.setNumOfFaults(0);
    }

    private void addPointRest() {
        Point winner = getRestPoints();
        Point losser = getServicePoints();
        if(winner == Point.CERO) {
            winner = Point.QUINCE;
        } else if(winner == Point.QUINCE) {
            winner = Point.TREINTA;
        } else if(winner == Point.TREINTA) {
            winner = Point.CUARENTA;
        } else if(winner == Point.CUARENTA) {
            Point losserPoints = losser;
            if(losserPoints == winner) {
                winner = Point.AD;
            } else if(losserPoints == Point.AD) {
                losser = Point.CUARENTA;
            } else {
                winner = Point.WIN;
            }
        } else {
            winner = Point.WIN;
        }
        this.setRestPoints(winner);
        this.setServicePoints(losser);
    }


    private void addPointService() {
        Point winner = getServicePoints();
        Point losser = getRestPoints();
        if(winner == Point.CERO) {
            winner = Point.QUINCE;
        } else if(winner == Point.QUINCE) {
            winner = Point.TREINTA;
        } else if(winner == Point.TREINTA) {
            winner = Point.CUARENTA;
        } else if(winner == Point.CUARENTA) {
            Point losserPoints = losser;
            if(losserPoints == winner) {
                winner = Point.AD;
            } else if(losserPoints == Point.AD) {
                losser = Point.CUARENTA;
            } else {
                winner = Point.WIN;
            }
        } else {
            winner = Point.WIN;
        }
        this.setRestPoints(losser);
        this.setServicePoints(winner);
    }


    @Override
    public String showRestPoints() {
        return this.getRestPoints().getPoints();
    }

    @Override
    public String showServicePoints() {
        return this.getServicePoints().getPoints();
    }

    public void newFault() {
        this.setNumOfFaults(this.getNumOfFaults() + 1);
        if(this.getNumOfFaults() == 2) {
            restPoint();
        }
    }


}
