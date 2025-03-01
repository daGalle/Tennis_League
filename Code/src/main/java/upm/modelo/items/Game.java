package upm.modelo.items;

public abstract class Game<T> {
    private T servicePoints;
    private T restPoints;
    private int numOfFaults;

    public T getServicePoints() {
        return servicePoints;
    }

    public T getRestPoints() {
        return restPoints;
    }

    public void setServicePoints(T servicePoints) {
        this.servicePoints = servicePoints;
    }


    public void setRestPoints(T restPoints) {
        this.restPoints = restPoints;
    }

    public int getNumOfFaults() {
        return numOfFaults;
    }

    public void setNumOfFaults(int numOfFaults) {
        this.numOfFaults = numOfFaults;
    }

    public abstract String showRestPoints();
    public abstract String showServicePoints();
    public abstract void newFault();
    public abstract void restPoint();
    public abstract void servePoint();
    public abstract boolean isWinner();
}
