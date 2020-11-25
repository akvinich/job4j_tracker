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

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Tracker innerTracker = new Tracker();
        Item[] newItems = new Item[items.length];
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (key.equals(item.getName())) {
                innerTracker.add(item);
            }
        }
        return innerTracker.findAll();
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (item == null) {
                return Arrays.copyOf(itemsWithoutNull, index);
            }
        }
        return itemsWithoutNull;
    }
}