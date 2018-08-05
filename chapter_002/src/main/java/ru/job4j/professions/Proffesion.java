package ru.job4j.professions;

public class Proffesion {
    String name;
    String prof;

    public Proffesion() {

    }

    public Proffesion(String name, String prof) {
        this.name = name;
        this.prof = prof;
    }

    public String getName() {
        return name;
    }

    public String getProf() {
        return prof;
    }
}
