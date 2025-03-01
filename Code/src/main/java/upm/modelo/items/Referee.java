package upm.modelo.items;

import java.util.Scanner;

public class Referee extends User{
    private String surname;
    private String password;
    private String email;

    public Referee(String name, String password) {
        super(name);
        this.password = password;
    }

    public Referee(String name, String surname, String password, String email) {
        super(name);
        this.surname = surname;
        this.password = password;
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isNotRegisted() {
        if(email == null || surname == null) {
            return true;
        } else {
            return false;
        }
    }

    public void registed() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Faltan algunos datos por rellenar");
        System.out.printf("Introduce tu apellido: ");
        this.surname = sc.nextLine();
        System.out.println();
        System.out.printf("Introduce tu email: ");
        this.email = sc.nextLine();
        System.out.println("--Arbitro registrado con exito--");
    }

    @Override
    public void show() {
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurname());
        System.out.println("Email: " + getEmail());
    }
}
