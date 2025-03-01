package upm.modelo.items;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Player extends User{
    private LocalDate birthday;
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Player(String name) {
        super(name);
    }
    public Player(String name, String birthday) {
        super(name);
        this.birthday = LocalDate.parse(birthday, FORMATTER);
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getPlayerYear() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public void show() {
        System.out.println("\n---Name: " + getName()+ " ---");
    }
}
