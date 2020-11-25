package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void checkFindAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item(1, "test1");
        Item item2 = new Item(2, "test2");
        Item item3 = null;
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findAll().length, is(2));
    }
}