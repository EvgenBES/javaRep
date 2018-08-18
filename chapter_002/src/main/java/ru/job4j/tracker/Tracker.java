package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Tracker {

    private final Item[] items = new Item[100];
    private int position = 0;
    private Random random = new Random();


    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    private String generateId() {
        return String.valueOf(new Date().getTime() + random.nextInt(5));
    }

    public Item[] getAll() {
        return Arrays.copyOf(this.items, this.position);
    }


    public boolean replace(String id, Item item) {
        boolean result = false;

        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                item.setId(id);
                items[i] = item;
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

        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, this.position - i);
                this.position--;
                result = true;
                break;
            }
        }
        return result;
    }


    public Item[] findByName(String key) {
        Item[] resultName = new Item[this.items.length];
        int resultId = 0;
        for (int i = 0; i != this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                resultName[resultId] = items[i];
                resultId++;
            }
        }
        return resultName = Arrays.copyOf(resultName, resultId);
    }


}