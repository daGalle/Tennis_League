package upm.modelo.items;

public enum Point {
    CERO("0"),
    QUINCE("15"),
    TREINTA("30"),
    CUARENTA("40"),
    AD("AD"),
    WIN("WIN");
    private String points;

    Point(String points) {
        this.points = points;
    }

    public String getPoints() {
        return points;
    }
}
