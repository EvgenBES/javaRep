package ru.job4j.tracker;

public class Item {
    private String id;
    private String name;
    private String description;
    private long create;


    public Item(String name, String desc, long create) {
        this.name = name;
        this.description = desc;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public long getCreate() {
        return this.create;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
       return "ID заявки: " + getId() + "\n" +
               "Имя заявки: " + getName() + "\n" +
               "Описание заявки: " + getDescription() + "\n" +
               " ";
    }
}

