package ru.job4j.tracker;

import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return create == item.create
                && Objects.equals(id, item.id)
                && Objects.equals(name, item.name)
                && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, create);
    }

    public String toString() {
        String ln = System.lineSeparator();
        return "ID заявки: " + getId() + ln
                + "Имя заявки: " + getName() + ln
                + "Описание заявки: " + getDescription() + ln
                + " ";
    }
}

