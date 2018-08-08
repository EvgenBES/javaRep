package ru.job4j.tracker;

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
        Item[] result = new Item[this.position];
        for (int i = 0; i != this.position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }

    public void replace(String id, Item item) {
        for (int i = 0; i < this.position; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(id)) {
                item.setId(id);
                items[i] = item;
                break;
            }
        }
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }return result;
    }

    public void delete(String id) {
        for (int i = 0; i != items.length; i++) {
            if (items[i].getId().equals(id)) {
                Item tempItem = items[i];
                for (int j = i + 1; j != items.length; j++) {
                    this.items[j - 1] = items[j];
                }
                this.items[items.length - 1] = tempItem;
                System.arraycopy(this.items, 0, this.items, 0, items.length - 1);
            }
        }

    }

    public Item[] findAll() {
        Item[] coryItem = this.items;
        for (int i = 0; i != coryItem.length; i++) {
            if (coryItem[i] == null) {
                Item tempItem = coryItem[i];
                for (int j = i + 1; j != coryItem.length; j++) {
                    coryItem[j - 1] = coryItem[j];
                }
                coryItem[coryItem.length - 1] = tempItem;
                System.arraycopy(coryItem, 0, coryItem, 0, coryItem.length - 1);
            }
        }
        return coryItem;
    }

    public Item[] findByName(String key) {
        Item[] resultName = new Item[this.items.length];
        int resultId = 0;
        for (int i = 0; i != this.items.length; i++) {
            if (this.items[i].getName().equals(key)) {
                resultName[resultId] = this.items[i];
                resultId++;
            }
        }
        System.arraycopy(resultName, 0, resultName, 0, resultId - 1);

        return resultName;
    }


}