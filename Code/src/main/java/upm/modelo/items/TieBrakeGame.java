package upm.modelo.items;

public class TieBrakeGame extends Game<Integer> {

    public TieBrakeGame() {
        setRestPoints(0);
        setServicePoints(0);
    }

    @Override
    public String showRestPoints() {
        return String.valueOf(getRestPoints());
    }

    @Override
    public String showServicePoints() {
        return String.valueOf(getServicePoints());
    }

    @Override
    public void newFault() {
        this.setNumOfFaults(this.getNumOfFaults() + 1);
        if(this.getNumOfFaults() > 2) {
            restPoint();
        }
    }

    @Override
    public void restPoint() {
        this.setRestPoints(this.getRestPoints() + 1);
        this.setNumOfFaults(0);
    }

    @Override
    public void servePoint() {
        this.setServicePoints(this.getServicePoints() + 1);
        this.setNumOfFaults(0);
    }



    @Override
    public boolean isWinner() {
        return (getRestPoints() >= 7 && getServicePoints() <= getRestPoints() - 2) || (getServicePoints() >= 7 && getRestPoints() <= getServicePoints() - 2);
    }
}
