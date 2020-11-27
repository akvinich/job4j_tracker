package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public boolean replace(int id, Item item) {
        int replaceIndex = this.indexOf(id);
        if (replaceIndex < 0) {
            return false;
        }
        item.setId(id);
        items[replaceIndex] = item;
        return true;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] newItems = new Item[items.length];
        int newItemsSize = 0;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                newItems[index] = item;
                newItemsSize++;
            }
        }
        return Arrays.copyOf(newItems, newItemsSize);
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}