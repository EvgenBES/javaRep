package ru.job4j.tracker;

import java.util.*;

public class Tracker {

    private final List<Item> items = new ArrayList<>();
    private int position = 0;
    private Random random = new Random();


    public List<Item> add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        return items;
    }

    private String generateId() {
        return String.valueOf(new Date().getTime() + random.nextInt(5));
    }

    public List<Item> getAll() {
        return this.items;
    }


    public boolean replace(String id, Item item) {
        boolean result = false;

        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i) != null && this.items.get(i).getId().equals(id)) {
                item.setId(id);
                items.add(i, item);
                result = true;
                break;
            }
        }
        return result;
    }


    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }


    public boolean delete(String id) {
        boolean result = false;

        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i) != null && this.items.get(i).getId().equals(id)) {
                this.items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }


    public List<Item> findByName(String key) {
        List<Item> resultName = new ArrayList<>();


        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                resultName.add(item);
            }
        }
        return resultName;
    }


}